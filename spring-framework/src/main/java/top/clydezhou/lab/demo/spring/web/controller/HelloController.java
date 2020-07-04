package top.clydezhou.lab.demo.spring.web.controller;

import org.springframework.web.bind.annotation.*;
import top.clydezhou.lab.demo.spring.config.aop.LogAnnotation;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @RestController = @ResponseBody + @Controller
 * @author clyde
 * @date 2020-06-18 23:35
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    public static final String TIP_STR = "URL 匹配规则演示：";

    @LogAnnotation(name = "helloWorld")
    @RequestMapping("/{paramName}")
//    @ResponseStatus(HttpStatus.CREATED)
    public String helloWorld(@PathVariable(required = false) String paramName, HttpServletRequest request) {
        // "/projects/{project}/versions" matches "/projects/spring/versions" and captures project=spring
        return TIP_STR + "路径参数：" + paramName;
    }

    @LogAnnotation(name = "regexp")
    @RequestMapping("/regexp/{paramName:[a-z]+}")
    //    @ResponseStatus(HttpStatus.CREATED)
    public String regexp(@PathVariable(required = false) String paramName, HttpServletRequest request) {
        // "/projects/{project:[a-z]+}/versions" matches "/projects/spring/versions" but not "/projects/spring1/versions"
        return TIP_STR + "匹配正则表达式：" + paramName;
    }

    @RequestMapping("/one/?")
    public String one(HttpServletRequest request) {
        // "/pages/t?st.html"
        // matches "/pages/test.html" and "/pages/t3st.html"
        return TIP_STR + "使用问号，匹配一个字符";
    }

    @RequestMapping("/zeroOrMoreChar/*")
    public String zeroOrMoreChar(HttpServletRequest request) {
        // "/resources/*.png" matches "/resources/file.png"
        // "/projects/*/versions" matches "/projects/spring/versions" but does not match "/projects/spring/boot/versions"
        return TIP_STR + "使用 * ，匹配0个或多个字符";
    }

    @RequestMapping("/zeroOrMorePath/**")
    public String zeroOrMorePath(HttpServletRequest request) {
        // "/resources/**" matches "/resources/file.png" and "/resources/images/file.png"
        return TIP_STR + "使用 ** ，匹配 0 或者多个路径";
    }

    @RequestMapping("/jackson/{object}")
    public Map<String, String> jackson(@PathVariable String object) {
        Map<String, String> map = new HashMap<>();
        map.put(TIP_STR, "convert to jackson");
        map.put("object", object);
        return map;
    }

    @RequestMapping("/param")
    public Map<String, String> param(@RequestParam(required = false) String paramName) {
        Map<String, String> map = new HashMap<>();
        map.put(TIP_STR, "RequestParam");
        map.put("paramName", paramName);
        return map;
    }
}
