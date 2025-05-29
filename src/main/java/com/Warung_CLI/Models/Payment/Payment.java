package com.Warung_CLI.Models.Payment;

import java.time.LocalDateTime;
import java.util.UUID;

public class Payment {
    private String paymentId;
    private String orderId;
    private double amount;
    private String method; // contoh: "CASH", "BANK_TRANSFER", "E-WALLET"
    private String status; // contoh: "PENDING", "SUCCESS", "FAILED"
    private LocalDateTime paymentDate;

    // Constructor
    public Payment(String orderId, double amount, String method) {
        this.paymentId = UUID.randomUUID().toString(); // Auto-generate ID
        this.orderId = orderId;
        this.amount = amount;
        this.method = method;
        this.status = "PENDING";
        this.paymentDate = null;
    }

    // Getter dan Setter
    public String getPaymentId() {
        return paymentId;
    }

    public String getOrderId() {
        return orderId;
    }

    public double getAmount() {
        return amount;
    }

    public String getMethod() {
        return method;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    // Method utama
    public void processPayment() {
        if (amount <= 0) {
            this.status = "FAILED";
            System.out.println("Gagal: Jumlah pembayaran tidak valid.");
            return;
        }

        // Simulasi pemrosesan pembayaran
        this.status = "SUCCESS";
        this.paymentDate = LocalDateTime.now();
        System.out.println("Pembayaran berhasil dengan metode: " + method);
    }

    public void cancelPayment() {
        if (status.equals("PENDING")) {
            this.status = "CANCELLED";
            System.out.println("Pembayaran dibatalkan.");
        } else {
            System.out.println("Tidak bisa membatalkan pembayaran yang sudah diproses.");
        }
    }

    public void printReceipt() {
        System.out.println("======= STRUK PEMBAYARAN =======");
        System.out.println("ID Pembayaran : " + paymentId);
        System.out.println("ID Pesanan    : " + orderId);
        System.out.println("Jumlah        : " + amount);
        System.out.println("Metode        : " + method);
        System.out.println("Status        : " + status);
        System.out.println("Tanggal       : " + (paymentDate != null ? paymentDate : "Belum dibayar"));
        System.out.println("================================");
    }
}
