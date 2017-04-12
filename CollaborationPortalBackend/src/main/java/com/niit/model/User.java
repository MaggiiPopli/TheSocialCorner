package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class User extends Error{

	@Id
	private String username;
	private String name;
	private String email_id;
	private String gender;
	private String password;
	private String contact;
	private String address;
	private char status;
	private String role;
	private String reason;
	private char isOnline;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public char getIsOnline() {
		return isOnline;
	}
	public void setIsOnline(char isOnline) {
		this.isOnline = isOnline;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", name=" + name + ", email_id=" + email_id + ", gender=" + gender
				+ ", password=" + password + ", contact=" + contact + ", address=" + address + ", status=" + status
				+ ", role=" + role + ", reason=" + reason + ", isOnline=" + isOnline + "]";
	}
	
	
	
}
