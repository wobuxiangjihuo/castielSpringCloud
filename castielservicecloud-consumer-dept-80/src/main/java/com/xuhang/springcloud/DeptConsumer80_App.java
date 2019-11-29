package com.xuhang.springcloud;

import com.xuhang.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
/**在启动该微服务的时候就能去加载我们的自定义Ribbon配置类，从而使配置生效
 *  踩坑警告!!!!!!!!!!!!!
 *  注意: @RibbonClient name属性一定要对照 provider yml 配置的 spring:application:name 的设置
 *  严格区分大小写,否则RibbonClient注解不会生效,无法执行自定义 负载均衡算法
 * */
@RibbonClient(name="castielservicecloud-dept",configuration=MySelfRule.class)
public class DeptConsumer80_App
{
    public static void main(String[] args)
    {
        SpringApplication.run(DeptConsumer80_App.class, args);
    }
}