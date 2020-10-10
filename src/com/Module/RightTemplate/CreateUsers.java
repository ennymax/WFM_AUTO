package com.Module.RightTemplate;

import com.aventstack.extentreports.Status;
import com.base.TestBase;
import com.utility.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.security.SecureRandom;

public class CreateUsers extends TestBase {
    @Test
    public void CREATE_USER() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("CREATE USER");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        Login login = new Login(driver);
        TabHandle tabHandle = new TabHandle(driver);
        RandomStuff randomStuff = new RandomStuff();
        FileUpload fileUpload = new FileUpload();
        RandomStuff randomNumbers = new RandomStuff();

        SecureRandom rn = new SecureRandom();
        int resourcetype = rn.nextInt(3) + 1;

        login.LoginNexus();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Wfm_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("UserManagement_XPATH"))).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("Usr_XPATH"))).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("RightTemplateUser_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("NewUserFname_XPATH"))).sendKeys(randomStuff.ListRandom());

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("NewUserLastName_XPATH"))).sendKeys(randomStuff.ListRandom());

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("NewUserEmail_XPATH"))).sendKeys(randomStuff.ListRandom() + "@gmail.com");

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("NewUserPhone_XPATH"))).sendKeys(Utility.fetchLocator("ContactPhoneNumber_TEXT"));

        Thread.sleep(1000);
        WebElement ele1111 = driver.findElement(By.xpath(Utility.fetchLocator("NewUserRightTemplate_XPATH")));
        Select sel111 = new Select(ele1111);
        sel111.selectByIndex(resourcetype);

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("NewUserDepartment_XPATH"))).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("NewUserA1_XPATH"))).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("NewUserA2_XPATH"))).click();

        Thread.sleep(2000);
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.xpath("//input[@type='file']"))).click().build().perform();

        fileUpload.UploadFileImage3MB();
        test.log(Status.PASS, "Profile Picture Of Resource Uploaded Successfully");

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("NewUserStaffID_XPATH"))).sendKeys(Utility.fetchLocator("High_TEXT") + randomNumbers.RandomNumbers());

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("NewserJobTittle_XPATH"))).sendKeys(Utility.fetchLocator("High_TEXT") + randomStuff.ListRandom());

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("NewUserRegion_XPATH"))).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("Newq11_XPATH"))).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("CreateNewUser_XPATH"))).click();

        Thread.sleep(2000);
        WebElement msg =(new WebDriverWait(driver, 15)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchLocator("AssertNewUserCreation_XPATH"))));
        String text = msg.getText();
        if (msg.isEnabled() && text.contains("Successfully created")) {
            test.log(Status.PASS, "New User Created successfully");
        } else {
            test.log(Status.FAIL, "User Creation Failed");
        }

        driver.findElement(By.xpath(Utility.fetchLocator("NewUserOKBTN_XPATH"))).click();

        driver.quit();
        System.out.println("********************CREATE USER********************");
    }
}
