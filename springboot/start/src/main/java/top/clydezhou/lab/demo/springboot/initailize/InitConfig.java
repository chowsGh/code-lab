package top.clydezhou.lab.demo.springboot.initailize;

import cn.hutool.json.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

import java.util.Iterator;

/**
 * @author clyde
 * @date 2020-07-07 23:55
 */
@Configuration(proxyBeanMethods = false)
public class InitConfig implements ApplicationContextAware {
    private static final Logger LOGGER = LoggerFactory.getLogger(InitConfig.class);

    private ApplicationContext applicationContext;

    @Bean
    public CommandLineRunner propertiesWriter() {
        return (String... args) -> {
            ConfigurableEnvironment environment = (ConfigurableEnvironment)applicationContext.getEnvironment();
            MutablePropertySources propertySources = environment.getPropertySources();
            Iterator<PropertySource<?>> iterator = propertySources.iterator();
            LOGGER.info("start traverse all properties:");
            while (iterator.hasNext()) {
                PropertySource ps = iterator.next();
                LOGGER.info("{}:{}", ps.getName(), JSONUtil.toJsonStr(ps.getSource()));
            }
            LOGGER.info("end traverse all properties:");
        };
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }


}
