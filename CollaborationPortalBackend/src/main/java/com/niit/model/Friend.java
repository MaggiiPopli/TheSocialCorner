package com.niit.model;


import javax.persistence.Entity;

import org.springframework.stereotype.Component;
import javax.persistence.Id;

@Component
@Entity
public class Friend {

	@Id
	private int Id;
	private String username;
	private String friend_name;
	private char friend_request;
	private char isOnline;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFriend_name() {
		return friend_name;
	}
	public void setFriend_name(String friend_name) {
		this.friend_name = friend_name;
	}
	public char getFriend_request() {
		return friend_request;
	}
	public void setFriend_request(char friend_request) {
		this.friend_request = friend_request;
	}
	public char getIsOnline() {
		return isOnline;
	}
	public void setIsOnline(char isOnline) {
		this.isOnline = isOnline;
	}
	
	
	
}
