package com.damon.provider.api.common;

import java.util.List;
import java.util.Random;

public class LoadBalance {
    public static URL random(List<URL> urlList) {
        Random random = new Random();
        int n = random.nextInt(urlList.size());
        return urlList.get(n);
    }
}
