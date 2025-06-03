package com.Warung_CLI.Services;

/**
 * customerExeption
 */
public class customerExeption extends Exception {
    public OutOfStockException(String message) {
        super(message);
    }

}
