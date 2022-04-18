package com.damon.provider.api.common.protocol.http;

import com.damon.provider.api.common.Invocation;
import com.damon.provider.api.common.Protocol;
import com.damon.provider.api.common.URL;

public class HttpProtocol implements Protocol {


    @Override
    public void start(URL url) {
        HttpServer httpServer = new HttpServer();
        httpServer.start(url.getHostName(), url.getPort());
    }

    //消费端发送消息
    @Override
    public String send(URL url, Invocation invocation) {
        HttpClient httpClient = new HttpClient();
        return httpClient.send(url.getHostName(), url.getPort(), invocation);
    }
}
