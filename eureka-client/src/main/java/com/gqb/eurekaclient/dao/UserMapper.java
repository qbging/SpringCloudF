package com.gqb.eurekaclient.dao;

import com.gqb.eurekaclient.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 如果用映射文件时，也需要@Mapper，如果启动类有@MapperScan，则@Mapper可删
 */
//@Mapper
public interface UserMapper {

    //注解方式可以使用
//    @Select("select * from tbl_user where id = #{id}")
//    public User selelctOne(String id);
//    @Select("select name from tbl_user where id = #{id}")
//    public Object selelctOneAtt(String id);

    //配置文件方式可以使用
    public User selectMapperByid(String id);

    //注解方式
    @Select("select * from tbl_user")
    public List<User> selectUserList();

    public List<User> selectList();

    public int insertUser(User user);
}
