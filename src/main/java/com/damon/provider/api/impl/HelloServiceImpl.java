package com.damon.provider.api.impl;

import com.damon.provider.api.HelloService;

//提供服务
public class HelloServiceImpl implements HelloService {

    @Override
    public String hello(String name) {
        return "hello," + name;
    }
}
