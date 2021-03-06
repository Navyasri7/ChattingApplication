package com.chatdata.Dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.chatdata.model.Job;

@Repository("jobDao")
@Transactional
public class JobDaoImpl implements JobDaoInt {
	@Autowired
	private SessionFactory sessionFactory;

	public boolean addJob(Job job) {
		Session session=sessionFactory.getCurrentSession();
		try
		{
			session.save(job);
			return true;
		}
		catch(Exception e)
		{
		System.out.println(e.getMessage());
		return false;
		
	}
	}

	public void deleteJob(String id) {
		Session session=sessionFactory.getCurrentSession();
		Job job=session.get(Job.class,id);
		session.delete(job);
	}

	public void editJob(Job job) {
		Session session = sessionFactory.getCurrentSession();
		session.update(job);
		
	}

	public Job getJob(String id) {
		Session session=sessionFactory.getCurrentSession();
		Job job=(Job)session.get(Job.class, id);
		return job;
	}

	public List<Job> getAllJobs() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Job");
		return query.getResultList();
	}

}
