package com.example.springboot.webapplication.login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    //login
    //GET,POST
    //get요청에 대해서만 이 메서드가 작용할 수 있도록
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String gotoLoginPage() {
        return "login";
    }
    //POST에 대해서만
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String gotoWelcomePage(@RequestParam String name,
                                  @RequestParam String password, ModelMap model) {
        model.put("name",name);
        model.put("password",password);

        return "welcome";
    }
}
