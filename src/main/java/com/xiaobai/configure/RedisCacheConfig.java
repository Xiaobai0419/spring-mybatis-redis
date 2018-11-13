package com.xiaobai.configure;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import java.lang.reflect.Method;


/**
 * 通过spring管理redis缓存配置
 *
 * @author Administrator
 * @EnableCaching注解是spring framework中的注解驱动的缓存管理功能。
 * 自spring版本3.1起加入了该注解。如果你使用了这个注解，那么你就不需要在XML文件中配置cache manager了，
 * 等价于 <cache:annotation-driven/> 。能够在服务类方法上标注@Cacheable
 */
@Configuration
@EnableCaching
public class RedisCacheConfig
        extends CachingConfigurerSupport
{
//    private volatile JedisConnectionFactory jedisConnectionFactory;
//    private volatile RedisTemplate<String, String> redisTemplate;
//    private volatile RedisCacheManager redisCacheManager;
//
//    public RedisCacheConfig() {
//        super();
//    }

//    /**
//     * 带参数的构造方法 初始化所有的成员变量
//     *
//     * @param jedisConnectionFactory
//     * @param redisTemplate
//     * @param redisCacheManager
//     */
//    public RedisCacheConfig(JedisConnectionFactory jedisConnectionFactory, RedisTemplate<String, String> redisTemplate,
//                            RedisCacheManager redisCacheManager) {
//        this.jedisConnectionFactory = jedisConnectionFactory;
//        this.redisTemplate = redisTemplate;
//        this.redisCacheManager = redisCacheManager;
//    }
//
//    public JedisConnectionFactory getJedisConnecionFactory() {
//        return jedisConnectionFactory;
//    }
//
//    public RedisTemplate<String, String> getRedisTemplate() {
//        return redisTemplate;
//    }
//
//    public RedisCacheManager getRedisCacheManager() {
//        return redisCacheManager;
//    }

    @Bean
//    public KeyGenerator customKeyGenerator() {
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            public Object generate(Object target, Method method, Object... objects) {
                StringBuilder sb = new StringBuilder();
                sb.append(target.getClass().getName());
                sb.append(method.getName());
                for (Object obj : objects) {
                    sb.append(obj.toString());
                }
                return sb.toString();
            }
        };
    }
}
