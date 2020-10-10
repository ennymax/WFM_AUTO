package com.Module.ManageWorkOrder;

import com.aventstack.extentreports.Status;
import com.base.TestBase;
import com.utility.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

public class CreateWorkOrder extends TestBase {

    @Test
    public void CREATE_WORK_ORDER() throws IOException, InterruptedException {
        test = extent.createTest("CREATE WORK ORDER");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        BrokenLink brokenLink = new BrokenLink(driver);
        ScreenShot screenShot = new ScreenShot(driver);
        Login login = new Login(driver);
        RandomStuff randomStuff = new RandomStuff();
        SecureRandom rn = new SecureRandom();
        int tom = rn.nextInt(15) + 1;

        login.LoginPremium();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Wfm_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("WorkOrderManager_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ManageWorkOrder_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("All_XPATH"))).click();

        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("NewRecord_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        Thread.sleep(2000);
        WebElement ele111 = driver.findElement(By.xpath(Utility.fetchLocator("Queue_XPATH")));
        Select sel11 = new Select(ele111);
        sel11.selectByVisibleText("Cicod");

        Thread.sleep(2000);
        WebElement ele11 = driver.findElement(By.xpath(Utility.fetchLocator("a_XPATH")));
        Select sel1 = new Select(ele11);
        sel1.selectByVisibleText("Sales");

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("Summary_XPATH_XPATH"))).sendKeys(Utility.fetchLocator("Summary_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Discription_XPATH"))).sendKeys(Utility.fetchLocator("Description_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("WfmEmail_XPATH"))).sendKeys(randomStuff.ListRandom() + "@gmail.com");
        driver.findElement(By.xpath(Utility.fetchLocator("CustomerName_XPATH"))).sendKeys(Utility.fetchLocator("CustomerName_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("ContactNumber_XPATH"))).sendKeys(Utility.fetchLocator("ContactPhoneNumber_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("AddressLine1_XPATH"))).sendKeys(Utility.fetchLocator("AddressLine1_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("AddressLine2_XPATH"))).sendKeys(Utility.fetchLocator("AddressLine1_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("city_XPATH"))).sendKeys(randomStuff.ListRandom());

        WebElement ele11lg = driver.findElement(By.xpath(Utility.fetchLocator("Region_XPATH")));
        Select sel1lg = new Select(ele11lg);
        sel1lg.selectByIndex(1);

        WebElement ele11l = driver.findElement(By.xpath(Utility.fetchLocator("Priority_XPATH")));
        Select sel1l = new Select(ele11l);
        sel1l.selectByIndex(1);

        driver.findElement(By.xpath(Utility.fetchLocator("CreateBtn_XPATH"))).click();

        Thread.sleep(2000);
        screenShot.ScreenShot();
        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertTrue_XPATH"))).size() != 0) {
            test.log(Status.PASS, "New WORK Order Created SuccessFULLY");
        } else {
            test.log(Status.FAIL, "Work Order Cant be Created");
        }

        driver.findElement(By.xpath(Utility.fetchLocator("OkBTN_XPATH"))).click();

        driver.quit();
        System.out.println("********************CREATE WORK ORDER********************");
    }
}
