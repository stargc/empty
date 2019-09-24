package com.example.empty.business.service.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author created by guanchen on 2019/9/23 16:58
 */
@Service
public class RedisValueService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /***
     * 字符型存储
     * @param key
     * @param value
     */
    public void setValue(String key, String value) {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key, value);
    }

    /***
     * 字符型存储，设置过期时间
     * @param key
     * @param value
     * @param timeout
     * @param unit
     */
    public void setValueByTimer(String key, Object value, long timeout, TimeUnit unit) {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key, value, timeout, unit);
    }


    /**
     * 查询字符型存储的结果
     * @param key
     * @return
     */
    public <T> T getValue(String key, Class<T> responseType) {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        Object o = valueOperations.get(key);
        if(o == null){
            return null;
        }
        if (responseType instanceof Class){
            return (T)o;
        }
        throw new RuntimeException("数据类型解析错误");
    }

    /**
     * 查询字符型存储的结果
     * @param key
     * @return
     */
    public String getValue(String key) {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        if(valueOperations.get(key) == null){
            return null;
        }
        return valueOperations.get(key).toString();
    }

    /***
     * 判断Key是否存在
     * @param key
     * @return
     */
    public boolean existsKey(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 删除key
     *
     * @param key
     */
    public void deleteKey(String key) {
        redisTemplate.delete(key);
    }

    /**
     * 删除多个key
     *
     * @param keys
     */
    public void deleteKey(String... keys) {
        Set<String> kSet = Stream.of(keys).collect(Collectors.toSet());
        redisTemplate.delete(kSet);
    }

    /**
     * 设置key的生命周期
     *
     * @param key
     * @param time
     * @param timeUnit
     */
    public void expireKey(String key, long time, TimeUnit timeUnit) {
        redisTemplate.expire(key, time, timeUnit);
    }

    /**
     * 指定key在指定的日期过期
     *
     * @param key
     * @param date
     */
    public void expireKeyAt(String key, Date date) {
        redisTemplate.expireAt(key, date);
    }

}
