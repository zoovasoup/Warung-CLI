package com.Warung_CLI.Models;

public class CartItem {
	private Product product;
	private int quantity;
	private double totalPrice;

	public CartItem(Product product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
		this.totalPrice = product.getPrice() * quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
}
