package com.Warung_CLI.Controllers;

import com.Warung_CLI.Models.User;

/**
 * AuthController
 */
public class AuthController {

    public void loginMenu() {
        System.out.println("Welcome to the Login Menu");
        System.out.println("1. Login as Customer");
        System.out.println("2. Login as Seller");
        System.out.println("3. Exit");
    }

    public void registerMenu() {
        System.out.println("Welcome to the Registration Menu");
        System.out.println("1. Register as Customer");
        System.out.println("2. Register as Seller");
    }

    public Object loginRedirect(User user) {
        if (user.isSeller()) {
            return new SellerController();
        } else {
            return new CustomerController();
        }
    }
}
