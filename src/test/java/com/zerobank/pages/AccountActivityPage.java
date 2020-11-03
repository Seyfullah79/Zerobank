package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityPage extends BasePage {


    @FindBy(linkText = "Find Transactions")
    public WebElement findTransactions;

    @FindBy(linkText = "Show Transactions")
    public WebElement showTransactions;

    @FindBy(xpath = "(//h2[@class='board-header'])[2]")
    public WebElement subTitleFind;

    @FindBy(xpath = "(//h2[@class='board-header'])[1]")
    public WebElement subTitleShow;

    @FindBy(id = "aa_fromDate")
    public WebElement fromDate;

    @FindBy(id = "aa_toDate")
    public WebElement toDate;

    @FindBy(css = ".btn.btn-primary")
    public WebElement findButton;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody/tr/td[1]")
    public List<WebElement> datesInTable;

    @FindBy (id = "aa_description")
    public WebElement description;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody/tr//td[2]")
    public List<WebElement> descriptionTable;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody/tr/td[3]")
    public List<WebElement> depositTable;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody/tr/td[4]")
    public List<WebElement> withdrawalTable;

    @FindBy(id = "aa_type")
    public WebElement typeDropDown;




    public String accountDropBoxFirstSelected(){

       WebElement dropDownbox = Driver.get().findElement(By.id("aa_accountId"));

       Select accuntDropDown = new Select(dropDownbox);

       String text = accuntDropDown.getFirstSelectedOption().getText();

       return text;

    }





}
