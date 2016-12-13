package pl.edu.pw.elka.pfus.sso.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:https://localhost:8443/cas/logout?service=http://localhost:8080/app1/home";
    }
}