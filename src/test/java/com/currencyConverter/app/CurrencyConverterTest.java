package com.currencyConverter.app;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pages.CurrencyConverterPage;
import io.qameta.allure.Feature;
import org.junit.Test;


@Feature("Converter")
@Story("Main converter funcionality")
public class CurrencyConverterTest extends BaseTests {

    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void verifyUserAbleToSelectCurrencyFromPopularList() {
        CurrencyConverterPage converterPage = CurrencyConverterPage.open();

        String popCurrency = converterPage.getRandomPopularCurrency();
        converterPage.selectPopularCurrency(popCurrency)
                .checkCurrentTabCurrency(popCurrency)
                .checkPopCurrencySelected(popCurrency)
                .checkMainCurrencySelected(popCurrency);

    }

    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void verifyUserAbleToSelectCurrencyFromMainList() {
        CurrencyConverterPage converterPage = CurrencyConverterPage.open();

        String popCurrency = converterPage.getRandomPopularCurrency();
        converterPage.selectMainCurrency(popCurrency)
                .checkCurrentTabCurrency(popCurrency)
                .checkPopCurrencySelected(popCurrency)
                .checkMainCurrencySelected(popCurrency);

        String currency = "BGN";
        converterPage.selectMainCurrency(currency)
                .checkCurrentTabCurrency(currency)
                .checkMainCurrencySelected(currency);

    }

    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void verifyUserAbleToSelectCurrencyInTOField() {
        CurrencyConverterPage converterPage = CurrencyConverterPage.open();

        converterPage.selectTabTo();

        String popCurrency = converterPage.getRandomPopularCurrency();
        converterPage.selectMainCurrency(popCurrency)
                .checkCurrentTabCurrency(popCurrency)
                .checkPopCurrencySelected(popCurrency)
                .checkMainCurrencySelected(popCurrency);

        String currency = "TRY";
        converterPage.selectMainCurrency(currency)
                .checkCurrentTabCurrency(currency)
                .checkMainCurrencySelected(currency);
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void verifyUserAbleToSelectCurrencyInFROMField() {
        CurrencyConverterPage converterPage = CurrencyConverterPage.open();

        converterPage.selectTabFrom();

        String popCurrency = converterPage.getRandomPopularCurrency();
        converterPage.selectMainCurrency(popCurrency)
                .checkCurrentTabCurrency(popCurrency)
                .checkPopCurrencySelected(popCurrency)
                .checkMainCurrencySelected(popCurrency);

        String currency = "ZAR";
        converterPage.selectMainCurrency(currency)
                .checkCurrentTabCurrency(currency)
                .checkMainCurrencySelected(currency);
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void verifyUserAbleToClearTabs() {
        CurrencyConverterPage converterPage = CurrencyConverterPage.open();

        converterPage.fillTabFrom("12,34")
                .inputFieldFROMShouldNOTHave(Condition.value("0"))
                .inputFieldTOShouldNOTHave(Condition.value("0"));
        converterPage.clearResults()
                .inputFieldFROMShouldHave(Condition.value("0"))
                .inputFieldTOShouldHave(Condition.value("0"));

    }

    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void verifyUserAbleToFillTOField() {
        CurrencyConverterPage converterPage = CurrencyConverterPage.open();

        converterPage.fillTabTo("56,78")
                .inputFieldTOShouldHave(Condition.value("56,78"))
                .inputFieldFROMShouldNOTHave(Condition.value("0"));

    }

    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void verifyUserAbleToFillFROMField() {
        CurrencyConverterPage converterPage = CurrencyConverterPage.open();

        converterPage.fillTabFrom("09,87")
                .inputFieldFROMShouldHave(Condition.value("09,87"))
                .inputFieldTOShouldNOTHave(Condition.value("0"));

    }

}
