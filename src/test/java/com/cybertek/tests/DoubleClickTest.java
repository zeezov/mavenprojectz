package com.cybertek.tests;

import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DoubleClickTest extends TestBase {

    @Test
    public void test() {
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");

        // switch to iframe
        driver.switchTo().frame("iframeResult");

        // actions lets us do advanced interactions with browser
        // double click, right click, drag drop, hover
        Actions actions = new Actions(driver);

        // identify the webelement on which we will double click

        WebElement text = driver.findElement(By.id("demo"));

        // Double Click on element
        // we have to add .perform() at the end of any action
        actions.doubleClick(text).perform();

        Assert.assertTrue(text.getAttribute("style").contains("red"));






    }

}
