package org.example;

import org.example.pages.LoginPage;
import org.example.pages.RegisterPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegisterTest extends BaseTest {

    @Test
    void registerPositiveTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegister();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.register(username, email, password, password);
        System.out.println(driver.getCurrentUrl());
        assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    void registerNegativeTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegister();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.register("baduser", "baduser@test.com", "abc", "abc");

        assertTrue(driver.getCurrentUrl().contains("/register"));
    }
}