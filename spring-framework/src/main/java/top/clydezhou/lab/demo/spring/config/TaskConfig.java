package top.clydezhou.lab.demo.spring.config;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Executor;

/**
 * @author clyde
 * @date 2020-07-21 21:25
 */
@EnableAsync
@Configuration
public class TaskConfig implements AsyncConfigurer {

//    @Override
//    public Executor getAsyncExecutor() {
//        return null;
//    }
//
//    @Override
//    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
//        return null;
//    }
}
