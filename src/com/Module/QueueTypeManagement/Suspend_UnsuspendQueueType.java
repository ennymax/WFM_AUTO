package com.Module.QueueTypeManagement;

import com.aventstack.extentreports.Status;
import com.base.TestBase;
import com.utility.Login;
import com.utility.ScreenShot;
import com.utility.TabHandle;
import com.utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;

public class Suspend_UnsuspendQueueType extends TestBase {
    @Test
    public void SUSPEND_AND_UNSUSPEND_QUEUE_TYPE_STATUS() throws IOException, InterruptedException {
        test = extent.createTest("SUSPEND AND UNSUSPEND QUEUE TYPE STATUS");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        ScreenShot screenShot = new ScreenShot(driver);
        Login login = new Login(driver);
        TabHandle tabHandle = new TabHandle(driver);

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
        driver.findElement(By.xpath(Utility.fetchLocator("QueueTypeSuspendBTN_XPATH"))).click();

        driver.switchTo().alert().accept();

        Thread.sleep(2000);
        screenShot.ScreenShotFullPage();
        WebElement msg = (new WebDriverWait(driver, 15)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchLocator("AssertSuspendQueueTypeStatus_XPATH"))));
        String text = msg.getText();
        if (msg.isEnabled() && text.contains("Suspended")) {
            test.log(Status.PASS, "Suspension Successful");
        } else {
            test.log(Status.FAIL, "Suspension Failed");
        }

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("OKBTN1_XPATH"))).click();

        Thread.sleep(3000);
        driver.findElement(By.xpath(Utility.fetchLocator("QueTypeUpdateActionBtn_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("QueueTypeUnsuspendBTN_XPATH"))).click();

        driver.switchTo().alert().accept();

        Thread.sleep(2000);
        screenShot.ScreenShot();
        WebElement msg1 = (new WebDriverWait(driver, 15)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchLocator("AssertUnsuspendQueueTypeStatus_XPATH"))));
        String text1 = msg1.getText();
        if (msg1.isEnabled() && text1.contains("Un-Suspended")) {
            test.log(Status.PASS, "UnSuspension Successful");
        } else {
            test.log(Status.FAIL, "UnSuspension Failed");
        }

        driver.findElement(By.xpath(Utility.fetchLocator("OKBTN1_XPATH"))).click();

        driver.quit();
        System.out.println("********************SUSPEND AND UNSUSPENDED QUEUE TYPE STATUS********************");
    }
}
