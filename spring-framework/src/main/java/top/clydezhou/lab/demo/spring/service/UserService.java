package top.clydezhou.lab.demo.spring.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import top.clydezhou.lab.demo.spring.entity.UserInfo;
import top.clydezhou.lab.demo.spring.mapper.UserMapper;

import javax.annotation.Resource;

/**
 * @author clyde
 * @date 2020-07-12 21:26
 */
@Service
public class UserService {
    private UserMapper userMapper;

    @Resource(name = "mysqlUserMapper")
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * 必须是外部调用，不能内部调用，例如在其他方法中调用， transactionDemo ，事务将不生效
     * 必须是 public 才会生效
     * 默认值回滚运行时异常，和 error。不包括受检异常。By default, a transaction will be rolling back on RuntimeException and Error but not on checked exceptions (business exceptions).
     * 可以通过 rollbackFor 制定异常进行回滚。
     * 
     * 如果是多个数据源，创建多个事务管理器，则需要在这里制定对应的事务管理器名称。
     */
    @Transactional(value = "mysqlTransactionManager", rollbackFor = {Exception.class})
    public void transactionDemo() {
        UserInfo user = new UserInfo();
        user.setId(-1L);
        userMapper.saveUser(user);
        userMapper.saveUser(user);
    }
}
