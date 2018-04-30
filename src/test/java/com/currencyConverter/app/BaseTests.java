package com.currencyConverter.app;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.junit.ScreenShooter;
import com.codeborne.selenide.junit.TextReport;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.CustomTestWatcher;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.Rule;

public abstract class BaseTests {

    static {
        Configuration.browser = WebDriverRunner.CHROME;
        Configuration.baseUrl = "https://goo.gl/UszK6B";
        Configuration.clickViaJs = true;
        Configuration.browserSize = "1280x1024";
        Configuration.pollingInterval = 50;
        Configuration.collectionsTimeout = 20;
        Configuration.driverManagerEnabled = true;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @Rule
    public TextReport report = new TextReport().onFailedTest(true).onSucceededTest(true);

    @Rule
    public ScreenShooter screenShooter = ScreenShooter.failedTests().succeededTests();

    @Rule
    public CustomTestWatcher logger = new CustomTestWatcher();

}
