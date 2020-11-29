package com.applitools.applifashion.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {

    static {
        WebDriverManager.chromedriver().setup();
    }

    private WebDriver driver;

    public WebDriver getDriver() {
        if (this.driver == null)
            this.driver = startNewInstance();
        return this.driver;
    }

    public void quit() {
        try {
            if (this.driver != null)
                this.driver.quit();
        } finally {
            this.driver = null;
        }
    }

    private WebDriver startNewInstance() {
        return new ChromeDriver();
    }
}
