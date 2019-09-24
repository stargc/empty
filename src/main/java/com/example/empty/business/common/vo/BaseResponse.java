package com.example.empty.business.common.vo;

import lombok.Data;

/**
 * @author guanchen
 * @version $Id BaseResponse.java, v 0.1 2018-08-13 15:55 star Exp $$
 */
@Data
public class BaseResponse {

    /** 成功后返回resultCode值*/
    public static final String SUCCESS = "1";
    /** 失败后返回resultCode值*/
    public static final String FAILED = "-1";

    /**返回代码*/
    private String resultCode;
    /**返回值描述*/
    private String resultMsg;
}
