package com.example.demo.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.LoginResponse;
import com.example.demo.model.RequestUser;
import com.example.demo.model.User;
import com.example.demo.model.UserList;
import com.example.demo.service.LoginService;

@RestController
public class HelloController {
	
	@Autowired
	LoginService loginService;

	
	
	@PostMapping(path = "/user", consumes = "application/json", produces = "application/json")
	
	public User postuser(@RequestBody User newuser) {
	//	public User postuser(@RequestParam  String firstname) {
		System.out.println("test messsage");
		System.out.println(newuser.getFirstname());
		// return null;
		return loginService.savepostuser(newuser);
		
	}
	
	
	@PutMapping( path = "/user/{id}", consumes = "application/json", produces = "application/json")
	public LoginResponse edituser(@PathVariable int id, @RequestBody UserList userList) {

		return loginService.edituser(id,userList );
	  
	}
	
	@GetMapping( path = "/user/{id}", consumes = "application/json", produces = "application/json")
	public User getuser(@PathVariable int id) {

		return (User)loginService.getuser(id);
	  
	}
	
	@GetMapping( path = "/users", consumes = "application/json", produces = "application/json")
	public List<UserList> getusers() {

		return  loginService.getusers();
	  
	}
	@PostMapping( path = "/login", consumes = "application/json", produces = "application/json")
	public LoginResponse authenticateUser(@RequestBody RequestUser requestUser) {
		
    //    System.out.println(requestUser.getEmail());
	 return loginService.getuserbyemail(requestUser.getEmail(), requestUser.getPassword());
	  
	}
	
	
	@DeleteMapping( path ="/user/{id}",  produces = "application/json")
	public LoginResponse deleteuser(@PathVariable int id) {

	   return loginService.deleteuser(id);
	//	return "hello" + id;

	  
	}
	
	

	@RequestMapping("/hi")
	public String hicontroller() {
		return " hello";
		
	}



@RequestMapping("/test")
public ModelAndView login() {
ModelAndView modelAndView = new ModelAndView();
modelAndView.setViewName("login");
    return modelAndView;
}


}