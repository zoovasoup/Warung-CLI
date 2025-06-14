package com.Warung_CLI.Models;

public abstract class User {
	private String name;
	private String username;
	private String password;
	private boolean seller;
	private String id;

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public User(String name, String username, String password, boolean seller) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
	}

	public abstract String generateId();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isSeller() {
		return seller;
	}

	public void setSeller(boolean seller) {
		this.seller = seller;
	}

	@Override
	public String toString() {
		return "======= DATA USER =======\n" +
				"Nama     : " + name + "\n" +
				"Username : " + username + "\n" +
				"Password : " + password + "\n";
	}
}
