package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CalculatorPage extends BasePage {

    private static final By FIRST_NUMBER_INPUT = By.name("number1");
    private static final By SECOND_NUMBER_INPUT = By.name("number2");
    private static final By OPERATION_DROPDOWN = By.name("operation");
    private static final By CALCULATE_BUTTON = By.cssSelector(".btn-calculate");

    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    public void enterFirstNumber(String number) {
        getElement(FIRST_NUMBER_INPUT).clear();
        getElement(FIRST_NUMBER_INPUT).sendKeys(number);
    }

    public void enterSecondNumber(String number) {
        getElement(SECOND_NUMBER_INPUT).clear();
        getElement(SECOND_NUMBER_INPUT).sendKeys(number);
    }

    public void selectOperationByValue(String operation) {
        Select select = new Select(getElement(OPERATION_DROPDOWN));
        select.selectByValue(operation);
    }

    public void clickCalculate() {
        getClickableElement(CALCULATE_BUTTON).click();
    }

    public void calculate(String firstNumber, String secondNumber, String operation) {
        enterFirstNumber(firstNumber);
        enterSecondNumber(secondNumber);
        selectOperationByValue(operation);
        clickCalculate();
    }
}