package com.Warung_CLI.Controllers;

import java.util.ArrayList;
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
        sellerService.setSellerId(seller.getId());
        Scanner sc = new Scanner(System.in);
        this.sellerId = seller.getId();

        while (true) {
            sellerMenu();
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    ArrayList<Product> allProduct = sellerService.getAllProduct();
                    for (Product product : allProduct) {
                        System.out.println(product.toString());
                    }
                    break;

                case 2:
                    addProductMenu();
                    break;

                case 3:
                    deleteProductMenu();
                    break;

                case 4:
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

    public void addProduct() {
        addProductMenu();
    }

    private void sellerMenu() {
        System.out.println("\n==== MENU SELLER ====");
        System.out.println("1. Lihat semua produk");
        System.out.println("2. Tambah produk");
        System.out.println("3. Hapus produk");
        System.out.println("4. Lihat pesanan dari customer");
        System.out.println("5. Kembali");
        System.out.print("Pilih opsi: ");
    }

    private void addProductMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n==== TAMBAH PRODUK ====");
        System.out.print("Masukkan nama produk: ");
        String name = scanner.nextLine();

        System.out.print("Masukkan deskripsi produk: ");
        String description = scanner.nextLine();

        System.out.print("Masukkan harga produk: ");
        double price = 0;
        try {
            price = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Harga tidak valid. Produk tidak ditambahkan.");
            return;
        }

        System.out.print("Masukkan kategori produk: ");
        String category = scanner.nextLine();

        System.out.print("Masukkan stok produk: ");
        int stock = 0;
        try {
            stock = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Stok tidak valid. Produk tidak ditambahkan.");
            return;
        }

        Product newProduct = new Product(name, description, price, category, stock);
        sellerService.addProduct(newProduct);

        System.out.println("Produk berhasil ditambahkan:");
        System.out.println(newProduct);
    }

    private void deleteProductMenu() {
        System.out.println("\n==== HAPUS PRODUK ====");
        System.out.print("Masukkan ID produk yang ingin dihapus: ");
        // Add logic to read product ID
        // Logic to delete the product using sellerService
    }
}
