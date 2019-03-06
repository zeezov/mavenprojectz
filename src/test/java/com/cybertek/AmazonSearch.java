package com.cybertek;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonSearch {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://amazon.com");

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

        searchBox.sendKeys("Iphone chargers");
        searchBox.submit();

        String searchTerm = "Iphone chargers";

        // get.Text() does not work with search boxes
        // String actual =  driver.findElement(By.id("twotabsearchtextbox")).getText();

        // this is the first options to get the value of the search box
        String actual =  driver.findElement(By.id("twotabsearchtextbox")).getAttribute("value");

        // second option will be: .getAttribute("innerHTML");

        if(searchTerm.equals(actual)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("actual => " + actual);
            System.out.println("searchTerm => " + searchTerm);
        }

    }
}
