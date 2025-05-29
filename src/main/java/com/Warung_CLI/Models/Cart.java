package com.Warung_CLI.Models;

import java.util.ArrayList;

import com.Warung_CLI.Models.Payment.Payment;

public class Cart {
	private ArrayList<CartItem> items;
	private int totalPrice;
	private Payment payment;
	
	public Cart(ArrayList<CartItem> items, int totalPrice, Payment payment) {
		this.items = items;
		this.totalPrice = totalPrice;
		this.payment = payment;
	}

	public ArrayList<CartItem> getItems() {
		return items;
	}

	public void setItems(ArrayList<CartItem> items) {
		this.items = items;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	
}
