package core.dao;

import java.util.List;
import core.bean.UUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository("UUserMapper")
public interface UUserMapper {

    int deleteByPrimaryKey(int id);


    int insert(UUser record);

    UUser selectByPrimaryKey(int id);
    UUser loginByname(@Param("username")String name, @Param("pwd") String pwd);
    UUser getUserByName(@Param("username")String name);
    List<UUser> selectAll();
    int updateByPrimaryKey(UUser record);
     List<UUser> selectUserBypage();
    List<String> getRolesByUserId(@Param("id")int id);
}