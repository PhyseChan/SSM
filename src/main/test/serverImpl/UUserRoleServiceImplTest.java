package serverImpl;

import com.github.pagehelper.PageInfo;
import core.bean.UUserRole;
import core.service.serverImpl.UUserRoleServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UUserRoleServiceImplTest {
    @Autowired
    UUserRoleServiceImpl uUserRoleService;
    @Test
    public void selectUserByPageTest(){
        PageInfo<UUserRole> userlist=uUserRoleService.selectUserByPage(1,3);
        System.out.println(userlist.getSize());
    }
}
