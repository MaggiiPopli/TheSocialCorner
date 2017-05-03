package com.niit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.model.Forum;
import com.niit.model.ForumComment;

public class ForumDAOImpl implements ForumDAO{
	
	
	
	@Autowired
	SessionFactory sessionFactory;
	
	public ForumDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	public boolean insertForum(Forum forum) {
		// TODO Auto-generated method stub
		try{
			Session sess=sessionFactory.openSession();
			Transaction tx=sess.beginTransaction();
			sess.save(forum);
			tx.commit();
			sess.close();
			return true;
		}
		catch(Exception e){
			System.out.println(e);
			return false;
		}
		
	}

	public boolean updateForum(Forum forum) {
		// TODO Auto-generated method stub
		try{
			Session sess=sessionFactory.openSession();
			Transaction tx=sess.beginTransaction();
			sess.update(forum);
			tx.commit();
			sess.close();
			return true;
		}
		catch(Exception ex){
			System.out.println(ex);
			return false;
		}
	}

	public boolean deleteForum(int forum_id) {
		// TODO Auto-generated method stub
		try{
			Session sess=sessionFactory.openSession();
			Transaction tx=sess.beginTransaction();
			Forum id=sess.get(Forum.class, forum_id);
			sess.delete(id);
			tx.commit();
			sess.close();
			return true;
		}
		catch(Exception ex){
			System.out.println("Exception"+ex);
			return false;
		}
	}

	public List<Forum> getForumList() {
		// TODO Auto-generated method stub
		return null;
	}

	public Forum getForumByID(int forum_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean insertForumComment(ForumComment forumcomment, String username, int forum_id) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateForumComment(ForumComment forumcomment) {
		// TODO Auto-generated method stub
		return false;
	}

	public void deleteForumComment(int forum_id) {
		// TODO Auto-generated method stub
		
	}

	public ForumComment getForumCommentByID(int forum_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ForumComment> getAllForumComment() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
