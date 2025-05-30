package com.Warung_CLI.Controllers;

import com.Warung_CLI.Models.User;

/**
 * AuthController
 */
public class AuthController {

    public void loginRedirect(User user) {
        if (user.isSeller()) {
        } else {
            System.out.println("Redirecting to Customer Dashboard...");
        }
    }

}
