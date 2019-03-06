package com.cybertek;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDownButton {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://the-internet.herokuapp.com/dropdown");

        // 1. we have locate and element with tag select
        // it needs to be select tag
        WebElement selectElement =  driver.findElement(By.id("dropdown"));

        // 2.create a select object using the web element above

        Select list = new Select(selectElement);

        // print the selected option
        String selectedOption = list.getFirstSelectedOption().getText();
        System.out.println("Selected option by default => " + selectedOption);

        // print all available options
        List<WebElement> options = list.getOptions();
        System.out.println("Options.size() = " + options.size());

        // print each element

        for(WebElement option : options) {
            System.out.println(option.getText());
        }

        // select different options
        // there are 3 different options we can use to select from drop down list

        // 1. by .selectByVisibleTest()
        list.selectByVisibleText("Option 2");
        System.out.println("Selected option: " + list.getFirstSelectedOption().getText());

        // 2. by .selectByIndex
        list.selectByIndex(1);
        System.out.println("Selected Option: " + list.getFirstSelectedOption().getText());

        // 3. by .selectValueAttribute
        list.selectByValue("2");
        System.out.println("Selected Option: " + list.getFirstSelectedOption().getText());

        // if in the application, drop down does not use select tag
        // you cannot use the select Class
        // 1. You will have to click on the drop down separately
        // 2. you will have to locate and click on the option in the second step

    }
}
