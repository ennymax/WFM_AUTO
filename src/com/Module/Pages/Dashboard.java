package com.Module.Pages;

import com.aventstack.extentreports.Status;
import com.base.TestBase;
import com.utility.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import java.io.IOException;

public class Dashboard extends TestBase {

    @Test
    public void ASSERT_DASHBOARD() throws IOException, InterruptedException {
        test = extent.createTest("ASSERT DASHBOARD");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        BrokenLink brokenLink = new BrokenLink(driver);
        ScreenShot screenShot = new ScreenShot(driver);
        Login login = new Login(driver);
        TabHandle tabHandle = new TabHandle(driver);

        login.LoginPremium();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Wfm_XPATH"))).click();

        if (driver.findElements(By.xpath(Utility.fetchLocator("assersetUpescalation_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Set Up Escalation is displayed and enabled");
        } else {
            test.log(Status.FAIL, "Set Up escalation is not displayed and enabled");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertConfigureResources_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Configure Resources is displayed and enabled");
        } else {
            test.log(Status.FAIL, "Configure Resources is not displayed and enabled");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertCreateTypesAndAccess_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Create Type and access is displayed and enabled");
        } else {
            test.log(Status.FAIL, "Create Type and access is displayed and enabled");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertSetUpBusiness_XPATH"))).size() != 0) {
            test.log(Status.PASS, "SetUp Business Life Cycle is displayed abd enabled");
        } else {
            test.log(Status.FAIL, "SetUp Business Life Cycle is not displayed and Enabled");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertSetUpBusinessLifeCycle_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Business Life Cycle is displayed and enabled");
        } else {
            test.log(Status.FAIL, "Business life Cycle is not displayed and enabled");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertSetUpWoflow_XPATH"))).size() != 0) {
            test.log(Status.PASS, "SetUp workflow is displayed and enabled");
        } else {
            test.log(Status.FAIL, "SetUp workflow is not displayed and enabled");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertWatchVideo_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Watch Video Feature is displayed and enabled");
        } else {
            test.log(Status.FAIL, "RavePayment Page wasn't displayed");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AsserLearnMoreCicodSupport_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Learn more cicod support is displayed and enabled");
        } else {
            test.log(Status.FAIL, "Learn more cicod support is not displayed and enabled");
        }

        driver.quit();
        System.out.println("********************ASSERT DASHBOARD********************");
    }
}
