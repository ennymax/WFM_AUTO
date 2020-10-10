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

public class CreateSourceComplaint extends TestBase {
    @Test
    public void CREATE_SOURCE_COMPLAIN() throws IOException, InterruptedException {
        test = extent.createTest("CREATE SOURCE COMPLAIN");
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
        driver.findElement(By.xpath(Utility.fetchLocator("WorkOrderManager_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SourceComplainBTN_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("AddSourceComplainSource_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("SourceComplaintName_XPATH"))).sendKeys(Utility.fetchLocator("High_TEXT") + randomStuff.ListRandom());
        driver.findElement(By.xpath(Utility.fetchLocator("SourceComplaintDescription_XPATH"))).sendKeys(Utility.fetchLocator("Decrib_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("CreateQUEUEbtn_XPATH"))).click();

        Thread.sleep(1600);
        driver.switchTo().alert().accept();

        Thread.sleep(2000);
        WebElement msg =(new WebDriverWait(driver, 15)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchLocator("AssertSuccessfulSourceComplaint_XPATH"))));
        String text = msg.getText();
        if (msg.isEnabled() && text.contains("Successful")) {
            test.log(Status.PASS, "Source Complaint Created Successfully");
        } else {
            test.log(Status.FAIL, "Source Complaint Can't be created");
        }

        driver.findElement(By.xpath(Utility.fetchLocator("OKBTN4_XPATH"))).click();

        driver.quit();
        System.out.println("********************CREATE SOURCE COMPLAIN********************");
    }
}
