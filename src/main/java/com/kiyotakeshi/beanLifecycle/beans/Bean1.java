package com.kiyotakeshi.beanLifecycle.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Bean1 {

    private Bean2 bean2;
    private Bean3 bean3;

    public Bean1() {
        System.out.println(getClass().getSimpleName() + "::constructor");
    }

    @Autowired
    public void setBean2(Bean2 bean2) {
        System.out.println(getClass().getSimpleName() + "::setSpringBean2");
        this.bean2 = bean2;
    }

    @Autowired
    public void setBean3(Bean3 bean3) {
        System.out.println(getClass().getSimpleName() + "::setSpringBean3");
        this.bean3 = bean3;
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
