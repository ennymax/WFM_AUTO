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

public class Show_HideStatusFromResource extends TestBase {

    @Test
    public void SHOW_HIDE_STATUS_FROM_RESOURCE() throws IOException, InterruptedException {
        test = extent.createTest("SHOW/HIDE STATUS FROM RESOURCE");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        Login login = new Login(driver);
        TabHandle tabHandle = new TabHandle(driver);
        SecureRandom rn = new SecureRandom();
        int tom = rn.nextInt(15) + 1;

        login.LoginPremium();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Wfm_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("WorkOrderManager_XPATH"))).click();

        Thread.sleep(1500);
        driver.findElement(By.xpath(Utility.fetchLocator("Manage_Queue_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("QueTypeUpdateActionBtn_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("LinkStatus_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("AsDdStatusBTN_XPATH"))).click();

        Thread.sleep(2000);
        WebElement ele111 = driver.findElement(By.xpath(Utility.fetchLocator("WorkOrderStatus_XPATH")));
        Select sel11 = new Select(ele111);
        sel11.selectByIndex(tom);

        WebElement mcj = driver.findElement(By.xpath(Utility.fetchLocator("WorkOrederPriority_XPATH")));
        mcj.clear();
        mcj.sendKeys(Utility.fetchLocator("High_TEXT") + tom);

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("CreateNewStatusa_XPATH"))).click();

        Thread.sleep(2000);
        WebElement msg =(new WebDriverWait(driver, 25)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchLocator("aaaaa_XPATH"))));
        String text = msg.getText();
        if (msg.isEnabled() && text.contains("Successful")) {
            test.log(Status.PASS, "New Status Added Successful");
        } else {
            test.log(Status.FAIL, "No Status was Added");
        }

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("OKBTN1_XPATH"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ShowToResource_XPATH"))).click();

        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        Thread.sleep(2000);
        WebElement msgq =(new WebDriverWait(driver, 25)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchLocator("AssertHideStatus_XPATH"))));
        String textq = msgq.getText();
        if (msgq.isEnabled() && textq.contains("This status is now visible to any Resource")) {
            test.log(Status.PASS, "Show Status from Resource is Successful");
        } else {
            test.log(Status.FAIL, "Show Status from Resource Failed");
        }

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("OKBTN1_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("HideFromResource_XPATH"))).click();

        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        Thread.sleep(2000);
        WebElement msg1 =(new WebDriverWait(driver, 25)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchLocator("AssertHideStatus_XPATH"))));
        String text1 = msg1.getText();
        if (msg1.isEnabled() && text1.contains("This status is now hidden from any Resource")) {
            test.log(Status.PASS, "Hide Status from Resource is Successful");
        } else {
            test.log(Status.FAIL, "Hide Status from Resource Failed");
        }

        driver.quit();
        System.out.println("********************SHOW/HIDE STATUS FROM RESOURCE********************");
    }
}
