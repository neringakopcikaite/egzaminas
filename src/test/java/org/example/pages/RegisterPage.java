package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterPage extends BasePage {

    private static final By USERNAME_INPUT = By.name("username");
    private static final By EMAIL_INPUT = By.name("email");
    private static final By PASSWORD_INPUT = By.name("password");
    private static final By CONFIRM_PASSWORD_INPUT = By.name("passwordConfirm");
    private static final By REGISTER_BUTTON = By.cssSelector(".btn-login");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME_INPUT))
                .sendKeys(username);
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(EMAIL_INPUT))
                .sendKeys(email);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_INPUT))
                .sendKeys(password);
    }

    public void enterConfirmPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CONFIRM_PASSWORD_INPUT))
                .sendKeys(password);
    }

    public void clickRegister() {
        wait.until(ExpectedConditions.elementToBeClickable(REGISTER_BUTTON))
                .click();
    }

    public void register(String username, String email, String password, String confirmPassword) {
        enterUsername(username);
        enterEmail(email);
        enterPassword(password);
        enterConfirmPassword(confirmPassword);
        clickRegister();
    }
}