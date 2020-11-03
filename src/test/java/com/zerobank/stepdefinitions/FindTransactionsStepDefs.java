package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FindTransactionsStepDefs {

    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
        new AccountSummaryPage().AccountActivity.click();
        AccountActivityPage aap = new AccountActivityPage();
        aap.findTransactions.click();
        BrowserUtils.waitFor(2);
        String actualText = aap.subTitleFind.getText();
        String expectedText = "Find Transactions";
        Assert.assertEquals(expectedText, actualText);
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String fromDate, String toDate) {
        AccountActivityPage aap = new AccountActivityPage();
        aap.fromDate.clear();
        aap.toDate.clear();
        aap.fromDate.sendKeys(fromDate);
        aap.toDate.sendKeys(toDate);
    }

    @When("clicks search")
    public void clicks_search() {
        new AccountActivityPage().findButton.click();
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String fromDate, String toDate) throws ParseException {
        BrowserUtils.waitFor(2);
        AccountActivityPage aap = new AccountActivityPage();
        List<String> dates = BrowserUtils.getElementsText(aap.datesInTable);
        List<Date> listOfDates = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        for (String date : dates) {
            listOfDates.add(format.parse(date));
        }
        Date d1 = format.parse(fromDate);
        Date d2 = format.parse(toDate);
        boolean flag = false;
        for (Date date : listOfDates) {
            if (date.after(d1) && date.before(d2) || date.equals(d1) || date.equals(d2)) {
                flag = true;
            } else {
                flag = false;
                break;
            }
        }
        Assert.assertTrue(flag);
    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() throws ParseException {

        AccountActivityPage aap = new AccountActivityPage();
        List<String> dates = BrowserUtils.getElementsText(aap.datesInTable);

        List<Date> listOfDates = new ArrayList<>();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");


        for (String date : dates) {
            listOfDates.add(format.parse(date));
        }

        boolean flag = false;

        for (int i = 0; i < listOfDates.size() -1; i++) {
            if (listOfDates.get(i).after(listOfDates.get(i + 1))) {
                flag = true;
            } else {
                System.out.println(listOfDates.get(i));
                flag = false;
                break;
            }
        }
        Assert.assertTrue(flag);
    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String notDate) throws ParseException {
        AccountActivityPage aap = new AccountActivityPage();
        List<String> dates = BrowserUtils.getElementsText(aap.datesInTable);
        List<Date> listOfDates = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        for (String date : dates) {
            listOfDates.add(format.parse(date));
        }
        boolean flag = false;

        for (int i = 0; i < listOfDates.size(); i++) {
            if (!listOfDates.get(i).equals(notDate)) {
                flag = true;
            } else {
                flag = false;
                break;
            }
        }
        Assert.assertTrue(flag);
    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String description) {
        AccountActivityPage aap = new AccountActivityPage();
        aap.description.clear();
        aap.description.sendKeys(description.toUpperCase());
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String string) {
        BrowserUtils.waitFor(1);
        AccountActivityPage aap = new AccountActivityPage();
        List<String> descriptionText = BrowserUtils.getElementsText(aap.descriptionTable);
        boolean flag = false;
        for (int i = 0; i < descriptionText.size(); i++) {
            if (descriptionText.get(i).contains(string)) {
                flag = true;
            } else {
                flag = false;
                break;
            }
        }
        Assert.assertTrue(flag);
    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String string) {

        AccountActivityPage aap = new AccountActivityPage();
        List<String> descriptionText = BrowserUtils.getElementsText(aap.descriptionTable);
        boolean flag = false;
        for (int i = 0; i < descriptionText.size(); i++) {
            if (!descriptionText.get(i).contains(string)) {
                flag = true;
            } else {
                flag = false;
                break;
            }
        }
        Assert.assertTrue(flag);
    }

    @Then("results table should show at least one result under {string}")
    public void results_table_should_show_at_least_one_result_under(String string) {
        BrowserUtils.waitFor(2);
        List<String> elementsText = null;
        AccountActivityPage aap = new AccountActivityPage();
        if (string.toLowerCase().equals("deposit")) {
            elementsText = BrowserUtils.getElementsText(aap.depositTable);
        } else if (string.toLowerCase().equals("withdrawal")) {
            elementsText = BrowserUtils.getElementsText(aap.withdrawalTable);
        }



        for (int i = 0; i < elementsText.size(); i++) {
            if (elementsText.get(i).isEmpty()) {
                elementsText.remove(elementsText.get(i));
            }
        }

        Assert.assertTrue(elementsText.size() >= 1);
    }

    @When("user selects type {string}")
    public void user_selects_type(String string) {
        AccountActivityPage aap= new AccountActivityPage();
        Select type = new Select(aap.typeDropDown);
        type.selectByVisibleText(string);
        aap.findButton.click();
    }

    @Then("results table should show no result under {string}")
    public void results_table_should_show_no_result_under(String string) {
        BrowserUtils.waitFor(2);
        List<String> elementsText = null;
        AccountActivityPage aap = new AccountActivityPage();
        if (string.toLowerCase().equals("deposit")) {
            elementsText = BrowserUtils.getElementsText(aap.depositTable);
        } else if (string.toLowerCase().equals("withdrawal")) {
            elementsText = BrowserUtils.getElementsText(aap.withdrawalTable);
        }
        int count =0 ;
        for (String s : elementsText) {
            if(!s.isEmpty()){
                count ++;
            }
        }
        Assert.assertTrue(count==0);
    }
}