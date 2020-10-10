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

public class UpdateWorkOrder extends TestBase {

    @Test
    public void UPDATE_WORKORDER() throws IOException, InterruptedException {
        test = extent.createTest("UPDATE WORK ORDER");
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
        driver.findElement(By.xpath(Utility.fetchLocator("UpdateWorkOrder_XPATH"))).click();

        Thread.sleep(2000);
        screenShot.ScreenShot();
        driver.findElement(By.xpath(Utility.fetchLocator("CreateBtn_XPATH"))).click();

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertTrue_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Update WorkOrder was Successful SuccessFULLY");
        } else {
            test.log(Status.FAIL, "Update Work Order Failed");
        }

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("OkBTN_XPATH"))).click();

        driver.quit();
        System.out.println("********************UPDATE WORK ORDER TEST********************");
    }
}
