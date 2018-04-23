package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.SelenideElement;
import com.google.common.io.Files;
import org.openqa.selenium.By;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.matchesText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.page;
import static org.openqa.selenium.By.cssSelector;

import io.qameta.allure.*;




public class CurrencyConverterPage {

    private By tabs = cssSelector(".converter-tabItem");
    private By selectedTab = cssSelector(".converter-tabItem__selected");
    private By inputElements = cssSelector(".ui-input");
    private By popularCurrencyList = cssSelector(".converter-popularItem");
    private By popularCurrencySelected = cssSelector(".converter-popularItem__selected");
    private By mainCurrency = cssSelector(".converter-currenciesItem");
    private By mainCurrencySelected = cssSelector(".converter-currenciesItem__selected");
    private By clearButon = cssSelector(".ui-btnTxt");
    private By currencySymbol = cssSelector(".converter-currenciesSymbol");

    @Step("Choose Tab FROM")
    public CurrencyConverterPage chooseTabFrom() {
        $$(tabs).get(0).click();
        return this;
    }

    @Step("Fill input FROM with value \"{currValue}\"")
    public CurrencyConverterPage fillTabFrom(String currValue) {
        $$(inputElements).get(0).val(currValue);
        return this;
    }

    @Step("Choose Tab TO")
    public CurrencyConverterPage chooseTabTo() {
        $$(tabs).get(1).click();
        return this;
    }

    @Step("Fill input FROM with value \"{currValue}\"")
    public CurrencyConverterPage fillTabTo(String currValue) {
        $$(inputElements).get(1).val(currValue);
        return this;
    }

    public static SelenideElement getRandomElement(ElementsCollection list) {
        int rnd = new Random().nextInt(list.size());
        //we should exclude 19 because its hidden element
        while (rnd == 19){
            rnd = new Random().nextInt(list.size());
        }
        return list.get(rnd);
    }

    public String getRandomPopularCurrency() {
        return getRandomElement($$(popularCurrencyList)).text();
    }

    public String getRandomMainCurrency() {
        return getRandomElement($$(mainCurrency)).find(currencySymbol).text();
    }

    @Step("Choose currency \"{currency}\" from Popular list")
    public CurrencyConverterPage choosePopularCurrency(String currency) {
        $$(popularCurrencyList).find(matchesText(currency)).click();
        return this;
    }

    @Step("Choose currency \"{currency}\" from Main list")
    public CurrencyConverterPage chooseMainCurrency(String currency) {
        $$(currencySymbol).find(matchesText(currency)).click();
        return this;
    }

    @Step("Check Active tab currency is \"{currency}\"")
    public CurrencyConverterPage checkCurrentTabCurrency(String currency) {
        $(selectedTab).shouldHave(matchesText(currency));
        return this;
    }

    @Step("Check Active currency in main list is \"{currency}\"")
    public CurrencyConverterPage checkMainCurrencySelected(String currency) {
        $(mainCurrencySelected).shouldHave(matchesText(currency));
        return this;
    }

    @Step("Check Active currency in popular list is \"{currency}\"")
    public CurrencyConverterPage checkPopCurrencySelected(String currency) {
        $(popularCurrencySelected).shouldHave(matchesText(currency));
        return this;
    }

    @Step("Check Both input fields !==  \"{value}\"")
    public CurrencyConverterPage checkInputFieldsNotEqual(String value) {
        $$(inputElements).get(0).shouldNotHave(attribute("value", value));
        $$(inputElements).get(1).shouldNotHave(attribute("value", value));
        return this;
    }

    @Step("Check Both input fields ==  \"{value}\"")
    public CurrencyConverterPage checkInputFieldsEqual(String value) {
        $$(inputElements).get(0).shouldHave(attribute("value", value));
        $$(inputElements).get(1).shouldHave(attribute("value", value));
        return this;
    }

    @Step("Clear results")
    public CurrencyConverterPage clearResults() {
        $(clearButon).click();
        return this;
    }
}
