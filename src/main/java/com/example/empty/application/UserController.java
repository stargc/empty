package com.example.empty.application;

import com.example.empty.business.service.user.login.LoginService;
import com.example.empty.business.service.user.login.vo.LoginReq;
import com.example.empty.business.service.user.login.vo.LoginResp;
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
    private LoginService loginService;

    @PostMapping("/_login")
    public LoginResp login(@RequestBody @Valid LoginReq req){
        return loginService.login(req);
    }
}
