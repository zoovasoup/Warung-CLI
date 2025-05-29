package com.Warung_CLI.Models.Repo;

import java.util.HashMap;
import java.util.List;

import com.Warung_CLI.Models.Seller;

public class SellerRepo implements RepoInterface{
	private HashMap<String, Seller> database;
	private long idCounter = 0 ;
	
	public SellerRepo() {};
	
	@Override
	public Object put(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object patch(String id, Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
