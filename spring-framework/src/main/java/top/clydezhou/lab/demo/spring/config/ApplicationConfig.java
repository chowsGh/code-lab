/**
 *
 */
package top.clydezhou.lab.demo.spring.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;

/**
 * 应用全局配置
 *
 * @author chows
 * Date:2019-12-30 10:12:51
 */
//@Import({
//    MybatisH2Config.class,
//    MybatisMySqlConfig.class,
//    WebConfig.class
//})

// @ImportResource It is typically used
// when designing @Configuration classes to be bootstrapped by an AnnotationConfigApplicationContext,
// but where some XML functionality such as namespaces is still necessary.
//@ImportResource({"classpath:application-config/applicationContext.xml"})

//@ComponentScan("top.clydezhou.lab.demo.spring.config")
@Configuration
public class ApplicationConfig implements ApplicationContextAware, ApplicationListener, ApplicationEventPublisherAware {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationConfig.class);

    private ApplicationEventPublisher applicationEventPublisher;

    private ApplicationContext applicationContext;

    private void init() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            LOGGER.debug("app is shutdowning.");
        }, ApplicationConfig.class.getName() + "-shutdownHook"));
    }

    /**
     * xml 相同写法
     * <bean class="org.springframework.context.support.PropertySourcesPlaceholderConfigurer">
     *     <property name="locations" value="classpath:com/something/jdbc.properties"/>
     * </bean>
     *
     * @return
     * @throws IOException
     */
    @Bean
    public PropertySourcesPlaceholderConfigurer placeholderConfigurer() throws IOException {
        PropertySourcesPlaceholderConfigurer placeholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        Resource[] locations =
            new PathMatchingResourcePatternResolver().getResources("classpath:properties/*.properties");
        placeholderConfigurer.setLocations(locations);
        return placeholderConfigurer;
    }

    /**
     * 监听全局事件，这里做演示只打印事件
     *
     * @param event
     */
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        LOGGER.debug("event:{}", event);
    }

    /**
     * 用于发 ApplicationEvent
     *
     * @param applicationEventPublisher
     */
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
        applicationEventPublisher.publishEvent("set applicationEventPublisher successfully.");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        init();
    }

    // 如果没有指定 spring mvc 的特殊 bean, spring 会默认加载 DispatcherServlet.properties 里的特殊 bean.
    /**
     * The DispatcherServlet delegates to special beans to process requests and render the appropriate responses. By “special beans” we mean Spring-managed Object instances that implement framework contracts. Those usually come with built-in contracts, but you can customize their properties and extend or replace them.
     *
     * The following table lists the special beans detected by the DispatcherServlet:
     *
     * Bean type	Explanation
     * HandlerMapping
     *
     * Map a request to a handler along with a list of interceptors for pre- and post-processing. The mapping is based on some criteria, the details of which vary by HandlerMapping implementation.
     *
     * The two main HandlerMapping implementations are RequestMappingHandlerMapping (which supports @RequestMapping annotated methods) and SimpleUrlHandlerMapping (which maintains explicit registrations of URI path patterns to handlers).
     *
     * HandlerAdapter
     *
     * Help the DispatcherServlet to invoke a handler mapped to a request, regardless of how the handler is actually invoked. For example, invoking an annotated controller requires resolving annotations. The main purpose of a HandlerAdapter is to shield the DispatcherServlet from such details.
     *
     * HandlerExceptionResolver
     *
     * Strategy to resolve exceptions, possibly mapping them to handlers, to HTML error views, or other targets. See Exceptions.
     *
     * ViewResolver
     *
     * Resolve logical String-based view names returned from a handler to an actual View with which to render to the response. See View Resolution and View Technologies.
     *
     * LocaleResolver, LocaleContextResolver
     *
     * Resolve the Locale a client is using and possibly their time zone, in order to be able to offer internationalized views. See Locale.
     *
     * ThemeResolver
     *
     * Resolve themes your web application can use — for example, to offer personalized layouts. See Themes.
     *
     * MultipartResolver
     *
     * Abstraction for parsing a multi-part request (for example, browser form file upload) with the help of some multipart parsing library. See Multipart Resolver.
     *
     * FlashMapManager
     *
     * Store and retrieve the “input” and the “output” FlashMap that can be used to pass attributes from one request to another, usually across a redirect. See Flash Attributes.
     */

    // https://docs.spring.io/spring/docs/5.2.6.RELEASE/spring-framework-reference/web.html#mvc-viewresolver
}
