package core.dao;

import java.util.List;
import core.bean.UPermission;
import org.springframework.stereotype.Repository;

@Repository("UPermissionMapper")
public interface UPermissionMapper {

    int deleteByPrimaryKey(Long id);

    int insert(UPermission record);

    UPermission selectByPrimaryKey(Long id);

    List<UPermission> selectAll();

    int updateByPrimaryKey(UPermission record);
}