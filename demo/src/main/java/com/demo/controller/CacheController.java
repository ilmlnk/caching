package com.demo.controller;

import com.demo.service.CacheService;
import lombok.extern.log4j.Log4j;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author ilmlnk
 * @version 0.0.1
 */
@RestController
@RequestMapping("/api/v1/cache")
@Log4j
public class CacheController {

    private CacheService cacheService;

    @PostMapping("/create")
    public Map<String, Object> createCache(String cache){
        return cacheService.createCache(cache);
    }

    @PostMapping
    public boolean put(String cache, String key, Object o){
        return cacheService.put(cache,key,o);
    }
    
    @GetMapping
    public Object get(String cache, String key) {
        return cacheService.get(cache,key);
    }
    
    @DeleteMapping("/delete")
    public void clear(){
        cacheService.clear();
    }

    @DeleteMapping("/delete")
    public void clear(String cache){
        cacheService.clear(cache);
    }
}
