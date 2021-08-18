package com.cloud.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan(value = {"com.cloud.service.mapper"})
@EnableEurekaClient
public class ComCloudServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComCloudServiceApplication.class, args);
    }

}
