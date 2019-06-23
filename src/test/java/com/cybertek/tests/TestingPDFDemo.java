package com.cybertek.tests;

import com.codeborne.pdftest.PDF;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class TestingPDFDemo {

    // for this test we have new dependency

    @Test
    public void pdfTest() {

        File file = new File("/Users/nshaazizov/Documents/About Stacks.pdf");

        // PDF file represents our pdf file, it is created using the file object
        PDF pdf = new PDF(file);

        System.out.println(pdf.title);

        System.out.println(pdf.numberOfPages);

        System.out.println(pdf.text);

        Assert.assertTrue(pdf.text.contains("the"));

    }

}
