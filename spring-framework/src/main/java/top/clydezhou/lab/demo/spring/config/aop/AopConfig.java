package top.clydezhou.lab.demo.spring.config.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;
import org.springframework.core.annotation.OrderUtils;

import java.lang.reflect.AnnotatedElement;

/**
 * @author clyde
 * @date 2020-07-03 0:22
 */
@Configuration
@EnableAspectJAutoProxy
public class AopConfig {

    /*
     * spring 建议使用能实现业务，且最小影响的增强[advice]。例如：你只是期望在方法返回后，更新缓存，那么你使用after return更合适，而不是使用 around。虽然他们都可以实现这个功能。
     * 使用最具体的增强，可以减少开发过程可能的错误。例如，你选择使用 after return，你总能成功的调用目标对象的方法，而 around advice 必须使用连接点[joinpoint]的 proceed() ,保证目标方法被调用。
     *
     * 1. 启动声明式注解 （类 @AspectJ 注解） 或者使用 xml
     *      - @Configuration @EnableAspectJAutoProxy
     * 2. 声明切面[aspect]: 切点[pointcut]，增强[advice]，根据切点，找到对应的连接点[joinpoint]，进行增强。
     * 3. 增强[advice]
     *      - Before advice
     *      - After returning
     *      - After throwing
     *      - After (finally)
     *      - Around advice
     * 原理：
     * 1. 在使用目标类的地方，会注入动态代理类，调用目标方法会先调用动态代理类，然后在调用目标方法。而类中方法相互调用不会走动态代理类，所以不会调用动态代理的增强方法。
     * 2. 基于接口的动态代理，
     * 3. 基于cglib的动态代理
     *   - org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator
     *   - 生成代理 org.springframework.aop.framework.ProxyCreatorSupport.createAopProxy
     *   - org.springframework.aop.framework.CglibAopProxy.DynamicAdvisedInterceptor.intercept
     */

}
