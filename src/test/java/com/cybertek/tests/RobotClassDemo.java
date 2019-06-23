package com.cybertek.tests;

import com.cybertek.utilities.Driver;
import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class RobotClassDemo extends TestBase {


    // In this class we are trying to upload file using Windows pop up

    @Test
    public void robotTest() throws AWTException {

        driver.get("http://practice.cybertekschool.com/upload");

        driver.findElement(By.id("file-upload")).click();

        //file path
        // /Users/nshaazizov/Documents/AboutStacks.pdf

        //FILE PATH
        File file  = new File("/Users/nshaazizov/Documents/About Stacks.pdf");
        StringSelection stringSelection = new StringSelection(file.getAbsolutePath());

        // Copying the file path to memory, like when we do CTRL/CMD+C
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

        Robot robot = new Robot();

        // use VK_META to enter the COMMAND button on mac
        // hit CMD + TAB to bring the window to focus
        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_META);

        // hit CMD + G to open the go to window
        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_G);

        robot.keyRelease(KeyEvent.VK_G);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyRelease(KeyEvent.VK_META);

        // paste the file path
        // CMD + V

        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_V);

        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_META);

        // Hit the Enter twice.
        // 1 - to close the go to window and highlight the file
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(2000);


        // 2. to select file and close window     fr
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(2000);


        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);





    }

}
