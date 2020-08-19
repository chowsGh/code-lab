package top.clydezhou.lab.demo.mybatis.spring.mapper;

import org.apache.ibatis.annotations.*;
import top.clydezhou.lab.demo.mybatis.spring.entity.AccountInfo;

import java.util.List;

@Mapper
public interface AccountInfoMapper {

  @Select("SELECT * FROM accountinfo WHERE id = #{id}")
  AccountInfo findById(@Param("id") long id);

  @Options(keyProperty = "id", useGeneratedKeys = true)
  @Insert("INSERT INTO accountinfo (`id`, `username`, `password`, `nickname`, `createtime`, `lastupdatetime`, `flag`) VALUES (null, #{accountInfo.username}, #{accountInfo.password}, #{accountInfo.nickName}, null, null, #{accountInfo.flag})")
  long save(@Param("accountInfo") AccountInfo accountInfo);

  long saveAll(List<AccountInfo> list);
}