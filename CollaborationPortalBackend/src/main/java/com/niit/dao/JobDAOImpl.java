 package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.model.Job;
import com.niit.model.JobApplied;

public class JobDAOImpl implements JobDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public JobDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	public List<Job> viewOpenedJobs() {
		// TODO Auto-generated method stub
		return null;
	}

	public Job getJobDetails(String job_id) {
		// TODO Auto-generated method stub
		Session sess=sessionFactory.openSession();
		Transaction tx=sess.beginTransaction();
		Job j=sess.get(Job.class, job_id);
		tx.commit();
		sess.close();
		return j;
	}

	public boolean updateJob(Job job) {
		// TODO Auto-generated method stub
		try{
			Session sess=sessionFactory.openSession();
			Transaction tx=sess.beginTransaction();
			sess.update(job);
			tx.commit();
			sess.close();
			return true;
		}
		catch(Exception e){
			System.out.println(e);
		return false;
		}
	}

	public boolean updateJobApplied(JobApplied jobapplied) {
		// TODO Auto-generated method stub
		try{
			Session sess=sessionFactory.openSession();
			Transaction tx=sess.beginTransaction();
			sess.update(jobapplied);
			tx.commit();
			sess.close();
		return true;
		}
		catch(Exception ex){
			System.out.println(ex);
			return false;
		}
	}

	public boolean insertJob(Job job) {
		// TODO Auto-generated method stub
		try{
			Session sess=sessionFactory.openSession();
			Transaction tx=sess.beginTransaction();
			sess.saveOrUpdate(job);
			tx.commit();
			sess.close();
			return true;
		}
		catch(Exception ex){
			System.out.println(ex);
			return false;
		}
	}

	public boolean insertJobApplied(JobApplied jobapplied) {
		// TODO Auto-generated method stub
		try{
			Session sess=sessionFactory.openSession();
			Transaction tx=sess.beginTransaction();
			sess.saveOrUpdate(jobapplied);
			tx.commit();
			sess.close();
			return true;
		}
		catch(Exception ex){
			System.out.println(ex);
			return false;
		}
	}

	public List<JobApplied> getMyAppliedJobs() {
		// TODO Auto-generated method stub
		return null;
	}

	public JobApplied getAppliedJob(String username, String job_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public JobApplied getAppliedJob(String job_id) {
		// TODO Auto-generated method stub
		Session sess=sessionFactory.openSession();
		Transaction tx=sess.beginTransaction();
		JobApplied j=sess.get(JobApplied.class, job_id);
		tx.commit();
		sess.close();
		return j;
	}

	public List<JobApplied> getallAppliedJobs() {
		// TODO Auto-generated method stub
		Session sess=sessionFactory.openSession();
		Transaction tx=sess.beginTransaction();
		Query q=sess.createQuery("from JobApplied");
		List<JobApplied> j=q.list();
		tx.commit();
		sess.close();
		return j;
	}

}
