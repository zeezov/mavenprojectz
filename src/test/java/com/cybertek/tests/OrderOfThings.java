package com.cybertek.tests;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class OrderOfThings {

        // this will make this test run first
    @Test (priority = 1)
    public void test1() {
        System.out.println("Executing 1");
    }

    @Test (priority = 3)
    public void test2() {
        System.out.println("Executing 2");
    }

    @Ignore // Will ignore this particular Test Case
    @Test (priority = 2)
    public void test3() {
        System.out.println("Executing 3");
    }







}
