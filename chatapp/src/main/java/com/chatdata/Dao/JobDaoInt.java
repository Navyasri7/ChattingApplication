package com.chatdata.Dao;

import java.util.List;


import com.chatdata.model.Job;

public interface JobDaoInt {
	
	public boolean addJob(Job job);
	public void deleteJob(String id);
	public void editJob(Job job);
	public Job getJob(String id);
	 public List<Job> getAllJobs();

}
