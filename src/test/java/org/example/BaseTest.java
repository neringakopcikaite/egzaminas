package org.example;

import org.example.pages.LoginPage;
import org.example.pages.RegisterPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected String username;
    protected String email;
    protected String password;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.manage().window().maximize();

        username = "user" + System.currentTimeMillis();
        email = username + "@test.com";
        password = "Password123";

        driver.get("http://localhost:8080/login");
    }

    protected void registerUser() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegister();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.register(
                username,
                email,
                password,
                password
        );

        driver.get("http://localhost:8080/login");
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}