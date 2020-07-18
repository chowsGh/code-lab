package top.clydezhou.lab.demo.spring.bootstrap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import java.util.Map;

/**
 * 非 web 容器启动
 *
 * @author clyde
 * @date 2020-07-04 20:14
 */
@Configuration
@ComponentScan(basePackages = {"top.clydezhou.lab.demo.spring"}, excludeFilters = {
    @ComponentScan.Filter(type = FilterType.REGEX, pattern = "top.clydezhou.lab.demo.spring.bootstrap.*"),
    @ComponentScan.Filter(type = FilterType.REGEX, pattern = "top.clydezhou.lab.demo.spring.web.*")})
public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Application.class)) {

        }
    }
}
