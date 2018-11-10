package com.xiaobai.configure.properties;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

//@Component
//@PropertySource("classpath:properties/thread-pool.properties")
public class ThreadPoolConfig {
    /**
     * 核心线程个数
     */
    @Value("${core.pool.size}")
    private int corePoolSize;
    /**
     * 最大线程个数
     */
    @Value("${max.pool.size}")
    private int maxPoolSize;
    /**
     * 保持心跳时间
     */
    @Value("${keep.alive.time}")
    private int keeAliveTime;
    /**
     * 任务队列长度
     */
    @Value("${task.queue.size}")
    private int taskQueueSize;
    /**
     * 等待任务结束的时间
     */
    @Value("${await.termination.time}")
    private int awaitTerminationTime;

    /**
     * 使用@value注解注入properties中的属性
     * 1. 在类名上面使用  @PropertySource("classpath:*") 注解,*代表属性文件路径,可以指向多个配置文件路径
     *      如果是多个配置文件,则是 @PropertySource({"classpath:*","classpath:*"....})
     * 2. 在字段上直接使用@value注解
     * 3. 注解内使用${core.pool.size}  core.pool.size 代表属性文件里面的key
     * 5. 需要新增 PropertySourcesPlaceholderConfigurer 的 bean
     * 6. 在 PropertySourcesPlaceholderConfigurer 增加@bean注解,申明返回的是一个bean,否则会注入失败
     *
     */

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
