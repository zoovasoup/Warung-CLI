package com.Warung_CLI.Models.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderHistory {
	private final List<Order> orders;

	public OrderHistory() {
		this.orders = new ArrayList<>();
	}

	public void add(Order order) {
		orders.add(order);
	}

	public List<Order> getOrders() {
		return orders;
	}

	public boolean isEmpty() {
		return orders.isEmpty();
	}

	public void printAllOrders() {
		if (orders.isEmpty()) {
			System.out.println("Belum ada riwayat pesanan.");
			return;
		}

		System.out.println("\n==== RIWAYAT PESANAN ====");
		for (Order order : orders) {
			System.out.println(order);
		}
	}
}
