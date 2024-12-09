package com.testngFramwork;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class navigate_Websit_And_Click_Link {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");
    }

    @Test
    public void navigateToElectronicsPage(){
        driver.findElement(By.linkText("Electronics")).click();
        String ExpectedTitle = driver.findElement(By.xpath("//div[@class='pagecontainer__top']/child::h1/span")).getText();
        String ActualTitle = "Electronics";
        Assert.assertTrue(ExpectedTitle.contains(ActualTitle));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");

        driver.findElement(By.linkText("Cell Phones & Smartphones")).click();
        String ExpectedTitle2 = driver.findElement(By.xpath("//span[@class='b-pageheader__text']")).getText();
        String ActualTilte2 = "Cell Phones & Smartphones";
        Assert.assertTrue(ExpectedTitle2.contains(ActualTilte2));

    }
}
