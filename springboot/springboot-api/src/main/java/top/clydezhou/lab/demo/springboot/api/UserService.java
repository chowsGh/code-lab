package top.clydezhou.lab.demo.springboot.api;


import top.clydezhou.lab.demo.springboot.api.model.UserModel;

/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */
public interface UserService {

    String getUserName(Long id);

    UserModel addUser(UserModel user);
}
