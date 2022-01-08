package org.naic.pages;

import org.naic.utility.ConfigReader;
import org.naic.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "INT_USERNAME")
    public WebElement userNameBox;

    @FindBy(id="INT_PASSWORD")
    public WebElement passwordBox;

    @FindBy(id="INT_LOGIN_BTN")
    public WebElement loginButton;

    @FindBy(id="INT_MESSAGE_WRAPPER")
    public WebElement errorMessage;

    public void goTo(){
        Driver.getDriver().get(ConfigReader.read("login-url"));

    }

    public void login(){
        userNameBox.sendKeys(ConfigReader.read("InvalidUsername"));
        passwordBox.sendKeys(ConfigReader.read("InvalidPassword"));
        loginButton.click();
    }
}
