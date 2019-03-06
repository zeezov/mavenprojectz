package com.cybertek.tests;

/*
    THIS TEST SUPPOSED TO FAIL. NEED TO FOLLOW TEST CASES

1.open browser
2.go to https://amazon.com
3.verifythat default dropdown option is ALL
4.verify that all options are sorted alphabetically
5.Click on the menu icon on the left
6.click on Full Store directory
7.capture all of the main department namesin the page. Examples for main department pages shown in the picture.
8.verify that departments names are sorted alphabetically
9.verify that all departments names are listed in the dropdown from step 4
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmazonDepartmentsTest {

    WebDriver driver;
    Select allDepartments;

    @BeforeClass
    public void setUpMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://amazon.com");

    }
    // 3.verify that default dropdown option is ALL
    @Test(priority = 0)
    public void testDefaultValue() {

        WebElement selectElement = driver.findElement(By.id("searchDropdownBox"));
        // create a Select class object
        // if you want to work with Drop Down you need to create object of type select
        allDepartments = new Select(selectElement);
        // get the current selected option
        String selectedOption = allDepartments.getFirstSelectedOption().getText();
        Assert.assertEquals(selectedOption, "ALL");

    }

    // 4.verify that all options are sorted alphabetically
    @Test (priority = 1)
    public void sortAlphabetical() {

        // using the compare to method, we will compare each element in the list to the next one
        for(int i = 0; i < allDepartments.getOptions().size()-1; i++) {

            String current = allDepartments.getOptions().get(i).getText();
            String next = allDepartments.getOptions().get(i+1).getText();

            System.out.println("comparing: " + current + " with " + next);

            Assert.assertTrue(current.compareTo(next) <= 0);

        }

    }

    /*
    6.click on Full Store directory
    7.capture all of the main department names in the page.
    Examples for main department pages shown in the picture.
    8.verify that departments names are sorted alphabetically
     */

    @Test
    public void mainDepartmentTest() {

        driver.findElement(By.cssSelector("i.hm-icon.nav-sprite")).click();
        driver.findElement(By.cssSelector("a[href='/gp/site-directory?ref_=nav_em_T1_0_2_2_33__fullstore']")).click();


        //7.capture all of the main department names in the page.
        List<WebElement> mainDepts = driver.findElements(By.cssSelector("h2.fsdDeptTitle"));

        for(WebElement option : mainDepts) {
            System.out.println(option.getText());
        }
    }

    @AfterClass
    public void tearDown() {
        //driver.quit();
    }


}
