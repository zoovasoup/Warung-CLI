package com.Warung_CLI.Models.Order;

import com.Warung_CLI.Models.Product;

public class OrderItem {
	private Product product;
	private int quantity;

	public OrderItem(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}
	
	public double getTotalPrice() {
		return quantity * product.getPrice();
	}

}
