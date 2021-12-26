package com.automationpractice.testsuite;

import com.automationpractice.pages.UserStories;
import com.automationpractice.pages.WomenSummersDress;
import com.automationpractice.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SummerDress extends TestBase {
    SoftAssert softAssert;
    UserStories userStories;
    WomenSummersDress womenSummersDress;

    @BeforeMethod(groups = {"regression", "smoke", "sanity"})
    public void setIn() {

        softAssert = new SoftAssert();
        userStories = new UserStories();
        womenSummersDress = new WomenSummersDress();
    }

    @Test(groups = {"sanity", "regression"})
    public void summerDressesDisplayOnSearchResult() throws InterruptedException {

        womenSummersDress.displayWomenDress();
        womenSummersDress.clickOnSummerDress();
        //Thread.sleep(1000);
        womenSummersDress.Sliderchange();
    }
}

