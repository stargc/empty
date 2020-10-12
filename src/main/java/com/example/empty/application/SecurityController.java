package com.example.empty.application;

import com.example.empty.business.service.security.KerberosService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author created by guanchen on 2020/7/28 14:22
 */

@Slf4j
@Validated
@RestController
public class SecurityController {

    @Autowired
    private KerberosService kerberos;

    @GetMapping("kerberosTest")
    public String kerberosTest(HttpServletRequest request, HttpServletResponse response){
        kerberos.check(request, response);
        return "SUCCESS";
    }
}
