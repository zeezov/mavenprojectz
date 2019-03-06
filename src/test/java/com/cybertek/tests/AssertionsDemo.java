package com.cybertek.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionsDemo {

    @Test
    public void test1() {
        String a = "A";
        String b = "A";

        // to check if they are equal
        Assert.assertEquals(a,b); // comparing a to b

    }

    @Test
    public void test2() {
        String a = "A";
        String b = "AAA";

        // to check if they are equal
        Assert.assertEquals(a,b); // comparing a to b

    }

    @Test
    public void test3() {
        boolean b = 1==1;
        Assert.assertTrue(b);
    }

    @Test
    public void test4() {
        String a = "AD";
        String b = "AAA";

        Assert.assertTrue(b.contains(a));

    }

    @Test
    public void test5() {
        String a = "AD";
        String b = "AAA";

        Assert.assertTrue(b.contains(a), b + " should have containded " + a);

    }

}
