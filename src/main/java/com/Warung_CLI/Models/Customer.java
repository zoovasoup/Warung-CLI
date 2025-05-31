package com.Warung_CLI.Models;

import com.Warung_CLI.Models.Order.OrderHistory;

public class Customer extends User {
	private Cart cart;
	private OrderHistory history;
	private static int idCounter = 1;

	public Customer(String name, String username, String password) {
		super(name, username, password, false);
		super.setId(generateId());
	}

	public String generateId() {
		return "C" + (idCounter++);
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

	@Override
	public String toString() {
		return super.toString() + "Customer [cart=" + cart + ", history=" + history + "]";
	}

}
