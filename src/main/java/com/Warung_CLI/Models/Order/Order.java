package com.Warung_CLI.Models.Order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.Warung_CLI.Models.Customer;
import com.Warung_CLI.Models.Product;

public class Order {
	private String id;
	private Customer customer;
	private List<OrderItem> items;
	private Date orderDate;
	private boolean isPaid;

	public Order(String id, Customer customer) {
		this.id = id;
		this.customer = customer;
		this.items = new ArrayList<>();
		this.orderDate = new Date();
		this.isPaid = false;
	}

	public String getId() {
		return id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void addItem(Product product, int quantity) {

	}

	public Date getOrderDate() {
		return orderDate;
	}

	public boolean isPaid() {
		return isPaid;
	}

	public void setPaid(boolean paid) {
		isPaid = paid;
	}

	public double getTotalAmount() {
		double total = 0;
		for (OrderItem item : items) {
			total += item.getTotalPrice();
		}
		return total;
	}
}
