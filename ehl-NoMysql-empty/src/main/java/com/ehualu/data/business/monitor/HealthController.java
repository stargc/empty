package com.ehualu.data.business.monitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author created by guanchen on 2020/7/22 10:03
 */
@RestController
public class HealthController {
    private static Logger log = LoggerFactory.getLogger(HealthController.class);

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
