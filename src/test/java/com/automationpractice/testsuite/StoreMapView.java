package com.automationpractice.testsuite;

import com.automationpractice.customlisteners.CustomListeners;
import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.SignINPage;
import com.automationpractice.pages.StoreScreensshots;
import com.automationpractice.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(CustomListeners.class)
public class StoreMapView extends TestBase {
    HomePage homePage;
    SignINPage signINPage;
    SoftAssert softAssert;
    StoreScreensshots storeSceensshots;

    @BeforeMethod(groups = {"regression", "smoke", "sanity"})
    public void inIt1() {
        homePage = new HomePage();
        storeSceensshots = new StoreScreensshots();
        signINPage = new SignINPage();

        softAssert = new SoftAssert();
    }

    @Test(groups = {"sanity", "regression"})
    public void userShouldNavigateToSignInPageSuccessFully() {
        homePage.setClickOnSignInLink();
        storeSceensshots.clickOnStore("screen");

    }
}