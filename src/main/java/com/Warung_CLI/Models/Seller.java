package com.Warung_CLI.Models;

import java.util.ArrayList;

public class Seller extends User {
	private String storeName;
	private String storeDescription;
	private ArrayList<Product> products;
	private static int idCounter = 1;

	public Seller(String name, String username, String password, String storeName, String storeDescription) {
		super(name, username, password, true);
		this.storeName = storeName;
		this.storeDescription = storeDescription;
		this.products = new ArrayList<>();
		super.setId(generateId());
	}

	public String generateId() {
		return "S" + (idCounter++);
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

	public void addProduct(Product product) {
		this.products.add(product);
	}

	@Override
	public String toString() {
		return super.toString() + "Seller [storeName=" + storeName + ", storeDescription=" + storeDescription
				+ ", products=" + products
				+ "]";
	}
}
