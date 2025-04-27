package com.kiddoz.dyslexia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.kiddoz.recommendation.repository", "com.kiddoz.dyslexia.repository"})
@EntityScan(basePackages = {"com.kiddoz.recommendation.model", "com.kiddoz.dyslexia.model"})
@ComponentScan(basePackages = {"com.kiddoz.recommendation", "com.kiddoz.dyslexia"},
        excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX,
                pattern = ".*(AI|Recommendation).*"))
public class DyslexiaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DyslexiaApplication.class, args);
    }

}
