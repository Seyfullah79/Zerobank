package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class AccountSummaryStepDefs {


    @Then("the user should see {string} as a title")
    public void the_user_should_see_as_a_title(String expectedTittle) {
        String actualTittle = Driver.get().getTitle();
        Assert.assertEquals(expectedTittle,actualTittle);
    }

    @Then("Account summary page should have to following account types")
    public void account_summary_page_should_have_to_following_account_types(List<String> expectedHeaderText) {
        AccountSummaryPage asp = new AccountSummaryPage();
        List<String> actualHeaderText = BrowserUtils.getElementsText(asp.subHeaders);
        Assert.assertEquals(actualHeaderText,expectedHeaderText);
    }

    @Then("Credit Accounts table must have columns")
    public void credit_Accounts_table_must_have_columns(List<String> expectedtext) {
        AccountSummaryPage asp = new AccountSummaryPage();
        List<String> actualText = BrowserUtils.getElementsText(asp.creditAccountsTable);
        Assert.assertEquals(actualText,expectedtext);
    }


}
