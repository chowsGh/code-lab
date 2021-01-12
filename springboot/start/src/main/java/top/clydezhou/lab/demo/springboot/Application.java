package top.clydezhou.lab.demo.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;
import top.clydezhou.lab.demo.springboot.common.SpringUtils;
import top.clydezhou.lab.demo.springboot.config.database.DataSourceConfig;

/**
 * @SpringBootApplication 注解是三个注解的组合： @SpringBootConfiguration，@EnableAutoConfiguration， @ComponentScan
 * 可以不激活特定的自动配置例如：@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
 * **NOTICE 注意** 这个类最好放到 springboot 项目的根包下例如某个业务包。
 */
@SpringBootApplication
// 扫描 ConfigurationProperties
@ConfigurationPropertiesScan({"top.clydezhou.lab.demo.springboot.config"})
// 添加额外的配置
@PropertySource({"config/mysql-datasource.properties"})
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);

        DataSourceConfig bean = SpringUtils.getBean(DataSourceConfig.class);
        System.out.println(bean);
    }
}
