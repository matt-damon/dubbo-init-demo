package com.damon.provider.api.common.protocol.http;

import com.damon.provider.api.common.Invocation;
import com.damon.provider.api.common.LocalRegister;
import org.apache.commons.io.IOUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ObjectInputStream;
import java.lang.reflect.Method;


public class HttpServerHandler {
    public void handler(HttpServletRequest req, HttpServletResponse resp) {
        try {
            ObjectInputStream ois = new ObjectInputStream(req.getInputStream());
            Invocation invocation = (Invocation)ois.readObject();

            String interfaceName = invocation.getInterfaceName();
            //根据本地存储的映射获取字节码对象
            Class implClass = LocalRegister.get(interfaceName);
            //反射
            Method method = implClass.getMethod(invocation.getMethodName(), invocation.getParameterTypes());
            String result = (String)method.invoke(implClass.newInstance(), invocation.getParams());
            System.out.println("server tomcat:" + result);
            IOUtils.write(result.getBytes(), resp.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
