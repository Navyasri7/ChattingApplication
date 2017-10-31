package com.chatdata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chatdata.Dao.FriendDaoInt;
import com.chatdata.model.Friend;
import com.chatdata.model.Registration;

@RestController
public class FriendController {
	@Autowired
	private FriendDaoInt friendDao;
	
	@PostMapping("/suggestFriend")
	public ResponseEntity<?> listOfSuggestedUsers(@RequestBody String firstname){
		List<Registration> suggestedUsers=friendDao.listOfSuggestedUsers(firstname);
		return new ResponseEntity<List<Registration>>(suggestedUsers,HttpStatus.OK);		

}
	@PostMapping("/friend")
	public ResponseEntity<?> friendRequest(@RequestBody Friend friend ){
			friendDao.friendRequest(friend);
		System.out.println(friend.getFromId());
				return new ResponseEntity<Friend>(friend,HttpStatus.OK);		
			
		}
	/*@PostMapping("/pending")
	public ResponseEntity<?> pendingRequests(@RequestBody String firstname ){
		List<Friend> pendingRequests=friendDao.pendingRequests(firstname);
		return new ResponseEntity<List<Friend>>(pendingRequests,HttpStatus.OK);	
	}*/
	}

