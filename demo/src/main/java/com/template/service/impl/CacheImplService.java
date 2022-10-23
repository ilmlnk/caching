package com.template.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.template.service.CacheService;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class CacheImplService implements CacheService {
    private HashMap<String,HashMap<String,Object>> cacheMap = new HashMap<>();


    @Override
    public HashMap<String, Object> createCache(String cache) {
        return cacheMap.put(cache,new HashMap<>());
    }

    @Override
    public boolean put(String cache, String key, Object o) {
        if(!isCacheExist(cache)){
            HashMap<String,Object> objectHashMap = new HashMap<>();
            objectHashMap.put(key,o);
            cacheMap.put(cache,objectHashMap);
        }else {
            cacheMap.put(cache, (HashMap<String, Object>) new HashMap().put(key, o));
        }
        System.out.println(cacheMap.get(cache));
        return true;
    }

    @Override
    public Object get(String cache, String key) { //get object from object map
        return this.cacheMap.get(cache).get(key);
    }

    @Override
    public void clear() { //full clear
        cacheMap = new HashMap<>();
    }

    @Override
    public void clear(String cache) { //object map clear
        cacheMap.remove(cache);
    }

    @Override
    public boolean isCacheExist(String cache) {
      return cacheMap.containsKey(cache);
    }
}
