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

public class DefaultQueueType extends TestBase {

    @Test
    public void DEFAULT_QUEUE_TYPE() throws IOException, InterruptedException {
        test = extent.createTest("DEFAULT QUEUE TYPE");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        ScreenShot screenShot = new ScreenShot(driver);
        Login login = new Login(driver);
        TabHandle tabHandle = new TabHandle(driver);

        login.LoginDef1();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Wfm_XPATH"))).click();

        Thread.sleep(1500);
        driver.findElement(By.xpath(Utility.fetchLocator("WorkOrderManagement_XPATH"))).click();

        Thread.sleep(1500);
        driver.findElement(By.xpath(Utility.fetchLocator("ManageQueueTypeBTN_XPATH"))).click();

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertOrderFulmentPickUp_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Order Fulfilment PickUp Queue Type is present as Default");
        } else {
            test.log(Status.FAIL, "Order Fulfilment PickUp Queue Type is not present as Default");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertOrderFulmentDelivery_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Order Fulfilment Delivery Queue Type is present as Default");
        } else {
            test.log(Status.FAIL, "Order Fulfilment Delivery Queue Type is not present as Default");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AsserOrderFulfilmentOnline_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Order Fulfilment Online Queue Type is present as Default");
        } else {
            test.log(Status.FAIL, "Order Fulfilment Online Queue Type is not present as Default");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertPersonnelComplaint_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Personal Complain Queue Type is present as Default");
        } else {
            test.log(Status.FAIL, "Personal Complain Queue Type is not present as Default");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertFinancePAyment_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Finance Payment Queue Type is present as Default");
        } else {
            test.log(Status.FAIL, "Finance Payment Queue Type is not present as Default");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertDeliveryComplaint_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Delivery Complaint Queue Type is present as Default");
        } else {
            test.log(Status.FAIL, "Delivery Complaint Queue Type is not present as Default");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertProductComplaint_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Complaint Product services Queue Type is present as Default");
        } else {
            test.log(Status.FAIL, "Complaint Product services Queue Type is not present as Default");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertComplaintDuplicateTransaction_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Complaint Duplicate Transactions Queue Type is present as Default");
        } else {
            test.log(Status.FAIL, "Complaint Duplicate Transactions Queue Type is not present as Default");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertComplaintBillingIssue_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Complaint Billing Queue Type is present as Default");
        } else {
            test.log(Status.FAIL, "Complaint Billing Queue Type is not present as Default");
        }

        Thread.sleep(999);

        driver.quit();
        System.out.println("********************DEFAULT QUEUE TYPE********************");
    }
}
