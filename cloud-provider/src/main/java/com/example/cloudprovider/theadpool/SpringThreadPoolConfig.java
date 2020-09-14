package com.example.cloudprovider.theadpool;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync //开启异步处理注解
public class SpringThreadPoolConfig {
    @Bean//把线程池对象注入到spring环境中
    public Executor createSpringThreadPool(){
        ThreadPoolTaskExecutor springThreadPool = new ThreadPoolTaskExecutor();
        //设置线程池中 线程名称的前缀 不加有默认线程名称
        springThreadPool.setThreadNamePrefix("type-add-");
        //设置线程池核心线程数  当任务数量小于核心线程数时
        //每来一个任务 都会创建一个新的线程对象 即便当前线程池中有空闲的线程
        //表示常驻核心线程数。如果等于0，则任务执行完成后，没有任何请求进入时销毁线程池的线程；
        // 如果大于0，即使本地任务执行完毕，核心线程也不会被销毁。这个值的设置非常关键，
        // 设置过大会浪费资源，设置的过小会导致线程频繁地创建或销毁。
        springThreadPool.setCorePoolSize(100);
        //设置线程缓冲队列 当任务数 大于 核心线程数时 把多余的任务存入缓冲队列中
        //当核心线程池中有空闲线程对象时 从缓冲队列中获取任务 执行任务
        springThreadPool.setQueueCapacity(80000);
        //当前任务数量大于缓冲队列数量时 再创建线程 最多创建300
        springThreadPool.setMaxPoolSize(300);
        //当前任务数量大于最大线程时 如何处理  CallerRunsPolicy 使用主线程处理当前任务
        springThreadPool.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //空闲线程的超时时间
        springThreadPool.setKeepAliveSeconds(6000);
        //设置核心线程 是否需要空闲超时关闭 默认是false
        springThreadPool.setAllowCoreThreadTimeOut(true);
        return  springThreadPool;
    }
}
