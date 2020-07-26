package top.clydezhou.lab.demo.spring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import top.clydezhou.lab.demo.spring.config.aop.LogAnnotation;

/**
 * @author clyde
 * @date 2020-07-21 22:04
 */
@Service
public class TaskService implements ITaskService {
    private Logger LOGGER = LoggerFactory.getLogger(TaskService.class);

    @LogAnnotation
    @Async
    @Override
    public void asyncTask() {
        LOGGER.info("start async task");
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            LOGGER.error("asyncTask exception", e);
        }
        LOGGER.info("end async task");
    }
}
