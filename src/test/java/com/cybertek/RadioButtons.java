package com.cybertek;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RadioButtons {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwRadioButton");

        /*
        verify blue and red not checked
        check blue
        verify blue checked, red not checked
        check red
        verify blue not checked, red is checked
         */

        WebElement blue = driver.findElement(By.id("gwt-debug-cwRadioButton-color-blue-input"));
        WebElement red = driver.findElement(By.id("gwt-debug-cwRadioButton-color-red-input"));

        System.out.println("DEFAULT");
        System.out.println("blue " + blue.isSelected());
        System.out.println("red " + red.isSelected());


        //click blue
        System.out.println("CLICKING ON BLUE");
        blue.click();
        System.out.println("blue " + blue.isSelected());
        System.out.println("red " + red.isSelected());

        //click red
        System.out.println("CLICKING ON RED");
        red.click();
        System.out.println("blue " + blue.isSelected());
        System.out.println("red " + red.isSelected());



    }
}
