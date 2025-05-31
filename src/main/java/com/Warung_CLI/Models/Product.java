package com.Warung_CLI.Models;

public class Product {
	private String id;
	private String title;
	private String description;
	private double price;
	private String categories;
	private int quantity;
	private static long idCounter = 1;

	public Product() {
	}

	public Product(String title, String description, double price, String categories, int quantity) {
		super();
		this.id = generateId();
		this.title = title;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.categories = categories;
	}

	public String generateId() {
		String id = "P" + (idCounter++);
		return id;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "id: " + id + ", title: " + title + ", description: " + description + ", price: " + price
				+ ", categories: " + categories + ", quantity: " + quantity;
	}
}
