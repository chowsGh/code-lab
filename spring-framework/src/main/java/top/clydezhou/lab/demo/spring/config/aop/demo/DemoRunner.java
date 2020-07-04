package top.clydezhou.lab.demo.spring.config.aop.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author clyde
 * @date 2020-07-04 20:35
 */
@Configuration
public class DemoRunner {

    @Resource
    private AopDemoClass aopDemoClass;

    @Bean
    public Runnable aopDemoClassRunner() {
        return aopDemoClass::demo;
    }
}
