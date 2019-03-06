package com.cybertek.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class DifferentAnnotations2 {

    @Test
    public void testOne() {
        System.out.println("This is Test One");
    }

    @Test
    public void testTwo() {
        System.out.println("This is Test Two");
    }

    // this will run after @Test testOne method and than after testTwo method
    @AfterMethod
    public void afterMethod() {
        System.out.println("This is After Method");
    }

    // this will only run 1 time. After everything else.
    @AfterClass
    public void afterClass() {
        System.out.println("This is After Class");
    }

}
