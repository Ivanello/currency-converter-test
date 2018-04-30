package com.currencyConverter.app;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.Before;
import pages.CurrencyConverterPage;
import io.qameta.allure.Feature;
import org.junit.Test;


@Feature("Converter")
@Story("Main converter funcionality")
public class CurrencyConverterTest extends BaseTests {

    CurrencyConverterPage converterPage;

    @Before
    public void setupTest() {
        converterPage = CurrencyConverterPage.open();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void verifyUserAbleToSelectCurrencyFromPopularList() {

        String expectedPopularCurrency = converterPage.getRandomPopularCurrency();

        converterPage.selectPopularCurrency(expectedPopularCurrency)
                .checkCurrentTabCurrency(expectedPopularCurrency)
                .checkPopCurrencySelected(expectedPopularCurrency)
                .checkMainCurrencySelected(expectedPopularCurrency);

    }

    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void verifyUserAbleToSelectCurrencyFromMainList() {

        String expectedPopularCurrency = converterPage.getRandomPopularCurrency();
        String expectedMaincurrency = "BGN";

        converterPage.selectMainCurrency(expectedPopularCurrency)
                .checkCurrentTabCurrency(expectedPopularCurrency)
                .checkPopCurrencySelected(expectedPopularCurrency)
                .checkMainCurrencySelected(expectedPopularCurrency)

                .selectMainCurrency(expectedMaincurrency)
                .checkCurrentTabCurrency(expectedMaincurrency)
                .checkMainCurrencySelected(expectedMaincurrency);

    }

    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void verifyUserAbleToSelectCurrencyInTOField() {

        converterPage.selectTabTo();

        String expectedPopularCurrency = converterPage.getRandomPopularCurrency();
        String expectedMaincurrency = "TRY";
        converterPage.selectMainCurrency(expectedPopularCurrency)
                .checkCurrentTabCurrency(expectedPopularCurrency)
                .checkPopCurrencySelected(expectedPopularCurrency)
                .checkMainCurrencySelected(expectedPopularCurrency)

                .selectMainCurrency(expectedMaincurrency)
                .checkCurrentTabCurrency(expectedMaincurrency)
                .checkMainCurrencySelected(expectedMaincurrency);
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void verifyUserAbleToSelectCurrencyInFROMField() {

        converterPage.selectTabFrom();

        String expectedPopularCurrency = converterPage.getRandomPopularCurrency();
        String expectedMainCurrency = "ZAR";

        converterPage.selectMainCurrency(expectedPopularCurrency)
                .checkCurrentTabCurrency(expectedPopularCurrency)
                .checkPopCurrencySelected(expectedPopularCurrency)
                .checkMainCurrencySelected(expectedPopularCurrency)

                .selectMainCurrency(expectedMainCurrency)
                .checkCurrentTabCurrency(expectedMainCurrency)
                .checkMainCurrencySelected(expectedMainCurrency);
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void verifyUserAbleToClearTabs() {

        converterPage.fillTabFrom("12,34")
                .inputFieldFROMShouldNOTHave(Condition.exactValue("0"))
                .inputFieldTOShouldNOTHave(Condition.exactValue("0"))

                .clearResults()
                .inputFieldFROMShouldHave(Condition.exactValue("0"))
                .inputFieldTOShouldHave(Condition.exactValue("0"));

    }

    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void verifyUserAbleToFillTOField() {

        converterPage.fillTabTo("56,78")
                .inputFieldTOShouldHave(Condition.exactValue("56,78"))
                .inputFieldFROMShouldNOTHave(Condition.exactValue("0"));

    }

    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void verifyUserAbleToFillFROMField() {

        converterPage.fillTabFrom("09,87")
                .inputFieldFROMShouldHave(Condition.exactValue("09,87"))
                .inputFieldTOShouldNOTHave(Condition.exactValue("0"));

    }

}
