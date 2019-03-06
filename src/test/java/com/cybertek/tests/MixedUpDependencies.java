package com.cybertek.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class MixedUpDependencies {

    @Test
    public void openBrowser() {
        System.out.println("Opening Browser");
    }

    @Test (dependsOnMethods = "openBrowser")
    public void logIn() {
        System.out.println("Log In");
    }

    // you have to carefull here because AfterMethod will run after each method. So it will
    // close the browser once openBrowswer method opens it.
    @AfterMethod
    public void cleanUp() {
        System.out.println("Close Browser");
    }


}
