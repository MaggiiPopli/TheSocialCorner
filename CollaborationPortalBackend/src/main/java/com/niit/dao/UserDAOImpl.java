package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.User;

@Repository
public class UserDAOImpl implements UserDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	
	public UserDAOImpl(SessionFactory sessionFactory)
	{
		this .sessionFactory=sessionFactory;
	}
	
	
	public boolean validate(String username, String password) {
		// TODO Auto-generated method stub
		System.out.println("INSIDE USER DAO IMPL VALIDATE"+username+" "+password);
		String hql= "select username from User where username=:username and password=:password";
		Query q=sessionFactory.openSession().createQuery(hql);
		q.setParameter("username", username);
		q.setParameter("password", password);

	
		@SuppressWarnings("unchecked")
		List<User> l=q.list();
		System.out.println("list is "+l);
		if(l.size()>0)
		{
			return true;
		}
		else
		{
		return false;
		}
		
	}

	public boolean saveUser(User u) {
		// TODO Auto-generated method stub
		System.out.println("Entring Save User Method");
		try{
		Session sess=sessionFactory.openSession();
		Transaction tx=sess.beginTransaction();
		sess.save(u);
		tx.commit();
		sess.close();
		return true;
		}
		catch(Exception ex)
		{
			System.out.println("Exception"+ex);
			return false;
		}
	}


	public boolean getUsername(String username) {
		// TODO Auto-generated method stub
		String hql="select * from User where username=:username";
		Session sess=sessionFactory.openSession();
		Query q=sess.createQuery(hql);
		q.setParameter("username", username);
		List<User> l=q.list();
		if(l.size()>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

		public List<User> getAllUsers() {
			System.out.println("Entering getAllUsers method");
			Session session = sessionFactory.openSession();
			Query query=session.createQuery("select username from User");
			// Transaction tx = session.beginTransaction();
			/*SQLQuery query=session.createSQLQuery("select * from l_user where username in (select username from l_user where username!=? minus(select friend_name from l_friend where username=? union select username from l_friend where friend_name=?))");*/
			//query.setString("username", username);
			List<User> users=query.list();
			System.out.println("USER DETAILS"+users);
			System.out.println("Getall users in userdao"+users);
			// tx.commit();
			session.close();
			return users;
		}
		



	

}
