package com.example.demo.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.LoginResponse;
import com.example.demo.model.User;
import com.example.demo.model.UserList;
import com.example.demo.repository.UserRpository;

@Service
public class LoginService {

	@Autowired
	UserRpository userRpository  ;
	
	public User savepostuser(User newuser) {
		return userRpository.save(newuser);	
	}

	public User getuser(int id) {
		User user = userRpository.findById(id).get();	
		return user;
	}

	public LoginResponse deleteuser(int id) {
		Optional<User> findById = userRpository.findById(id);
		User user =null;
		if(findById.isPresent()) {
			user=findById.get();
		}
		
		LoginResponse lr= new LoginResponse() ;
		
		if(user==null)
		{
			lr.setStatus(false);
		}
		else
		{
			lr.setStatus(true);
			userRpository.deleteById(id);
		}
		return lr;
	}

	public LoginResponse getuserbyemail(String email, String password) {
		
		User user = userRpository.findByEmailAndPassword(email.toLowerCase(), password);
		
		LoginResponse lr= new LoginResponse() ;
		
		
		if(user==null)
			lr.setStatus(false); 
		else
			lr.setStatus(true);
		return lr;
		
	}

	public List<UserList> getusers() {
		
		List <User> users = userRpository.findAll();
		List <UserList> userslist = new ArrayList <UserList> ();
		for(User user:users)		
		{
			UserList ul = new UserList();
			ul.setId(user.getId());
			ul.setFirstname(user.getFirstname());
			ul.setLastname(user.getLastname());
			ul.setEmail(user.getEmail());
			userslist.add(ul);		
		}
		return userslist;
	}

	public LoginResponse edituser(int id, UserList userList) {
		Optional<User> findById = userRpository.findById(id);
		User user =null;
		if(findById.isPresent()) {
			user=findById.get();
		}
		
		LoginResponse lr= new LoginResponse() ;
		
		if(user==null)
		{
			lr.setStatus(false);
		}
		else
		{
			lr.setStatus(true);
			user.setFirstname(userList.getFirstname());
			user.setLastname(userList.getLastname());
			user.setEmail(userList.getEmail());
			userRpository.save(user);
		}
		// TODO Auto-generated method stub
		return lr;
	}
		
		



}
