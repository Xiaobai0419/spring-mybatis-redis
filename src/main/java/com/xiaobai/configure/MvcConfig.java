package com.xiaobai.configure;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@ComponentScan(basePackages = "com.xiaobai")
@ImportResource("classpath:applicationContext.xml")
public class MvcConfig{
}
