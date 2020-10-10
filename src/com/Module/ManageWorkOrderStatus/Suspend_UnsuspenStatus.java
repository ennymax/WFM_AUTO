package com.Module.ManageWorkOrderStatus;

import com.aventstack.extentreports.Status;
import com.base.TestBase;
import com.utility.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;

public class Suspend_UnsuspenStatus extends TestBase {
    @Test
    public void SUSPEND_AND_UNSUSPEND_STATUS() throws IOException, InterruptedException {
        test = extent.createTest("UPDATE STATUS");
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

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ManageWorkOrderStatus_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("StatusActionBTN_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Suspend_XPATH"))).click();

        driver.switchTo().alert().accept();

        Thread.sleep(2000);
        WebElement msg =(new WebDriverWait(driver, 15)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchLocator("SuspendStatus_XPATH"))));
        String text = msg.getText();
        if (msg.isEnabled() && text.contains("Suspended")) {
            test.log(Status.PASS, "Suspension Successful");
        } else {
            test.log(Status.FAIL, "Suspension Failed");
        }

        driver.findElement(By.xpath(Utility.fetchLocator("OKBTN1_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("StatusActionBTN_XPATH"))).click();

        Thread.sleep(5000);
        driver.findElement(By.xpath(Utility.fetchLocator("unsuspend_XPATH"))).click();

        driver.switchTo().alert().accept();

        Thread.sleep(2000);
        WebElement msg1 =(new WebDriverWait(driver, 15)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchLocator("AssertUnsuspendStatus_XPATH"))));
        String text1 = msg1.getText();
        if (msg1.isEnabled() && text1.contains("Un-Suspended")) {
            test.log(Status.PASS, "UnSuspension Successful");
        } else {
            test.log(Status.FAIL, "UnSuspension Failed");
        }

        driver.findElement(By.xpath(Utility.fetchLocator("OKBTN1_XPATH"))).click();

        driver.quit();
        System.out.println("********************SUSPEND AND UNSUSPEND STATUS********************");
    }
}
