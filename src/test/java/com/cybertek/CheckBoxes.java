package com.cybertek;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxes {
    public static void main(String[] args) {

//        System.setProperty("webdriver.chrome.driver",
//                "/Users/nshaazizov/Documents/selenium dependencies/drivers/chromedriver");

        // these are all the drivers for all browsers
        /*
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.operadriver().setup();
        WebDriverManager.phantomjs().setup();
        WebDriverManager.edgedriver().setup();
        WebDriverManager.iedriver().setup();
         */
        // setting driver path for chrome using the webdriverManager
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/forgot_password");

        WebElement email = driver.findElement(By.id("email"));
                                                            //this will click on the bottom
        email.sendKeys("someemail@somemail.com" + Keys.ENTER);

        // we can also say email.submit();
       // email.submit();

        String expected = "Your e-mail's been sent!";
        String actual = driver.findElement(By.id("content")).getText();

        //System.out.println(actual);

        if(actual.equals(expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("actual => " + actual);
            System.out.println("expected => " + expected);
        }











    }


}
