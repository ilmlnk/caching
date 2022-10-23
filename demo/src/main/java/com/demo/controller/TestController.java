package com.demo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.spi.LoggerFactoryBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ilmlnk
 * @version 0.0.1
 */
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class TestController {

    private static final String CALL_ENDPOINT = "call endpoint : %s ";

    @GetMapping("/ping")
    public String ping() {
        log.info(String.format(CALL_ENDPOINT, "ping"));
        return "work - OK";
    }
}
