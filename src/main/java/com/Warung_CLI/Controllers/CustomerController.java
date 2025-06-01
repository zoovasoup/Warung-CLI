package com.Warung_CLI.Controllers;

import com.Warung_CLI.Models.Customer;
import com.Warung_CLI.Services.CustomerService;

/**
 * CustomerController
 */
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void customerRoute(Customer customer) {
        cus

    }

    public void customerMenu() {
        System.out.println("\n==== MENU CUSTOMER ====");
        System.out.println("1. Lihat list produk");
        System.out.println("2. Tambah ke keranjang");
        System.out.println("3. Lihat keranjang");
        System.out.println("4. Checkout");
        System.out.println("5. Riwayat pesanan");
        System.out.println("6. Kembali");
        System.out.print("Pilih opsi: ");
    }

}
