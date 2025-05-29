package com.Warung_CLI.Services;

import java.util.ArrayList;

import com.Warung_CLI.Models.Product;
import com.Warung_CLI.Models.Seller;
import com.Warung_CLI.Repo.SellerRepo;

public class SellerService {
	private final SellerRepo sellerRepo;
	private final String sellerId;

	public SellerService(SellerRepo sellerRepo, String sellerId) {
		this.sellerRepo = sellerRepo;
		this.sellerId = sellerId;
	}

    public ArrayList<Product> getAllProduct() {
        Seller seller = sellerRepo.getById(sellerId);

        if (seller != null) {
            return seller.getProducts(); 
        }

        System.out.println("Seller dengan ID " + sellerId + " tidak ditemukan.");
        return new ArrayList<>();
    }
}
