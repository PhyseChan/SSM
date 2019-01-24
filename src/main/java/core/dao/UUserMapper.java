package core.dao;

import java.util.List;
import core.bean.UUser;
import org.springframework.stereotype.Repository;

@Repository("UUserMapper")
public interface UUserMapper {

    int deleteByPrimaryKey(Long id);


    int insert(UUser record);

    UUser selectByPrimaryKey(Long id);


    List<UUser> selectAll();

    int updateByPrimaryKey(UUser record);

     List<UUser> selectUserBypage();
}