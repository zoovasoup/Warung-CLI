package com.Warung_CLI.Models.Order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.Warung_CLI.Models.CartItem;
import com.Warung_CLI.Models.Customer;
import com.Warung_CLI.Models.Product;

public class Order {
	private String id;
	private Customer customer;
	private List<OrderItem> items;
	private Date orderDate;
	private boolean isPaid;
	private static long idCounter = 1;

	public Order(Customer customer, ArrayList<CartItem> items) {
		this.id = generateId();
		this.customer = customer;
		this.items = new ArrayList<>();

		for (CartItem cartItem : items) {
			OrderItem orderItem = new OrderItem(cartItem.getProduct(), cartItem.getQuantity());
			this.items.add(orderItem);
		}

		this.orderDate = new Date();
		this.isPaid = false;
	}

	public String generateId() {
		String id = "O" + idCounter;
		return id;
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

	@Override
	public String toString() {
		return "======= DATA PESANAN =======\n" +
				"ID Pesanan   : " + id + "\n" +
				"Pelanggan    : " + (customer != null ? customer.getUsername() : "null") + "\n" +
				"Tanggal      : " + orderDate + "\n" +
				"Status Bayar : " + (isPaid ? "Sudah dibayar" : "Belum dibayar") + "\n" +
				"Jumlah Item  : " + (items != null ? items.size() : 0) + "\n" +
				"Total Harga  : " + getTotalAmount() + "\n" +
				"=============================";
	}
}
