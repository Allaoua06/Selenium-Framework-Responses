package com.testngFramwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class succes_Register_Login {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        driver.get("https://www.facebook.com/");
    }

    @Test(priority=1)
    public void registerToFacebook(){

      driver.findElement(By.linkText("Create new account")).click();
      driver.findElement(By.name("firstname")).sendKeys("Selenium");
      driver.findElement(By.name("lastname")).sendKeys("Panda");
      Select day = new Select(driver.findElement(By.id("day")));
      day.selectByVisibleText("25");
      Select month = new Select(driver.findElement(By.id("month")));
      month.selectByVisibleText("Sep");
      Select year = new Select(driver.findElement(By.id("year")));
      year.selectByVisibleText("1982");
      driver.findElement(By.xpath("//input[@id ='sex' and @value='2']")).click();
      WebElement inputElem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id = 'custom_gender_container']/following-sibling::div[1]/descendant::div[3]/following::input[1]")));
      inputElem.sendKeys("6143013533");
      driver.findElement(By.id("password_step_input")).sendKeys("Selenium@5687");
      driver.findElement(By.xpath("//div[@class = '_1lch']/child::button")).click();


        WebElement waitLoadPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='banner']/child::div[3]/descendant::div[2]/descendant::span[3]")));
        Assert.assertTrue(waitLoadPage.isDisplayed());

        driver.findElement(By.xpath("//div[@role='banner']/child::div[3]/descendant::div[2]/following::div[1]/descendant::div[1]/i")).click();
        WebElement waitForLogOutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='x1xmf6yo']/child::div[2]/child::div[2]/descendant::div[9]/following-sibling::div/descendant::div[4]/child::span")));
        waitForLogOutButton.click();
        driver.findElement(By.xpath("//div[@aria-label='Log Out']")).click();
    }

    @Test(priority = 2)
    public void loginWithValidCredentiels(){
        driver.findElement(By.xpath("//div[@class ='_6luv _52jv']/child::form/child::div[1]/div[1]/input")).sendKeys("6143013533");
        driver.findElement(By.xpath("//div[@class ='_6luv _52jv']/child::form/child::div[1]/div[2]/div/input")).sendKeys("Selenium@5687");
        driver.findElement(By.xpath("//div[@class ='_6luv _52jv']/child::form/child::div[2]/button")).click();
        WebElement waitLoadPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='banner']/child::div[3]/descendant::div[2]/descendant::span[3]")));
        Assert.assertTrue(waitLoadPage.isDisplayed());
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
