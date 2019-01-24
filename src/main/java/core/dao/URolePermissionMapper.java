package core.dao;

import java.util.List;
import core.bean.URolePermission;
import org.springframework.stereotype.Repository;

@Repository("URolePermissionMapper")
public interface URolePermissionMapper {

    int insert(URolePermission record);

    List<URolePermission> selectAll();
}