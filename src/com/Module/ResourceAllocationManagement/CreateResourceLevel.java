package com.Module.ResourceAllocationManagement;

import com.aventstack.extentreports.Status;
import com.base.TestBase;
import com.utility.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class CreateResourceLevel extends TestBase {

    @Test
    public void CREATE_RESOURCE_LEVEL() throws IOException, InterruptedException {
        test = extent.createTest("CREATE RESOURCE LEVEL");
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
        driver.findElement(By.xpath(Utility.fetchLocator("NewResouceLevel_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ResourceLevelName_XPATH"))).sendKeys(Utility.fetchLocator("High_TEXT") + randomStuff.RandomWords());

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ResourceLevelDiscription_XPATH"))).sendKeys(Utility.fetchLocator("Decrib_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("CreateResourceLevelBTN_XPATH"))).click();
        test.log(Status.PASS, "Resource Level Created Successfully");

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ResourceLevelOKBTN_XPATH"))).click();

        driver.quit();
        System.out.println("********************CREATE RESOURCE LEVEL********************");
    }
}
