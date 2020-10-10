package com.Module.ResourceAllocationManagement;

import com.aventstack.extentreports.Status;
import com.base.TestBase;
import com.utility.Login;
import com.utility.TabHandle;
import com.utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class UpdateResourceType extends TestBase {

    @Test
    public void Update_RESOURCE_TYPE() throws IOException, InterruptedException {
        test = extent.createTest("Update RESOURCE TYPE");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        Login login = new Login(driver);
        TabHandle tabHandle = new TabHandle(driver);

        login.LoginPremium();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Wfm_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ResourceManagement_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ManageReourceType_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ACtionBTN_XPATH"))).click();

        Thread.sleep(1000);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("UpdateResourceTypeBTN_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        Thread.sleep(1000);
        WebElement aal = driver.findElement(By.xpath(Utility.fetchLocator("ResourceTypeDiscription_XPATH")));
        aal.clear();
        aal.sendKeys(Utility.fetchLocator("Decrib_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SaveUpd_XPATH"))).click();
        test.log(Status.PASS, "Update resource Type successful");

        driver.findElement(By.xpath(Utility.fetchLocator("OKBTN1_XPATH"))).click();

        driver.quit();
        System.out.println("********************UPDATE RESOURCE TYPE********************");
    }
}
