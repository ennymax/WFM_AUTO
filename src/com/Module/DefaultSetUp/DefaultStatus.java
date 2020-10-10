package com.Module.DefaultSetUp;

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

public class DefaultStatus extends TestBase {
    @Test
    public void DEFAULT_QUEUE_STATUES() throws IOException, InterruptedException {
        test = extent.createTest("DEFAULT QUEUE STATUES");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        ScreenShot screenShot = new ScreenShot(driver);
        Login login = new Login(driver);
        TabHandle tabHandle = new TabHandle(driver);

        login.LoginDef1();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Wfm_XPATH"))).click();

        Thread.sleep(1500);
        driver.findElement(By.xpath(Utility.fetchLocator("WorkOrderManagement_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ManageWorkOrderStatus_XPATH"))).click();

        Thread.sleep(1500);
        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertInProgress_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Status INPROGRESS is present as Default");
        } else {
            test.log(Status.FAIL, "Status INPROGRESS is not present as Default");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertDelivered_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Status DELIVERED is present as Default");
        } else {
            test.log(Status.FAIL, "Status DELIVERED is not present as Default");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertPackaging_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Status PACKAGING is present as Default");
        } else {
            test.log(Status.FAIL, "Status PACKAGING is not present as Default");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertInTransit_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Status IN TRANSIT is present as Default");
        } else {
            test.log(Status.FAIL, "Status IN TRANSIT is not present as Default");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertResolved_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Status RESOLVED is present as Default");
        } else {
            test.log(Status.FAIL, "Status RESOLVED is not present as Default");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertOpened_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Status OPEN is present as Default");
        } else {
            test.log(Status.FAIL, "Status OPEN is not present as Default");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertunderInvestigation_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Status UNDER INVESTIGATION is present as Default");
        } else {
            test.log(Status.FAIL, "Status UNDER INVESTIGATION is not present as Default");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertProccessing_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Status PROCESSING is present as Default");
        } else {
            test.log(Status.FAIL, "Status PROCESSING is not present as Default");
        }

        driver.quit();
        System.out.println("********************DEFAULT QUEUE STATUES********************");
    }
}
