package com.Module.ResourceAllocationManagement;

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

public class Suspend_UnsuspendResourceLevel extends TestBase {
    @Test
    public void SUSPEND_UNSUSPEND_RESOURCE_LEVEL() throws IOException, InterruptedException {
        test = extent.createTest("SUSPEND UNSUSPEND RESOURCE LEVEL");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        Login login = new Login(driver);
        TabHandle tabHandle = new TabHandle(driver);
        RandomStuff randomStuff = new RandomStuff();

        login.LoginPremium();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Wfm_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ResourceManagement_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ManageResouceLevel_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ActionUpdateResourLevel_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SuspendResourceLevel_XPATH"))).click();

        driver.switchTo().alert().accept();

        Thread.sleep(2000);
        WebElement msg = (new WebDriverWait(driver, 15)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchLocator("AssertSuspendResouceleve_XPATH"))));
        String text = msg.getText();
        if (msg.isEnabled() && text.contains("Suspended")) {
            test.log(Status.PASS, "Suspension Successful");
        } else {
            test.log(Status.FAIL, "Suspension Failed");
        }

        driver.findElement(By.xpath(Utility.fetchLocator("ResoOKBTN_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ActionUpdateResourLevel_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("UnsuspendResourceLevel_XPATH"))).click();

        Thread.sleep(1000);
        driver.switchTo().alert().accept();

        Thread.sleep(2000);
        WebElement msg1 = (new WebDriverWait(driver, 15)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchLocator("AssertUnsuspendResourceLevel_XPATH"))));
        String text1 = msg1.getText();
        if (msg1.isEnabled() && text1.contains("Un-Suspended")) {
            test.log(Status.PASS, "UnSuspension Successful");
        } else {
            test.log(Status.FAIL, "UnSuspension Failed");
        }

        driver.findElement(By.xpath(Utility.fetchLocator("ResoOKBTN_XPATH"))).click();

        driver.quit();
        System.out.println("********************SUSPEND AND UNSUSPENDED RESOURCE LEVEL********************");
    }
}
