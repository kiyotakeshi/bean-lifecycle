package com.kiyotakeshi.beanLifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
public class AppConfig {

    @Bean
    public static CustomBeanFactoryPostProcessor getCustomBeanFactoryPostProcessor(){
        return new CustomBeanFactoryPostProcessor();
    }

    @Bean
    public static CustomBeanPostProcessor getCustomBeanPostProcessor(){
        return new CustomBeanPostProcessor();
    }
}
