package top.clydezhou.lab.demo.mybatis.spring.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserInfoMapper {

  @Select("SELECT id FROM userinfo WHERE id = #{id}")
  Long findById(@Param("id") long id);

}