package com.Warung_CLI.Models;

import com.Warung_CLI.Models.Order.Order;
import com.Warung_CLI.Models.Order.OrderHistory;

public class Customer extends User {
	private Cart cart;
	private OrderHistory history = new OrderHistory();
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

	public void addOrder(Order order) {
		this.history.add(order);
		;
	}

	public void clearCart() {
		if (cart != null) {
			cart.clearCart();
		}
	}

	@Override
	public String toString() {
		return super.toString() + "\n======= DATA CUSTOMER =======\n" +
				"Isi Keranjang   : " + (cart != null ? cart.getItems().size() : 0) + " item\n" +
				"Total Pesanan   : " + (history != null ? history.getOrders().size() : 0) + "\n" +
				"==============================";
	}
}
