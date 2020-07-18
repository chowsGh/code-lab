package top.clydezhou.lab.demo.spring.test.common;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * @author clyde
 * @date 2020-07-13 22:51
 */
@Configuration
@ComponentScan(basePackages = {"top.clydezhou.lab.demo.spring"}, excludeFilters = {
    @ComponentScan.Filter(type = FilterType.REGEX, pattern = "top.clydezhou.lab.demo.spring.bootstrap.*"),
    @ComponentScan.Filter(type = FilterType.REGEX, pattern = "top.clydezhou.lab.demo.spring.web.*")})
public class MybatisTestConfig {
}
