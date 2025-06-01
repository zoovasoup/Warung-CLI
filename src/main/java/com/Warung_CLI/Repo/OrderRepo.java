package com.Warung_CLI.Repo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.Warung_CLI.Models.Order.Order;

public class OrderRepo implements RepoInterface<Order> {
	private HashMap<String, Order> database;

	public OrderRepo() {
		this.database = new HashMap<>();
	};

	@Override
	public Order put(Order order) {
		database.put(order.getId(), (Order) order);
		return (Order) order;
	}

	@Override
	public Order patch(String id, Order order) {

		Order orderNew = (Order) order;
		if (database.containsKey(id)) {
			database.put(id, orderNew);
			return (Order) order;
		}

		return null;
	}

	@Override
	public Order getById(String id) {
		return database.get(id);
	}

	@Override
	public List<Order> getAll() {
		return new ArrayList<>(database.values());
	}

	@Override
	public boolean delete(String id) {
		return database.remove(id) != null;
	}
}
