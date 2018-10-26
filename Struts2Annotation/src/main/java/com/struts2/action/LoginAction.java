package com.struts2.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
 
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import org.hibernate.Session;
import com.struts2.model.User;
import com.struts2.hibernate.util.HibernateUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

 
import com.opensymphony.xwork2.ActionSupport;
 

public class LoginAction extends ActionSupport {
 
    private static final long serialVersionUID = 7299264265184515893L;
    private String username;
    private String password;
    public LoginAction() {
    	
    }
 
    @Override
    public String execute() {
    	//start hibernate connection
    	Session DBsession = HibernateUtil.getSessionFactory().getCurrentSession();
    	DBsession.beginTransaction();
    	
        if (this.username == null && this.password == null) {
        	
            return "showForm";
        } 
        HttpServletRequest request = ServletActionContext.getRequest();
         
        // Valid username and password 
        User userObj = null;
        try {
        	
        
        	// Create CriteriaBuilder
        	CriteriaBuilder builder = DBsession.getCriteriaBuilder();

        	// Create CriteriaQuery
        	CriteriaQuery<User> query = builder.createQuery(User.class);
        	Root<User> root = query.from(User.class);
        	query.select(root).where(builder.equal(root.get("username"),this.username) );
        	
        
        	userObj = DBsession.createQuery(query).getSingleResult();
        }catch(Exception e) {
        	//do nothing
        	addActionError("User doesn't exist or no connection to Database.");
        	 
            return "loginError";
        }
        
        
        if (userObj != null && userObj.getPassword().equals(this.password)) {
            HttpSession session = request.getSession();
             
            // Store userName in session
            session.setAttribute("loginedUsername", this.username);
             
            return "loginSuccess";
        }
        // Invalid username or password
        else {
            // ** See in ApplicationResources.properties
            String message = getText("error.login");
 
            addActionError(message);
 
            return "loginError";
        }
    }
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
}