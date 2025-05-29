package com.Warung_CLI.Models;

import java.util.ArrayList;

public class Seller extends User{
	private String storeName;
	private String storeDescription;
	private ArrayList<Product> products;
	
	public Seller(User user, String storeName, String storeDescription, ArrayList<Product> products) {
		super(user.getName(), user.getUsername(), user.getEmail(), user.getPassword());
	}

	@Override
	public String toString() {
		return "Seller [storeName=" + storeName + ", storeDescription=" + storeDescription + ", products=" + products
				+ "]";
	}
}
