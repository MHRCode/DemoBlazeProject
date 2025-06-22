package com.demoblaze.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver","path/to/chromedriver.exe");
            driver = new ChromeDriver();
        }
        return driver;
    }
}