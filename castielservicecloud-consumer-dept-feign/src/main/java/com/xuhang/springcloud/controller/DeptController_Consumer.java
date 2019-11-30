package com.xuhang.springcloud.controller;

import entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import service.DeptClientService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DeptController_Consumer
{

     @Autowired
     DeptClientService service;

     @RequestMapping(value = "/consumer/dept/get/{id}")
     public Dept get(@PathVariable("id") Long id)
     {
          return this.service.get(id);
     }

     @RequestMapping(value = "/consumer/dept/list")
     public List<Dept> list()
     {
          return this.service.list();
     }

     @RequestMapping(value = "/consumer/dept/add")
     public Object add(Dept dept)
     {
          return this.service.add(dept);
     }
}

