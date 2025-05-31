package com.Warung_CLI.Repo.Data;

import com.Warung_CLI.Models.Customer;
import com.Warung_CLI.Repo.CustomerRepo;

public class CustomerData {
	private Customer[] customers;

	private Customer c1 = new Customer("Alice Johnson", "alice_j", "alice123");
	private Customer c2 = new Customer("Bob Smith", "bob_s", "bobpass");
	private Customer c3 = new Customer("Charlie Brown", "charlie_b", "charlie321");
	private Customer c4 = new Customer("Diana Prince", "diana_p", "wonderwoman");

	public CustomerData() {
		customers = new Customer[] { c1, c2, c3, c4 };
	}

	public void injectCustomer(CustomerRepo customerRepo) {
		for (Customer customer : customers) {
			customerRepo.put(customer);
		}
	}

}
