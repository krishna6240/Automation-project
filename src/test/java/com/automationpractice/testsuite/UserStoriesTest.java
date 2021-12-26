package com.automationpractice.testsuite;

import com.automationpractice.pages.UserStories;
import com.automationpractice.pages.WomenSummersDress;
import com.automationpractice.resources.testdata.TestData;
import com.automationpractice.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class UserStoriesTest extends TestBase {

    SoftAssert softAssert;
    UserStories userStories;
    WomenSummersDress womenSummersDress;

    @BeforeMethod(groups = {"regression", "smoke", "sanity"})
    public void setup1() {

        softAssert = new SoftAssert();
        userStories = new UserStories();
        womenSummersDress = new WomenSummersDress();
    }
    @Test(dataProvider = "dataSet", dataProviderClass = TestData.class,groups = {"smoke", "regression"})
    public void verifyUserShouldAddProductToTheCartSuccessfully(String product, String qty,
                                                                String size, String colour) throws InterruptedException{
        userStories.setSelectProduct(product);
        userStories.selectQty(qty);
        userStories.setSelectSize(size);
        userStories.setSelectColour(colour);
        userStories.setAddToCartButton();
        Thread.sleep(2000);
        userStories.setCloseWindow();
        userStories.clickonCheckOutbtn();
        userStories.clearQuityTab();
        String expectedText = "Your shopping cart is empty.";
        String actualText =userStories.setConfirmationText();
        System.out.println(actualText);
        softAssert.assertEquals(actualText,expectedText);

    }


}





