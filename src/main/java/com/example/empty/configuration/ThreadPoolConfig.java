package com.example.empty.configuration;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author created by guanchen on 2019/12/30 16:37
 */
@Configuration
@EnableAsync
public class ThreadPoolConfig implements AsyncConfigurer {

    @Value("${threadPool.corePoolSize}")
    private int corePoolSize;
    @Value("${threadPool.maxPoolSize}")
    private int maxPoolSize;
    @Value("${threadPool.queueCapacity}")
    private int queueCapacity;
    @Value("${threadPool.keepAliveSeconds}")
    private int keepAliveSeconds;

    @Override
    @Bean(value = "customExecutor")
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        // 最先线程池，低于这个数，新建线程
        threadPoolTaskExecutor.setCorePoolSize(corePoolSize);
        // 最大线程池
        threadPoolTaskExecutor.setMaxPoolSize(maxPoolSize);
        // 持有等待执行的任务队列大小
        threadPoolTaskExecutor.setQueueCapacity(queueCapacity);
        //空闲线程的存活时间
        threadPoolTaskExecutor.setKeepAliveSeconds(keepAliveSeconds);
        //配置线程池中的线程的名称前缀
        threadPoolTaskExecutor.setThreadNamePrefix("async-service-");

        // 任务执行策略-处理程序遭到拒绝将抛出运行时 RejectedExecutionException。
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }

}
