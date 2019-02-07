package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.entity.User;
import com.services.UserServices;

//public class UserLoginController {
//	
//
//}
@Controller
@RequestMapping(value="/login")
public class UserLoginController {
	@Autowired
	UserServices userServices;
	@Autowired
	SessionFactory session;
	@RequestMapping(value="/page", method = RequestMethod.GET)
	public ModelAndView getPage(HttpServletRequest request,
			HttpServletResponse response){
		System.out.println("User Login contoller: page");
 		return new ModelAndView("/login");
 	 
	}
	
	@RequestMapping(value="/register-form", method = RequestMethod.GET)
	public ModelAndView registerFrom(HttpServletRequest request,
			HttpServletResponse response){
 		return new ModelAndView("/SupplierDashboard/supplierView/register-from");
 	 
	}
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public @ResponseBody String login(HttpServletRequest request,
			HttpServletResponse response){
		System.out.println("=====================User Login contoller: login========");
		String userId = request.getParameter("emailId");
		String password = request.getParameter("password");
		System.out.println("userId:"+userId+", password:"+password);
		
		String colName = "email";
		List<User> users = userServices.getByName(colName, userId);
		
		User user;
		
		if(users!=null && users.size() >0){
			user = users.get(0);
			if(user.getEmail().equals(userId) && user.getPassword().equals(password)){
				if(user.getRole().equals("admin")){
					request.getSession().setAttribute("user",user);
					System.out.println("this is admin login");
					return "admin";
				}else if(user.getRole().equals("supplier")){
					request.getSession().setAttribute("user",user);
					System.out.println("this is supplier login");
					return "supplier";
				}else if(user.getRole().equals("enduser")){
					request.getSession().setAttribute("user",user);
					System.out.println("this is endusr login");
					return ("enduser");
				}
			}
		}
		System.out.println("user and pwd is wrong");
 		return "fail";
 	 
	}
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public @ResponseBody String logout(HttpServletRequest request,
			HttpServletResponse response){
		System.out.println("User Login contoller: logout");
		
		request.getSession().removeAttribute("user"); 
 		return "success";
 	 
	}
}