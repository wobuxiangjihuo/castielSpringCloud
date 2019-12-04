package com.xuhang.service;



import com.xuhang.springcloud.entity.Dept;

import java.util.List;

/**
 * Created by ZeroV on 2018/11/6.
 */
public interface DeptService {

    public boolean add(Dept dept);

    public Dept get(Long id);

    public List<Dept> list();
}