package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PayBillsPage extends BasePage {

    @FindBy(linkText = "Add New Payee")
    public WebElement addNewPayee;

    @FindBy(linkText = "Pay Saved Payee")
    public WebElement paySavedPayee;

    @FindBy(linkText = "Purchase Foreign Currency")
    public WebElement purchaseForeignCurrency;

    @FindBy(xpath = "(//h2[@class= 'board-header'])[2]")
    public WebElement addNewPayeeBoardHeader;

    @FindBy(id = "np_new_payee_name")
    public WebElement payeeNameBox;

    @FindBy(id = "np_new_payee_address")
    public WebElement payeeAddressBox;

    @FindBy(id = "np_new_payee_account")
    public WebElement accountBox;

    @FindBy(id = "np_new_payee_details")
    public WebElement payeeDetailsBox;

    @FindBy(xpath = "//input[@id='add_new_payee']")
    public WebElement addButton;

    @FindBy(xpath = "//div[@id='alert_content']")
    public WebElement approveText;

    @FindBy(xpath = "//h2[text()='Purchase foreign currency cash']")
    public WebElement purchaseForeignCurrencyCashHeader;

    @FindBy(id = "pc_currency")
    public WebElement currencyDropBox;

    @FindBy(id = "pc_amount")
    public WebElement amount;

    @FindBy(id = "pc_inDollars_true")
    public WebElement USDollarClick;

    @FindBy(id = "pc_inDollars_false")
    public WebElement selectedCurrency;

    @FindBy(id = "pc_calculate_costs")
    public WebElement calculateCostButton;



}
