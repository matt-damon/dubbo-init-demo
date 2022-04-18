package com.damon.provider.api.common.protocol.dubbo;

import com.damon.provider.api.common.Invocation;
import com.damon.provider.api.common.Protocol;
import com.damon.provider.api.common.URL;

public class DubboProtocol implements Protocol {
    @Override
    public void start(URL url) {

    }

    @Override
    public String send(URL url, Invocation invocation) {
        return null;
    }
}
