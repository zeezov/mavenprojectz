package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PrestaShopHomePage {

    public PrestaShopHomePage() {

        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy (linkText = "Sing in")
    public WebElement signIn;

    public WebElement product(String productName) {

        String xpath = "(//h5//a[@title='" + productName + "'])[1]";
        return Driver.getDriver().findElement(By.xpath(xpath));

    }

}
