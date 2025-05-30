package com.Warung_CLI;

public class Menu {
	public void login() {
	    System.out.println("====== WARUNG CLI ======");
	    System.out.println("1. Login");
	    System.out.println("2. Register");
	    System.out.println("3. Keluar");
	    spacer();
	    System.out.print("Pilih opsi: ");
	}
	
	public void customerMenu() {
        System.out.println("\n==== MENU CUSTOMER ====");
        System.out.println("1. Lihat list produk");
        System.out.println("2. Tambah ke keranjang");
        System.out.println("3. Lihat keranjang");
        System.out.println("4. Checkout");
        System.out.println("5. Riwayat pesanan");
        System.out.println("6. Kembali");
        spacer();
        System.out.print("Pilih opsi: ");
	}

	
	public void spacer() {
		System.out.println("=========================");
	}
}
