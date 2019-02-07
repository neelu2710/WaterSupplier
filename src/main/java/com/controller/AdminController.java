package com.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//import org.apache.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.entity.City;
import com.entity.User;
import com.services.CityServices;
import com.services.UserServices;

@Controller
@RequestMapping(value="/admin")
public class AdminController {
	@Autowired
	CityServices cityServices;
	@Autowired
	UserServices userServices;
	@Autowired
	SessionFactory session;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView getPage(HttpServletRequest request,
			HttpServletResponse response){
		List<User> users = userServices.list();
		System.out.println("Admin contoller"+users.listIterator());
		
 		return new ModelAndView("/AdminDashboard/AdminView/index");
 	 
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request,
			HttpServletResponse response){
		System.out.println("===================Admin contoller: login with "+request.getParameter("emailId")+"=================");
		String userId = request.getParameter("emailId");
		String password = request.getParameter("password");
		System.out.println("userId:"+userId+", password:"+password);
		if(true){
			
		}
 		return new ModelAndView("/AdminDashboard/index");
 	 
	}
	@RequestMapping(value="/upload", method = RequestMethod.GET)
	public ModelAndView upload(HttpServletRequest request,
			HttpServletResponse response){
		System.out.println("/// upload");
		User user = (User)request.getSession().getAttribute("user");
		System.out.println("user: "+user);
		
		/*if(user != null) {
			return new ModelAndView("/upload");
		}
		return new ModelAndView("/login_error");
 	 */
		return new ModelAndView("/upload");
	}
	@RequestMapping(value="/uplaod", method = RequestMethod.POST)
	public @ResponseBody String uplaod(@RequestParam("file") MultipartFile file, HttpServletRequest request, HttpServletResponse response){
		System.out.println("Admin contoller: upload user: "+request.getSession().getAttribute("user"));
		
		User usr = (User)request.getSession().getAttribute("user");		
		
		if(usr == null) {
			return "User is not loged in";
		}
		String UPLOADED_FOLDER = "/home/neelesh/FreakCoders/WaterSupplier/tomcat/webapps/water_uploads/";

		if (file.isEmpty()) {
            //req.addFlashAttribute("message", "Please select a file to upload");
			System.out.println("data file is empty");
            return "No File found: error";
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            //redirectAttributes.addFlashAttribute("message", "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try {

            FileInputStream file1 = new FileInputStream(new File("/home/neelesh/FreakCoders/WaterSupplier/tomcat/webapps/water_uploads/"+file.getOriginalFilename()));
            XSSFWorkbook workbook = new XSSFWorkbook(file1);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            rowIterator.next();
            
            while(rowIterator.hasNext())
            {
                Row row = rowIterator.next();
                if(row.getCell(0) != null || row.getCell(0).toString().contains(""))
	            {
	            	System.out.println(row.getCell(0));
	            	User user = new User();
	            	user.setName(row.getCell(0).toString());
	            	user.setPassword(row.getCell(1).toString());
	            	user.setRole(row.getCell(2).toString());
	            	user.setEmail(row.getCell(3).toString());
	            	
	            	userServices.saveOrUpdate(user);
	            	
	            }
            }
            file1.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
       System.out.println("file uploaded successs fully");
		return "Done Successfully";
	}
	
	@RequestMapping(value="/upload-city", method = RequestMethod.GET)
	public ModelAndView uploadCity(HttpServletRequest request,
			HttpServletResponse response){
		System.out.println("===============Upload City=============");
		User user = (User)request.getSession().getAttribute("user");
		System.out.println("user: "+user);
		
		if(user != null) {
			return new ModelAndView("/uploadCity");
		}
		return new ModelAndView("/login_error");
 	 
	}
	
	@RequestMapping(value="/uplaod/city", method = RequestMethod.POST)
	public @ResponseBody String uplaodCity(@RequestParam("file") MultipartFile file, HttpServletRequest request, HttpServletResponse response){
		System.out.println("Admin contoller: upload city: "+request.getSession().getAttribute("user"));
		
		User usr = (User)request.getSession().getAttribute("user");		
		
		if(usr == null) {
			return "User is not loged in";
		}
		String UPLOADED_FOLDER = "/home/neelesh/FreakCoders/WaterSupplier/tomcat/webapps/water_uploads/";

		if (file.isEmpty()) {
            //req.addFlashAttribute("message", "Please select a file to upload");
			System.out.println("data file is empty");
            return "No File found: error";
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            //redirectAttributes.addFlashAttribute("message", "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try {

            FileInputStream file1 = new FileInputStream(new File("/home/neelesh/FreakCoders/WaterSupplier/tomcat/webapps/water_uploads/"+file.getOriginalFilename()));
            XSSFWorkbook workbook = new XSSFWorkbook(file1);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            rowIterator.next();
            
            while(rowIterator.hasNext())
            {
                Row row = rowIterator.next();
                if(row.getCell(0) != null || row.getCell(0).toString().contains(""))
	            {
	            	System.out.println(row.getCell(0));
	            	City city = new City();
	            	city.setCityName(row.getCell(0).toString());
	            	
	            	cityServices.saveOrUpdate(city);
	            }
            }
            file1.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
       System.out.println("file uploaded successs fully");
		return "Done Successfully";
	}
	
}
