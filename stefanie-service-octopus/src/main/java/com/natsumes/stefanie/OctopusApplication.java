package com.natsumes.stefanie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OctopusApplication {

    public static void main(String[] args) {
        SpringApplication.run(OctopusApplication.class, args);
    }

}
