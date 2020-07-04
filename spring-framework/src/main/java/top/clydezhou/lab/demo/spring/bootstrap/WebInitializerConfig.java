package top.clydezhou.lab.demo.spring.bootstrap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * @author clyde
 * @date 2020-06-18 22:56
 */
@Configuration
@ComponentScan(basePackages = {"top.clydezhou.lab.demo.spring"},
    excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = "top.clydezhou.lab.demo.spring.bootstrap.*"))
public class WebInitializerConfig {

}
