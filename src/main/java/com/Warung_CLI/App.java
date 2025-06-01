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
        CustomerService customerService = new CustomerService(customerRepo, sellerRepo, orderRepo);
        SellerService sellerService = new SellerService(sellerRepo, orderRepo);

        AuthController authController = new AuthController(authService, sellerRepo, customerRepo);
        CustomerController customerController = new CustomerController(customerService);
        SellerController sellerController = new SellerController(sellerService);

        mainMenu(authController, customerController, sellerController);

    }

    private static void mainMenu(AuthController authController, CustomerController customerController,
            SellerController sellerController) {
        boolean running = true;

        while (running) {
            User user = authController.authRoute();

            if (user == null) {
                // User memilih Exit dari authRoute()
                running = false;
                System.out.println("Terima kasih telah menggunakan aplikasi!");
            } else if (user instanceof Customer) {
                Customer customer = (Customer) user;
                customerController.customerRoute(customer);
                // Setelah route selesai, akan otomatis loop ulang ke authRoute()
            } else if (user instanceof Seller) {
                Seller seller = (Seller) user;
                sellerController.sellerRoute(seller);
                // Setelah route selesai, akan otomatis loop ulang ke authRoute()
            }
        }
    }
}
