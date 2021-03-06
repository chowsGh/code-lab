/**
 * 
 */
package top.clydezhou.lab.demo.springdata.mongodb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;

/**
 * @author chows
 * Date:2019-12-30 10:12:51
 */
@Configuration
// @ImportResource It is typically used
// when designing @Configuration classes to be bootstrapped by an AnnotationConfigApplicationContext,
// but where some XML functionality such as namespaces is still necessary.
@ImportResource({"classpath:application-config/applicationContext.xml"})
public class ApplicationConfig {

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
        Resource[] locations = new PathMatchingResourcePatternResolver().getResources("classpath:application-config/**.properties");
        placeholderConfigurer.setLocations(locations);
        return placeholderConfigurer;
    }
}
