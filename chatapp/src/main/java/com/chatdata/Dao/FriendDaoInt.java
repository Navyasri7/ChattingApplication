package com.chatdata.Dao;

import java.util.List;

import com.chatdata.model.Friend;
import com.chatdata.model.Registration;

public interface FriendDaoInt {
	List<Registration>listOfSuggestedUsers(String firstName );
	public void friendRequest(Friend friend);

}
