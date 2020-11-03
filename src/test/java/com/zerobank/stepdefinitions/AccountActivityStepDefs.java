package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import io.cucumber.java.en.When;

public class AccountActivityStepDefs {
    @When("the user clicks on Account Activity page")
    public void the_user_clicks_on_Account_Activity_page() {
       new AccountActivityPage().AccountActivity.click();
    }

}
