package core.dao;

import java.util.List;
import core.bean.UUserRole;
import org.springframework.stereotype.Repository;

@Repository("UUserRoleMapper")
public interface UUserRoleMapper {

    int insert(UUserRole record);

    List<UUserRole> selectAll();
    List<UUserRole> selectItemBypage();
}