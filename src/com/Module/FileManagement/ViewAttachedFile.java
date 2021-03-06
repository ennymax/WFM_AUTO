package com.Module.FileManagement;

import com.aventstack.extentreports.Status;
import com.base.TestBase;
import com.utility.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ViewAttachedFile extends TestBase {

    @Test
    public void VIEW_ATTACHED_FILE() throws IOException, InterruptedException {
        test = extent.createTest("VIEW ATTACHED FILE");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://cicod.com/login");

        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        BrokenLink brokenLink = new BrokenLink(driver);
        ScreenShot screenShot = new ScreenShot(driver);
        Login login = new Login(driver);
        TabHandle tabHandle = new TabHandle(driver);

        login.LoginNexus();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Wfm_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("WorkOrderManager_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ManageWorkOrder_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("All_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Picker_XPATH"))).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("vIEWattachedFile_XPATH"))).click();
        test.log(Status.PASS, "Attached File Can be viewed");

        Thread.sleep(3000);
        System.out.println("********************VIEW ATTACHED FILE********************");
        driver.quit();
    }
}
