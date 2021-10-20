package com.element.trailsmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJpaRepositories
@EnableSwagger2
public class TrailsManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrailsManagerApplication.class, args);
    }

}
