package com.niit.dao;

import java.util.List;

import com.niit.model.Blog;
import com.niit.model.BlogComment;

public interface BlogDAO {

	public void insertBlog(Blog blog);
	
	public List<Blog> viewBlog();
	
	public boolean updateBlog(Blog blog);
	
	public boolean editBlog(int blog_id);
	
	public boolean deleteBlog(int blog_id);
	
	public Blog getBlogbyId(int blog_id);
	
	public List<Blog> getBlogbyUsername(String username);
	
	public boolean insertBlogComment(BlogComment blogComment, String username, int blog_id);
	
	public boolean updateBlogComment(BlogComment blogComment);
	
	public void deleteBlogComment(int blog_id);
	
	public BlogComment getBlogCommentbyId(int blog_id);
	
	public List<BlogComment> getBlogCommentList();
	
}
