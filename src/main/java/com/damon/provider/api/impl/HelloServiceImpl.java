package com.damon.provider.api.impl;

import com.damon.provider.api.HelloService;

//ζδΎζε‘
public class HelloServiceImpl implements HelloService {

    @Override
    public String hello(String name) {
        return "hello," + name;
    }
}
