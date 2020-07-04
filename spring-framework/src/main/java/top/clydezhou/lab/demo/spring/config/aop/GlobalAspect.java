package top.clydezhou.lab.demo.spring.config.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 全局切片
 * @author chows
 *
 */
@Aspect
@Component
public class GlobalAspect {

    @Pointcut("within(top.clydezhou.lab.demo.spring.config.aop..*)")
    public void isService() {}
}
