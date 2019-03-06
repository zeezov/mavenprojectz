package com.cybertek.tests;

import org.testng.annotations.Test;

public class MoreDependenciesTests {

    @Test
    public void openBrowser() {
        System.out.println("Opening Browser");
    }

    @Test (dependsOnMethods = "openBrowser")
    public void logIn() {
        System.out.println("Log In");
    }

    @Test (dependsOnMethods = "logIn")
    public void logOut() {
        System.out.println("Log Out");
    }

}
