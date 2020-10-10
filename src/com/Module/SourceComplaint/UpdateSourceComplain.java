package com.Module.SourceComplaint;

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

public class UpdateSourceComplain extends TestBase {

    @Test
    public void UPDATE_SOURCE_COMPLAIN() throws IOException, InterruptedException {
        test = extent.createTest("UPDATE SOURCE COMPLAIN");
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
        driver.findElement(By.xpath(Utility.fetchLocator("SourceComplaintActionBTN_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("UpdateSourceComplainBTN_XPATH"))).click();

        Thread.sleep(1000);
        WebElement aal = driver.findElement(By.xpath(Utility.fetchLocator("SourceComplaintDescription_XPATH")));
        aal.clear();
        aal.sendKeys(Utility.fetchLocator("Decrib_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("CreateQUEUEbtn_XPATH"))).click();

        Thread.sleep(1000);
        driver.switchTo().alert().accept();

        Thread.sleep(2000);
        WebElement msg =(new WebDriverWait(driver, 45)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchLocator("UpdateSourceComplaint_XPATH"))));
        String text = msg.getText();
        if (msg.isEnabled() && text.contains("Successful")) {
            test.log(Status.PASS, "Source Complaint was Update");
        } else {
            test.log(Status.FAIL, "Source Complaint Failed to Updated");
        }

        driver.findElement(By.xpath(Utility.fetchLocator("OKBTN4_XPATH"))).click();

        driver.quit();
        System.out.println("********************UPDATE SOURCE COMPLAIN********************");
    }
}
