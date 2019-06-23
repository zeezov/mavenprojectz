package com.cybertek.tests;

import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebTebleExample extends TestBase {

    public void login() {

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test" + Keys.ENTER);

    }

    //@Test
    public void printWholeTable() {
        login();

        WebElement table = driver.findElement(By.id("ctl00_MainContent_orderGrid"));

        System.out.println(table.getText());

    }

    @Test
    public void printAllHeaders() {

        login();

        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//th"));

        for (WebElement header : headers) {

            System.out.println(header.getText());

        }

    }

    @Test
    public void printRow() {

        login();

        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr"));

        System.out.println("Number of rows: " + allRows.size());

        for (WebElement header : allRows) {

            System.out.println(header.getText());

        }

        // print the nth row

        System.out.println("Print row: " + 3);
        System.out.println(allRows.get(2).getText());


    }

    @Test
    public void printTableSize() {

        login();

        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr"));

        System.out.println("Number of rows: " + allRows.size());

        List<WebElement> allHeaders = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tbody/tr[1]/th"));

        System.out.println("Number of columns: " + allHeaders.size());

    }

    // print a row without using a list

    @Test
    public void printRow2() {

        login();

        WebElement row = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[1]"));

        System.out.println(row.getText());

    }


    // print all the cells of a row of index is given in the xpath
    @Test
    public void printAllCellsInOneRow() {

        login();

        List<WebElement> cells = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[2]/td"));

        for (WebElement header : cells) {

            System.out.println(header.getText());

        }

    }

    // print by coordinates: based on row and column number

    @Test
    public void printByCoordinates() {

        login();

        WebElement cell = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[3]/td[11]"));

        System.out.println(cell.getText());

        // this is the example for below getCell method
        System.out.println(getCell(3,11).getText());

    }

    // we can create this method an pass the number to get the cells from rows. See example above
    public WebElement getCell(int row, int col) {
        String xpath = "//table[@id='ctl00_MainContent_orderGrid']/tbody/tr["+row+"]/td["+col+"]";
        return driver.findElement(By.xpath(xpath));
    }

    // print all values from single column
    @Test
    public void printColumn() {

        login();

        List<WebElement> allNames = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[2]"));

        for (WebElement header : allNames) {

            System.out.println(header.getText());

        }

    }

    // Find the select check box for a given name

    @Test
    public void selectCheckBox() {

        login();

        WebElement checkboxes = driver.findElement(By.xpath("//td[.='Mark Smith']/../td[1]/input"));

        System.out.println(checkboxes.isSelected());
        checkboxes.click();
        System.out.println(checkboxes.isSelected());

    }

    /*
    Verify that name "Mark Smith" exists in the names column
    verify that city 'Whitestone, British' exists in the cities column
     */

    @Test
    public void test() {

        login();

        int nameIndex = getColumnIndex("Name");

        System.out.println(nameIndex);

        List<WebElement> allNames = driver.findElements(
                By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td["+nameIndex+"]"));

        boolean found = false;

        for (int i = 0; i < allNames.size(); i++) {
                if (allNames.get(i).getText().equals("Mark Smith")) {
                    found = true;
                    break;
                }
            }

        Assert.assertTrue(found);

        int cityIndex = getColumnIndex("City");
        List<WebElement> allCities = driver.findElements(
                By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td["+cityIndex+"]"));

        for (int i = 0; i < allCities.size(); i++) {
            if (allCities.get(i).getText().equals("Whitestone, British")) {
                found = true;
                break;
            }
        }


    }

    // gets a column name as a parameters and returns the index of the name
    public int getColumnIndex(String column) {

        List<WebElement> allHeaders = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//th"));

        for (int i = 0; i < allHeaders.size() ; i++) {

            if(allHeaders.get(i).getText().equals(column)) {
                return i+1;
            }
        }

        return 0;
    }




}
