package top.clydezhou.lab.demo.spring.config.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface LogAnnotation {

    String name() default "defaultName";

    String group() default "group";

    String type() default "";
}
