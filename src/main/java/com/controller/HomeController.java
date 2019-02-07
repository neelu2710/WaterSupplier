package com.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.entity.City;
import com.entity.Enquiry;
import com.entity.User;
import com.services.CityServices;
import com.services.EnquiryServices;
import com.services.UserServices;

@Controller
@RequestMapping("/")
public class HomeController extends HttpServlet {
	@Autowired
	UserServices userServices;
	@Autowired
	EnquiryServices enquiryServices;
	@Autowired
	CityServices cityServices;
	
	//private static final Logger logger = Logger.getLogger(HomeController.class);

	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView getPage(HttpServletRequest request,	HttpServletResponse response){
		System.out.println("home contoller");
		//private static final Logger logger = Logger.getLogger(HomeController.class);
		System.out.println("We are in the home controller");
		List<User> users = userServices.list();
		List<City> city = cityServices.list();
		request.getSession().setAttribute("user", users);
		//request.setAttribute("user", users);
		request.getSession().setAttribute("city", city);  
		System.out.println("===========city=========="+users.size());
		//if(city!= null && city.size()>0) {
		System.out.println("==============Homecontroller: city size is==========================:"+city.size());
		//}
 		return new ModelAndView("/HomeDashboard/index");
	}
	
	/*@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView getPage1(HttpServletRequest request,
			HttpServletResponse response){
		System.out.println("we are in the Home controller");
 		return new ModelAndView("/HomeDashboard/index");
 	 
	}*/
	@RequestMapping(value="/enquiry", method = RequestMethod.POST)
	public ModelAndView enquiry(Enquiry enquiry, HttpServletRequest request,HttpServletResponse response){
		System.out.println("enquiry");
		enquiryServices.saveOrUpdate(enquiry);
 		return new ModelAndView("index");
 	 
	}

}
