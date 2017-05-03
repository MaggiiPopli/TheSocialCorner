package com.niit.dao;

import java.util.List;

import com.niit.model.Job;
import com.niit.model.JobApplied;

public interface JobDAO {
	
	public List<Job> viewOpenedJobs();
	public Job getJobDetails(String job_id);
	public boolean updateJob(Job job);
	public boolean updateJobApplied(JobApplied jobapplied);
	public boolean insertJob(Job job);
	public boolean insertJobApplied(JobApplied jobapplied);
	public List<JobApplied> getMyAppliedJobs();
	public JobApplied getAppliedJob(String username, String job_id);
	public JobApplied getAppliedJob(String job_id);
	public List<JobApplied> getallAppliedJobs();
	
	

}
