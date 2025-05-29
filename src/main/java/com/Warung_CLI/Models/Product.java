package com.Warung_CLI.Models;

public class Product {
	private String title;
	private String description;
	private double price;
	private String Categories;
	
	public Product(String title, String description, double price, String categories) {
		super();
		this.title = title;
		this.description = description;
		this.price = price;
		Categories = categories;
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
		return Categories;
	}

	public void setCategories(String categories) {
		Categories = categories;
	}
	
}
