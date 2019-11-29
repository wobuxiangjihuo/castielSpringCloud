package com.xuhang.springcloud.controller;

import entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DeptController_Consumer
{
     //private static final String REST_URL_PREFIX="http://localhost:8001";
     private static final String REST_URL_PREFIX="http://castielservicecloud-dept";

     @Autowired
     private RestTemplate restTemplate;
     List list =new ArrayList();

     @RequestMapping("/consumer/dept/add")
     public boolean add(Dept dept)
     {
          //三个参数, REST请求地址、请求参数、HTTP响应转换被转换成的对象类型
          return  restTemplate.postForObject(REST_URL_PREFIX+"/dept/add",dept,Boolean.class);
     }

     @RequestMapping(value = "/consumer/dept/get/{id}")
     public Dept get(@PathVariable("id") Long id) {
          return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
     }

     @SuppressWarnings("unchecked")
     @RequestMapping(value = "/consumer/dept/list")
     public List<Dept> list() {
          return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
     }

     // 测试@EnableDiscoveryClient,消费端可以调用服务发现
     @RequestMapping(value = "/consumer/dept/discovery")
     public Object discovery() {
          return restTemplate.getForObject(REST_URL_PREFIX + "/dept/discovery", Object.class);
     }

}

