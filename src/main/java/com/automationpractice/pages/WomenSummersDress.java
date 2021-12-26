package com.automationpractice.pages;

import com.automationpractice.utility.Utility;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WomenSummersDress extends Utility {
    public WomenSummersDress() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(css = "a[title='Women']")
    WebElement womentab;
    @CacheLookup
    @FindBy(xpath = "//ul[@class='submenu-container clearfix first-in-line-xs']//ul//li//a[@title='Summer Dresses'][normalize-space()='Summer Dresses']")
    WebElement dresss;
    @CacheLookup
    @FindBy(css = ".ui-slider-handle.ui-state-default.ui-corner-all.ui-state-hover")
    WebElement sliderchange;


    public void displayWomenDress() {

        mouseHoverToElement(womentab);

    }

    public void clickOnSummerDress() {
        clickOnElement(dresss);
    }

    public void Sliderchange() {
        mouseHoverToElement(sliderchange);
    }

}
