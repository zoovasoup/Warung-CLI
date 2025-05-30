package com.Warung_CLI.Repo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.Warung_CLI.Models.Customer;
import com.Warung_CLI.Models.User;

public class CustomerRepo implements RepoInterface<Customer> {
	private HashMap<String, Customer> database;

	public CustomerRepo() {
	};

	@Override
	public Customer put(Customer customer) {
		database.put(customer.getId(), (Customer) customer);
		return (Customer) customer;
	}

	@Override
	public Customer patch(String id, Customer customer) {

		Customer userNew = (Customer) customer;
		if (database.containsKey(id)) {
			database.put(id, userNew);
			return (Customer) customer;
		}

		return null;
	}

	@Override
	public User getById(String id) {
		return database.get(id);
	}

	@Override
	public List<Customer> getAll() {
		return new ArrayList<>(database.values());
	}

	@Override
	public boolean delete(String id) {
		return database.remove(id) != null;
	}

	public HashMap<String, Customer> getDatabase() {
		return this.database;
	}
}
