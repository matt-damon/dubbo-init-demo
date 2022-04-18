package com.damon.provider.api.common;

public interface Protocol {
    void start(URL url);//协议启动时做啥
    String send(URL url, Invocation invocation);//协议如何传输数据
}
