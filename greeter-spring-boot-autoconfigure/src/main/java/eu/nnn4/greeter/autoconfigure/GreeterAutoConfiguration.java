package eu.nnn4.greeter.autoconfigure;

import eu.nnn4.greeter.library.Greeter;
import eu.nnn4.greeter.library.GreetingConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static eu.nnn4.greeter.library.GreeterConfigParams.*;

@Configuration
@ConditionalOnClass(Greeter.class)
// On application startup, the GreeterAutoConfiguration class
// will run if the class Greeter is present in the classpath.
// If run successfully, it will populate the Spring application context
// with GreeterConfig and Greeter beans by reading the properties via GreeterProperties class.
@EnableConfigurationProperties(GreeterProperties.class)
public class GreeterAutoConfiguration {

    @Autowired
    private GreeterProperties greeterProperties;

    @Bean
    @ConditionalOnMissingBean
//    will ensure that these beans will only be created
//    if they don't already exist. This enables developers
//    to completely override the auto-configured beans
//    by defining their own in one of the @Configuration classes.
    public GreetingConfig greeterConfig() {

        String userName = greeterProperties.getUserName() == null ? System.getProperty("user.name") : greeterProperties.getUserName();
        String morningMessage = greeterProperties.getMorningMessage() == null ? "Good Morning" : greeterProperties.getMorningMessage();
        String afternoonMessage = greeterProperties.getAfternoonMessage() == null ? "Good Afternoon" : greeterProperties.getAfternoonMessage();
        String eveningMessage = greeterProperties.getEveningMessage() == null ? "Good Evening" : greeterProperties.getEveningMessage();
        String nightMessage = greeterProperties.getNightMessage() == null ? "Good Night" : greeterProperties.getNightMessage();

        GreetingConfig greetingConfig = new GreetingConfig();
        greetingConfig.put(USER_NAME, userName);
        greetingConfig.put(MORNING_MESSAGE, morningMessage);
        greetingConfig.put(AFTERNOON_MESSAGE, afternoonMessage);
        greetingConfig.put(EVENING_MESSAGE, eveningMessage);
        greetingConfig.put(NIGHT_MESSAGE, nightMessage);
        return greetingConfig;
    }

    @Bean
    @ConditionalOnMissingBean
    public Greeter greeter(GreetingConfig greetingConfig) {
        return new Greeter(greetingConfig);
    }

}