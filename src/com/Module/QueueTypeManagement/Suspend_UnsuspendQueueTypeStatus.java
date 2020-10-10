package com.Module.QueueTypeManagement;

import com.aventstack.extentreports.Status;
import com.base.TestBase;
import com.utility.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import java.io.IOException;
import java.security.SecureRandom;

public class Suspend_UnsuspendQueueTypeStatus extends TestBase {

    @Test
    public void ADD_STATUSES_TO_QUEUE_TYPE() throws IOException, InterruptedException {
        test = extent.createTest("Suspend Unsuspend QueueType Status");
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
        driver.findElement(By.xpath(Utility.fetchLocator("LinkStatus1_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SuspendQueueTypeStatus_XPATH"))).click();
        test.log(Status.PASS, "Suspend new Status Successful");

        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        Thread.sleep(3000);
        driver.findElement(By.xpath(Utility.fetchLocator("OKBTN1_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("UnsuspendQueueTypeStatus_XPATH"))).click();
        test.log(Status.PASS, "Unsuspend New Status Successful");

        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        Thread.sleep(3000);
        driver.findElement(By.xpath(Utility.fetchLocator("OKBTN1_XPATH"))).click();

        driver.quit();
        System.out.println("********************ADD STATUSES TO QUEUE TYPE********************");
    }
}
