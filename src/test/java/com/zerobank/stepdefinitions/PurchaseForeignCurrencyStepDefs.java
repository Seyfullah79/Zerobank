package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PurchaseForeignCurrencyStepDefs {
    @Given("the user accesses the Purchase foreign currency cash tab")
    public void the_user_accesses_the_Purchase_foreign_currency_cash_tab() {
        PayBillsPage pbp = new PayBillsPage();
        pbp.PayBills.click();
        pbp.purchaseForeignCurrency.click();
        BrowserUtils.waitFor(1);
        Assert.assertTrue(pbp.addNewPayeeBoardHeader.isDisplayed());
    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> expectedCurrencyListText) {
        PayBillsPage pbp = new PayBillsPage();
        Select currency = new Select(pbp.currencyDropBox);
        List<WebElement> currencyList = currency.getOptions();
        List<String> actualCurrencyListText = BrowserUtils.getElementsText(currencyList);
        Assert.assertTrue(actualCurrencyListText.containsAll(expectedCurrencyListText));
    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        PayBillsPage pbp = new PayBillsPage();
        pbp.PayBills.click();
        pbp.purchaseForeignCurrency.click();
        BrowserUtils.waitFor(1);
        pbp.amount.sendKeys("100");
        pbp.selectedCurrency.click();
        pbp.calculateCostButton.click();
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        Alert alert = Driver.get().switchTo().alert();
        BrowserUtils.waitFor(1);
        String actualText = alert.getText();
        System.out.println("actualText = " + actualText);
        String expectedText = "Please, ensure that you have filled all the required fields with valid values.";
        Assert.assertEquals(actualText,expectedText);
    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
        PayBillsPage pbp = new PayBillsPage();
        pbp.PayBills.click();
        pbp.purchaseForeignCurrency.click();
        Select currency = new Select(pbp.currencyDropBox);
        currency.selectByVisibleText("Eurozone (euro)");
        pbp.selectedCurrency.click();
        pbp.calculateCostButton.click();
    }


}
