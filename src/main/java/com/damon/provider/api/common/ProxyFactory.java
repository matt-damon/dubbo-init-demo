package com.damon.provider.api.common;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

//客户端代理工厂
public class ProxyFactory {

    public static <T> T getProxy(final Class interfaceClass) {
        return (T)Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //封装RPC需要的所有参数
                Invocation invocation = new Invocation(interfaceClass.getName(), method.getName(), method.getParameterTypes(), args);
                //从注册中心获得服务地址列表
                List<URL> urlList = RemoteMapRegister.get(interfaceClass.getName());
                //负载均衡
                URL url = LoadBalance.random(urlList);
                //获取rpc协议
                Protocol protocol = ProtocolFactory.getProtocol();
                //完成rpc调用
                String result = protocol.send(url, invocation);
                return result;
            }
        });
    }
}
