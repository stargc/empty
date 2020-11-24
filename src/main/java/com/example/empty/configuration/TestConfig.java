package com.example.empty.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.io.IOException;

/**
 * @author created by guanchen on 2020/11/24 8:56
 */
@Configuration
@Slf4j
public class TestConfig {

    @Value("${system_testValue}")
    private String coreSite;

    @Bean
    @ConditionalOnProperty(name = "stdp.security.enable", havingValue = "true")
    public void kerberosAuth(){
        log.info("do first");
    }

    @Bean
    @DependsOn("kerberosAuth")
    public void hbaseTemplate(){
        log.info("do second");
    }
}
