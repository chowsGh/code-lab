package top.clydezhou.lab.demo.spring.test.unit.mapper;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;
import top.clydezhou.lab.demo.spring.entity.UserInfo;
import top.clydezhou.lab.demo.spring.mapper.UserMapper;
import top.clydezhou.lab.demo.spring.test.common.TestBase;

import javax.annotation.Resource;

/**
 * @author clyde
 * @date 2020-07-13 22:42
 */
public class UserMapperTest extends TestBase {
    @Resource(name = "mysqlUserMapper")
    private UserMapper userMapper;

    @Test
    @Transactional
    public void getUserTest() {
        long id = -100;
        UserInfo u = new UserInfo();
        u.setId(id);
        u.setAge(12);
        u.setName("test");
        userMapper.saveUser(u);
        UserInfo user = userMapper.getUser(id);
        Assert.assertEquals(user.getName(), u.getName());
    }
}
