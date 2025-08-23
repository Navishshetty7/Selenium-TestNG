package com.automationexercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    @FindBy(css = "a[href='/products']")
    WebElement productsButton;

    @FindBy(css = "a[href='/login']")
    WebElement signupLoginButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ProductsPage clickProducts() {
        productsButton.click();
        return new ProductsPage(driver);
    }

    public LoginPage clickSignupLogin() {
        signupLoginButton.click();
        return new LoginPage(driver);
    }
}