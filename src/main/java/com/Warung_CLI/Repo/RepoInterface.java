package com.Warung_CLI.Repo;

import java.util.List;

public interface RepoInterface<T> {

	T put(T object);

	Object patch(String id, Object object);

	Object getById(String id);

	List<T> getAll();

	boolean delete(String id);

}
