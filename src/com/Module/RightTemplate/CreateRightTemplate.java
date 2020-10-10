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

public class CreateRightTemplate extends TestBase {
    @Test
    public void CREATE_RIGHT_TEMPLATE() throws IOException, InterruptedException {
        test = extent.createTest("CREATE RIGHT TEMPLATE");
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
        driver.findElement(By.xpath(Utility.fetchLocator("NewRightTemplateBTN_XPATH"))).click();

        Thread.sleep(1400);
        driver.findElement(By.xpath(Utility.fetchLocator("RightTemplateName_XPATH"))).sendKeys(randomStuff.RandomWords());

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("RightTemplateDiscription_XPATH"))).sendKeys(Utility.fetchLocator("Dec_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ViewAllRightTemplate_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("CreateRightTemplateBTN_XPATH"))).click();

        Thread.sleep(2000);
        WebElement msg =(new WebDriverWait(driver, 45)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchLocator("AssertRightTemolateCreation_XPATH"))));
        String text = msg.getText();
        if (msg.isEnabled() && text.contains("Successful")) {
            test.log(Status.PASS, "Right Template Created Successfully");
        } else {
            test.log(Status.FAIL, "Right Template Can't be created");
        }

        driver.findElement(By.xpath(Utility.fetchLocator("RightTemplatOKBTN_XPATH"))).click();

        driver.quit();
        System.out.println("********************CREATE RIGHT TEMPLATE********************");
    }
}
