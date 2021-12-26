package com.automationpractice.testbase;
import com.automationpractice.propertyreader.PropertyReader;
import com.automationpractice.utility.Utility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase extends Utility {
    String browser = PropertyReader.getInstance().getProperty("browser");

    @BeforeMethod(groups = {"regression", "sanity", "smoke"})
    public void setUp() {
        selectBrowser(browser);
    }


    @AfterMethod(groups = {"regression", "sanity", "smoke"})
    public void tearDown() {
        closeBrowser();
    }
}

