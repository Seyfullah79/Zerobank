package com.zerobank.stepdefinitions;

import com.zerobank.pages.EntrancePage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {

    @When("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
        new EntrancePage().signIn.click();
    }

    @When("the user enters valid credentials and sign in")
    public void the_user_enters_valid_credentials_and_sign_in() {
        LoginPage lp = new LoginPage();
        lp.login.sendKeys(ConfigurationReader.get("username"));
        lp.password.sendKeys(ConfigurationReader.get("password"));
        lp.signInButton.click();
    }

    @Then("the user should see Account Summary Page")
    public void the_user_should_see_Account_Summary_Page() {
        String actualTittle = Driver.get().getTitle();
        String expectedTitle = "Zero - Account Summary";
        Assert.assertEquals(expectedTitle,actualTittle);
    }

    @When("the user enters invalid {string} or {string}")
    public void the_user_enters_invalid_or(String username, String password) {
        LoginPage lp = new LoginPage();
        lp.login.sendKeys(username);
        lp.password.sendKeys(password);
        lp.signInButton.click();
    }

    @Then("the user should see the {string} message")
    public void the_user_should_see_the_message(String expectedText) {
        LoginPage lp = new LoginPage();
        String actualText = lp.errorText();
        Assert.assertEquals(expectedText,actualText);
    }





}
