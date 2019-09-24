package com.example.empty.business.strategy.test;

import com.example.empty.business.common.vo.BaseResponse;
import com.example.empty.business.service.redis.RedisValueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author guanchen
 * @version $Id TestService.java, v 0.1 2019-04-23 10:58 star Exp $$
 */
@Service
@Slf4j
public class TestStrategy {

    @Value("${testValue}")
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
}
