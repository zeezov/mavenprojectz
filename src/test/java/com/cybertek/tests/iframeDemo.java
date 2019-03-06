package com.cybertek.tests;

/*1. create a new class IframeDemo
2. go to url https://the-internet.herokuapp.com/tinymce
3. enter text in the text editor

*/

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class iframeDemo {

    @Test
    public void test() {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/tinymce");

        // in order to deal with iFrame we need to change the focus of selenium into iFrame.
        // We need to switch to iFrame.

        // locate iFrame
        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));

        //switch to iFrame
        driver.switchTo().frame(iframe);

        WebElement body = driver.findElement(By.tagName("body"));

        body.clear();
        body.sendKeys("Yo wat up?");

        //When we switch to iFrame selenium cannot see contents of previous html
        //We need to switch back to where we came from
        //We can switch back to parent frame

        driver.switchTo().parentFrame();

        // click on the link at the bottom of the website
        driver.findElement(By.linkText("Elemental Selenium")).click();

    }

}
