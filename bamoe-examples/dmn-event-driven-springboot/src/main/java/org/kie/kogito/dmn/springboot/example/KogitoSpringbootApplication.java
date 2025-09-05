package org.kie.kogito.dmn.springboot.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "org.kie.kogito.app.**", "org.kie.kogito.**", "http**" })
public class KogitoSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(KogitoSpringbootApplication.class, args);
    }
}
