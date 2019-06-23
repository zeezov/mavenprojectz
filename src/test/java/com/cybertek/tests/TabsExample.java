package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class TabsExample {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.get("http://the-internet.herokuapp.com/windows");

        driver.manage().window();

    }

    @AfterMethod
    public void cleanUp() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

    /*
    Test case:
    go to http://the-internet.herokuapp.com/windows
    click on click “Click here”

    verify that new title is “New window”
    verify that new title is not “The internet”
     */

    @Test
    public void changeTab() {

        // By default selenium can only handle one tab at the time.
        // If we want to do anything in the new tab, we have to switch to it first.

        // gives the ID's if all current open tabs
        System.out.println(driver.getWindowHandles().size());

        // printing the ID of the currently open tab
        System.out.println(driver.getWindowHandle());

        driver.findElement(By.linkText("Click Here")).click();

        System.out.println(driver.getWindowHandles().size());
        System.out.println("*****************************************");

        // set is just like ArrayList, but it wont take duplicates.
        Set<String> windowHandles = driver.getWindowHandles();

        for(String handle : windowHandles) {
            System.out.println("==> " + handle);

            driver.switchTo().window(handle);
            System.out.println(driver.getTitle());

            // to stop at the tab that you need if you have multiple tabs open.
            if(driver.getTitle().equals("New Window")) {
                break;
            }

        }

        Assert.assertEquals(driver.getTitle(), "New Window");
        Assert.assertNotEquals(driver.getTitle(), "The Internet");

    }

    /*
    go to https://www.w3schools.com/html/
    click on try it yourself
    verify the url of the new tab contains "default"
     */

    @Test
    public void changeTab2() {

        driver.get("https://www.w3schools.com/html/");

        driver.findElement(By.linkText("Try it Yourself »")).click();

        // title of the second tab: Tryit Editor v3.6
        // get all handles
        // switch 1 by 1
        // if the title is the right, break the loop
                                    // shows all open window tabs
        for(String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals("Tryit Editor v3.6")) {
                break;
            }
        }

        Assert.assertTrue(driver.getCurrentUrl().contains("default"));

    }


}
