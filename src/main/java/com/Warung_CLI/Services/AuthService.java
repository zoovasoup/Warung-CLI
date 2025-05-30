package com.Warung_CLI.Services;

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
    private final List<User> users;

    public AuthService(CustomerRepo customerRepo, SellerRepo sellerRepo) {
        this.customerRepo = customerRepo;
        this.sellerRepo = sellerRepo;
        this.users = customerRepo.getAll();
        users.addAll(sellerRepo.getAll());
    }

    public User login(String username, String password) {
        User auth = new User(username, password);

        for (User user : users) {
            if (user.getUsername().equals(auth.getUsername()) && user.getPassword().equals(auth.getPassword())) {
                return user;
            }
        }

        return null;
    }

    public boolean register(String name, String username, String password, boolean role) {
        User newUser = new User(name, username, password, role);
        if (role) {
            sellerRepo.put((Seller) newUser);
        } else {
            customerRepo.put((Customer) newUser);
        }
        return false;
    }

}
