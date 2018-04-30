package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import models.Currencies;
import org.openqa.selenium.By;

import java.util.Random;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.By.cssSelector;


public class CurrencyConverterPage extends BasePage {

    /* Locators */

    private By tabs = cssSelector(".converter-tabItem"),
            selectedTab = cssSelector(".converter-tabItem__selected"),
            inputElements = cssSelector(".ui-input"),
            popularCurrencyList = cssSelector(".converter-popularItem"),
            popularCurrencySelected = cssSelector(".converter-popularItem__selected"),
            mainCurrency = cssSelector(".converter-currenciesItem"),
            mainCurrencySelected = cssSelector(".converter-currenciesItem__selected"),
            clearButon = cssSelector(".ui-btnTxt"),
            currencySymbol = cssSelector(".converter-currenciesSymbol");

    /* Actions */

    @Step
    public static CurrencyConverterPage open() {
        Selenide.open("");
        return new CurrencyConverterPage();
    }

    @Step("Select Tab FROM")
    public CurrencyConverterPage selectTabFrom() {
        $(tabs).click();
        return this;
    }

    @Step("Fill input FROM with value '{currValue}'")
    public CurrencyConverterPage fillTabFrom(String currValue) {
        $(inputElements).val(currValue);
        return this;
    }

    @Step("Select Tab TO")
    public CurrencyConverterPage selectTabTo() {
        $(tabs, 1).click();
        return this;
    }

    @Step("Fill input TO with value '{currValue}'")
    public CurrencyConverterPage fillTabTo(String currValue) {
        $(inputElements, 1).val(currValue);
        return this;
    }


    @Step("Select currency '{currency}' from Popular list")
    public CurrencyConverterPage selectPopularCurrency(String currency) {
        $$(popularCurrencyList).findBy(text(currency)).click();
        return this;
    }

    @Step("Select currency '{currency}' from Main list")
    public CurrencyConverterPage selectMainCurrency(String currency) {
        $$(currencySymbol).find(textCaseSensitive(currency)).click();
        return this;
    }

    @Step("Clear results")
    public CurrencyConverterPage clearResults() {
        $(clearButon).click();
        return this;
    }

    /*  Assertions */

    @Step("Check Active tab currency is '{currency}'")
    public CurrencyConverterPage checkCurrentTabCurrency(String currency) {
        $(selectedTab).shouldHave(textCaseSensitive(currency));
        return this;
    }

    @Step("Check Active currency in main list is '{currency}'")
    public CurrencyConverterPage checkMainCurrencySelected(String currency) {
        $(mainCurrencySelected).shouldHave(text(currency));
        return this;
    }

    @Step("Check Active currency in popular list is '{currency}'")
    public CurrencyConverterPage checkPopCurrencySelected(String currency) {
        $(popularCurrencySelected).shouldHave(text(currency));
        return this;
    }

    @Step("Check From input field !== '{value}'")
    public CurrencyConverterPage inputFieldFROMShouldNOTHave(Condition value) {
        $(inputElements).shouldNotHave(value);
        return this;
    }

    @Step("Check TO input field !==  '{value}'")
    public CurrencyConverterPage inputFieldTOShouldNOTHave(Condition value) {
        $(inputElements, 1).shouldNotHave(value);
        return this;
    }

    @Step("Check FROM input fields ==  '{value}'")
    public CurrencyConverterPage inputFieldFROMShouldHave(Condition value) {
        $(inputElements).shouldHave(value);
        return this;
    }

    @Step("Check TO input fields ==  '{value}'")
    public CurrencyConverterPage inputFieldTOShouldHave(Condition value) {
        $(inputElements, 1).shouldHave(value);
        return this;
    }


    /* Helpers */

    public static SelenideElement getRandomElement(ElementsCollection list) {
        int rnd = new Random().nextInt(list.filter(visible).size());
        return list.get(rnd);
    }

    public String getRandomPopularCurrency() {
        int rnd = new Random().nextInt(Currencies.values().length);
        return Currencies.values()[rnd].name();
//        return getRandomElement($$(popularCurrencyList)).text();
    }

    private String getRandomMainCurrency() {
        return getRandomElement($$(mainCurrency)).find(currencySymbol).text();
    }

}
