package top.clydezhou.lab.demo.spring.config.aop.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import top.clydezhou.lab.demo.spring.config.aop.LogAnnotation;

/**
 * 用于测试 Aop，需要注册到spring容器中
 *
 * @author clyde
 * @date 2020-07-04 19:35
 */
@Component
public class AopDemoClass {

    private static final Logger LOGGER = LoggerFactory.getLogger(AopDemoClass.class);

    @LogAnnotation()
    public void demo() {
        LOGGER.debug("{} demo.", AopDemoClass.class.getName());
//        throw new UnsupportedOperationException();
    }
}
