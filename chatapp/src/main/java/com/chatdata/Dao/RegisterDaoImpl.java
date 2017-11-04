package com.chatdata.Dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chatdata.model.Registration;
@Repository("registerDao")
@Transactional
public class RegisterDaoImpl implements RegisterDaoInt {
	@Autowired
	private SessionFactory sessionFactory;

	public boolean registerUser(Registration register) {
		Session session=sessionFactory.getCurrentSession();
		try
		{
			session.save(register);
		return true;
	}catch(Exception e)
		{
		System.out.println(e.getMessage());
		return false;
	}

	}

public Registration loginCheck(Registration register) {
	Session session=sessionFactory.getCurrentSession();
	Query query=session.createQuery("from Registration where id = ? and password = ?");
	query.setString(0, register.getId());
	query.setString(1, register.getPassword());
	register =(Registration)query.uniqueResult();
	return register;
}	
}
