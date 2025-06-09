package com.Warung_CLI.Controllers;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.Warung_CLI.Exeptions.InvalidCredentialsException;
import com.Warung_CLI.Models.Customer;
import com.Warung_CLI.Models.Seller;
import com.Warung_CLI.Models.User;
import com.Warung_CLI.Repo.CustomerRepo;
import com.Warung_CLI.Repo.SellerRepo;
import com.Warung_CLI.Services.AuthService;

public class AuthController {
    private final AuthService authService;
    private final SellerRepo sellerRepo;
    private final CustomerRepo customerRepo;

    public AuthController(AuthService authService, SellerRepo sellerRepo, CustomerRepo customerRepo) {
        this.authService = authService;
        this.sellerRepo = sellerRepo;
        this.customerRepo = customerRepo;
    }

    public User authRoute() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=== AUTH MENU ===");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Pilih opsi: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        return loginRoute();
                    case 2:
                        return registerRoute();
                    case 3:
                        System.out.println("Keluar dari program...");
                        return null;
                    default:
                        System.out.println("Pilihan tidak valid. Coba lagi.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka. Silakan coba lagi.");
                scanner.nextLine(); // Clear buffer
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan: " + e.getMessage());
            }
        }
    }

    public User loginRoute() throws InvalidCredentialsException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=== LOGIN MENU ===");
            System.out.println("1. Login sebagai Customer");
            System.out.println("2. Login sebagai Seller");
            System.out.println("3. Kembali");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Username: ");
                        String customerUsername = scanner.nextLine();
                        System.out.print("Password: ");
                        String customerPassword = scanner.nextLine();

                        User customer = authService.loginCustomer(customerUsername, customerPassword);
                        if (customer != null && customer instanceof Customer) {
                            return customer;
                        } else {
                            throw new InvalidCredentialsException("Username/password salah atau bukan customer.");
                        }

                    case 2:
                        System.out.print("Username: ");
                        String sellerUsername = scanner.nextLine();
                        System.out.print("Password: ");
                        String sellerPassword = scanner.nextLine();

                        User seller = authService.loginSeller(sellerUsername, sellerPassword);
                        if (seller != null && seller instanceof Seller) {
                            return seller;
                        } else {
                            throw new InvalidCredentialsException("Username/password salah atau bukan customer.");
                        }

                    case 3:
                        return null;

                    default:
                        System.out.println("Pilihan tidak valid. Coba lagi.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka.");
                scanner.nextLine(); // Clear input buffer
            } catch (InvalidCredentialsException e) {
                System.out.println("❌ " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan saat login: " + e.getMessage());
            }
        }
    }

    public User registerRoute() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=== REGISTER MENU ===");
            System.out.println("1. Register sebagai Customer");
            System.out.println("2. Register sebagai Seller");
            System.out.println("3. Kembali");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Nama: ");
                        String customerName = scanner.nextLine();
                        System.out.print("Username: ");
                        String customerUsername = scanner.nextLine();
                        System.out.print("Password: ");
                        String customerPassword = scanner.nextLine();

                        Customer newCustomer = new Customer(customerName, customerUsername, customerPassword);
                        customerRepo.put(newCustomer);
                        System.out.println("Customer berhasil didaftarkan.");
                        return newCustomer;

                    case 2:
                        System.out.print("Nama: ");
                        String sellerName = scanner.nextLine();
                        System.out.print("Username: ");
                        String sellerUsername = scanner.nextLine();
                        System.out.print("Password: ");
                        String sellerPassword = scanner.nextLine();
                        System.out.print("Nama Toko: ");
                        String storeName = scanner.nextLine();
                        System.out.print("Deskripsi Toko: ");
                        String storeDescription = scanner.nextLine();

                        Seller newSeller = new Seller(sellerName, sellerUsername, sellerPassword, storeName,
                                storeDescription);
                        sellerRepo.put(newSeller);
                        System.out.println("Seller berhasil didaftarkan.");
                        return newSeller;

                    case 3:
                        return null;

                    default:
                        System.out.println("Pilihan tidak valid. Coba lagi.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka. Coba lagi.");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan saat registrasi: " + e.getMessage());
            }
        }
    }

    public void registerMenu() {
        System.out.println("=== REGISTER MENU ===");
        System.out.println("1. Register sebagai Customer");
        System.out.println("2. Register sebagai Seller");
    }
}
