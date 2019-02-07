package com.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.entity.User;
import com.services.EnquiryServices;
import com.services.UserServices;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserServices userServices;
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public ModelAndView getPage(HttpServletRequest request,
			HttpServletResponse response){
		System.out.println("user contoller: list");
		ArrayList<User> users = (ArrayList<User>)userServices.list();
		for(int i=0; users != null && i < users.size() ; i++) {
			User user = users.get(i);
			System.out.println("ID: "+user.getUserId()+" Name: "+user.getName()+" Role:"+user.getRole()+" , i is:"+i);
		}
		request.setAttribute("users", users);
 		return new ModelAndView("/AdminDashboard/AdminView/users");
 	 
	}
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public ModelAndView register(){
		return new ModelAndView("/HomeDashboard/register");
	 
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> save(@ModelAttribute("command") User user,
			BindingResult result, HttpServletRequest request,
			HttpServletRequest response, ModelMap model){
		Map<String,Object> map = new HashMap<String,Object>();
		
		String email = user.getEmail();
		ArrayList<User> users = new ArrayList<User>(); 
		users = (ArrayList<User>) userServices.getByName("email", email);
		if(users != null && users.size() > 0) {
			map.put("status", "fail");
			map.put("message", "This email Id already exist");
		}else {			
			userServices.saveOrUpdate(user);
			map.put("status","success");
	 		map.put("message","Register successfuly");
		}
		
		//return new ModelAndView("/HomeDashboard/register");
		return map;
	 
	}
	
	/*@RequestMapping(value="/list", method = RequestMethod.GET)
	public ModelAndView getlist(){
		List<User> users = userServices.list();
		ModelAndView view =new ModelAndView("/user/users");
		return view;
	 
	}*/

}
