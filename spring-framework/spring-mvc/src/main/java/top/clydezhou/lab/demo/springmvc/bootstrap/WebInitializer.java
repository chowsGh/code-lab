package top.clydezhou.lab.demo.springmvc.bootstrap;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

/**
 * web 容器引导 spring mvc 需要继承 WebApplicationInitializer。
 * 也可以方便的直接继承 AbstractDispatcherServletInitializer，则使用 xml 配置，
 * AbstractAnnotationConfigDispatcherServletInitializer  则使用 java 配置
 * 可以通过 java 或者 xml 的形式配置
 *
 * @author clyde
 * @date 2020-06-18 22:32
 */
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebInitializerConfig.class };
    }

    @Override protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}

//public class WebInitializer extends AbstractDispatcherServletInitializer {
//
//    @Override
//    protected WebApplicationContext createRootApplicationContext() {
//        return null;
//    }
//
//    @Override
//    protected WebApplicationContext createServletApplicationContext() {
//        XmlWebApplicationContext cxt = new XmlWebApplicationContext();
//        cxt.setConfigLocation("/WEB-INF/spring/dispatcher-config.xml");
//        return cxt;
//    }
//
//    @Override
//    protected String[] getServletMappings() {
//        return new String[] { "/" };
//    }
//}