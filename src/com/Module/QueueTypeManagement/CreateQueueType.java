package com.Module.QueueTypeManagement;

import com.aventstack.extentreports.Status;
import com.base.TestBase;
import com.utility.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.SecureRandom;

public class CreateQueueType extends TestBase {

    @Test
    public void CREATE_QUEUE_TYPE() throws IOException, InterruptedException {
        test = extent.createTest("CREATE QUEUE TYPE");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        Login login = new Login(driver);
        TabHandle tabHandle = new TabHandle(driver);
        RandomStuff randomStuff = new RandomStuff();
        SecureRandom rn = new SecureRandom();
        int tom = rn.nextInt(15) + 1;

        login.LoginPremium();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Wfm_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("WorkOrderManager_XPATH"))).click();

        Thread.sleep(1500);
        driver.findElement(By.xpath(Utility.fetchLocator("Manage_Queue_XPATH"))).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("CreateQUEUETYpeBTN_XPATH"))).click();

        Thread.sleep(2500);
        driver.findElement(By.xpath(Utility.fetchLocator("QueueTypeName_XPATH"))).sendKeys(randomStuff.ListRandom());

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("QueueTypeDiscription_XPATH"))).sendKeys(Utility.fetchLocator("Decrib_TEXT"));

        Thread.sleep(2000);
        WebElement ele111 = driver.findElement(By.xpath(Utility.fetchLocator("SelectQueue_XPATH")));
        Select sel11 = new Select(ele111);
        sel11.selectByIndex(tom);

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("CreateQUEUEbtn_XPATH"))).click();

        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        Thread.sleep(2000);
        WebElement msg =(new WebDriverWait(driver, 15)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchLocator("AssertqueueCreation_XPATH"))));
        String text = msg.getText();
        if (msg.isEnabled() && text.contains("Successful")) {
            test.log(Status.PASS, "Create QueueType Successfully");
        } else {
            test.log(Status.FAIL, "Create QueueType  Failed");
        }

        driver.findElement(By.xpath(Utility.fetchLocator("OKBTN1_XPATH"))).click();

        driver.quit();
        System.out.println("********************CREATE QUEUE TYPE********************");
    }
}