package com.Warung_CLI.Controllers;

import java.util.Scanner;

import com.Warung_CLI.Models.Customer;
import com.Warung_CLI.Models.Seller;
import com.Warung_CLI.Models.User;
import com.Warung_CLI.Repo.CustomerRepo;
import com.Warung_CLI.Repo.SellerRepo;
import com.Warung_CLI.Services.AuthService;

/**
 * AuthController
 */
public class AuthController {
    private AuthService authService;
    private SellerRepo sellerRepo;
    private CustomerRepo customerRepo;

    public AuthController(AuthService authService, SellerRepo sellerRepo, CustomerRepo customerRepo) {
        this.authService = authService;
        this.sellerRepo = sellerRepo;
        this.customerRepo = customerRepo;
    }

    public User authRoute() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1: // Login
                    return loginRoute();
                case 2: // Register
                    // return registerRoute();
                case 3: // Exit
                    System.out.println("Exiting...");
                    return null;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    public User loginRoute() {
        System.out.println("Welcome to the Login Menu");
        System.out.println("1. Login as Customer");
        System.out.println("2. Login as Seller");
        System.out.println("3. Exit");

        while (true) {
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: // Login as Customer
                    System.out.print("Enter username: ");
                    String customerUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String customerPassword = scanner.nextLine();
                    User customer = authService.login(customerUsername, customerPassword);
                    if (customer != null && !customer.isSeller()) {
                        return customer;
                    } else {
                        System.out.println("Invalid credentials or not a customer.");
                    }
                    break;

                case 2: // Login as Seller
                    System.out.print("Enter username: ");
                    String sellerUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String sellerPassword = scanner.nextLine();
                    User seller = authService.login(sellerUsername, sellerPassword);
                    if (seller != null && seller.isSeller()) {
                        return seller;
                    } else {
                        System.out.println("Invalid credentials or not a seller.");
                    }
                    break;

                case 3: // Exit
                    System.out.println("Exiting...");
                    return null;

                default:
                    System.out.println("Invalid choice, please try again.");
            }

        }
    }

    public User registerRoute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Registration Menu");
        System.out.println("1. Register as Customer");
        System.out.println("2. Register as Seller");
        System.out.println("3. Exit");

        while (true) {
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1: // Register as Customer
                    System.out.print("Enter name: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Enter username: ");
                    String customerUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String customerPassword = scanner.nextLine();
                    Customer customer = new Customer(customerName, customerUsername, customerPassword);

                    customerRepo.put(customer);
                    return customer;

                case 2: // Register as Seller
                    System.out.print("Enter name: ");
                    String sellerName = scanner.nextLine();
                    System.out.print("Enter username: ");
                    String sellerUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String sellerPassword = scanner.nextLine();
                    System.out.print("Enter store name: ");
                    String storeName = scanner.nextLine();
                    System.out.print("Enter store description: ");
                    String storeDescription = scanner.nextLine();
                    Seller seller = new Seller(sellerName, sellerUsername, sellerPassword, storeName, storeDescription);

                    sellerRepo.put(seller);
                    return seller;

                case 3: // Exit
                    System.out.println("Exiting...");
                    return null;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    public void registerMenu() {
        System.out.println("Welcome to the Registration Menu");
        System.out.println("1. Register as Customer");
        System.out.println("2. Register as Seller");
    }

}
