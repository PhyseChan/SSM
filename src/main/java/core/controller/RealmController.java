package core.controller;


import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.Collection;
import java.util.Map;
@Controller
public class RealmController {
    @Autowired
    private  RequestMappingHandlerMapping rmhm;

    @RequestMapping("/reload")
    public String reload(){
        Map<RequestMappingInfo,HandlerMethod> handlerMethods=rmhm.getHandlerMethods();
        Collection<HandlerMethod> methods=handlerMethods.values();
        for(HandlerMethod method:methods){
            RequiresPermissions anno=method.getMethodAnnotation(RequiresPermissions.class);
            if (anno!=null){
                String resources= anno.value()[0];
                System.out.println("=================================>"+resources);

            }
        }
        return "main";
    }

}
