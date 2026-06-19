package org.example;

import org.example.pages.CalculatorPage;
import org.example.pages.CalculationsPage;
import org.example.pages.LoginPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculatorTest extends BaseTest {


    @Test
    void createCalculationPositiveTest() {

        registerUser();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        driver.get("http://localhost:8080/calculator");

        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.calculate("7", "3", "+");

        assertTrue(driver.getCurrentUrl().contains("/calculate"));
    }

    @Test
    void createCalculationNegativeTest() {

        registerUser();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        driver.get("http://localhost:8080/calculator");

        assertTrue(driver.getCurrentUrl().contains("/calculator"));
    }
}