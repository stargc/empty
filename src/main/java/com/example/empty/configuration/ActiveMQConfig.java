//package com.example.empty.configuration;
//
//import org.apache.activemq.ActiveMQConnectionFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jms.annotation.EnableJms;
//import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
//import org.springframework.jms.config.JmsListenerContainerFactory;
//
//import javax.jms.ConnectionFactory;
//
///**
// * @author created by guanchen on 2020/1/2 10:22
// */
//@Configuration
//@EnableJms
//public class ActiveMQConfig {
//
//    @Value("${spring.activemq.broker-url}")
//    private String url;
//    @Value("${spring.activemq.user}")
//    private String user;
//    @Value("${spring.activemq.password}")
//    private String password;
//
//    @Bean
//    public ConnectionFactory getActiveMqConnection(){
//        return new ActiveMQConnectionFactory(user, password,url);
//    }
//
//    @Bean(name="queueListenerContainerFactory")
//    public JmsListenerContainerFactory queueListenerContailerFactory(ConnectionFactory connectionFactory){
//        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
//        factory.setConnectionFactory(connectionFactory);
//        factory.setPubSubDomain(false);
//        return factory;
//    }
//
//    @Bean(name="topicListenerContainerFactory")
//    public JmsListenerContainerFactory topicListenerContainerFactory(ConnectionFactory connectionFactory){
//        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
//        factory.setConnectionFactory(connectionFactory);
//        factory.setPubSubDomain(true);
//        return factory;
//    }
//}
