package com.cybertek;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CraigslistTest {

    public static void main(String[] args) {

        // using FireFox for this task
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();

        driver.get("https://washingtondc.craigslist.org/");

        driver.findElement(By.id("query")).sendKeys("corolla");

        // using a link text
        //driver.findElement(By.linkText("electronics")).click();

        // using partial link tex
        driver.findElement(By.partialLinkText("+garden")).click();



    }
}
