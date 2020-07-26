package top.clydezhou.lab.demo.spring.service;

import org.springframework.scheduling.annotation.Async;

/**
 * @author clyde
 * @date 2020-07-21 22:07
 */
public interface ITaskService {
    @Async
    void asyncTask();
}
