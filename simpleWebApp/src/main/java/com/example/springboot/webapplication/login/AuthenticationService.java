package com.example.springboot.webapplication.login;


import org.springframework.stereotype.Service;
//AuthenticationService를 Springbean으로 만들기
@Service
public class AuthenticationService {
    //사용자 인증
    public boolean authenticate(String username, String password){
        boolean isValidUserName = username.equalsIgnoreCase("MOYA");
        boolean isValidPassword= password.equalsIgnoreCase("dummy");
        return isValidUserName&&isValidPassword;
    }
}
