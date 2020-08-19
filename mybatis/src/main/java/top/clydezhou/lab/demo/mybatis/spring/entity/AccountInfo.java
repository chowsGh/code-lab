package top.clydezhou.lab.demo.mybatis.spring.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * The type User info.
 *
 * @date 2020.06.16 23:36:35
 */
public class AccountInfo extends BaseEntity implements Serializable {
    private String username;
    private String password;
    private String nickName;

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "AccountInfo{" + "username='" + username + '\'' + ", password='" + password + '\'' + ", nickName='"
            + nickName + '\'' + "} " + super.toString();
    }
}
