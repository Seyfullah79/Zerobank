package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.EntrancePage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AccountActivityNavigationStepDefs {

    @Given("the user is logged in")
    public void the_user_is_logged_in() {

        Driver.get().get(ConfigurationReader.get("url"));
        new EntrancePage().signIn.click();
        new LoginPage().login();

    }

    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String AccountType) {

        AccountSummaryPage asp = new AccountSummaryPage();
        asp.getWebElement(AccountType).click();
    }

    @Then("the Account Activity page should be displayed")
    public void the_Account_Activity_page_should_be_displayed() {

        String actualTitle = Driver.get().getTitle();
        String expectedTitle = "Zero - Account Activity";
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String expectedText) {

        AccountActivityPage aap = new AccountActivityPage();
        String actualText = aap.accountDropBoxFirstSelected();
        Assert.assertEquals(expectedText,actualText);
    }





}
