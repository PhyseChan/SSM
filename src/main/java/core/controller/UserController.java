package core.controller;

import core.bean.UUser;
import core.bean.User;
import core.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UUser user;

    @RequestMapping(value = "/getid",produces = "application/json;charset=UTF-8")
    @RequiresPermissions("admin:research")
    public @ResponseBody String getid(HttpServletRequest request){
        return userService.getUserid("lee");
    }

    @RequestMapping(value = "/getUserByName",produces = "application/json;charset=UTF-8")
    @RequiresPermissions("admin:research")
    public @ResponseBody User getUserByname(HttpServletRequest request){
        return userService.getUserByName("lee");
    }

    @RequestMapping(value = "/login" ,produces = "application/json;charset=UTF-8" )
    public String login(HttpServletRequest request){
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        user.setNickname(username);
        user.setPassword(password);
        Subject subject= SecurityUtils.getSubject();

        try {
            subject.login(new UsernamePasswordToken(user.getNickname(),user.getPassword()));
            System.out.println("登陆成功");
        } catch (AuthenticationException e) {
            System.out.println("登陆失败");
            e.printStackTrace();
        }
        return "user";
    }

    @RequestMapping(value = "/userpage" ,produces = "application/json;charset=UTF-8" )
    @RequiresPermissions("user:update")
    public String userpage(HttpServletRequest request){
        return "userneopage";
    }

    @RequestMapping(value = "/testPermission" , produces = "appliction/json;charset=UTF-8")
    @RequiresPermissions("user:insert")
    public String testpermission (HttpServletRequest request){
        return "testpage";
    }


}
