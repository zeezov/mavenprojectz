package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSAlerts {

    /*

     */

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        //this below code will not open browser and run everything in the back ground

//        ChromeOptions options= new ChromeOptions();
//        options.setHeadless(true);
//        driver = new ChromeDriver(options);

        driver = new ChromeDriver();

    }

//    @AfterMethod
//    public void cleanUp() throws InterruptedException {
//        Thread.sleep(5000);
//        driver.quit();
//    }

    @Test
    public void oopsTest() {

        driver.get("https://sweetalert.js.org/");
        //trigger the pop up
        // this pop up is not HTML pop up. You cannot right click and inspect it.
        // this kind of pop up comes from JavaScript
        WebElement popUp = driver.findElement(By.xpath("(//button[@class='preview'])[1]"));

        popUp.click();
        // switch to alert
        Alert alert = driver.switchTo().alert();

        alert.accept(); // clicking on JavaScript pop up

    }

    @Test
    public void dismissTest() {

        driver.get("http://the-internet.herokuapp.com/javascript_alerts");

        // trigger the pop up
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();

        // this JS pop up have two options Cancel and Ok
        // we use dismiss to click on cancel.
        Alert alert = driver.switchTo().alert();
        alert.dismiss(); // clicking Cancel on a pop up

    }

    @Test
    public void alertTest() {

        driver.get("http://the-internet.herokuapp.com/javascript_alerts");

        // trigger the pop up
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();

        //This JS pop up is asking to enter text and asking to press OK or Cancel
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Hello");
        alert.accept();

    }

}
