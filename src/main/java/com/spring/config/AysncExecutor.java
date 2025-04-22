package com.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class AysncExecutor {

    private static ThreadPoolTaskExecutor getThreadPoolTaskExecutor(){
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        int cores = Runtime.getRuntime().availableProcessors();
        threadPoolTaskExecutor.setCorePoolSize(cores);
        threadPoolTaskExecutor.setMaxPoolSize(2* cores);
        threadPoolTaskExecutor.setThreadNamePrefix("CUSTOM-THREADPOOL-");
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }

    @Bean(name = "taskExecutor")
    public ThreadPoolTaskExecutor customThreadPool(){
        return getThreadPoolTaskExecutor();
    }
}
