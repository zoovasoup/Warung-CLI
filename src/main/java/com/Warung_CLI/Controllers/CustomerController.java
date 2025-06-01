package com.Warung_CLI.Controllers;

import java.util.Scanner;

import com.Warung_CLI.Models.Customer;
import com.Warung_CLI.Models.Product;
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
        Scanner scanner = new Scanner(System.in);
        while (true) {
            customerMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    customerService.getAllProducts().forEach(product -> {
                        System.out.println(product.toString());
                    });
                    break;
                case 2:
                    System.out.print("Masukkan ID produk: ");
                    String productId = scanner.next();
                    System.out.print("Masukkan jumlah produk: ");
                    int quantity = scanner.nextInt();

                    Product product = customerService.getAllProducts().stream()
                            .filter(p -> p.getId().equals(productId))
                            .findFirst()
                            .orElse(null);

                    customerService.addToCart(customer, product, quantity);
                    break;
                case 3:
                    customerService.seeCart(customer);
                    break;
                case 4:
                    System.out.print("Masukkan ID produk yang ingin dihapus: ");
                    String productIdToRemove = scanner.next();

                    customerService.removeFromCart(customer, productIdToRemove);
                    break;
                case 5:
                    System.out.println("Checkout keranjang...");

                    customerService.checkout(customer);
                    break;
                case 6:
                    System.out.println("Riwayat pesanan untuk " + customer.getName() + ":");

                    customerService.getOrderHistory(customer).forEach(order -> {
                        System.out.println(order.toString());
                    });
                    break;
                case 7:
                    System.out.println("Apakah Anda yakin ingin logout? (y/n)");
                    String confirm = scanner.next();
                    if (confirm.equalsIgnoreCase("y")) {
                        System.out.println("Anda telah logout.");
                        return; // Exit the loop and return to the main menu
                    }
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    public void customerMenu() {
        System.out.println("\n==== MENU CUSTOMER ====");
        System.out.println("1. Lihat semua produk");
        System.out.println("3. Tambah produk ke keranjang");
        System.out.println("4. Lihat keranjang");
        System.out.println("5. Hapus produk dari keranjang");
        System.out.println("6. Checkout");
        System.out.println("7. Lihat riwayat pesanan");
        System.out.println("8. Logout");
        System.out.print("Pilih opsi: ");
    }

}
