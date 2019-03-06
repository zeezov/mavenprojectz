package com.cybertek;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RealCheckBoxes {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");

        WebElement monday = driver.findElement(By.id("gwt-debug-cwCheckBox-Monday-input"));

//        // to see if monday check box is selected. Returns true or false
//        System.out.println(monday.isSelected()); // prints false
//        // to click on the check box
//        //monday.click();
//        System.out.println(monday.isSelected()); // prints true

        if(!monday.isSelected()) {
            monday.click();
        }
        System.out.println(monday.isSelected());











    }
}
