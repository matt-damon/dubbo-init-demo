package com.damon.consumer;

import com.damon.provider.api.HelloService;
import com.damon.provider.api.common.ProxyFactory;

public class Consumer {
    public static void main(String[] args) {
        HelloService helloService = ProxyFactory.getProxy(HelloService.class);
        String name = helloService.hello("damon");
        System.out.println("consumer result:" + name);
    }
}
