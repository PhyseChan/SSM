package core.service;

import core.bean.User;
import core.dao.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service("UserService")
public class UserService {
    @Resource(name = "UserMapper")
    UserMapper userMapper;

    public String getUserid(String username){
        return  userMapper.getUserId(username);
    }
    public User getUserByName(String username){
        return userMapper.userByName(username);
    }
}
