package com.Module.ResourceAllocationManagement;

import com.aventstack.extentreports.Status;
import com.base.TestBase;
import com.utility.Login;
import com.utility.TabHandle;
import com.utility.Utility;
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

public class UpdateResouceLevel extends TestBase {

    @Test
    public void Update_RESOURCE_LEVEL() throws IOException, InterruptedException {
        test = extent.createTest("Update RESOURCE LEVEL");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        Login login = new Login(driver);
        TabHandle tabHandle = new TabHandle(driver);

        login.LoginPremium();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Wfm_XPATH"))).click();

        Thread.sleep(3000);
        driver.findElement(By.xpath(Utility.fetchLocator("ResourceManagement_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ManageResouceLevel_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ActionUpdateResourLevel_XPATH"))).click();

        Thread.sleep(1000);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("UpdateResourceLevel_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        Thread.sleep(1000);
        WebElement aal = driver.findElement(By.xpath(Utility.fetchLocator("ResourceLevelDiscription_XPATH")));
        aal.clear();
        aal.sendKeys(Utility.fetchLocator("Decrib_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("CreateResourceLevelBTN_XPATH"))).click();

        Thread.sleep(2000);
        WebElement msg =(new WebDriverWait(driver, 45)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchLocator("AssertSuccessUpdateCreated_XPATH"))));
        String text = msg.getText();
        if (msg.isEnabled() && text.contains("Successful")) {
            test.log(Status.PASS, "Update Resource Level Successfully");
        } else {
            test.log(Status.FAIL, "Update Resource level Failed");
        }

        driver.findElement(By.xpath(Utility.fetchLocator("ResourceLevelOKBTN_XPATH"))).click();

        driver.quit();
        System.out.println("********************UPDATE RESOURCE LEVEL********************");
    }
}
