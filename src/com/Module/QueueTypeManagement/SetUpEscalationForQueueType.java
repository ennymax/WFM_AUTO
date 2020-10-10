package com.Module.QueueTypeManagement;

import com.aventstack.extentreports.Status;
import com.base.TestBase;
import com.utility.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;

public class SetUpEscalationForQueueType extends TestBase {

    @Test
    public void SETUP_ESCALATION_FOR_QUEUE_TYPE() throws IOException, InterruptedException {
        test = extent.createTest("SETUP ESCALATION FOR QUEUE TYPE");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        Login login = new Login(driver);
        TabHandle tabHandle = new TabHandle(driver);
        RandomStuff randomStuff = new RandomStuff();
        RandomStuff randomNumbers = new RandomStuff();

        login.LoginPremium();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Wfm_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("WorkOrderManager_XPATH"))).click();

        Thread.sleep(1500);
        driver.findElement(By.xpath(Utility.fetchLocator("Manage_Queue_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("QueTypeUpdateActionBtn_XPATH"))).click();

        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("EscalationBTN_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ViewLevels_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("NewEscalationRecord_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Label_XPATH"))).sendKeys(Utility.fetchLocator("PshopName_TEXT") + randomNumbers.RandomNumbers());

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("TimeValue_XPATH"))).sendKeys(Utility.fetchLocator("High_TEXT") + randomNumbers.RandomNumbers());
        driver.findElement(By.xpath(Utility.fetchLocator("EscalationPriority_XPATH"))).sendKeys(Utility.fetchLocator("High_TEXT") + randomNumbers.RandomNumbers());

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Role1_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("CreateEscalation_XPATH"))).click();

        Thread.sleep(2000);
        WebElement msg1 =(new WebDriverWait(driver, 15)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchLocator("AssertEscalation_XPATH"))));
        String text1 = msg1.getText();
        if (msg1.isEnabled() && text1.contains("Successfully updated")) {
            test.log(Status.PASS, "Escalation setup was Successful");
        } else {
            test.log(Status.FAIL, "Escalation setup was Failed");
        }

        driver.findElement(By.xpath(Utility.fetchLocator("OKBTN1_XPATH"))).click();

        driver.quit();
        System.out.println("********************SET UP ESCALATION FOR QUEUE TYPE********************");
    }
}
