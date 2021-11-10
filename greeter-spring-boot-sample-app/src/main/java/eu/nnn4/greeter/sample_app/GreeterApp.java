package eu.nnn4.greeter.sample_app;

import eu.nnn4.greeter.library.Greeter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GreeterApp implements CommandLineRunner {

    @Autowired
    private Greeter greeter;
    private static final Logger log = LoggerFactory.getLogger(GreeterApp.class);
    public static void main(String[] args) {
        SpringApplication.run(GreeterApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String message = greeter.greet();
        System.out.println(message);
        log.info(log.getName()+"\nstandart logger: {}",message);

    }
}