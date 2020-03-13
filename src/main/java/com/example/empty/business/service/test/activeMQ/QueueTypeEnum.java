package com.example.empty.business.service.test.activeMQ;

public enum QueueTypeEnum {
    TOPIC("0","Topic"),
    QUEUE("1","Topic");

    private String code;
    private String msg;

    private QueueTypeEnum(String code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
