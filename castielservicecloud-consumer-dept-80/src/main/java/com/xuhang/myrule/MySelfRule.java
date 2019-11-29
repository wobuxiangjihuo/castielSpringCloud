package com.xuhang.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/** 自定义Ribbon算法规则  不能放在@componentScan注解下面
 *  (例如@SpringBootApplication 包含componentScan注解下面), 因为会全局共享*/
@Configuration
public class MySelfRule
{
    //切换成 随机算法
    @Bean
    public IRule myRule()
    {
        //return new RoundRobinRule();
        //return new RandomRule();
        return  new RandomRule_XH();
    }
}
