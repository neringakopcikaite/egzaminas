package org.example;
import org.example.pages.RegisterPage;
import org.example.pages.LoginPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    void loginPositiveTest() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegister();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.register(username, email, password, password);

        driver.get("http://localhost:8080/login");

        loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        System.out.println(driver.getCurrentUrl());

        assertTrue(driver.getCurrentUrl().contains("/calculator"));
    }

    @Test
    void loginNegativeTest() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("wrongUser", "wrongPassword");

        assertTrue(driver.getCurrentUrl().contains("/login"));
    }
}