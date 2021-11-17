package com.nextbase.pages;

import com.nextbase.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "left-menu-list")
    private WebElement leftNavigationMenu;

    public void leftMenuNavigateTo(String tabName) {
        leftNavigationMenu.findElement(By.partialLinkText(tabName)).click();
    }

}
