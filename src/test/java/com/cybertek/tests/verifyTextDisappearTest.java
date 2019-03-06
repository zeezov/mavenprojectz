package com.cybertek.tests;

import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class verifyTextDisappearTest extends TestBase {

    @Test
    public void verify1() {

       driver.get("https://www.w3schools.com/howto/howto_js_toggle_hide_show.asp");

        WebElement text = driver.findElement(By.id("myDIV"));
        System.out.println(text.getText());

        Assert.assertTrue(text.isDisplayed());

        WebElement button = driver.findElement(By.xpath("//button[.='Toggle Hide and Show']"));
        button.click();

        Assert.assertFalse(text.isDisplayed());

    }

    @Test
    public void verify2() {

        driver.get("https://www.w3schools.com/jquery/tryit.asp?filename=tryjquery_html_remove");

        // we need to switch to iframe
        driver.switchTo().frame("iframeResult");

        WebElement text = driver.findElement(By.xpath("//body/p"));
        System.out.println(text.getText());

        Assert.assertTrue(text.isDisplayed());

        WebElement button = driver.findElement(By.xpath("//body/button"));
        button.click();

        /*
        Elements can have different states:

            1. They exist in HTML and also visible on the page

                driver.findElement --> will return the element
                                   --> done not care if the element is displayed or not
                element.isDisplayed --> return true

            2. They exist on HTML but not visible on the page

                driver.findElement --> will return the element
                                   --> done not care if the element is displayed or not
                element.isDisplayed --> return false

            3. Does not exist on HTML and not visible

                 driver.findElement --> return NoSuchElementException

         */

        Assert.assertFalse(elementDisplayed(By.xpath("//body/p")));



    }

    /**
     * takes a locator and returns if element matching this locator exists
     * @param by
     * @return
     */

    public boolean elementDisplayed(By by) {

        // try to find it
        // if cant find it, return false

        try {
            return driver.findElement(by).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }

    }

}
