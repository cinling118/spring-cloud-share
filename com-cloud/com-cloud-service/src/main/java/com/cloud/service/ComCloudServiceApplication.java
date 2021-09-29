package com.cloud.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ImportResource;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan(value = {"com.cloud.service.mapper"})
@EnableEurekaClient
@ImportResource("classpath:transaction.xml")
public class ComCloudServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComCloudServiceApplication.class, args);
    }

}
