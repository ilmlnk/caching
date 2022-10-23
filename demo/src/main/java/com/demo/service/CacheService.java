package com.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.demo.service.impl.CacheServiceImpl;

import java.util.HashMap;
import java.util.Map;

@Service
public class CacheService implements CacheServiceImpl {
    private HashMap<String, HashMap<String, Object>> cacheMap = new HashMap<>();

    @Cacheable
    @Override
    public Map<String, Object> createCache(String cache) {
        return cacheMap.put(cache,new HashMap<>());
    }

    @CachePut
    @Override
    public boolean put(String cache, String key, Object o) {
        if(isCacheExist(cache)){
            cacheMap.put(cache, (HashMap<String, Object>) new HashMap().put(key, o));
        } else {
            HashMap<String,Object> objectCacheMap = new HashMap<>();
            objectCacheMap.put(key,o);
            cacheMap.put(cache,objectCacheMap);
        }
        return true;
    }

    @Override
    public Object get(String cache, String key) {
        return cacheMap.get(cache).get(key);
    }

    @CacheEvict
    @Override
    public void clear() {
        cacheMap = new HashMap<>();
    }

    @CacheEvict
    @Override
    public void clear(String cache) {
        cacheMap.remove(cache);
    }

    @Override
    public boolean isCacheExist(String cache) {
      return cacheMap.containsKey(cache);
    }
}
