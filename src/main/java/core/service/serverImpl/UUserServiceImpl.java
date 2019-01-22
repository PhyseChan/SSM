package core.service.serverImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import core.bean.UUser;
import core.dao.UUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("UUserServiceImpl")
public class UUserServiceImpl {
    @Autowired
    UUserMapper uUserMapper;

    public PageInfo<UUser> selectUserByPage(int currentpage,int size){
        PageHelper.startPage(currentpage,size);
        List<UUser> users=uUserMapper.selectUserBypage();
        PageInfo<UUser> pageInfo=new PageInfo<UUser>(users);
        return pageInfo;
    }

}
