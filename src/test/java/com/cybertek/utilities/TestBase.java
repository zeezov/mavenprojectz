package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {

    protected WebDriver driver;
    protected Actions actions;
    protected SoftAssert softAssert;

//    @BeforeClass
//    public void setUpClass() {
//        WebDriverManager.chromedriver().setup();
//    }

    @BeforeMethod
    public void setUpMethod() {
        driver = Driver.getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        softAssert = new SoftAssert();
        actions = new Actions(driver);
    }

    @AfterMethod
    public void tearDownMethod() {
       // driver.quit();
        Driver.closeDriver();
        softAssert.assertAll();
    }



}
