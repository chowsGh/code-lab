package top.clydezhou.lab.demo.spring.test.common;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import top.clydezhou.lab.demo.spring.bootstrap.WebInitializerConfig;

/**
 * 测试父类
 * @author clyde
 * @date 2020-07-13 22:43
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = MybatisTestConfig.class)
public abstract class TestBase {
}
