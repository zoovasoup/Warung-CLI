package com.Warung_CLI.Controllers;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.Warung_CLI.Exeptions.ProductNotFoundException;
import com.Warung_CLI.Models.Product;
import com.Warung_CLI.Models.Seller;
import com.Warung_CLI.Models.Order.Order;
import com.Warung_CLI.Services.SellerService;

public class SellerController {
    private final SellerService sellerService;
    private String sellerId = null;

    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    public void sellerRoute(Seller seller) {
        Scanner sc = new Scanner(System.in);
        this.sellerId = seller.getId();

        while (true) {
            try {
                sellerMenu();
                int choice = Integer.parseInt(sc.nextLine().trim());

                switch (choice) {
                    case 1:
                        lihatSemuaProduk();
                        break;

                    case 2:
                        addProductMenu();
                        break;

                    case 3:
                        deleteProductMenu();
                        break;

                    case 4:
                        lihatPesananDariCustomer();
                        break;

                    case 5:
                        System.out.println("Kembali ke menu utama.");
                        return;

                    default:
                        System.out.println("❌ Pilihan tidak valid. Silakan masukkan angka dari 1-5.");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Input harus berupa angka. Silakan coba lagi.");
            } catch (Exception e) {
                System.out.println("❌ Terjadi kesalahan: " + e.getMessage());
            }
        }
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

    private void lihatSemuaProduk() {
        ArrayList<Product> allProduct = sellerService.getAllProduct(sellerId);
        if (allProduct.isEmpty()) {
            System.out.println("📦 Anda belum memiliki produk.");
        } else {
            for (Product product : allProduct) {
                System.out.println(product);
            }
        }
    }

    private void lihatPesananDariCustomer() {
        ArrayList<Order> orders = sellerService.getOrdersForSeller(sellerId);
        if (orders.isEmpty()) {
            System.out.println("📪 Belum ada pesanan masuk.");
        } else {
            for (Order order : orders) {
                System.out.println(order);
            }
        }
    }

    private void addProductMenu() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("\n==== TAMBAH PRODUK ====");
            System.out.print("Masukkan nama produk: ");
            String name = scanner.nextLine().trim();

            if (name.isEmpty())
                throw new IllegalArgumentException("Nama produk tidak boleh kosong.");

            System.out.print("Masukkan deskripsi produk: ");
            String description = scanner.nextLine().trim();

            System.out.print("Masukkan harga produk: ");
            double price = Double.parseDouble(scanner.nextLine().trim());
            if (price <= 0)
                throw new IllegalArgumentException("Harga harus lebih dari 0.");

            System.out.print("Masukkan kategori produk: ");
            String category = scanner.nextLine().trim();

            System.out.print("Masukkan stok produk: ");
            int stock = Integer.parseInt(scanner.nextLine().trim());
            if (stock < 0)
                throw new IllegalArgumentException("Stok tidak boleh negatif.");

            Product newProduct = new Product(name, description, price, category, stock);
            sellerService.addProduct(sellerId, newProduct);

            System.out.println("✅ Produk berhasil ditambahkan:");
            System.out.println(newProduct);

        } catch (NumberFormatException e) {
            System.out.println("❌ Format angka tidak valid. Harap masukkan angka yang benar.");
        } catch (IllegalArgumentException e) {
            System.out.println("❌ " + e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ Terjadi kesalahan: " + e.getMessage());
        }
    }

    private void deleteProductMenu() throws ProductNotFoundException {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("\n==== HAPUS PRODUK ====");
            System.out.print("Masukkan ID produk yang ingin dihapus: ");
            String productId = scanner.nextLine().trim();

            if (productId.isEmpty())
                throw new IllegalArgumentException("ID produk tidak boleh kosong.");

            boolean success = sellerService.deleteProduct(sellerId, productId);
            if (success) {
                System.out.println("✅ Produk berhasil dihapus.");
            } else {
                throw new ProductNotFoundException("Produk dengan ID " + productId + " tidak ditemukan.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("❌ " + e.getMessage());
        } catch (ProductNotFoundException e) {
            System.out.println("❌ " + e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ Terjadi kesalahan: " + e.getMessage());
        }
    }
}
