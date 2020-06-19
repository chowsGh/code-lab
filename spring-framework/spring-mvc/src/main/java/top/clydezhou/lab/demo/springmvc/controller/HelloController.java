package top.clydezhou.lab.demo.springmvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author clyde
 * @date 2020-06-18 23:35
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Resource
    private String vl;

    @GetMapping("/world")
    public String helloWorld() {
        return "hello world" + vl;
    }
}
