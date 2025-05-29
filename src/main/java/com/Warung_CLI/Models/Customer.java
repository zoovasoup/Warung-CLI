package com.Warung_CLI.Models;

import com.Warung_CLI.Models.Order.OrderHistory;

public class Customer extends User{
	private Cart cart;
	private OrderHistory history;

	public Customer(User user) {
		super(user.getName(), user.getUsername(), user.getEmail(), user.getPassword(), false);
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public OrderHistory getHistory() {
		return history;
	}

	public void setHistory(OrderHistory history) {
		this.history = history;
	}
}
