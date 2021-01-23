package com.example.empty.business.service.activeMQ;

//import org.apache.activemq.command.ActiveMQDestination;
//import org.apache.activemq.command.ActiveMQQueue;
//import org.apache.activemq.command.ActiveMQTopic;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 * @author created by guanchen on 2019/12/29 11:54
 */
@Service
public class TestMQProducer {
//    @Autowired
//    private JmsMessagingTemplate jmsMessagingTemplate;

    public void send(String quereName, String msg, int queueType) {
//        ActiveMQDestination queue = null;
//        switch (queueType) {
//            case 0:
//                queue = new ActiveMQTopic(quereName);
//                break;
//            case 1:
//                queue = new ActiveMQQueue(quereName);
//                break;
//            default:
//                queue = new ActiveMQQueue(quereName);
//                break;
//        }
//
//        this.jmsMessagingTemplate.convertAndSend(queue, msg);
    }

}
