package com.cloud.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages="com.cloud")
public class ComCloudWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComCloudWebApplication.class, args);
        //自定义的ApplicationContext实现类
//        SpringApplication springApplication = new SpringApplication(ComCloudWebApplication.class);
//        springApplication.setApplicationContextClass(AnnotationConfigServletWebServerApplicationContext.class);
//        springApplication.run(args);
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate()
    {
        return new RestTemplate();
    }
}
