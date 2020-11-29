package com.applitools.applifashion.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {
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
