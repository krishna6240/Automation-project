package com.automationpractice.testsuite;

import com.automationpractice.customlisteners.CustomListeners;
import com.automationpractice.customlisteners.CustomListeners;
import com.automationpractice.pages.CreateAccountPage;
import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.SignINPage;
import com.automationpractice.resources.testdata.TestData;
import com.automationpractice.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


@Listeners(CustomListeners.class)
public class SignPageTest extends TestBase {
    HomePage homePage;
    SignINPage signINPage;
    SoftAssert softAssert;
    CreateAccountPage createAccountPage;
    @BeforeMethod(groups = {"regression", "smoke", "sanity"})
    public void inIt() {
        homePage = new HomePage();
        signINPage = new SignINPage();

        softAssert = new SoftAssert();
    }
    @Test(groups = {"sanity", "regression"})
    public void userShouldNavigateToSignInPageSuccessFully(){
        homePage.setClickOnSignInLink();
        String expectedTest= "AUTHENTICATION";
        String actualTest= signINPage.verifyAuthenticationText();
        softAssert.assertEquals(expectedTest,actualTest);
        softAssert.assertAll();
    }

    @Test (dataProvider = "credentials", dataProviderClass = TestData.class ,groups = {"regression"})

    public void verifyTheErrorMessageWithInValidCredentials(String username, String password,String message) {
        homePage.setClickOnSignInLink();
        signINPage.signInWithUserNameAndPassword(username, password);
        String expectedTest = message;
        String actualTest = signINPage.getVerifyAuthenticationFailedMessage();
        softAssert.assertEquals(expectedTest, actualTest);
        softAssert.assertAll();
    }
    @Test (groups = {"smoke", "regression"})
    public void verifyThatUserShouldLogInSuccessFullyWithValidCredentials(){
        homePage.setClickOnSignInLink();
        signINPage.signInWithUserNameAndPassword("Georgesmith@gmail.com","acd1234");
        String expectedTest = "Sign out";
        String actualTest = signINPage.verifyLogOutLink();
        softAssert.assertEquals(expectedTest, actualTest);
        softAssert.assertAll();
    }
    @Test(groups = {"smoke", "regression"})
    public void VerifyThatUserShouldLogOutSuccessFully(){
        homePage.setClickOnSignInLink();
        signINPage.signInWithUserNameAndPassword("Georgesmith@gmail.com","acd1234");
        signINPage.clickOnSignOut();
        String expectedTest = "Sign in";
        String actualTest = homePage.signButtonVerify();
        softAssert.assertEquals(expectedTest, actualTest);
        softAssert.assertAll();
    }


}