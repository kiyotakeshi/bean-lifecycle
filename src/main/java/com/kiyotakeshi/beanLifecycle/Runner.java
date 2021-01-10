package com.kiyotakeshi.beanLifecycle;

import com.kiyotakeshi.beanLifecycle.beans.Bean1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.IntStream;

public class Runner {
    public static void main(String[] args) {

        // try-with-resources
        // AnnotationConfigApplicationContext -> GenericApplicationContext -> ConfigurableApplicationContext
        // ConfigurableApplicationContext extends Closeable(AutoCloseable), so we can use try-with-resources to
        // public interface ConfigurableApplicationContext extends ApplicationContext, Lifecycle, Closeable {
        try (var context = new AnnotationConfigApplicationContext(AppConfig.class)) {
             var bean1 = context.getBean(Bean1.class);
        }

        // not called PreDestroy unless context.close()
//        IntStream.range(0, 3).mapToObj(i -> "").forEach(System.out::println); // three lines
        var context = new AnnotationConfigApplicationContext(AppConfig.class);
        var bean1 = context.getBean(Bean1.class);
         context.close();
    }
}
