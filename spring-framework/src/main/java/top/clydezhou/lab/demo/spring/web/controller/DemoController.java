package top.clydezhou.lab.demo.spring.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.clydezhou.lab.demo.spring.web.api.SimpleResult;

/**
 * @author clyde
 * @date 2020-07-03 0:09
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping("/exception")
    public SimpleResult exception() {
        throw new UnsupportedOperationException();
    }
}
