package com.example.empty.business.strategy.test;

import com.example.empty.business.common.vo.BaseResponse;
import com.example.empty.business.service.redis.RedisValueService;
import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/**
 * @author guanchen
 * @version $Id TestService.java, v 0.1 2019-04-23 10:58 star Exp $$
 */
@Service
@Slf4j
public class TestStrategy {

    @Value("${system_testValue}")
    private String testValue;

    @Resource
    private RedisValueService redisValueService;

    @Resource
    private RestTemplate restTemplate;

    public BaseResponse doTest(){
        log.info(testValue);
        BaseResponse response = new BaseResponse();
        response.setResultCode(BaseResponse.SUCCESS);
        response.setResultMsg("SUCCESS：" + testValue);
        return response;
    }

    public BaseResponse redisTest(){
        String key = "test";
        redisValueService.setValueByTimer(key,new Date(),100, TimeUnit.MINUTES);
        log.info(redisValueService.getValue(key));
        Date date = redisValueService.getValue(key,Date.class);
        log.info(date.toLocaleString());

        BaseResponse response = new BaseResponse();
        response.setResultCode(BaseResponse.SUCCESS);
        response.setResultMsg("SUCCESS");
        return response;
    }

    public BaseResponse restTest(String phone){
        String url = String.format("http://apis.juhe.cn/mobile/get?phone=%s&key=b8c3c0asdwab284ca6cd9a51fee15c76",phone);
        String result = restTemplate.getForObject(url,String.class);

        BaseResponse response = new BaseResponse();
        response.setResultCode(BaseResponse.SUCCESS);
        response.setResultMsg(result);
        return response;
    }

    @Cacheable(value = "IZUUL", key = "#key")
    public String cacheTest(String key) {
        log.info("cacheIZUUL()方法执行");
        return getCache(key);
    }

    @CachePut(value = "IZUUL", key = "#key")
    public String cachePutTest(String key) {
        log.info("cachePutIZUUL()方法执行");
        return "cachePutIZUUL--" + key;
    }
    private String getCache(String key) {
        try {
            log.info("getCache()方法执行");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return key;
    }

    public String caffeineTest(String key){
        LoadingCache<String, String> build = Caffeine.newBuilder().refreshAfterWrite(1, TimeUnit.MINUTES)
                .build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String key)  {
                        return "aaa";
                    }
                });
        String a = build.get(key);
        build.refresh(key);
        build.invalidateAll();
        return a;
    }

    @Async
    public void testAsync(int i) {
        System.out.println(i + "异步线程id：" + Thread.currentThread().getId() + " start");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(i + "异步线程id：" + Thread.currentThread().getId() + " end");
    }

    @Autowired
    private Executor executor;

    public void testExecutor(int i){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                testAsync(i);
            }
        });
    }
}
