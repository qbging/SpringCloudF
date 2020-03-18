package com.gqb.eurekaclient.service;

import com.gqb.eurekaclient.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author guoqb
 * @date : 2019/10/18 18:01
 * @descript
 */
@Service
public class UserServiceImpl {

    @Autowired
    private UserMapper userMapper;

    public Object queryObjectByid(String id){
//        userMapper.selelctOneAtt(id)
//        return userMapper.selelctOne(id);
        return userMapper.selectMapperByid(id);
    }
}
