package com.chatdata.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Friend {
	
@Id
	private String id;
	public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getFromId() {
	return fromId;
}
public void setFromId(String fromId) {
	this.fromId = fromId;
}
public String getToId() {
	return toId;
}
public void setToId(String toId) {
	this.toId = toId;
}
public char getStatus() {
	return status;
}
public void setStatus(char status) {
	this.status = status;
}
	private String fromId;
	private String toId;
	private char  status;

}
