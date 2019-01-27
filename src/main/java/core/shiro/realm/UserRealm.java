package core.shiro.realm;

import core.bean.URole;
import core.bean.UUser;
import core.dao.URoleMapper;
import core.dao.UUserMapper;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class UserRealm extends AuthorizingRealm{

    @Autowired
    UUserMapper uUserMapper;

    @Autowired
    URoleMapper uRoleMapper;

    @Override
    public String getName(){
        return "UserRealm";
    }
    //授权操作
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        UUser user= (UUser) principalCollection.getPrimaryPrincipal();
        List<String> permissions=new ArrayList<String>();
        List<String> roles=new ArrayList<String>();
        roles=uRoleMapper.getroles();


        return null;
    }
    //认证操作
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username=(String) authenticationToken.getPrincipal();
        UUser user= uUserMapper.getUserByName(username);
        if (user == null){
            return  null;
        }

        SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(user,user.getPassword(),getName());

        return info;
    }
}
