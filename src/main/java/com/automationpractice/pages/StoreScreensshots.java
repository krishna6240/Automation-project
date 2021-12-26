package com.automationpractice.pages;

import com.automationpractice.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StoreScreensshots extends Utility {
    public StoreScreensshots() {
        PageFactory.initElements(driver, this);
    }
    @CacheLookup
    @FindBy(xpath = "//a[@title='Our stores']")
    WebElement screenshot;

    public void clickOnStore(String screen){
        clickOnElement(screenshot);
        takeElementScreenshot(screenshot,screen);


    }
}
