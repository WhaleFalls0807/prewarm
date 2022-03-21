package com.whaleal.prewarm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@AutoConfigurationPackage
@SpringBootApplication
@EnableScheduling
public class PrewarmApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrewarmApplication.class, args);
    }

}
