package top.clydezhou.lab.demo.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Component;

import top.clydezhou.lab.demo.springboot.dao.dataobject.UserDO;
import top.clydezhou.lab.demo.springboot.dao.mapper.UserMapper;
import top.clydezhou.lab.demo.springboot.api.UserService;
import top.clydezhou.lab.demo.springboot.api.model.UserModel;

/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    private static final BeanCopier copier = BeanCopier.create(UserModel.class, UserDO.class, false);

    @Override
    public String getUserName(Long id) {
        UserDO userDO = userMapper.getById(id);
        return userDO != null ? userDO.getName() : null;
    }

    @Override
    public UserModel addUser(UserModel user) {
        UserDO userDO = new UserDO();
        copier.copy(user, userDO, null);
        Long id = userMapper.insert(userDO);
        user.setId(id);
        return user;
    }
}
