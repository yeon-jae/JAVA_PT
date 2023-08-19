package com.example.springboot.webapplication.login;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    //생성자 생성

    public LoginController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    //인증 확인
    private AuthenticationService authenticationService;


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
        if(authenticationService.authenticate(name,password)){
            model.put("name",name);


            return "welcome";
        }
        model.put("errorMessage","Invalid Credentials! PLEASE TRY AGAIN");
        return "login";
    }
}
