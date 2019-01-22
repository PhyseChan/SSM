package core.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import core.bean.UUser;
import core.bean.User;
import core.dao.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
    public PageInfo<User> selectUserByPage(int currentpage, int size){
        PageHelper.startPage(currentpage,size);
        List<User> users=userMapper.selectUserBypage();
        PageInfo<User> pageInfo=new PageInfo<User>(users);
        return pageInfo;
    }

}
