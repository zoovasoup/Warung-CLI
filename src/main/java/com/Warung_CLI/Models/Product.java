package com.Warung_CLI.Models;

public class Product {
	private String title;
	private String description;
	private double price;
	private String categories;
	private int quantity;
	
	public Product(String title, String description, double price, String categories, int quantity) {
		super();
		this.title = title;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.categories = categories;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
