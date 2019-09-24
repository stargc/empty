package com.example.empty.application;

import com.example.empty.business.strategy.user.login.LoginStrategy;
import com.example.empty.business.strategy.user.login.vo.LoginReq;
import com.example.empty.business.strategy.user.login.vo.LoginResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@Slf4j
@Validated
@RestController
@RequestMapping({"/dluc/user/"})
public class UserController {

    @Resource
    private LoginStrategy loginStrategy;

    @PostMapping("/_login")
    public LoginResp login(@RequestBody @Valid LoginReq req){
        return loginStrategy.login(req);
    }
}
