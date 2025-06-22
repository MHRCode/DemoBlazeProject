package com.demoblaze.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    WebDriver driver;

    By username = By.id("sign-username");
    By password = By.id("sign-password");
    By signupButton = By.xpath("//button[text()='Sign up']");

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void register(String user, String pass) {
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(signupButton).click();
    }
}