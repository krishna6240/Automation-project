package com.automationpractice.pages;

import com.automationpractice.utility.Utility;
import org.etsi.uri.x01903.v13.QualifyingPropertiesType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserStories extends Utility {
    public UserStories()
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[normalize-space()='Women']")
    WebElement verifyWomenWord;
    @FindBy(xpath = "//a[@class='subcategory-name'][normalize-space()='Tops']")
    WebElement topsLink;
    @FindBy(xpath = "//a[@class='subcategory-name'][normalize-space()='Dresses']")
    WebElement dressesLink;
    @FindBy(id = "selectProductSort")
    WebElement selectProductSort;
    @FindBy(xpath = "//i[@class='icon-th-list']")
    WebElement selectListView;
    @FindBy(id = "center_column")
    WebElement selectProduct;
    @FindBy(id = "group_1")
    WebElement selectSize;
    @FindBy(xpath = "//span[normalize-space()='Add to cart']")
    WebElement addToCartButton;
    @FindBy(xpath = "(//h2[normalize-space()='Product successfully added to your shopping cart'])[1]")
  /*  WebElement confirmationText;
    @FindBy(xpath = "//span[@title='Close window']")*/
    WebElement closeWindow;
    @FindBy(xpath = "//span[normalize-space()='Proceed to checkout']")
    WebElement checkout;
    @FindBy(xpath = "//input[@class='cart_quantity_input form-control grey']")
    WebElement clearQty;
    @CacheLookup
    @FindBy(xpath = "//p[contains(text(),'Your shopping cart is empty.')]")
    WebElement confirmationText;




    public String verifyWomenText() {
        return getTextFromElement(verifyWomenWord);
    }

    public void clickOnTopsLink() {
        clickOnElement(topsLink);
    }

    public void clickOnDressLink() {
        clickOnElement(dressesLink);
    }

    public void setSelectProductSort(String productSortby) {
        selectByVisibleTextFromDropDown(selectProductSort, productSortby);
    }

    public void clickListView() {
        clickOnElement(selectListView);
    }

    public void setSelectProduct(String product) {
        clickOnElement(By.xpath("//a[normalize-space()='"+product+"']"));
    }

    public void selectQty(String quantity) {
        doubleClickAndSendKeysOnElement(By.xpath("//input[@id='quantity_wanted']"), quantity);
    }

    public void setSelectSize(String size) {
        selectByVisibleTextFromDropDown(selectSize, size);
    }

    public void setSelectColour(String colour) {
        clickOnElement(By.xpath("//a[@title='" + colour + "']"));
    }
    public void setAddToCartButton(){
        clickOnElement(addToCartButton);
    }
    public String setConfirmationText(){
        return getTextFromElement(confirmationText);
    }
    public void setCloseWindow(){
        clickOnElement(closeWindow);
    }
    public void clickonCheckOutbtn(){
        clickOnElement(checkout);
    }
    public void clearQuityTab() {
                 //  sendTextToElement(clearQty,value);
        clearQty.clear();
    }

}



