package com.ehualu.data.business.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author created by guanchen on 2020/7/22 10:03
 */
@Slf4j
@RestController
public class HealthController {

    @GetMapping("healthCheck")
    public void healthCheck(){
        log.info("服务正常");
    }

    @GetMapping("healthCheckForLog")
    public String healthCheckForLog(@RequestParam String ip){
        String logMsg = String.format("IP[%s]服务可以正常访问！",ip);
        log.info(logMsg);
        return logMsg;
    }
}
