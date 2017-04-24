package com.niit.controller;

import java.util.Date;

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

import com.niit.dao.BlogDAOImpl;
import com.niit.model.Blog;

@RestController
public class BlogController {

	
	public static Logger log=LoggerFactory.getLogger(BlogController.class);
	
	@Autowired
	BlogDAOImpl blogDAOImpl;
	
	@Autowired
	Blog blog;
	
	@RequestMapping(value="/createblog/", method=RequestMethod.POST)
	public ResponseEntity<Blog> creatingBlog(@RequestBody Blog blog, HttpSession session, HttpServletRequest request)
	{
		System.out.println("inside create blog spring controller");
		session=request.getSession(false);
		String username=(String) session.getAttribute("username");
		blog.setDate_of_creation(new Date());
		blog.setUsername(username);
		blogDAOImpl.insertBlog(blog);
	
			System.out.println("Inside If part Blog controller");
			blog.setErrorcode("200");
			blog.setErrormessage("Blog is successfully Started!");
			return new ResponseEntity<Blog>(blog,HttpStatus.OK);
		
		/*else
		{
			System.out.println("Inside else part Blog controller");
			blog.setErrorcode("404");
			blog.setErrormessage("Blog Creation Unsuccessfull!!");
			return new ResponseEntity<Blog>(blog, HttpStatus.OK);
			
		}*/
		
	}
}
