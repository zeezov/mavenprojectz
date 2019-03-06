package com.cybertek.tests;

import com.cybertek.pages.HomePage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ErrorMessageValidationTest extends TestBase {

    /*
    Wrong email
    1. go to website http://automationpractice.com/index.php
    2. try to login with wrong email
    3. verify error message Invalid email address.
     */

    HomePage homePage = new HomePage();

    @Test
    public void wrongEmail() {

        driver.get(ConfigurationReader.getProperty("url"));

        homePage.username.sendKeys("admin");
        //driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("admin");

        homePage.password.sendKeys("test");
        //driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test" + Keys.ENTER);

        homePage.loginButton.click();

        String expectedError = "Invalid Login or Password.";
        String actualError = homePage.errorMessage.getText();

        Assert.assertEquals(actualError,expectedError);

    }

    @Test
    public void wrongPassword() {



        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        homePage.username.sendKeys("Tester");
        homePage.password.sendKeys("admin");
        homePage.loginButton.click();

//        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
//        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("admin" + Keys.ENTER);

        String expectedError = "Invalid Login or Password.";
        String actualError = homePage.errorMessage.getText();

        Assert.assertEquals(actualError,expectedError);

    }

    @Test
    public void noEmail() {

        homePage.open();

        homePage.logIn("", "admin");


//        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(" ");
//        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("admin" + Keys.ENTER);

        String expectedError = "Invalid Login or Password.";
        String actualError = homePage.errorMessage.getText();

        Assert.assertEquals(actualError,expectedError);

    }

    @Test
    public void noPassword() {

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("" + Keys.ENTER);

        String expectedError = "Invalid Login or Password.";
        String actualError = driver.findElement(By.id("ctl00_MainContent_status")).getText();

        Assert.assertEquals(actualError,expectedError);

    }





}
