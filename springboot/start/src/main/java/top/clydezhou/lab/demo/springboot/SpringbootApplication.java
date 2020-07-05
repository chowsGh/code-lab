package top.clydezhou.lab.demo.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication 注解是三个注解的组合： @SpringBootConfiguration，@EnableAutoConfiguration， @ComponentScan
 * 可以不激活特定的自动配置例如：@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
 */
@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

}
