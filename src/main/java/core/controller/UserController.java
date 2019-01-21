package core.controller;

import core.bean.User;
import core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/getid",produces = "application/json;charset=UTF-8")
    public @ResponseBody String getid(HttpServletRequest request){
        return userService.getUserid("lee");
    }

    @RequestMapping(value = "/getUserByName",produces = "application/json;charset=UTF-8")
    public @ResponseBody User getUserByname(HttpServletRequest request){
        return userService.getUserByName("lee");
    }
}
