package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CalculationsPage extends BasePage {

    public CalculationsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCalculationVisible(String firstNumber, String operation, String secondNumber, String result) {
        return !driver.findElements(By.xpath(
                "//tr[td[text()='" + firstNumber + "'] " +
                        "and td[text()='" + operation + "'] " +
                        "and td[text()='" + secondNumber + "'] " +
                        "and td[text()='" + result + "']]"
        )).isEmpty();
    }

    public boolean isCalculationNotVisible(String firstNumber) {
        return driver.findElements(
                By.xpath("//td[text()='" + firstNumber + "']")
        ).isEmpty();
    }


}