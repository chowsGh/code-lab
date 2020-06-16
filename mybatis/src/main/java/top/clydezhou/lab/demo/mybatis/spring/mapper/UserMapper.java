package top.clydezhou.lab.demo.mybatis.spring.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import top.clydezhou.lab.demo.mybatis.spring.entity.UserInfo;

@Mapper
public interface UserMapper extends BaseMapper<UserInfo> {

    public Integer selectMaxAge();

}
