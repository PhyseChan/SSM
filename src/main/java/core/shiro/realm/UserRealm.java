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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserRealm extends AuthorizingRealm{

    @Autowired
    UUserMapper uUserMapper;



    @Override
    public String getName(){
        return "UserRealm";
    }
    //授权操作
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        UUser user= (UUser) principalCollection.getPrimaryPrincipal();
        user.setId(uUserMapper.getIdByNameAndPwd(user.getNickname(),user.getPassword()));
        List<String> permissions=new ArrayList<String>();
        List<String> roles=new ArrayList<String>();
        /*获取用户角色*/
        roles=uUserMapper.getRolesByUserId(user.getId());
        Set<String> roleSet=new HashSet<String>();
        for(String role:roles){
            roleSet.add(role);
        }
        /*获取用户所有权限*/
        permissions = uUserMapper.getPermissionByUserId(user.getId());
        Set<String> permissionSet=new HashSet<String>();
        for (String permission:permissions){
            System.out.println(permission);
            permissionSet.add(permission);
        }
        SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setStringPermissions(permissionSet);
        simpleAuthorizationInfo.setRoles(roleSet);
        return simpleAuthorizationInfo;
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
