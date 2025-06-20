package com.example.ch4codeyourself;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

<<<<<<< HEAD:ch4-spring-db2/ch4-examples/src/main/java/com/example/ch4codeyourself/Ch4ExamplesApplication.java
@SpringBootApplication(scanBasePackages = "com.example.ch4codeyourself.v4")
@EnableJpaRepositories(basePackages = "com.example.ch4codeyourself.v4")
@EntityScan(basePackages = "com.example.ch4codeyourself.v4")
=======
@SpringBootApplication(scanBasePackages = "com.captainyun7.ch4examples.v5")
@EnableJpaRepositories(basePackages = "com.captainyun7.ch4examples.v5")
@EntityScan(basePackages = "com.captainyun7.ch4examples.v5")
>>>>>>> upstream/main:ch4-spring-db2/ch4-examples/src/main/java/com/captainyun7/ch4examples/Ch4ExamplesApplication.java
public class Ch4ExamplesApplication {
    public static void main(String[] args) {
        SpringApplication.run(Ch4ExamplesApplication.class, args);
    }
}
