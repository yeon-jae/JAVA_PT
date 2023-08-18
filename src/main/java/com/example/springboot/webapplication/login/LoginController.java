package com.example.springboot.webapplication.login;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.logging.Logger;

@Controller
public class LoginController {
    @RequestMapping("/login")
    public String gotoLoginPage(@RequestParam String name, ModelMap model) {
        //어떤 값이 들어오든 name이라는 값에 저장이 됨
        model.put("name",name);

        return "login";
    }
}
