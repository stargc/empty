package com.example.empty.application;

import com.example.empty.business.common.vo.BaseResponse;
import com.example.empty.business.service.test.TestService;
import com.example.empty.business.service.test.activeMQ.TestMQProducer;
import com.example.empty.business.service.test.vo.ValidatorRequest;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;

@Slf4j
@Validated
@RestController
public class TestController {

    @Autowired
    private TestService testService;
    @Autowired
    private TestMQProducer testMQProducer;

    @PostMapping("/test1")
    public BaseResponse test1(@RequestBody @Valid ValidatorRequest demo){
        return testService.doTest();
    }

    @GetMapping(value = "/{room}")
    public BaseResponse test2(@PathVariable @Range(min = 1, max = 9, message = "教室只能从1-9") int room, @RequestParam @Email String email) {
        log.info(email + "," + room);
        return testService.doTest();
    }

    @GetMapping("redisTest")
    public BaseResponse redisTest(){
        return testService.redisTest();
    }


    @GetMapping("restTest/{phone}")
    public BaseResponse restTest(@PathVariable String phone){
        return testService.restTest(phone);
    }

    @GetMapping("/cacheTest/{key}")
    public String cacheTest(@PathVariable String key) {
        log.info("do cacheTest");
        return testService.cacheTest(key);
    }

    @GetMapping("/cachePutTest/{key}")
    public String cachePutTest(@PathVariable String key) {
        log.info("do cachePutTest");
        return testService.cachePutTest(key);
    }

    @GetMapping("/caffeineTest/{key}")
    public String caffeineTest(@PathVariable String key) {
        log.info("do caffeineTest");
        return testService.caffeineTest(key);
    }

    @GetMapping("/testAsync")
    public BaseResponse testAsync() {
        for (int i = 0; i < 10; i++) {
            testService.testExecutor(i);
        }
        return new BaseResponse(BaseResponse.SUCCESS,"SUCCESS");
    }

    @GetMapping("ZHCG/muckMQ")
    public BaseResponse muckMQ(@RequestParam String quereName,@RequestParam String msg,@RequestParam int queueType){
        testMQProducer.send(quereName,msg,queueType);
        return new BaseResponse(BaseResponse.SUCCESS,"SUCCESS");
    }


}
