package com.chatdata.Dao;

import com.chatdata.model.Job;

public interface JobDaoInt {
	
	public boolean addJob(Job job);
	public void deleteJob(String id);
	public void editJob(Job job);

}
