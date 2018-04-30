package com.currencyConverter.app;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.Test;
import pages.CurrencyConverterPage;


@Feature("Converter")
@Story("Failed Test Example")
public class FailedTest extends BaseTests {

    @Test
    public void filedCurrencyConverterTest() {
        CurrencyConverterPage converterPage = CurrencyConverterPage.open();

        String currency = "JPY";
        converterPage.selectPopularCurrency("CAD")
                .checkCurrentTabCurrency(currency)
                .checkPopCurrencySelected(currency)
                .checkMainCurrencySelected(currency);

    }
}
