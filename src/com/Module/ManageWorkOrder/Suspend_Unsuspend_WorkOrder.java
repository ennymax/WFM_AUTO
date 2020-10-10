package com.Module.ManageWorkOrder;

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
import java.security.SecureRandom;

public class Suspend_Unsuspend_WorkOrder extends TestBase {
    @Test
    public void UPDATE_STATUS() throws IOException, InterruptedException {
        test = extent.createTest("UPDATE STATUS");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        BrokenLink brokenLink = new BrokenLink(driver);
        ScreenShot screenShot = new ScreenShot(driver);
        Login login = new Login(driver);
        TabHandle tabHandle = new TabHandle(driver);
        SecureRandom rn = new SecureRandom();
        int tom = rn.nextInt(15) + 1;

        login.LoginPremium();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Wfm_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("WorkOrderManager_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ManageWorkOrder_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("All_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ActionBTNworkOrder_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SuspendWorkOre_XPATH"))).click();

        Thread.sleep(2000);
        screenShot.ScreenShot();
        WebElement msg =(new WebDriverWait(driver, 15)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchLocator("AssertSuspendWorkOrder_XPATH"))));
        String text = msg.getText();
        if (msg.isEnabled() && text.contains("Suspended")) {
            test.log(Status.PASS, "Suspension Successful");
        } else {
            test.log(Status.FAIL, "Suspension Failed");
        }

        driver.findElement(By.xpath(Utility.fetchLocator("WorkOrderOKBTN_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ActionBTNworkOrder_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("UnsuspendWorkOrder2_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("WorkOrderOKBTN_XPATH"))).click();

        driver.quit();
        System.out.println("********************SUSPEND UNSUSPEND WORKORDER********************");
    }
}
