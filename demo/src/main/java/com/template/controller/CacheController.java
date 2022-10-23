package com.template.controller;


import com.template.service.impl.CacheImplService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @version 0.0.1
 */
@RestController
@RequestMapping("/api/v1/cache")
@RequiredArgsConstructor
@Slf4j
public class CacheController {

    private final CacheImplService cacheImplService;

    @GetMapping
    public Object getCache(String cache, String key){return cacheImplService.get(cache,key);}

    @PostMapping
    public boolean put(String cache, String key, Object o){
        return cacheImplService.put(cache,key,o)  ;
    }

    @PostMapping("/crate")
    public HashMap<String, Object> createCache(String cache){return cacheImplService.createCache(cache);}

    @DeleteMapping("/delete")
    public void clear(){cacheImplService.clear();}

    @DeleteMapping
    public void clear(String cache){cacheImplService.clear(cache);}





}
