package com.Warung_CLI;

import java.util.Scanner;

import com.Warung_CLI.Controllers.AuthController;
import com.Warung_CLI.Controllers.CustomerController;
import com.Warung_CLI.Controllers.SellerController;
import com.Warung_CLI.Models.Customer;
import com.Warung_CLI.Models.Seller;
import com.Warung_CLI.Models.User;
import com.Warung_CLI.Repo.CustomerRepo;
import com.Warung_CLI.Repo.OrderRepo;
import com.Warung_CLI.Repo.SellerRepo;
import com.Warung_CLI.Repo.Data.CustomerData;
import com.Warung_CLI.Repo.Data.SellerData;
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

        CustomerData customerData = new CustomerData();
        SellerData sellerData = new SellerData();

        customerData.injectCustomer(customerRepo);
        sellerData.injectSeller(sellerRepo);

        AuthService authService = new AuthService(customerRepo, sellerRepo);
        CustomerService customerService = new CustomerService(customerRepo);
        SellerService sellerService = new SellerService(sellerRepo, orderRepo);

        AuthController authController = new AuthController(authService, sellerRepo, customerRepo);
        CustomerController customerController = new CustomerController();
        SellerController sellerController = new SellerController(sellerService);

        while (true) {
            User user = authController.authRoute();

            if (user instanceof Customer) {
                System.out.println("masuk customer");
                Customer customer = (Customer) user;

                // TODO: delete this sysout
                System.out.println(customer.toString());
                break;

            } else if (user instanceof Seller) {
                System.out.println("masuk seller");
                Seller seller = (Seller) user;

                // TODO: delete this sysout
                System.out.println(seller.toString());

                sellerController.sellerRoute(seller);
                break;
            }
        }

        System.out.println("thankyou for using our application!");
    }
}
