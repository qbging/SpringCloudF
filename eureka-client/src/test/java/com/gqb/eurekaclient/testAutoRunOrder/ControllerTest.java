package com.gqb.eurekaclient.testAutoRunOrder;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gqb.EurekaClientApplication;
import com.gqb.eurekaclient.dao.UserMapper;
import com.gqb.eurekaclient.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author guoqb
 * @date : 2019/10/23 9:54
 * @descript
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {EurekaClientApplication.class})
public class ControllerTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void testService(){
        User user = userMapper.selectMapperByid("1");
        System.out.println(user);
    }

    @Test
    public void testInsert(){
        User user = new User();
        user.setName("guoeryu");
        user.setPassWord("werterdf");
        user.setRealName("郭二宇");
        int i = userMapper.insertUser(user);
        System.out.println(i);
    }

    @Test
    public void testPageHelper(){
        //startPage必须放到查询语句的前面，才有效，底层是新增的threadlocal，写入的分页信息
        PageHelper.startPage(2,2);
        List<User> users = userMapper.selectUserList();
        //配置文件方式
//        List<User> users = userMapper.selectList();
        PageInfo pageInfo = new PageInfo(users);
        System.out.println(pageInfo);
    }
}
