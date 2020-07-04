package top.clydezhou.lab.demo.spring.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.VersionResourceResolver;

import java.util.List;

/**
 * @author clyde
 * @date 2020-06-18 23:55
 */
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    private List<HttpMessageConverter<?>> httpMessageConverter;

    /**
     * 静态资源配置
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // resource 所有文件以及子文件
        registry.addResourceHandler("/static/**")
            // {"/", "classpath:/META-INF/public-web-resources/"}
            .addResourceLocations("/static/")
            // 缓存？ 版本url?
            .resourceChain(false).addResolver(new VersionResourceResolver().addContentVersionStrategy("/**"));
    }

    // 拦截器

    /**
     * restcontroller 根据类型转换
     *
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        // 返回 String
//        converters.add(stringHttpMessageConverter());
//        // 实体转 json
//        converters.add(mappingJackson2HttpMessageConverter());
        converters.addAll(httpMessageConverter);
    }

    @Autowired
    public void setHttpMessageConverter(List<HttpMessageConverter<?>> httpMessageConverter) {
        this.httpMessageConverter = httpMessageConverter;
    }
}
