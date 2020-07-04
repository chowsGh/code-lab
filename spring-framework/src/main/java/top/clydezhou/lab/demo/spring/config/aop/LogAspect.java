package top.clydezhou.lab.demo.spring.config.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 启动注解在 AopConfig 中。
 */
@Aspect
@Component
public class LogAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);

    // 配置切点切点参考：https://docs.spring.io/spring/docs/5.2.7.RELEASE/spring-framework-reference/core.html#aop-pointcuts-examples

    /**
     * 声明切点，使用 LogAnnotation 注解的方法
     */
    @Pointcut("@annotation(top.clydezhou.lab.demo.spring.config.aop.LogAnnotation)")
    public void logPointCut() {}

    /**
     * 声明切点，将注解作为参数传入，等同于 logPointCut();
     * @param logAnnotation
     */
    @Pointcut("@annotation(logAnnotation)")
    public void logParamPointCut(LogAnnotation logAnnotation) {}

    /**
     * 匹配任何方法
     * execution(modifiers-pattern? ret-type-pattern declaring-type-pattern?name-pattern(param-pattern)
     *                 throws-pattern?)
     * ? 表示出现0次或者1次
     */
    @Pointcut("execution(public * *(..))")
    public void anyPublicOperation() {}

    /**
     * 引用其他切点，声明 service 切点，支持引用其他切面的切点
     * 可以与其他切点表达式进行组合，支持 &&, || and !。 You can combine pointcut expressions by using &&, || and !.
     */
    @Pointcut("anyPublicOperation() && top.clydezhou.lab.demo.spring.config.aop.GlobalAspect.isService()")
    public void serviceOperation() {}

    /**
     * 定义执行类型的切点
     * 切点表达式 execution(modifiers-pattern? ret-type-pattern declaring-type-pattern?name-pattern(param-pattern) throws-pattern?)
     */
//    @Pointcut("execution(* top.clydezhou.lab.demo.spring.config.aop..*Demo*.*(..))")
//    @Pointcut("execution(* top.clydezhou.lab.demo.spring.config.aop.demo.*Demo*.*(..))")
    @Pointcut("execution(* top.clydezhou.lab.demo.spring.config.aop.demo.AopDemoClass.*(..))")
    public void demoAspect() {}

    // **下方为aop通知**

    @Before(value = "demoAspect()")
    public void beforeDemoAspect(JoinPoint jp) {
        LOGGER.debug("demoAspect before:{}", jp.getSignature().getName());
    }
    
    @AfterReturning(value = "demoAspect()", returning = "returnValue")
    public void afterReturnDemoAspect(JoinPoint jp, Object returnValue) {
        LOGGER.debug("demoAspect afterRtnUser:{}, rtn:{}", jp.getSignature().getName(), returnValue);
    }
    
    @AfterThrowing(value = "demoAspect()", throwing="ex")
    public void afterThrowingDemoAspect(JoinPoint jp, Exception ex) {
        LOGGER.debug("demoAspect afterThrowing:{}, rtn:{}", jp.getSignature().getName(), ex.getMessage());
    }
    
    @After(value = "demoAspect()")
    public void afterDemoAspect(JoinPoint jp) {
        // 在 @AfterReturning @AfterThrowing 之后执行
        // 通常是用于释放资源或者类似的目的。
        LOGGER.debug("demoAspect after:{}", jp.getSignature().getName());
    }
    
    @Around(value = "@annotation(logAnnotation)")
    public Object aroundLog(ProceedingJoinPoint pjp, LogAnnotation logAnnotation) throws Throwable {
        /*
         * around 执行顺序
         * 1. @Before
         * 2. pjp.proceed();
         * 3. @AfterReurning @AfterThrowing
         * 4. @After
         */
        // @Before
        long start = System.currentTimeMillis();
        LOGGER.debug("aroundLog  Before logname:{} before:{}", logAnnotation.name(), pjp.getSignature().getName());
        try {
            Object obj = pjp.proceed();
            // @AfterReurning
            LOGGER.debug("aroundLog logname:{} AfterReurning:{}", logAnnotation.name(), pjp.getSignature().getName());
            return obj;
        } catch (Exception e) {
            // @AfterThrowing
            LOGGER.debug("aroundLog logname:{} AfterThrowing:{}", logAnnotation.name(), pjp.getSignature().getName());
            throw e;
        }
        finally {
            // @After
            long cost = System.currentTimeMillis() - start;
            LOGGER.debug("aroundLog logname:{} After:{}, cost:{}", logAnnotation.name(), pjp.getSignature().getName(), cost);
        }
    }
}
