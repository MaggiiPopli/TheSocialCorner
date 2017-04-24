package com.niit.dao;

import java.util.List;

import com.niit.model.Blog;

public interface BlogDAO {

	public void insertBlog(Blog blog);
	
	public List<Blog> viewBlog();
	
	public boolean updateBlog(Blog blog);
	
	public boolean editBlog(int blog_id);
	
	public boolean deleteBlog(int blog_id);
	
	public Blog getBlogbyId(int blog_id);
	
	public List<Blog> getBlogbyUsername(String username);
	
	//view blog
	//editblog, delete blog
	//getblogbyId where blog_id=:blog_id
	//getblogbyUsername select * from blog where username=:username
	
}
