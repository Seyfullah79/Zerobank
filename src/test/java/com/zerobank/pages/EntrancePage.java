package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EntrancePage {

    public EntrancePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = ".signin.btn.btn-info")
    public WebElement signIn;

}
