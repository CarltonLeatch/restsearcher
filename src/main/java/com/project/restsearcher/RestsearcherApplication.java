package com.project.restsearcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@ComponentScan(basePackages = "com.project")
@ComponentScan(basePackageClasses = {com.project.restsearcher.Config.WebSecurityConfig.class})
@EntityScan({"com.project.restsearcher.Model"})
@EnableJpaRepositories({"com.project.restsearcher.Repository"})
@SpringBootApplication
public class RestsearcherApplication {


    public static void main(String[] args) {
        SpringApplication.run(RestsearcherApplication.class, args);
    }
}
