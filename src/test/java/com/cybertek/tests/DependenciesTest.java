package com.cybertek.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependenciesTest {

    /*
    Dependencies on testNg
    In testing we can make test methods depended on one another,
    for example we can say method1 depends on method2
    so if method1 fails, method2 will not execute at all. It will be skipped.
     */

    @Test
    public void logIn() {
        System.out.println("Log In");
        Assert.assertTrue(false);
    }

        // this will make it depend on log in method and this method will not run and be ignored.
    @Test (dependsOnMethods = "logIn")
    public void zbuySth() {
        System.out.println("buy buy baby");
    }

    @Test
    public void homePage() {
        System.out.println("Home Page");
    }



}
