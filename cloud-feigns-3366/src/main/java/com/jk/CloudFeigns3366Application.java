package com.jk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudFeigns3366Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudFeigns3366Application.class, args);
    }

}
