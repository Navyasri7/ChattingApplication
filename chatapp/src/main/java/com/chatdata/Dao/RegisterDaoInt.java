package com.chatdata.Dao;

import com.chatdata.model.Registration;

public interface RegisterDaoInt {
	 public boolean registerUser(Registration register);
	 public Registration loginCheck(Registration register);
	
}
