package com.example.springboot.webapplication.login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {
    //인증 확인
    private AuthenticationService authenticationService;
    //생성자 생성
    public WelcomeController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    //login
    //GET,POST
    //get요청에 대해서만 이 메서드가 작용할 수 있도록
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String gotoWelcomePage(ModelMap model) {
        model.put("name","MOYA");
        return "welcome";
    }
 
}
