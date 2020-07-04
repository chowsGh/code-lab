package top.clydezhou.lab.demo.spring.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.clydezhou.lab.demo.spring.entity.UserInfo;

@Mapper
public interface UserMapper {

    public Integer selectMaxAge();

    @Select("select id, name, age, email, gender, createtime from userinfo where id = 1;")
    public UserInfo getUser();

    @Insert("INSERT INTO userinfo (id, name, age, email, gender, createtime) VALUES (#{id}, #{name}, #{age}, #{email}, #{gender}, #{createTime})")
    public int saveUser(UserInfo u);
}
