package com.kiyotakeshi.beanLifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import java.util.Arrays;

/**
 * Override Bean definition phase
 */
public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println(getClass().getSimpleName() + "::postProcessBeanFactory Listing Beans Start\n");

        // display all beans
        // Arrays.stream(beanFactory.getBeanDefinitionNames()).forEach(System.out::println);

        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();

        // display my custom settings bean
//        for (var beanDefinitionName :beanDefinitionNames){
//            String beanClassName = beanFactory.getBeanDefinition(beanDefinitionName).getBeanClassName();
//
//            String regex = "com.kiyotakeshi.beanLifecycle.beans";
//            if (beanClassName != null && beanClassName.contains(regex)){
//                System.out.println(beanClassName);
//            }
//        }

        // regex define outside method
//        for (var beanDefinitionName :beanDefinitionNames){
//            String beanClassName = beanFactory.getBeanDefinition(beanDefinitionName).getBeanClassName();
//
//            if (beanClassNameContains(beanClassName, "com.kiyotakeshi.beanLifecycle.beans")){
//                System.out.println(beanClassName);
//            }
//        }

//        private boolean beanClassNameContains (String beanClassName, String regex){
//            return beanClassName != null && beanClassName.contains(regex);
//        }

        // use lambda expression
        Arrays.stream(beanFactory.getBeanDefinitionNames()) // bean1
                .map(beanFactory::getBeanDefinition) // Generic bean: class [com.kiyotakeshi.beanLifecycle.beans.Bean1]; scope=singleton; abstract=false; lazyInit=null; autowireMode=0; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=null; factoryMethodName=null; initMethodName=null; destroyMethodName=null; defined in file [/Users/kiyotakeshi/gitdir/java/bean-lifecycle/target/classes/com/kiyotakeshi/beanLifecycle/beans/Bean1.class]
                .filter(beanDefinition -> beanClassNameContains(beanDefinition, "com.kiyotakeshi.beanLifecycle.beans")) // Generic bean: class [com.kiyotakeshi.beanLifecycle.beans.Bean1]; scope=singleton; abstract=false; lazyInit=null; autowireMode=0; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=null; factoryMethodName=null; initMethodName=null; destroyMethodName=null; defined in file [/Users/kiyotakeshi/gitdir/java/bean-lifecycle/target/classes/com/kiyotakeshi/beanLifecycle/beans/Bean1.class]
                .map(BeanDefinition::getBeanClassName)
                .forEach(System.out::println); // com.kiyotakeshi.beanLifecycle.beans.Bean1

        System.out.println("\n" +getClass().getSimpleName() + "::postProcessBeanFactory Listing Beans End\n");
    }

    private boolean beanClassNameContains(BeanDefinition beanDefinition, String regex) {
        return beanDefinition != null && beanDefinition.getBeanClassName().contains(regex);
    }
}
