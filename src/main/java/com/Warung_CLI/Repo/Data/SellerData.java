package com.Warung_CLI.Repo.Data;

import com.Warung_CLI.Models.Product;
import com.Warung_CLI.Models.Seller;
import com.Warung_CLI.Repo.SellerRepo;

public class SellerData {
	private Seller[] sellers;

	private Seller s1 = new Seller("Andi", "andi_shop", "pass123", "Andi Store", "Menjual pakaian pria dan wanita");
	private Seller s2 = new Seller("Budi", "budi_gadget", "pass456", "Budi Gadget", "Menjual gadget dan aksesoris");
	private Seller s3 = new Seller("Citra", "citra_books", "pass789", "Citra Bookstore", "Menjual buku dan alat tulis");
	private Seller s4 = new Seller("Dina", "dina_beauty", "pass321", "Dina Beauty", "Menjual kosmetik dan skincare");

	private Product p11 = new Product("Kemeja Pria", "Kemeja katun lengan panjang", 150000, "Pakaian", 10);
	private Product p12 = new Product("Celana Jeans", "Jeans pria ukuran 32", 200000, "Pakaian", 5);

	private Product p21 = new Product("Smartphone X", "HP Android 6GB RAM", 2500000, "Gadget", 7);
	private Product p22 = new Product("Headset Bluetooth", "Headset wireless tahan air", 300000, "Aksesoris", 12);

	private Product p31 = new Product("Buku Pemrograman Java", "Belajar Java dari nol", 80000, "Buku", 15);
	private Product p32 = new Product("Pulpen 1 Pack", "Isi 10 pulpen warna biru", 15000, "Alat Tulis", 30);

	private Product p41 = new Product("Lipstick Matte", "Lipstick warna nude tahan lama", 50000, "Kosmetik", 20);
	private Product p42 = new Product("Face Wash", "Sabun muka untuk kulit berminyak", 60000, "Skincare", 10);

	public SellerData() {
		sellers = new Seller[] { s1, s2, s3, s4 };

		// Tambahkan produk ke masing-masing seller
		s1.addProduct(p11);
		s1.addProduct(p12);

		s2.addProduct(p21);
		s2.addProduct(p22);

		s3.addProduct(p31);
		s3.addProduct(p32);

		s4.addProduct(p41);
		s4.addProduct(p42);
	}

	public void injectSeller(SellerRepo sellerRepo) {
		for (Seller seller : sellers) {
			sellerRepo.put(seller);
		}
	}
}
