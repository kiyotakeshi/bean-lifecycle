package com.kiyotakeshi.beanLifecycle;

import com.kiyotakeshi.beanLifecycle.beans.Bean1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.IntStream;

public class Runner {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class)) {
             var bean1 = context.getBean(Bean1.class);
        }

        // not called PreDestroy
//        IntStream.range(0, 3).mapToObj(i -> "").forEach(System.out::println); // three lines
//        var context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
//        var bean1 = context.getBean(Bean1.class);
    }
}
