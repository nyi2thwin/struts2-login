package com.struts2.action;
 
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
 
import com.opensymphony.xwork2.ActionSupport;
 
@Action(value = "userInfo", //
results = { //
        @Result(name = "userInfoPage", location = "/WEB-INF/pages/welcome.jsp")
} //
)
public class WelcomeAction  extends ActionSupport {
  
    private static final long serialVersionUID = 1L;
 
    @Override
    public String execute() {
         
        return "userInfoPage";
    }
     
}