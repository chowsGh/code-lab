package top.clydezhou.lab.demo.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import top.clydezhou.lab.demo.spring.utils.JsonUtils;
import top.clydezhou.lab.demo.spring.web.api.SimpleResult;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author clyde
 * @date 2020-06-30 22:30
 */
@Controller
@RequestMapping("/error")
public class ErrorController {

    @RequestMapping(path = "")
//    @ResponseBody
    public String handle(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        map.put("status", request.getAttribute("javax.servlet.error.status_code"));
        map.put("reason", request.getAttribute("javax.servlet.error.message"));
        return JsonUtils.toJson(map);
    }

    /**
     * 重定向到error.html
     * @return
     */
    @RequestMapping(path = "/redirect")
    public String redirect() {
        return "redirect:/error";
    }

    @RequestMapping(path = "/forward")
    public String forward() {
        return "forward:/error";
    }

    @RequestMapping("/exception")
    @ResponseBody
    public SimpleResult exception() {
        throw new UnsupportedOperationException();
    }
}