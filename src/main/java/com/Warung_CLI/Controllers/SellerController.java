package com.Warung_CLI.Controllers;

import java.util.Scanner;

import com.Warung_CLI.Models.Product;
import com.Warung_CLI.Models.Seller;
import com.Warung_CLI.Models.Order.Order;
import com.Warung_CLI.Services.SellerService;

/**
 * SellerController
 */
public class SellerController {
    private final SellerService sellerService;
    private String sellerId = null;

    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    public void sellerRoute(Seller seller) {
        Scanner sc = new Scanner(System.in);
        this.sellerId = seller.getId(); // Assuming Seller has a method getId()
        while (true) {
            sellerMenu();
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline character
            switch (choice) {
                case 1: // View all products
                    sellerService.getAllProduct();
                    break;

                case 2: // Add a new product
                    addProductMenu();
                    Product product = new Product("", "", "", 0.0, "", 0); // Create a new Product
                    sellerService.addProduct(product);
                    break;

                case 3: // Delete a product
                    Product product2 = new Product("", "", "", 0.0, "", 0); // Create a new Product
                    sellerService.deleteProduct(product2.getId());
                    break;

                case 4: // View orders from customers
                    for (Order order : sellerService.getOrdersForSeller()) {
                        System.out.println(order.toString());
                    }
                    break;
                case 5:
                    System.out.println("Kembali ke menu utama.");
                    return; // Exit the loop and return to the main menu
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    public void sellerMenu() {
        System.out.println("\n==== MENU SELLER ====");
        System.out.println("1. Lihat semua produk");
        System.out.println("2. Tambah produk");
        System.out.println("3. Hapus produk");
        System.out.println("4. Lihat pesanan dari customer");
        System.out.println("5. Kembali");
        System.out.print("Pilih opsi: ");
    }

    public void addProductMenu() {
        System.out.println("\n==== TAMBAH PRODUK ====");
        System.out.print("Masukkan nama produk: ");
        // Add logic to read product name
        System.out.print("Masukkan harga produk: ");
        // Add logic to read product price
        System.out.print("Masukkan deskripsi produk: ");
        // Add logic to read product description
        // Logic to add the product using sellerService
    }

    public void deleteProductMenu() {
        System.out.println("\n==== HAPUS PRODUK ====");
        System.out.print("Masukkan ID produk yang ingin dihapus: ");
        // Add logic to read product ID
        // Logic to delete the product using sellerService
    }
}
