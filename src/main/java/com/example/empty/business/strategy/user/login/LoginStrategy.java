package com.example.empty.business.strategy.user.login;

import com.example.empty.business.common.vo.BaseResponse;
import com.example.empty.business.service.user.UserService;
import com.example.empty.business.strategy.user.login.vo.LoginReq;
import com.example.empty.business.strategy.user.login.vo.LoginResp;
import com.example.empty.infrastructure.persistence.po.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author created by guanchen on 2019/9/23 11:20
 */
@Slf4j
@Service
public class LoginStrategy {

    @Resource
    private UserService userService;

    public LoginResp login(LoginReq req){
        LoginResp resp = new LoginResp();
        User user = userService.selectUserInfoByUserIdAndPassword(req.getUserName(),req.getPassword());
        if (user == null){
            resp.setResultCode(BaseResponse.SUCCESS);
            resp.setResultMsg("用户名或密码错误");
            return resp;
        }
        resp.setResultCode(BaseResponse.SUCCESS);
        if (user != null) {
            String phone = user.getPhone();
            log.info(phone);
        }

        return resp;
    }


    public static void main(String[] args) {
        User user = new User();
        user.setPhone("151");

        User emptyUser = null;


        Optional<User> userOptional = Optional.of(user);
        System.out.println(userOptional.get().getPhone().toString());


        Optional<User> userEOptional = Optional.of(emptyUser);
        System.out.println(userEOptional.get().getPhone().toString());

    }
}
