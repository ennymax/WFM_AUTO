package com.Module.ResourceAllocationManagement;

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

public class CreateNewResource extends TestBase {

    String regex1 = "2637(1|3|7|8)\\d{7}";

    @Test
    public void CREATE_NEW_RESOURCE() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("CREATE NEW RESOURCE");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        Login login = new Login(driver);
        TabHandle tabHandle = new TabHandle(driver);
        FileUpload fileUpload = new FileUpload();

        SecureRandom rn = new SecureRandom();
        int state = rn.nextInt(35) + 1;
        int resourcetype = rn.nextInt(7) + 1;
        int resourcelevel = rn.nextInt(6) + 1;
        int resourceshedule = rn.nextInt(5) + 1;
        int tom = rn.nextInt(999999999) + 1;
        RandomStuff randomStuff = new RandomStuff();
        RandomStuff rrandomStuff = new RandomStuff();

        login.LoginNexus();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Wfm_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ResourceManagement_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ManageResourceBTN_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("NewREsourcs_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("ResourceFirstName_XPATH"))).sendKeys(randomStuff.ListRandom());

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("ResourceLastName_XPATH"))).sendKeys(rrandomStuff.ListRandom());

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("ResourceEmail_XPATH"))).sendKeys(randomStuff.ListRandom() + "@gmail.com");

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("ResourcePhoneNumber_XPATH"))).sendKeys(Utility.fetchLocator("ContactPhoneNumber_TEXT"));

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("ResourceStaffID_XPATH"))).sendKeys(Utility.fetchLocator("High_TEXT") + randomStuff.RandomNumbers());

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("JobTitle_XPATH"))).sendKeys(Utility.fetchLocator("High_TEXT") + randomStuff.ListRandom());

        Thread.sleep(2000);
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.xpath("//input[@type='file']"))).click().build().perform();

        fileUpload.UploadFileImage3MB();
        test.log(Status.PASS, "Profile Picture Of Resource Uploaded Successfully");

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("NextOfKin_XPATH"))).sendKeys(Utility.fetchLocator("CustomerName_TEXT"));

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("NextOfKinPhoneNumber_XPATH"))).sendKeys(Utility.fetchLocator("ContactPhoneNumber_TEXT"));

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("ResourceAddressLine1_XPATH"))).sendKeys(Utility.fetchLocator("AddressLine1_TEXT"));

        Thread.sleep(1200);
        driver.findElement(By.xpath(Utility.fetchLocator("ResourceAddressLine2_XPATH"))).sendKeys(Utility.fetchLocator("AddressLine1_TEXT"));

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("City_XPATH"))).sendKeys(Utility.fetchLocator("City_TEXT"));

        WebElement ele111 = driver.findElement(By.xpath(Utility.fetchLocator("State_XPATH")));
        Select sel11 = new Select(ele111);
        sel11.selectByIndex(state);

        Thread.sleep(1000);
        WebElement ele1111 = driver.findElement(By.xpath(Utility.fetchLocator("ResourceType_XPATH")));
        Select sel111 = new Select(ele1111);
        sel111.selectByIndex(resourcetype);

        Thread.sleep(1000);
        WebElement ele11111 = driver.findElement(By.xpath(Utility.fetchLocator("ResourceLevel_XPATH")));
        Select sel1111 = new Select(ele11111);
        sel1111.selectByIndex(resourcelevel);

        Thread.sleep(1000);
        WebElement ele1111111 = driver.findElement(By.xpath(Utility.fetchLocator("ResourceSdedule_XPATH")));
        Select sel111111 = new Select(ele1111111);
        sel111111.selectByIndex(resourceshedule);

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("JoinDate_XPATH"))).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("Joinday_XPATH"))).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("ResourceDepartment_XPATH"))).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("BillingDepartment_XPATH"))).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("EngineeringDepartment_XPATH"))).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("CreateResourceBTN_XPATH"))).click();

        Thread.sleep(2000);
        WebElement msg =(new WebDriverWait(driver, 15)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchLocator("AssertResourcesCreation_XPATH"))));
        String text = msg.getText();
        if (msg.isEnabled() && text.contains("Successfully created")) {
            test.log(Status.PASS, "New Resources Created successfully");
        } else {
            test.log(Status.FAIL, "Resources Creation Failed");
        }

        driver.findElement(By.xpath(Utility.fetchLocator("CreateOKBTN_XPATH"))).click();

        driver.quit();
        System.out.println("********************CREATE NEW RESOURCE********************");
    }
}
