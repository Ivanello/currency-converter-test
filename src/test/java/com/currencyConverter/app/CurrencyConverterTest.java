package com.currencyConverter.app;

import Pages.CurrencyConverterPage;
import com.codeborne.selenide.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import io.qameta.allure.*;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;


public class CurrencyConverterTest {
    @BeforeClass
    public static void setupClass() {
        Configuration.browser = "chrome";
    }

    @Before
    public void setupTest() {
    }

    @After
    public void teardown() {
    }

    @Feature("Smoke Currency Converter Test")
    @Test
    public void smokeTest(){

//        String baseUrl = "https://goo.gl/UszK6B";
        CurrencyConverterPage page = open(baseUrl, CurrencyConverterPage.class);

        page.chooseTabFrom().fillTabFrom("1");

        String currency = page.getRandomMainCurrency();
        page.chooseMainCurrency(currency).
                checkMainCurrencySelected(currency).
                checkCurrentTabCurrency(currency);

        currency = page.getRandomPopularCurrency();
        page.choosePopularCurrency(currency).
                checkPopCurrencySelected(currency).
                checkCurrentTabCurrency(currency);

        page.chooseTabTo();

        currency = page.getRandomPopularCurrency();
        page.choosePopularCurrency(currency).
                checkPopCurrencySelected(currency).
                checkCurrentTabCurrency(currency);

        currency = page.getRandomMainCurrency();
        page.chooseMainCurrency(currency).
                checkMainCurrencySelected(currency).
                checkCurrentTabCurrency(currency);

        page.checkInputFieldsNotEqual("0");
        page.clearResults().checkInputFieldsEqual("0");
    }
}
