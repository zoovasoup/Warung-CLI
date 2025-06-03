package com.Warung_CLI.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.Warung_CLI.Models.Cart;
import com.Warung_CLI.Models.CartItem;
import com.Warung_CLI.Models.Customer;
import com.Warung_CLI.Models.Product;
import com.Warung_CLI.Models.Seller;
import com.Warung_CLI.Models.User;
import com.Warung_CLI.Models.Order.Order;
import com.Warung_CLI.Repo.CustomerRepo;
import com.Warung_CLI.Repo.OrderRepo;
import com.Warung_CLI.Repo.SellerRepo;

/**
 * CustomerService
 */
public class CustomerService {
    private final CustomerRepo customerRepo;
    private final SellerRepo sellerRepo;
    private final OrderRepo orderRepo;

    public CustomerService(CustomerRepo customerRepo, SellerRepo sellerRepo, OrderRepo orderRepo) {
        this.customerRepo = customerRepo;
        this.sellerRepo = sellerRepo;
        this.orderRepo = orderRepo;
    }

    public ArrayList<Product> getAllProducts() {
        ArrayList<Product> allProducts = new ArrayList<>();
        for (User user : sellerRepo.getAll()) {
            if (user instanceof Seller) {
                Seller seller = (Seller) user;
                allProducts.addAll(seller.getProducts());
            }
        }
        return allProducts;
    }

    public void addToCart(Customer customer, Product product, int quantity) {

        if (product.getQuantity() < quantity) {
            System.out.println("Stok tidak cukup untuk produk: " + product.getTitle());
            return;
        }

        if (customer.getCart() == null) {
            customer.setCart(new Cart());
        }

        Cart cart = customer.getCart();

        boolean found = false;
        for (CartItem item : cart.getItems()) {
            if (item.getProduct().getId().equals(product.getId())) {
                item.setQuantity(item.getQuantity() + quantity);
                found = true;
                break;
            }
        }

        if (!found) {
            CartItem cartItem = new CartItem(product, quantity);
            cart.addItem(cartItem);
        }

        product.setQuantity(product.getQuantity() - quantity);

        System.out.println("Produk ditambahkan ke keranjang. Stok dikurangi.");
    }

    public void seeCart(Customer customer) {
        Cart cart = customer.getCart();
        if (cart == null || cart.getItems().isEmpty()) {
            System.out.println("\n======= KERANJANG =======");
            System.out.println("Keranjang belanja Anda kosong.");
            System.out.println("==========================");
            return;
        }

        System.out.println("======= KERANJANG BELANJA =======");
        System.out.printf("%-20s %-10s %-10s%n", "Produk", "Qty", "Total");

        for (CartItem item : cart.getItems()) {
            System.out.printf("%-20s %-10d Rp%.2f%n",
                    item.getProduct().getTitle(),
                    item.getQuantity(),
                    item.getTotalPrice());
        }

        System.out.println("----------------------------------");
        System.out.printf("TOTAL HARGA : Rp%d%n", cart.getTotalPrice());
        System.out.println("==================================");
    }

    public void removeFromCart(Customer customer, String productId) {
        Cart cart = customer.getCart();

        CartItem toRemove = null;
        for (CartItem item : cart.getItems()) {
            if (item.getProduct().getId().equals(productId)) {
                // Tambahkan stok kembali ke produk aslinya
                Product product = item.getProduct();
                int quantity = item.getQuantity();
                product.setQuantity(product.getQuantity() + quantity);

                toRemove = item;
                break;
            }
        }

        if (toRemove != null) {
            cart.removeItem(toRemove);
            System.out
                    .println("Produk dengan ID " + productId + " telah dihapus dari keranjang dan stok dikembalikan.");
        } else {
            System.out.println("Produk dengan ID " + productId + " tidak ditemukan di keranjang belanja Anda.");
        }
    }

    public Order checkout(Customer customer) {
        Cart cart = customer.getCart();
        if (cart.getItems().isEmpty()) {
            System.out.println("Keranjang belanja Anda kosong. Silakan tambahkan produk sebelum checkout.");
            return null;
        }

        Order order = new Order(customer, cart.getItems());
        order.setPaid(true);
        customer.addOrder(order);
        customer.clearCart();
        orderRepo.put(order);

        System.out.println("Checkout berhasil! Pesanan ID: " + order.getId());
        return order;
    }

    public List<Customer> getAllCustomers(CustomerRepo customerRepo) {
        return customerRepo.getAll();
    }

    public List<Order> getOrderHistory(Customer customer) {
        return customer.getHistory().getOrders();
    }
}
