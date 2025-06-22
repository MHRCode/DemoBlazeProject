package com.demoblaze.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    By loginLink = By.id("login2");
    By signupLink = By.id("signin2");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLogin() {
        driver.findElement(loginLink).click();
    }

    public void clickSignUp() {
        driver.findElement(signupLink).click();
    }
}