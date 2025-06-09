package com.Warung_CLI.Models;

import java.util.ArrayList;

public class Cart {
	private ArrayList<CartItem> items = new ArrayList<>();

	public Cart() {
	}

	public ArrayList<CartItem> getItems() {
		return items;
	}

	public void setItems(ArrayList<CartItem> items) {
		this.items = items;
	}

	public int getTotalPrice() {
		int totalPrice = 0;
		for (CartItem item : items) {
			totalPrice += item.getProduct().getPrice() * item.getQuantity();
		}
		return totalPrice;
	}

	public void addItem(CartItem item) {
		this.items.add(item);
	}

	public void clearCart() {
		this.items.clear();
	}

	public void removeItem(CartItem item) {
		this.items.remove(item);
	}

}
