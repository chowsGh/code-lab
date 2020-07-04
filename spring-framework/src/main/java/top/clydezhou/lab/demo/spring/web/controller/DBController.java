package top.clydezhou.lab.demo.spring.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.clydezhou.lab.demo.spring.entity.UserInfo;
import top.clydezhou.lab.demo.spring.mapper.UserMapper;

import javax.annotation.Resource;

/**
 * @author clyde
 * @date 2020-07-01 1:10
 */
@RestController
@RequestMapping("/DB")
public class DBController {

    private UserMapper userMapper;

    @RequestMapping("/user")
    UserInfo getUser() {
        return userMapper.getUser();
    }

    @Resource(name = "mysqlUserMapper")
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
