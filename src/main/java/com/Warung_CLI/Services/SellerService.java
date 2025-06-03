package com.Warung_CLI.Services;

import java.util.ArrayList;
import java.util.List;

import com.Warung_CLI.Models.Product;
import com.Warung_CLI.Models.Seller;
import com.Warung_CLI.Models.Order.Order;
import com.Warung_CLI.Models.Order.OrderItem;
import com.Warung_CLI.Repo.OrderRepo;
import com.Warung_CLI.Repo.SellerRepo;

public class SellerService {
    private final SellerRepo sellerRepo;
    private final OrderRepo orderRepo;

    public SellerService(SellerRepo sellerRepo, OrderRepo orderRepo) {
        this.sellerRepo = sellerRepo;
        this.orderRepo = orderRepo;
    }

    public ArrayList<Product> getAllProduct(String sellerId) {
        Seller seller = sellerRepo.getById(sellerId);

        if (seller != null) {
            return seller.getProducts();
        }

        System.out.println("Seller dengan ID " + sellerId + " tidak ditemukan.");
        return new ArrayList<>();
    }

    public void addProduct(String sellerId, Product product) {
        Seller seller = sellerRepo.getById(sellerId);
        ArrayList<Product> products = seller.getProducts();

        if (seller != null) {
            products.add(product);
            seller.setProducts(products);
            sellerRepo.patch(sellerId, seller);
            System.out.println("Produk " + product.getTitle() + " berhasil ditambahkan.");
        }
    }

    public boolean deleteProduct(String sellerId, String productId) {
        Seller seller = sellerRepo.getById(sellerId);

        if (seller != null) {
            ArrayList<Product> products = seller.getProducts();
            boolean removed = products.removeIf(product -> product.getId().equals(productId));
            if (removed) {
                seller.setProducts(products);
                sellerRepo.patch(sellerId, seller);
                System.out.println("Produk dengan ID " + productId + " berhasil dihapus.");
                return true;
            } else {
                return false;
            }
        } else {
            System.out.println("Seller tidak ditemukan.");
            return false;
        }
    }

    public ArrayList<Order> getOrdersForSeller(String sellerId) {
        ArrayList<Product> sellerProducts = getAllProduct(sellerId);
        List<String> sellerProductIds = new ArrayList<>();

        for (Product p : sellerProducts) {
            sellerProductIds.add(p.getId());
        }

        ArrayList<Order> relevantOrders = new ArrayList<>();

        for (Order order : orderRepo.getAll()) {
            for (OrderItem item : order.getItems()) {
                if (sellerProductIds.contains(item.getProduct().getId())) {
                    relevantOrders.add(order);
                    break; // satu produk seller cukup, lanjut ke order berikutnya
                }
            }
        }

        return relevantOrders;
    }
}
