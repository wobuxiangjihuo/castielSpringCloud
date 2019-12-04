package com.xuhang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient//本服务启动后,自动注册到Eureka中
/*@EnableDiscoveryClient*/
@EnableCircuitBreaker//对hystrixR熔断机制的支持
public class DeptProvider8011_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8011_App.class, args);
    }
}

