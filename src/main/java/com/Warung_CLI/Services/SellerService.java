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
    private String sellerId;
    private final OrderRepo orderRepo;

    public SellerService(SellerRepo sellerRepo, OrderRepo orderRepo) {
        this.sellerRepo = sellerRepo;
        this.orderRepo = orderRepo;
    }

    public ArrayList<Product> getAllProduct() {
        Seller seller = sellerRepo.getById(sellerId);

        if (seller != null) {
            return seller.getProducts();
        }

        System.out.println("Seller dengan ID " + sellerId + " tidak ditemukan.");
        return new ArrayList<>();
    }

    public void addProduct(Product product) {
        Seller seller = sellerRepo.getById(sellerId);
        ArrayList<Product> products = seller.getProducts();

        if (seller != null) {
            products.add(product);
            seller.setProducts(products);
            sellerRepo.patch(sellerId, seller);
            System.out.println("Produk " + product.getTitle() + " berhasil ditambahkan.");
        }
    }

    public void deleteProduct(String productId) {
        Seller seller = sellerRepo.getById(sellerId);
        ArrayList<Product> products = seller.getProducts();

        if (seller != null) {
            products.removeIf(product -> product.getId().equals(productId));
            seller.setProducts(products);
            sellerRepo.patch(sellerId, seller);
            System.out.println("Produk dengan Id " + productId + " berhasil dihapus.");
        }
    }

    public ArrayList<Order> getOrdersForSeller() {
        ArrayList<Product> sellerProducts = getAllProduct();
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

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }
}
