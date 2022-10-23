package com.demo.service.impl;

import java.util.Map;

public interface CacheServiceImpl {
    Map<String, Object> createCache(String cache);
    boolean put(String cache, String key, Object o);
    Object get(String cache, String key);
    void clear();
    void clear(String cache);
    boolean isCacheExist(String cache);
}
