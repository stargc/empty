package com.example.empty.application;

import com.example.empty.business.service.caffeine.CaffeineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author created by guanchen on 2020/12/29 13:51
 */
@Slf4j
@RestController
public class CaffeineController {

    @Autowired
    private CaffeineService caffeineService;

    @GetMapping("/cacheTest/{key}")
    public String cacheTest(@PathVariable String key) {
        log.info("do cacheTest-{}",key);
        return caffeineService.cacheTest(key);
    }

    @GetMapping("/cachePutTest/{key}")
    public String cachePutTest(@PathVariable String key) {
        log.info("do cachePutTest-{}",key);
        return caffeineService.cachePutTest(key);
    }

    @GetMapping("/cacheEvictTest/{key}")
    public String cacheEvictTest(@PathVariable String key) {
        log.info("do caffeineTest-{}",key);
        caffeineService.cacheEvictTest(key);
        return "SUCCESS";
    }
}
