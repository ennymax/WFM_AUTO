package com.Module.RightTemplate;

import com.aventstack.extentreports.Status;
import com.base.TestBase;
import com.utility.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;

public class UpdateRightTemplate extends TestBase {

    @Test
    public void UPDATE_RIGHT_TEMPLATE() throws IOException, InterruptedException {
        test = extent.createTest("UPDATE RIGHT TEMPLATE");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        Login login = new Login(driver);
        TabHandle tabHandle = new TabHandle(driver);
        RandomStuff randomStuff = new RandomStuff();

        login.LoginPremium();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Wfm_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("UserManagement_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("RightTemplateBTN_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("RightTemplateActionBTN_XPATH"))).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("UpdateRightTemplate_XPATH"))).click();

        Thread.sleep(1000);
        WebElement acj = driver.findElement(By.xpath(Utility.fetchLocator("RightTemplateDiscription_XPATH")));
        acj.clear();
        acj.sendKeys(Utility.fetchLocator("Decrib_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("CreateRightTemplateBTN_XPATH"))).click();

        Thread.sleep(2000);
        WebElement msg =(new WebDriverWait(driver, 45)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchLocator("AssertUpdateRightTemplateBTN_XPATH"))));
        String text = msg.getText();
        if (msg.isEnabled() && text.contains("Successful")) {
            test.log(Status.PASS, "Updated was Successful");
        } else {
            test.log(Status.FAIL, "Update Failed");
        }

        driver.findElement(By.xpath(Utility.fetchLocator("UpdateRightTemplateOKBTN_XPATH"))).click();

        driver.quit();
        System.out.println("********************UPDATE RIGHT TEMPLATE********************");
    }
}
