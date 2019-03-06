package com.cybertek.tests;

import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoverTest extends TestBase {

    // moving the mouse

    @Test(enabled = false)
    public void test() {
        driver.get("https://amazon.com");

        WebElement signIn = driver.findElement(By.xpath("//span[.='Hello. Sign in']"));

        // to move the mouse
        actions.moveToElement(signIn).perform();

        driver.findElement(By.xpath("//span[.='Your Hearts']")).click();

        Assert.assertTrue(driver.getTitle().contains("Interesting"));

    }

            // scroll the page to find the element
    @Test(enabled = true)
    public void test2() {

        driver.get("https://amazon.com");

        WebElement help = driver.findElement(By.xpath("(//a[.='Help'])[2]"));

        actions.moveToElement(help).perform();

    }


}
