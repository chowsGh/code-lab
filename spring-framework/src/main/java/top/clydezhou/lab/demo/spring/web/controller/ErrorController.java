package top.clydezhou.lab.demo.spring.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author clyde
 * @date 2020-06-30 22:30
 */
@RestController
public class ErrorController {

    @RequestMapping(path = "/error")
    public Map<String, Object> handle(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        map.put("status", request.getAttribute("javax.servlet.error.status_code"));
        map.put("reason", request.getAttribute("javax.servlet.error.message"));
        return map;
    }

    @RequestMapping(path = "/redirect/error")
    public String redirect() {
        return "redirect:/error";
    }

    @RequestMapping(path = "/forward/error")
    public String forward() {
        return "forward:/error";
    }
}