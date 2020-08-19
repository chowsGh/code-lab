package top.clydezhou.lab.demo.mybatis.spring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import top.clydezhou.lab.demo.mybatis.spring.entity.AccountInfo;
import top.clydezhou.lab.demo.mybatis.spring.mapper.AccountInfoMapper;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author clyde
 * @date 2020-06-14 18:07
 */
@SpringBootApplication
@ImportResource("classpath:applicationContext.xml")
//@PropertySource({"classpath:properties/*.properties"})
public class Application implements CommandLineRunner {
    @Resource
    private AccountInfoMapper accountInfoMapper;

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        AccountInfo c = new AccountInfo();
        c.setId(0L);
        c.setUsername("zwx");
        c.setPassword("123");
        long save = accountInfoMapper.save(c);
        System.out.println(c);


        AccountInfo c1 = new AccountInfo();
        c1.setId(1L);
        c1.setUsername("zwx");
        c1.setPassword("123");

        AccountInfo c2 = new AccountInfo();
        c2.setId(2L);
        c2.setUsername("zwx");
        c2.setPassword("123");
        accountInfoMapper.saveAll(Arrays.asList(c1, c2));

        AccountInfo byId = accountInfoMapper.findById(1L);
        System.out.println(byId);
    }
}
