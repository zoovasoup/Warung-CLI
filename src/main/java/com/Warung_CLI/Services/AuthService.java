package com.Warung_CLI.Services;

import java.util.ArrayList;
import java.util.List;

import com.Warung_CLI.Models.Customer;
import com.Warung_CLI.Models.Seller;
import com.Warung_CLI.Models.User;
import com.Warung_CLI.Repo.CustomerRepo;
import com.Warung_CLI.Repo.SellerRepo;

/**
 * LoginService
 */
public class AuthService {
    private final SellerRepo sellerRepo;
    private final CustomerRepo customerRepo;

    public AuthService(CustomerRepo customerRepo, SellerRepo sellerRepo) {
        this.customerRepo = customerRepo;
        this.sellerRepo = sellerRepo;
    }

    public User loginSeller(String username, String password) {
        for (User user : sellerRepo.getAll()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public User loginCustomer(String username, String password) {
        for (User user : customerRepo.getAll()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public Customer registerUser(String name, String username, String password, boolean role) {
        Customer newCustomer = new Customer(name, username, password);
        customerRepo.put((Customer) newCustomer);
        return newCustomer;
    }

    public Seller registerSeller(String name, String username, String password, String storeName,
            String storeDescription, boolean role) {
        Seller newSeller = new Seller(name, username, password, storeName, storeDescription);
        sellerRepo.put((Seller) newSeller);
        return newSeller;
    }

}
