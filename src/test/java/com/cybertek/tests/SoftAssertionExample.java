package com.cybertek.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertionExample {

    @Test
    public void test1() {
        System.out.println("starting");

        // this will fail and not print "Done". Because assert method will stop the program
        Assert.assertTrue(false);

        System.out.println("Done");

    }

    @Test
    public void test2() {
        //is a class which comes from testNG. It allows doing soft assertions
        // it will not stop the code from running if it fails
        SoftAssert softAssert = new SoftAssert();

        System.out.println("starting");

        softAssert.assertTrue(false);

        // this will be printed because of soft assert
        System.out.println("done");

        softAssert.assertEquals(1,2);

        // reports which assert fails
        softAssert.assertAll();

    }

    @Test
    public void test3() {
        SoftAssert softAssert = new SoftAssert();

        System.out.println("Starting");

        softAssert.assertTrue(false);

        // regular assert class. This will make it fail. And wont print "done"
        Assert.assertTrue(false);

        System.out.println("done");

        softAssert.assertAll();
    }

}
