package com.demoblaze.steps;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.*;
import java.time.Duration;

public class DemoBlazeHomeStep {

    WebDriver driver;

    @Given("user launches the browser")
    public void user_launches_the_browser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @And("navigates to {string}")
    public void navigates_to(String url) {
        driver.get(url);
    }

    @Then("the homepage should load successfully")
    public void homepage_should_load() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("demoblaze"));
    }

    @Then("the page title should be {string}")
    public void verify_page_title(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @When("user clicks on the {string} button")
    public void user_clicks_button(String buttonName) {
        if (buttonName.equalsIgnoreCase("Login")) {
            driver.findElement(By.id("login2")).click();
        } else if (buttonName.equalsIgnoreCase("Sign up")) {
            driver.findElement(By.id("signin2")).click();
        }
    }

    @Then("the login modal should appear")
    public void login_modal_should_appear() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginModal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logInModal")));
        Assert.assertTrue(loginModal.isDisplayed());
    }

    @Then("the sign up modal should appear")
    public void signup_modal_should_appear() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement signUpModal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInModal")));
        Assert.assertTrue(signUpModal.isDisplayed());
    }
}
