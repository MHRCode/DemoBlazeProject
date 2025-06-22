package com.demoblaze.steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demoblaze.pages.HomePage;
import com.demoblaze.utils.BaseTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStep extends BaseTest {

    HomePage home;
    WebDriverWait wait;

    @Given("user is on homepage")
    public void user_on_homepage() {
        setUp();
        home = new HomePage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @When("user clicks on login link")
    public void user_clicks_login() {
        home.clickLogin();
    }

    @When("enters username and password")
    public void enters_username_and_password() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))).sendKeys("testuser");
        driver.findElement(By.id("loginpassword")).sendKeys("testpass");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
    }

    @Then("user should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        try {
            // Check if alert is present
            wait.until(ExpectedConditions.alertIsPresent());
            String alertText = driver.switchTo().alert().getText();
            System.out.println("Alert detected with message: " + alertText);
            driver.switchTo().alert().dismiss(); // or .accept()
            throw new AssertionError("Login failed: " + alertText); // fail the test explicitly
        } catch (org.openqa.selenium.TimeoutException e) {
            // No alert – continue checking successful login
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
        } finally {
            tearDown();
        }
    }
}