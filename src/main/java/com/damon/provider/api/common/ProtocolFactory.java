package com.damon.provider.api.common;

import com.damon.provider.api.common.protocol.dubbo.DubboProtocol;
import com.damon.provider.api.common.protocol.http.HttpProtocol;

public class ProtocolFactory {
    public static Protocol getProtocol() {
        //vm options: -DprotocolName=dubbo
        String name = System.getProperty("protocolName");
        if (name == null || name.equals("")) name = "http";
        switch (name) {
            case "http":
                return new HttpProtocol();
            case "dubbo":
                return new DubboProtocol();
            default:
                break;
        }
        return new HttpProtocol();
    }
}
