package top.clydezhou.lab.demo.spring.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Arrays;

/**
 * @author clyde
 * @date 2020-07-01 0:10
 */
@Configuration
public class HttpMessageConverterConfig {

    @Bean
    public StringHttpMessageConverter stringHttpMessageConverter() {
        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter();
        stringHttpMessageConverter
            .setSupportedMediaTypes(Arrays.asList(new MediaType("application", "json", StandardCharsets.UTF_8)));
        // text/html;charset=UTF-8
        return stringHttpMessageConverter;
    }

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter =
            new MappingJackson2HttpMessageConverter();
        Jackson2ObjectMapperBuilder builder =
            new Jackson2ObjectMapperBuilder().dateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        //            .indentOutput(true)
        //            .modulesToInstall(new ParameterNamesModule());
        mappingJackson2HttpMessageConverter.setObjectMapper(builder.build());
        mappingJackson2HttpMessageConverter
            .setSupportedMediaTypes(Arrays.asList(new MediaType("application", "json", StandardCharsets.UTF_8)));
        return mappingJackson2HttpMessageConverter;
    }
}
