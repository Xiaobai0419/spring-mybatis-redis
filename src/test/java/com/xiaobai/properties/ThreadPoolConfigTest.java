package com.xiaobai.properties;

import com.xiaobai.configure.PropertiesConfig;
import com.xiaobai.configure.properties.ThreadPoolConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 纯注解方式整合Junit单元测试框架测试类
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = { PropertiesConfig.class }) // 需要注意此处，将加载配置文件的注解换成加载配置类的注解
public class ThreadPoolConfigTest {

//    private final Logger logger = LoggerFactory.getLogger(getClass());
//
//    @Autowired
//    private ThreadPoolConfig threadPoolConfig;
//
//    @Test
//    public void testThreadPoolConfig() {
//        logger.info(threadPoolConfig.toString());
//    }
}
