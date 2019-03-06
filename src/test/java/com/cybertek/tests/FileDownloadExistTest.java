package com.cybertek.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDownloadExistTest {

    @Test
    public void test() {

        // get the current folder
        String currentFolder = System.getProperty("user.dir");
            System.out.println(currentFolder);

        // get the user folder
        String userFolder = System.getProperty("user.home");
            System.out.println(userFolder);

        String path = userFolder + "/Downloads/a.xlsx";
            System.out.println(path);

        Assert.assertTrue(Files.exists(Paths.get(path)));


    }

}
