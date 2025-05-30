package com.Warung_CLI;

import com.Warung_CLI.Repo.CustomerRepo;
import com.Warung_CLI.Repo.SellerRepo;
import com.Warung_CLI.Services.AuthService;
import com.Warung_CLI.Services.CustomerService;
import com.Warung_CLI.Services.SellerService;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        CustomerRepo customerRepo = new CustomerRepo();
        SellerRepo sellerRepo = new SellerRepo();

        AuthService authService = new AuthService(customerRepo, sellerRepo);
        CustomerService customerService = new CustomerService(customerRepo);
        SellerService sellerService = new SellerService(sellerRepo);

        String username = "testUser";
        String password = "testPass";

        authService.login(username, password);
        System.out.println("Hello World!");
    }
}
