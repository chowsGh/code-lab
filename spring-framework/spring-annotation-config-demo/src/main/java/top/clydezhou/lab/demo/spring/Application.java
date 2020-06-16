/**
 * 
 */
package top.clydezhou.lab.demo.spring;

import com.mysql.cj.ClientPreparedQueryBindings;
import com.mysql.cj.util.TimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import top.clydezhou.lab.demo.spring.entity.UserInfo;
import top.clydezhou.lab.demo.spring.mapper.UserMapper;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author chows
 * Date:2019-12-27 12:12:28
 */

public class Application {
    private static final Logger LOG = LoggerFactory.getLogger(Application.class);
    public static void main(String[] args) {
        // basepackage 表示扫描包根路径
        // 等同于在xml中配置
        // <context:annotation-config/>
        // 然后配置: 1. 注解形式：@Configuration @ComponentScan, 2. xml形式： <context:component-scan base-package="org.example"/>
        try(AnnotationConfigApplicationContext context = getAnnocationConfigApplicationContext()) {
            UserMapper mysqlUserMapper = (UserMapper)context.getBeanFactory().getBean("mysqlUserMapper");
            UserInfo u = new UserInfo();
            u.setCreateTime(LocalDateTime.now());
            LOG.info("selectMaxAge:{}", mysqlUserMapper.selectMaxAge());
        }
    }

    public static AnnotationConfigApplicationContext getAnnocationConfigApplicationContext() {
        String basePackage = Application.class.getPackage().getName();
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(basePackage);
        return context;
    }
}
