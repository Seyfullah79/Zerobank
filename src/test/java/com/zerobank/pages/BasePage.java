package com.zerobank.pages;

import com.zerobank.utilities.Driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() { PageFactory.initElements(Driver.get(), this); }

    @FindBy(linkText = "Account Summary")
    public WebElement AccountSummary;

    @FindBy(linkText = "Account Activity")
    public WebElement AccountActivity;

    @FindBy(linkText = "Transfer Funds")
    public WebElement TransferFunds;

    @FindBy(linkText = "Pay Bills")
    public WebElement PayBills;

    @FindBy(linkText = "My Money Map")
    public WebElement MyMoneyMap;

    @FindBy(linkText = "Online Statements")
    public WebElement OnlineStatements;



}
