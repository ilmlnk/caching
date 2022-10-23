package com.template.main;

import com.template.User;
import com.template.service.impl.CacheImplService;
//testing
public class Main {
    public static void main(String[] args) {
        User user = new User(1,"Sasha","53564574");
        CacheImplService cache = new CacheImplService();
        System.out.println(cache.isCacheExist("1"));
        cache.put("1","1",user);
        cache.put("1","2","ssss");
        System.out.println(cache.isCacheExist("1"));
        System.out.println(cache.get("1", "1"));
        System.out.println(cache.createCache("1111"));
    }
}
