package com.itheima.registry;

import com.itheima.pojo.URL;

import java.util.HashMap;
import java.util.Map;

/**
 * 注册中心
 */
public class NativeRegistry {
    private static   Map<String, Map<URL,Class>>  registCenter=new HashMap<>();

    /**
     * 注册服务
     * @param interfName
     * @param url
     * @param implClass
     */
    public static void regist(String interfName,URL url,Class implClass){
        Map<URL,Class> map=new HashMap<>();
        map.put(url,implClass);
        registCenter.put(interfName,map);

    }
    public static Class get(String interfaceName,URL url){
        return  registCenter.get(interfaceName).get(url);
    }
}
