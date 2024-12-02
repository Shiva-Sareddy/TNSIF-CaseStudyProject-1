package org.tns.onlineshopping.entities;

public class User {
	
	// Attributes
	private int userId;
	private String username;
	private String email;
	
	// Constructor
	public User(int userId, String username, String email) {
		this.userId = userId;
		this.username = username;
		this.email = email;
	}

	
	// Getters and Setters
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", email=" + email + "]";
	}
	
	
}