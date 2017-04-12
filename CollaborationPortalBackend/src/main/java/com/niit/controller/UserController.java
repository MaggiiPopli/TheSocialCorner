package com.niit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.dao.UserDAOImpl;
import com.niit.model.User;

@RestController
public class UserController {

	public static Logger log=LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserDAOImpl userDAOImpl;
	
	@Autowired
	User user;
	
	@RequestMapping(value="/login/", method=RequestMethod.POST)
	public ResponseEntity<User> validateUser(@RequestBody User user, HttpServletRequest request, HttpSession session)
	{
		System.out.println("Starting Validate Method");
	
		String username=user.getUsername();
		String password=user.getPassword();
		
		System.out.println("Username is"+username+"Password is"+password);
		
		boolean xUser=userDAOImpl.validate(username, password);
		if(xUser==false)
		{	
			System.out.println("Invalid credentials");
			user.setErrorcode("404");
			user.setErrormessage("Invalid Username or Password!!");
			return new ResponseEntity<User>(HttpStatus.OK);
		}
		else
		{
			System.out.println("Valid Credentials!");
			session.setAttribute("username", username);
			session.setAttribute("role", user.getRole());
			user.setIsOnline('Y');
			user.setErrorcode("200");
			user.setErrormessage("You have successfully loggedIn!!");
			log.debug("Ending Validate method");
			return new ResponseEntity<User>(HttpStatus.OK);
			
		}
	}
	
	@RequestMapping(value="/register/",method=RequestMethod.POST)
	public ResponseEntity<User> registerUser(@RequestBody User user)
	{
		System.out.println("Entring registerUser method in controller");
		/*if(userDAOImpl.getUsername(user.getUsername())==true)
		{
			user.setStatus('N');
			user.setIsOnline('N');
			
			if(userDAOImpl.saveUser(user)==true)
			{
				user.setErrorcode("200");
				user.setErrormessage("Registration Successfull");
				return new ResponseEntity<User>(HttpStatus.OK);
			}
			else
			{
				user.setErrorcode("404");
				user.setErrormessage("User cannot be Registered!!");
				return new ResponseEntity<User>(HttpStatus.OK);
			}
			
		}
		else
		{
			log.debug("Ending Method saveUser");
			user.setErrorcode("404");
			user.setErrormessage("User already exist with UserID"+ user.getUsername());
			return new ResponseEntity<User>(HttpStatus.OK);
		}*/
		boolean x=userDAOImpl.saveUser(user);
		if(x==true)
		{
			System.out.println("successful");
		}
		else
		{
				System.out.println("unsuccessful");
			
		}
		return new ResponseEntity<User>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/getUsers",method=RequestMethod.GET)
	public ResponseEntity<List<User>> getAllUsers(HttpSession session){
		String username=(String)session.getAttribute("username");
		List<User> users=userDAOImpl.getAllUsers();
		if(username==null)
		{
			user.setErrorcode("404");
			user.setErrormessage("Data not found");
			users.add(user);
		}
		
		
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
	}

	

}

	

