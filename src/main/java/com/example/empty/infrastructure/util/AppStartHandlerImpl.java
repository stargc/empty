package com.example.empty.infrastructure.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 项目启动完成后运行
 */
@Component
public class AppStartHandlerImpl implements CommandLineRunner {
    private Logger log = LoggerFactory.getLogger(AppStartHandlerImpl.class);


    @Override
    public void run(String... args) throws Exception {
        log.info("project start end,do some job.");
    }
}