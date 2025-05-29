package com.Warung_CLI.Models;

import java.util.ArrayList;

public class Seller extends User {
	private String storeName;
	private String storeDescription;
	private ArrayList<Product> products;

	public Seller(User user, String storeName, String storeDescription, ArrayList<Product> products) {
		super(user.getName(), user.getUsername(), user.getEmail(), user.getPassword(), true);
		this.storeName = storeName;
		this.storeDescription = storeDescription;
		this.products = products;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreDescription() {
		return storeDescription;
	}

	public void setStoreDescription(String storeDescription) {
		this.storeDescription = storeDescription;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Seller [storeName=" + storeName + ", storeDescription=" + storeDescription + ", products=" + products
				+ "]";
	}
}
