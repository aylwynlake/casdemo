package pl.edu.pw.elka.pfus.sso.app;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.edu.pw.elka.pfus.sso.app.controller.AbstractLogoutController;

@Controller
public class LogoutController extends AbstractLogoutController {
    {
        serviceUrl = "http://localhost:8081/app2/home";
    }
    
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        return super.logout(session);
    }

}
