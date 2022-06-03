package com.nttdata.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MicroserviceAccountsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceAccountsApplication.class, args);
    }

}
