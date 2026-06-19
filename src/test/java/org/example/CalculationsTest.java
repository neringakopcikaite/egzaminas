package org.example;

import org.example.pages.CalculatorPage;
import org.example.pages.CalculationsPage;
import org.example.pages.LoginPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculationsTest extends BaseTest {

    @Test
    void searchCalculationPositiveTest() {

        registerUser();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        driver.get("http://localhost:8080/calculator");

        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.calculate("7", "3", "+");

        driver.get("http://localhost:8080/numbers");

        CalculationsPage calculationsPage = new CalculationsPage(driver);

        assertTrue(calculationsPage.isCalculationVisible("7", "+", "3", "10"));
    }

    @Test
    void searchCalculationNegativeTest() {

        registerUser();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        driver.get("http://localhost:8080/numbers");

        CalculationsPage calculationsPage = new CalculationsPage(driver);

        assertTrue(calculationsPage.isCalculationNotVisible("999999"));
    }
}