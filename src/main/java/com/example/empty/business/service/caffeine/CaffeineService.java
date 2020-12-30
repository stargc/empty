package com.example.empty.business.service.caffeine;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author guanchen
 * @version $Id TestService.java, v 0.1 2019-04-23 10:58 star Exp $$
 */
@Service
@Slf4j
public class CaffeineService {

    @Cacheable(value = "IZUUL", key = "#key")
    public String cacheTest(String key) {
        log.info("do cacheIZUUL()-{}",key);
        return getCache(key);
    }

    @CachePut(value = "IZUUL", key = "#key")
    public String cachePutTest(String key) {
        log.info("do cachePutIZUUL()-{}",key);
        return "cachePutIZUUL--" + key;
    }

    private String getCache(String key) {
        try {
            Thread.sleep(5000);
            log.info("do getCache()-{}",key);
        } catch (InterruptedException e) {
            log.error(ExceptionUtils.getStackTrace(e));
        }
        return key;
    }

    @CacheEvict(value = "IZUUL", key = "#key")
    public void cacheEvictTest(String key){
        log.info("do cacheEvictIZUUL()-{}",key);
    }

}
