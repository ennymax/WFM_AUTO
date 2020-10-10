package com.Module.ManageWorkOrder;

import com.aventstack.extentreports.Status;
import com.base.TestBase;
import com.utility.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;

public class AdvancedSearch extends TestBase {
    @Test
    public void ADVANCED_SEARCH() throws IOException, InterruptedException {
        test = extent.createTest("ADD REMARK");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://internal.cicod.com/wfm-internal/index.php?r=site/login");

        BrokenLink brokenLink = new BrokenLink(driver);
        ScreenShot screenShot = new ScreenShot(driver);
        Login login = new Login(driver);
        TabHandle tabHandle = new TabHandle(driver);

        login.LoginWFM();

        driver.findElement(By.xpath(Utility.fetchLocator("AdvancedBTN_XPATH"))).click();

        Thread.sleep(2000);
        WebElement ele111 = driver.findElement(By.xpath(Utility.fetchLocator("SQueue_XPATH")));
        Select sel11 = new Select(ele111);
        sel11.selectByVisibleText("SAAS BUGS");

        Thread.sleep(2000);
        WebElement ele11 = driver.findElement(By.xpath(Utility.fetchLocator("SQueueType_XPATH")));
        Select sel1 = new Select(ele11);
        sel1.selectByVisibleText("WFM");

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("SStatus_XPATH"))).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("SOpen_XPATH"))).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("SFixed_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("SAddressLine1_XPATH"))).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("Ssdate_XPATH"))).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("ssdate_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("ClickOut_XPATH"))).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("Sddate_XPATH"))).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("Sdate_XPATH"))).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("SSearchBTN_XPATH"))).click();

        Thread.sleep(2000);
        WebElement msg =(new WebDriverWait(driver, 15)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchLocator("AssertAdvancedSearch_XPATH"))));
        String text = msg.getText();
        if (msg.isEnabled() && text.contains("Eniola Iyaomolere")) {
            test.log(Status.PASS, "Advanced Search was successful");
        } else {
            test.log(Status.FAIL, "Advanced Search Failed");
        }

        screenShot.ScreenShotFullPage();

        driver.quit();
        System.out.println("********************ADVANCED SEARCH TEST********************");
    }

}
