package com.chatdata.Dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chatdata.model.Friend;
import com.chatdata.model.Registration;

@Repository("friendDao")
@Transactional
public class FriendDaoImpl implements FriendDaoInt {
	@Autowired
	private SessionFactory sessionFactory;

	public List<Registration> listOfSuggestedUsers(String firstName) {
		Session session=sessionFactory.getCurrentSession();
		SQLQuery query=session.createSQLQuery("select * from Registration where firstName in "
							+ "(select firstName from Registration where firstName!=? minus "
							+ "(select fromId from Friend where toId=? "
							+ "union select toId from Friend where fromId=?)"
							+ ")");
		query.setString(0, "firstName");
		query.setString(1, "firstName");
		query.setString(2, "firstName");
		query.addEntity(Registration.class);
		List<Registration> suggestedUsers=query.list();
		
		return suggestedUsers ;
	}

	public void friendRequest(Friend friend) {
		Session session=sessionFactory.getCurrentSession();
		session.save(friend);
		
	}

}
