package com.Warung_CLI.Repo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.Warung_CLI.Models.Seller;

public class SellerRepo implements RepoInterface<Seller> {
	private HashMap<String, Seller> database;
	private long idCounter = 0;

	public SellerRepo() {
	};

	@Override
	public Seller put(Seller seller) {

		String id = "S" + String.valueOf(idCounter);
		database.put(id, (Seller) seller);
		return (Seller) seller;
	}

	@Override
	public Seller patch(String id, Seller seller) {

		Seller sellerNew = (Seller) seller;
		if (database.containsKey(id)) {
			database.put(id, sellerNew);
			return (Seller) seller;
		}

		return null;
	}

	@Override
	public Seller getById(String id) {
		return database.get(id);
	}

	@Override
	public List<Seller> getAll() {
		return new ArrayList<>(database.values());
	}

	@Override
	public boolean delete(String id) {
		return database.remove(id) != null;
	}
}
