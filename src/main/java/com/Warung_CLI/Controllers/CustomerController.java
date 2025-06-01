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

    }

    public void customerMenu() {
        System.out.println("\n==== MENU CUSTOMER ====");
        System.out.println("1. Lihat semua produk");
        System.out.println("2. Cari produk");
        System.out.println("3. Tambah produk ke keranjang");
        System.out.println("4. Lihat keranjang");
        System.out.println("5. Hapus produk dari keranjang");
        System.out.println("6. Checkout");
        System.out.println("7. Lihat riwayat pesanan");
        System.out.println("8. Kembali ke menu utama");
        System.out.print("Pilih opsi: ");
    }

}
