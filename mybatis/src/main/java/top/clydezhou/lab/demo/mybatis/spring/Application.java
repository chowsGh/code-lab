package top.clydezhou.lab.demo.mybatis.spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import top.clydezhou.lab.demo.mybatis.spring.mapper.UserInfoMapper;

/**
 * @author clyde
 * @date 2020-06-14 18:07
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    private UserInfoMapper cityMapper;

    public Application(UserInfoMapper cityMapper) {
        this.cityMapper = cityMapper;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(this.cityMapper.findById(1L));
    }
}
