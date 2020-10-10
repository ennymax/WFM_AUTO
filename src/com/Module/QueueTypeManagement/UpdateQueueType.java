package com.Module.QueueTypeManagement;

import com.aventstack.extentreports.Status;
import com.base.TestBase;
import com.utility.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.SecureRandom;

public class UpdateQueueType extends TestBase {

    @Test
    public void Update_Queue_Type() throws IOException, InterruptedException {
        test = extent.createTest("Update QueueType ");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        Login login = new Login(driver);
        TabHandle tabHandle = new TabHandle(driver);
        RandomStuff randomNumbers = new RandomStuff();
        SecureRandom rn = new SecureRandom();
        int tom = rn.nextInt(15) + 1;

        login.LoginPremium();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Wfm_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("WorkOrderManager_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ManageQueueTypeBTN_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("QueTypeUpdateActionBtn_XPATH"))).click();

        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("AddQueueTypeStatuses_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        Thread.sleep(2000);
        WebElement ele111 = driver.findElement(By.xpath(Utility.fetchLocator("QUENAME_XPATH")));
        Select sel11 = new Select(ele111);
        sel11.selectByIndex(tom);

        Thread.sleep(2000);
        WebElement cj = driver.findElement(By.xpath(Utility.fetchLocator("QueuetypeName_XPATH")));
        cj.clear();
        cj.sendKeys(Utility.fetchLocator("High_TEXT") + randomNumbers.RandomNumbers());

        Thread.sleep(2000);
        WebElement cjj = driver.findElement(By.xpath(Utility.fetchLocator("DSCC_XPATH")));
        cjj.clear();
        cjj.sendKeys(Utility.fetchLocator("Decrib_TEXT") + randomNumbers.RandomNumbers());

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Save123_XPATH"))).click();

        driver.switchTo().alert().accept();

        Thread.sleep(2000);
        WebElement msg1 =(new WebDriverWait(driver, 15)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchLocator("AssertUpdteQueueT_XPATH"))));
        String text1 = msg1.getText();
        if (msg1.isEnabled() && text1.contains("Successful")) {
            test.log(Status.PASS, "Update was Successful");
        } else {
            test.log(Status.FAIL, "Update failed");
        }

        driver.findElement(By.xpath(Utility.fetchLocator("OKBTN1_XPATH"))).click();

        driver.quit();
        System.out.println("********************UPDATE QUEUE TYPE********************");
    }
}
