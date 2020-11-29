package com.applitools.applifashion.pages;

import com.applitools.applifashion.utils.Browser;
import com.applitools.applifashion.utils.ConfigurationManager;
import org.openqa.selenium.WebDriver;

public class AppliFashionApp {

    private static final String APP_URL = ConfigurationManager.getAppUrl();

    private static ThreadLocal<Browser> browser = ThreadLocal.withInitial(Browser::new);

    public static WebDriver getDriver() {
        return browser.get().getDriver();
    }

    public static void close() {
        browser.get().quit();
    }

    public static MainPage openOnMainPage() {
        getDriver().get(APP_URL);
        return new MainPage();
    }
}
