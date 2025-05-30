package com.Warung_CLI.Services;

import java.util.List;
import java.util.UUID;

import com.Warung_CLI.Models.Cart;
import com.Warung_CLI.Models.CartItem;
import com.Warung_CLI.Models.Customer;
import com.Warung_CLI.Models.User;
import com.Warung_CLI.Models.Order.Order;
import com.Warung_CLI.Repo.CustomerRepo;

/**
 * CustomerService
 */
public class CustomerService {
    private final CustomerRepo customerRepo;

    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public Order checkout(Customer customer, Cart cart) {
        Order order = new Order(UUID.randomUUID().toString(), customer);

        for (CartItem cartItem : cart.getItems()) {
            order.addItem(cartItem.getProduct(), cartItem.getQuantity());
        }

        cart.clearCart();
        order.setPaid(true);
        return order;
    }

    public List<User> getAllCustomers(CustomerRepo customerRepo) {
        return customerRepo.getAll();
    }
}
