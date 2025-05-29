package com.Warung_CLI.Repo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.Warung_CLI.Models.User;

public class CustomerRepo implements RepoInterface<User> {
	private HashMap<String, User> database;
	private long idCounter = 0;

	public CustomerRepo() {
	};

	@Override
	public User put(User user) {

		String id = "U" + String.valueOf(idCounter);
		database.put(id, (User) user);
		return (User) user;
	}

	@Override
	public User patch(String id, User user) {

		User userNew = (User) user;
		if (database.containsKey(id)) {
			database.put(id, userNew);
			return (User) user;
		}

		return null;
	}

	@Override
	public User getById(String id) {
		return database.get(id);
	}

	@Override
	public List<User> getAll() {
		return new ArrayList<>(database.values());
	}

	@Override
	public boolean delete(String id) {
		return database.remove(id) != null;
	}

}
