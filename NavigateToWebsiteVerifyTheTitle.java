package com.testngFramwork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NavigateToWebsiteVerifyTheTitle {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void verifyTitleOfThePage(){
        driver.get("https://www.columbuslibrary.org/");
        String title = driver.getTitle();
        System.out.println("The title of the page is: " +title);
        String expectedTitel = "Columbus Metropolitan Library";
        Assert.assertEquals(title,expectedTitel);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
