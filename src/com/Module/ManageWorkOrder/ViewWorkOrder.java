package com.Module.ManageWorkOrder;

import com.aventstack.extentreports.Status;
import com.base.TestBase;
import com.utility.BrokenLink;
import com.utility.Login;
import com.utility.ScreenShot;
import com.utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class ViewWorkOrder extends TestBase {

    @Test
    public void VIEW_WORK_ORDER() throws IOException, InterruptedException {
        test = extent.createTest("VIEW WORK ORDER");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        BrokenLink brokenLink = new BrokenLink(driver);
        ScreenShot screenShot = new ScreenShot(driver);
        Login login = new Login(driver);

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
        driver.findElement(By.xpath(Utility.fetchLocator("ActionBTN_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ViewWorkOrder_XPATH"))).click();

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertPortlet_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Portlet is Displayed and Enabled");
        } else {
            test.log(Status.FAIL, "Portlet Failed");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertDescriptionSummary_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Description Summary is displayed and Enabled");
        } else {
            test.log(Status.FAIL, "Description Summary not Displayed and enabled");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertUpdateHistory_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Update History is Displayed and Enabled");
        } else {
            test.log(Status.FAIL, "Update History is not Displayed and Enabled");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertRedmarker_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Remark is displayed and enabled");
        } else {
            test.log(Status.FAIL, "Remark is not displayed and enabled");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertFile_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Attached File is displayed and Enabled");
        } else {
            test.log(Status.FAIL, "Attached file not displayed and enabled");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertRequestInventry_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Request inventory is displayed and Enabled");
        } else {
            test.log(Status.FAIL, "Request inventory not displayed and enabled");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertBOM_XPATH"))).size() != 0) {
            test.log(Status.PASS, "BOM is displayed and Enabled");
        } else {
            test.log(Status.FAIL, "BOM not displayed and enabled");
        }

        driver.quit();
        System.out.println("********************VIEW WORK ORDER********************");
    }
}
