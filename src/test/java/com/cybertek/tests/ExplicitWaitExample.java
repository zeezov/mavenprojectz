package com.cybertek.tests;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitWaitExample {

    // Explicit wait is used to wait for certain condition: such as element to be clickable, available,
    // disappear, have certain text.
    // Explicit wait is always called explicitly (just like thread.sleep) when we need to wait

    @Test
    public void test() {
        Driver.getDriver().get("https://the-internet.herokuapp.com/dynamic_controls");

        //Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // click on enable
        Driver.getDriver().findElement(By.xpath("//form[@id='input-example']//button")).click();

        // WebDriverWait class used to explicit waits
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

        // wait.until() : this is when wait happens
        // we are waiting for certain element this xpath to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text']")));

        // enter text
        Driver.getDriver().findElement(By.xpath("//input[@type='text']")).sendKeys("Hello World");



    }

}
