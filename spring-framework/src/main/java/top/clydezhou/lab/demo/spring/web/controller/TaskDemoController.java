package top.clydezhou.lab.demo.spring.web.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.clydezhou.lab.demo.spring.config.aop.LogAnnotation;
import top.clydezhou.lab.demo.spring.service.ITaskService;
import top.clydezhou.lab.demo.spring.service.TaskService;
import top.clydezhou.lab.demo.spring.utils.JsonUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author clyde
 * @date 2020-07-21 22:03
 */
@RestController
@RequestMapping("/task-demo")
public class TaskDemoController {

    // 使用接口的原因是，spring 会产生代理类，而代理类是实现接口，而不是继承 TaskService
    private ITaskService taskService;

    @RequestMapping("/async")
    public Map<String, Object> asyncDemo(HttpServletRequest request) {
        long start = System.currentTimeMillis();
        taskService.asyncTask();
        long cost = (System.currentTimeMillis() - start);
        Map<String, Object> result = new HashMap<>();
        result.put("cost", cost);
        result.put("name", "asyncDemo");
        return result;
    }

    @Resource
    public void setTaskService(ITaskService taskService) {
        this.taskService = taskService;
    }
}
