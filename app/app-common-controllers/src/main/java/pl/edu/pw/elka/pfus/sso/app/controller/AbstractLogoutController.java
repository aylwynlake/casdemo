package pl.edu.pw.elka.pfus.sso.app.controller;

import javax.servlet.http.HttpSession;

public abstract class AbstractLogoutController {

    protected String casServerLogoutUrl = "https://localhost:8443/cas/logout";
    protected String serviceUrl;
    
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:" + casServerLogoutUrl + "?service=" + serviceUrl;
    }
}