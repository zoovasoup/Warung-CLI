package com.Warung_CLI;

import com.Warung_CLI.Controllers.AuthController;
import com.Warung_CLI.Controllers.CustomerController;
import com.Warung_CLI.Controllers.SellerController;
import com.Warung_CLI.Models.Customer;
import com.Warung_CLI.Models.Seller;
import com.Warung_CLI.Models.User;
import com.Warung_CLI.Repo.CustomerRepo;
import com.Warung_CLI.Repo.OrderRepo;
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
        OrderRepo orderRepo = new OrderRepo();

        AuthService authService = new AuthService(customerRepo, sellerRepo);
        CustomerService customerService = new CustomerService(customerRepo);
        SellerService sellerService = new SellerService(sellerRepo);

        AuthController authController = new AuthController();
        CustomerController customerController = new CustomerController();
        SellerController sellerController = new SellerController(sellerService);

        String username = "testUser";
        String password = "testPass";

        while (true) {
            authController.loginMenu();
            int choice = 1;
            switch (choice) {
                case 1: 
                    User user = authService.login(username, password);
                    if ( user instanceof Customer) {
                    	sellerController.sellerRoute();
                    } else {
                    	customerController.customerRoute()
                    }

                case 3: // Exit
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
