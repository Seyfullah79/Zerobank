package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountSummaryPage extends BasePage {

    public WebElement getWebElement(String AccountType){

        WebElement element = Driver.get().findElement(By.linkText(""+AccountType +""));
        return element;
    }

    @FindBy(xpath = "//h2[@class='board-header']")
    public List<WebElement> subHeaders;

    @FindBy(xpath = "(//table[@class='table'])[3]//th")
    public List<WebElement> creditAccountsTable;


}
