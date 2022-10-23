package com.template.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public interface CacheService {

    HashMap<String, Object> createCache(String cache);

    boolean put(String cache, String key, Object o);

    Object get(String cache, String key);

    void clear();

    void clear(String cache);

    boolean isCacheExist(String cache);

}
