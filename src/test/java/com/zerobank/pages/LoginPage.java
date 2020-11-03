package com.zerobank.pages;

import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "user_login")
    public WebElement login;

    @FindBy(id = "user_password")
    public WebElement password;

    @FindBy(name = "submit")
    public WebElement signInButton;

    public void login() {
        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");
        login.sendKeys(username);
        this.password.sendKeys(password);
        signInButton.click();
    }

    public String errorText(){
        return Driver.get().findElement(By.cssSelector(".alert.alert-error")).getText();
    }







}
