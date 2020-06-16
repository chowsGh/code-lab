package top.clydezhou.lab.demo.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * 扫描 top.clydezhou.lab.demo.spring.config 下的 spring bean, config.
 * 和 AnnotationConfigApplicationContext 一起使用，扫描会重复，但是没有其他负面影响。
 * 配合 ClassPathXmlApplicationContext 使用更好
 *
 * xml 对应
 * <context:component-scan base-package="org.example">
 *         <context:include-filter type="regex"
 *                 expression=".*Stub.*Repository"/>
 *         <context:exclude-filter type="annotation"
 *                 expression="org.springframework.stereotype.Repository"/>
 * </context:component-scan>
 * @author clyde
 * @date 2020-06-14 21:36
 */
@Configuration
@ComponentScan("top.clydezhou.lab.demo.spring.config")
public class ScanConfig {
}
