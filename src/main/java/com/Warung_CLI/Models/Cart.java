package com.Warung_CLI.Models;

import java.util.ArrayList;

import com.Warung_CLI.Models.Payment.Payment;

public class Cart {
	private ArrayList<CartItem> items = new ArrayList<>();
	private Payment payment;

	public Cart(ArrayList<CartItem> items, Payment payment) {
		this.items = items;
		this.payment = payment;
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

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
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
