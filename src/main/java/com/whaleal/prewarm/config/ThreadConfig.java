package com.whaleal.prewarm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * 线程池类
 * @AUTHOR LYZ
 * @CREATE 2022-03-20  18:25
 */
@Configuration
@EnableAsync
public class ThreadConfig {

    /**
     * 公共线程池
     */
    @Bean
    public ThreadPoolTaskExecutor commonThreadPoolTaskExecutor() {
        ThreadPoolTaskExecutor pool = new org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor();
        int processNum = Runtime.getRuntime().availableProcessors(); // 返回可用处理器的Java虚拟机的数量
        int corePoolSize = (int) (processNum / (1 - 0.2));
        int maxPoolSize = (int) (processNum / (1 - 0.5));
        pool.setCorePoolSize(corePoolSize); // 核心池大小
        pool.setMaxPoolSize(maxPoolSize); // 最大线程数
        pool.setQueueCapacity(maxPoolSize * 1000); // 队列程度
        pool.setThreadPriority(Thread.MAX_PRIORITY);
        pool.setDaemon(false);
        pool.setKeepAliveSeconds(300);// 线程空闲时间
        return pool;
    }

}
