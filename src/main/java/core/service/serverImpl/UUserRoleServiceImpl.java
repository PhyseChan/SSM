package core.service.serverImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import core.bean.UUser;
import core.bean.UUserRole;
import core.dao.UUserMapper;
import core.dao.UUserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service ("UUserRoleServiceImpl")
public class UUserRoleServiceImpl {
    @Resource(name = "UUserRoleMapper")
    UUserRoleMapper userRoleMapper;

    public PageInfo<UUserRole> selectUserByPage(int currentpage, int size){
        PageHelper.startPage(currentpage,size);
        List<UUserRole> users=userRoleMapper.selectItemBypage();
        PageInfo<UUserRole> pageInfo=new PageInfo<UUserRole>(users);
        return pageInfo;
    }
}
