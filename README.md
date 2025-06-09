# Java CLI App – Warung E-Commerce

## 📌 Deskripsi Program

Aplikasi ini adalah program **Command Line Interface (CLI)** berbasis **vanilla Java** yang menyediakan fitur **autentikasi pengguna** serta **manajemen data pengguna** untuk dua tipe pengguna utama: **Customer** dan **Seller**. Struktur program disusun menyerupai gaya proyek Spring Boot, namun sepenuhnya ditulis tanpa framework eksternal.

---
## 🎯 Fungsi Utama

Berikut adalah daftar fitur utama dari aplikasi ini yang diambil dari service layer:

### 🔐 `AuthService` – Fitur Autentikasi
- **Registrasi Customer**
- **Registrasi Seller**
- **Autentikasi Login**

### 👤 `CustomerService` – Fitur Customer
- **Melihat semua produk**
- **Menambah produk ke keranjang**
- **Melihat keranjang**
- **Menghapus produk dari keranjang**
- **Checkout keranjang**
- **Melihat riwayat pesanan**

### 🛒 `SellerService` – Fitur Seller
- **Melihat seluruh produk**
- **Menambah produk**
- **Menghapus produk**
- **Melihat pesanan dari customer**
---

## ⚙️ Spesifikasi Teknis

- **Bahasa**: Java
- **Tipe Aplikasi**: CLI
- **Struktur Modular**: Controllers, Services, Models, Repo, Exceptions
- **Teknologi Tambahan**: Simulasi CRUD (Create, Read, Update, Delete) tanpa database eksternal

---

## 📦 Struktur Direktori Proyek

```
.
├── Controllers          # Menangani logika input/output pengguna
├── Exeptions            # Kelas-kelas untuk penanganan error
├── Models               # Representasi entitas data (Customer, Seller, Order)
│   └── Order
├── Repo                 # Simulasi database / penyimpanan data
│   └── Data
└── Services             # Logika bisnis utama aplikasi
```

---

## 📄 Lisensi

Proyek ini dirilis di bawah lisensi [MIT](https://opensource.org/licenses/MIT).
