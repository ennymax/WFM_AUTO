package com.Module.QueueManagement;

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

public class UpdateQUEUE extends TestBase {

    @Test
    public void UPDATE_STATUS() throws IOException, InterruptedException {
        test = extent.createTest("UPDATE QUEUE");
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
        driver.findElement(By.xpath(Utility.fetchLocator("ManageQueueType_XPATH"))).click();

        Thread.sleep(1500);
        driver.findElement(By.xpath(Utility.fetchLocator("ActionQUEBTN_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("queueUpdateBTN_XPATH"))).click();

        Thread.sleep(2000);
        WebElement mcj = driver.findElement(By.xpath(Utility.fetchLocator("QueueDescription_XPATH")));
        mcj.clear();
        mcj.sendKeys(Utility.fetchLocator("Decrib_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("QueueSaveBTN_XPATH"))).click();

        Thread.sleep(2000);
        screenShot.ScreenShotFullPage();
        WebElement msg1 =(new WebDriverWait(driver, 15)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchLocator("AssertUpdateQueue_XPATH"))));
        String text1 = msg1.getText();
        if (msg1.isEnabled() && text1.contains("Successful")) {
            test.log(Status.PASS, "Update was Successful");
        } else {
            test.log(Status.FAIL, "Update failed");
        }

        driver.findElement(By.xpath(Utility.fetchLocator("OK_XPATH"))).click();

        driver.quit();
        System.out.println("********************UPDATE QUEUE********************");
    }
}
