package com.ehualu.data.business.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author created by guanchen on 2020/7/22 10:03
 */
@Slf4j
@RestController
public class TestController {

    @GetMapping("test")
    public String createIndex(){
        return "Success";
    }
}
