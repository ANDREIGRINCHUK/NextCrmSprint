package com.nextbase.pages;


import com.nextbase.utilities.ConfigurationReader;
import com.nextbase.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(name = "USER_LOGIN")
    private WebElement usernameInput;

    @FindBy(name = "USER_PASSWORD")
    private WebElement passwordInput;

    @FindBy(css = "input.login-btn")
    public WebElement loginButton;

    public void enterUsername(String username) {
        usernameInput.clear();
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        loginButton.click();
    }

    public void loginAsHR() {
        login(ConfigurationReader.get("hr_username"), ConfigurationReader.get("hr_password"));
    }

    public void loginAsHelpDesk() {
        login(ConfigurationReader.get("helpdesk_username"), ConfigurationReader.get("helpdesk_password"));
    }

    public void loginAsMarketing() {
        login(ConfigurationReader.get("marketing_username"), ConfigurationReader.get("marketing_password"));
    }

    public void loginAs(String who) {
        if (who.equalsIgnoreCase("hr")) {
            loginAsHR();
        } else if (who.equalsIgnoreCase("helpdesk")) {
            loginAsHelpDesk();
        } else if (who.equalsIgnoreCase("marketing")) {
            loginAsMarketing();
        } else {
            System.out.println("Invalid login type");
        }
    }

}
