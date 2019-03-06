package com.cybertek.tests;

import com.cybertek.pages.HomePage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.TestBase;
import org.testng.annotations.Test;

public class LogInTestWithProperties extends TestBase {

    @Test
    public void readPropertyTest() {

        driver.get(ConfigurationReader.getProperty("url"));

        HomePage homePage = new HomePage();

        String username = ConfigurationReader.getProperty("username");
        String password = ConfigurationReader.getProperty("password");

        homePage.logIn(username,password);

    }

}
