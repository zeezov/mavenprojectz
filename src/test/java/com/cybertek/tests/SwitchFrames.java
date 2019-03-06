package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SwitchFrames {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/tinymce");
    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }

    @Test
    public void switchByElement() {

        // in order to deal with iFrame we need to change the focus of selenium into iFrame.
        // We need to switch to iFrame.

        // locate iFrame
        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));

        //switch to iFrame
        driver.switchTo().frame(iframe);

        WebElement body = driver.findElement(By.tagName("body"));

        body.clear();
        body.sendKeys("Yo wat up?");

    }
    // using id of the iFrame
    @Test
    public void switchByFrameId() {

        // in order to deal with iFrame we need to change the focus of selenium into iFrame.
        // We need to switch to iFrame.

        // locate iFrame
        //WebElement iframe = driver.findElement(By.id("mce_0_ifr"));

        //switch to iFrame
        driver.switchTo().frame("mce_0_ifr");

        WebElement body = driver.findElement(By.tagName("body"));

        body.clear();
        body.sendKeys("Yo wat up?");

    }

    // using id of the index
    @Test
    public void switchByFrameIndex() {

        // in order to deal with iFrame we need to change the focus of selenium into iFrame.
        // We need to switch to iFrame.

        // locate iFrame
        //WebElement iframe = driver.findElement(By.id("mce_0_ifr"));

        //switch to iFrame
        driver.switchTo().frame(0);

        WebElement body = driver.findElement(By.tagName("body"));

        body.clear();
        body.sendKeys("Yo wat up?");

    }



}
