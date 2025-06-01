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

	public void spacer() {
		System.out.println("=========================");
	}
}
