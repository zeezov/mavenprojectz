package com.cybertek.tests;

import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadTest extends TestBase {

    /*
    go to https://the-internet.herokuapp.com/upload
    upload file
    click upload
    verify text uploaded
     */

    @Test
    public void test() {

        driver.get("https://the-internet.herokuapp.com/upload");

        WebElement chooseFile = driver.findElement(By.id("file-upload"));

        String path = "/Users/nshaazizov/Downloads/test.txt";
        // for windows - "\\Users\\nshaazizov\\Downloads\\test.txt"

        chooseFile.sendKeys(path);

        driver.findElement(By.id("file-submit")).click();

        // verify text uploaded

        Assert.assertTrue(driver.findElement(By.xpath("//*[.='File Uploaded!']")).isDisplayed());


    }

}
