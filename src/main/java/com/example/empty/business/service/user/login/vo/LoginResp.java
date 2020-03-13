package com.example.empty.business.service.user.login.vo;

import com.example.empty.business.common.vo.BaseResponse;
import lombok.Data;

/**
 * @author created by guanchen on 2019/9/23 11:21
 */
@Data
public class LoginResp extends BaseResponse {
    private String userName;
    private Object orgInfo;
    private Object roleInfo;
}
