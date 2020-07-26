package top.clydezhou.lab.demo.spring.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author clyde
 * @date 2020-07-12 19:43
 */

@Component
public class SpringUtils implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static <T> T getBean(Class<T> clz) {
        return context.getBean(clz);
    }

    public static <T> T getBean(String name, Class<T> clz) {
        return context.getBean(name, clz);
    }

    public static Object getBean(String name) {
        return context.getBean(name);
    }
}
