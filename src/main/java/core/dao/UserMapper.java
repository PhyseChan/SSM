package core.dao;

import java.util.List;


import core.bean.User;
import org.springframework.stereotype.Repository;

@Repository("UserMapper")
public interface UserMapper {

    int insert(User record);

    List<User> selectAll();
    String getUserId(String username);
    User userByName(String username);
    List<User> selectUserBypage();
}