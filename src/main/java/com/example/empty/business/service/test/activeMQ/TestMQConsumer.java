package com.example.empty.business.service.test.activeMQ;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

@Component
@Slf4j
public class TestMQConsumer {


    @JmsListener(destination = "test_topic_public", containerFactory = "topicListenerContainerFactory")
    public void handleMessage(Message json) {
        String result = "";
        try {
            result = ((TextMessage)json).getText();
        } catch (JMSException e) {
            log.error(ExceptionUtils.getStackTrace(e));
        }
        log.info("MQ 获取信息" + result);
    }
}
