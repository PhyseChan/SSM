package core.service;

import com.github.pagehelper.PageInfo;
import core.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserServiceTest {
    @Autowired
    UserService userService;
    @Test
    public void getUserid() {
        System.out.println("===================================>lee:"+userService.getUserid("lee"));
    }

    @Test
    public void getUserByName() {
        assertEquals(userService.getUserByName("lee").getName(),"lee");
    }

    @Test
    public void getUserpage(){
        PageInfo<User> users=userService.selectUserByPage(2,3);
        System.out.println(users.getSize());
    }
}