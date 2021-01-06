package com.kiyotakeshi.beanLifecycle.beans;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Bean3 {

    public Bean3() {
        System.out.println(getClass().getSimpleName() + "::constructor");
    }

    @PostConstruct
    public void init() {
        System.out.println(getClass().getSimpleName() + "::init");
    }

    @PreDestroy
    public void destroy() {
        System.out.println(getClass().getSimpleName() + "::destroy");
    }

}
