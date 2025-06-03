package com.Warung_CLI.Controllers;

import java.util.List;
import java.util.Scanner;

import com.Warung_CLI.Exeptions.OutOfStockException;
import com.Warung_CLI.Models.Customer;
import com.Warung_CLI.Models.Product;
import com.Warung_CLI.Models.Order.Order;
import com.Warung_CLI.Services.CustomerService;

public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void customerRoute(Customer customer) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                customerMenu();
                int choice = Integer.parseInt(scanner.nextLine().trim());

                switch (choice) {
                    case 1:
                        lihatSemuaProduk();
                        break;
                    case 2:
                        tambahProdukKeKeranjang(scanner, customer);
                        break;
                    case 3:
                        customerService.seeCart(customer);
                        break;
                    case 4:
                        hapusProdukDariKeranjang(scanner, customer);
                        break;
                    case 5:
                        checkout(customer);
                        break;
                    case 6:
                        lihatRiwayatPesanan(customer);
                        break;
                    case 7:
                        if (konfirmasiLogout(scanner))
                            return;
                        break;
                    default:
                        System.out.println("❌ Pilihan tidak valid. Silakan pilih angka dari 1 sampai 7.");
                }

            } catch (NumberFormatException e) {
                System.out.println("❌ Input harus berupa angka. Silakan coba lagi.");
            } catch (Exception e) {
                System.out.println("❌ Terjadi kesalahan: " + e.getMessage());
            }
        }
    }

    public void customerMenu() {
        System.out.println("\n==== MENU CUSTOMER ====");
        System.out.println("1. Lihat semua produk");
        System.out.println("2. Tambah produk ke keranjang");
        System.out.println("3. Lihat keranjang");
        System.out.println("4. Hapus produk dari keranjang");
        System.out.println("5. Checkout");
        System.out.println("6. Lihat riwayat pesanan");
        System.out.println("7. Logout");
        System.out.print("Pilih opsi: ");
    }

    private void lihatSemuaProduk() {
        List<Product> products = customerService.getAllProducts();
        if (products.isEmpty()) {
            System.out.println("📦 Belum ada produk tersedia.");
        } else {
            products.forEach(product -> System.out.println(product));
        }
    }

    private void tambahProdukKeKeranjang(Scanner scanner, Customer customer) {
        try {
            System.out.print("Masukkan ID produk: ");
            String productId = scanner.nextLine().trim();
            if (productId.isEmpty())
                throw new IllegalArgumentException("ID produk tidak boleh kosong.");

            System.out.print("Masukkan jumlah produk: ");
            int quantity = Integer.parseInt(scanner.nextLine().trim());
            if (quantity <= 0)
                throw new IllegalArgumentException("Jumlah harus lebih dari 0.");

            Product product = customerService.getAllProducts().stream()
                    .filter(p -> p.getId().equals(productId))
                    .findFirst()
                    .orElse(null);

            if (product == null) {
                System.out.println("❌ Produk tidak ditemukan.");
                return;
            }

            customerService.addToCart(customer, product, quantity);
            System.out.println("✅ Produk berhasil ditambahkan ke keranjang.");

        } catch (NumberFormatException e) {
            System.out.println("❌ Format jumlah harus berupa angka.");
        } catch (OutOfStockException e) {
            System.out.println("❌ " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("❌ " + e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ Terjadi kesalahan: " + e.getMessage());
        }
    }

    private void hapusProdukDariKeranjang(Scanner scanner, Customer customer) {
        try {
            System.out.print("Masukkan ID produk yang ingin dihapus: ");
            String productId = scanner.nextLine().trim();
            if (productId.isEmpty())
                throw new IllegalArgumentException("ID produk tidak boleh kosong.");

            customerService.removeFromCart(customer, productId);
            System.out.println("✅ Produk berhasil dihapus dari keranjang.");

        } catch (IllegalArgumentException e) {
            System.out.println("❌ " + e.getMessage());
        }
    }

    private void checkout(Customer customer) {
        try {
            customerService.checkout(customer);
        } catch (Exception e) {
            System.out.println("❌ Gagal melakukan checkout: " + e.getMessage());
        }
    }

    private void lihatRiwayatPesanan(Customer customer) {
        List<Order> orders = customerService.getOrderHistory(customer);
        if (orders.isEmpty()) {
            System.out.println("📭 Anda belum memiliki riwayat pesanan.");
        } else {
            System.out.println("📜 Riwayat pesanan untuk " + customer.getName() + ":");
            orders.forEach(order -> System.out.println(order));
        }
    }

    private boolean konfirmasiLogout(Scanner scanner) {
        System.out.print("Apakah Anda yakin ingin logout? (y/n): ");
        String confirm = scanner.nextLine().trim();
        if (confirm.equalsIgnoreCase("y")) {
            System.out.println("✅ Anda telah logout.");
            return true;
        } else {
            System.out.println("❎ Logout dibatalkan.");
            return false;
        }
    }
}
