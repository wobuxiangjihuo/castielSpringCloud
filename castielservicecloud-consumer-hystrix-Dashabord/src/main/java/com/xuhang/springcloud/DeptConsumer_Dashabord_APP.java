package com.xuhang.springcloud;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class DeptConsumer_Dashabord_APP
{
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_Dashabord_APP.class, args);
    }
}
