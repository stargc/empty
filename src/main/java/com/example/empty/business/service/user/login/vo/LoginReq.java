package com.example.empty.business.service.user.login.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author created by guanchen on 2019/9/23 11:21
 */
@Data
public class LoginReq {
    @NotBlank(message="用户名不能为空")
    private String userName;
    @NotBlank(message="密码不能为空")
    private String password;
}
