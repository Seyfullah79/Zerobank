package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

public class AddNewPayeeStepDefs {
    @Given("Add New Payee tab")
    public void add_New_Payee_tab() {
        PayBillsPage pbp = new PayBillsPage();
        pbp.PayBills.click();
        pbp.addNewPayee.click();
        BrowserUtils.waitFor(1);
        Assert.assertTrue(pbp.addNewPayeeBoardHeader.isDisplayed());

    }

    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String,String> table) {

        PayBillsPage pbp = new PayBillsPage();
        pbp.payeeNameBox.sendKeys(table.get("Payee Name"));
        pbp.payeeAddressBox.sendKeys(table.get("Payee Address"));
        pbp.accountBox.sendKeys(table.get("Account"));
        pbp.payeeDetailsBox.sendKeys(table.get("Payee Details"));
        pbp.addButton.click();
    }

    @Then("message {string} should be displayed")
    public void message_should_be_displayed(String string) {
        PayBillsPage pbp = new PayBillsPage();
        String actualText = pbp.approveText.getText();
        String expectedText = string;
        Assert.assertEquals(expectedText,actualText);
    }

}


