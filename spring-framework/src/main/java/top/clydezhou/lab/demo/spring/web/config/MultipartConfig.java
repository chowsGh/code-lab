package top.clydezhou.lab.demo.spring.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * @author clyde
 * @date 2020-06-30 22:02
 */
@Configuration
public class MultipartConfig {
    // https://docs.spring.io/spring/docs/5.2.6.RELEASE/spring-framework-reference/web.html#mvc-multipart
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
//        commonsMultipartResolver.setMaxInMemorySize();
//        commonsMultipartResolver.setMaxUploadSize();
//        commonsMultipartResolver.setMaxUploadSizePerFile();
//        commonsMultipartResolver.setUploadTempDir();
        return commonsMultipartResolver;
    }
}
