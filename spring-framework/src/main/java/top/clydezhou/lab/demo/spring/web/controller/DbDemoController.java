package top.clydezhou.lab.demo.spring.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.clydezhou.lab.demo.spring.entity.UserInfo;
import top.clydezhou.lab.demo.spring.mapper.UserMapper;
import top.clydezhou.lab.demo.spring.service.UserService;
import top.clydezhou.lab.demo.spring.web.api.CommonResult;
import top.clydezhou.lab.demo.spring.web.api.SimpleResult;

import javax.annotation.Resource;
import java.util.logging.LogManager;

/**
 * @author clyde
 * @date 2020-07-01 1:10
 */
@RestController
@RequestMapping("/db-demo")
public class DbDemoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DbDemoController.class);

    @Resource(name = "mysqlUserMapper")
    private UserMapper userMapper;

    @Resource
    private UserService userService;

    @Resource(name = "mysqlUserMapper")
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @RequestMapping("/user/{id}")
    public UserInfo getUser(@PathVariable long id) {
        return userMapper.getUser(id);
    }

    @RequestMapping("/transactionalDemo")
    public SimpleResult transactionalDemo() {
        try {
            userService.transactionDemo();
        } catch (Exception e) {
            LOGGER.error("transactionalDemo exception.", e);
        }
        return new SimpleResult();
    }

}
