package com.cybertek.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DifferentAnnotations {

    @Test
    public void testOne() {
        System.out.println("This is Test One");
    }

    // runs one time before @Test method. If there is no @Test method @BeforeMethod wont run
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("This is Before Method");
    }

    @Test
    public void testTwo() {
        System.out.println("This is Test Two");
    }
    // runs one time before anything else
    @BeforeClass
    public void beforeClass() {
        System.out.println("This is Before Class");
    }



}
