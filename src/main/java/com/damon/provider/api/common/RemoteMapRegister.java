package com.damon.provider.api.common;


import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//注册中心
public class RemoteMapRegister {
    private static Map<String, List<URL>> REGISTER = new HashMap<>();

    public static void regist(String interfaceName, URL url) {
        List<URL> list = REGISTER.get(interfaceName);
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(url);
        REGISTER.put(interfaceName, list);
        //saveFile实现REGISTER在provider和consumer之间共享
        saveFile();
    }

    public static List<URL> get(String interfaceName) {
        REGISTER = getFile()    ;
        List<URL> list = REGISTER.get(interfaceName);
        return list;
    }

    private static void saveFile() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("classpath:register.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(REGISTER);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private static Map<String, List<URL>>  getFile() {
        try {
            FileInputStream fileInputStream = new FileInputStream("classpath:register.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (Map<String, List<URL>>)objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
