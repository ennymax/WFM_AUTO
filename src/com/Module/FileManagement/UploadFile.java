package com.Module.FileManagement;

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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.awt.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class UploadFile extends TestBase {

    @Test
    public void UPLOAD_FILE() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("UPLOAD FILE");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://cicod.com/login");

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        BrokenLink brokenLink = new BrokenLink(driver);
        ScreenShot screenShot = new ScreenShot(driver);
        Login login = new Login(driver);
        TabHandle tabHandle = new TabHandle(driver);
        FileUpload fileUpload = new FileUpload();

        login.LoginNexus();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Wfm_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("WorkOrderManager_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ManageWorkOrder_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("All_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Picker2_XPATH"))).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("Uploader_XPATH"))).click();

        Thread.sleep(2000);
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.xpath("//input[@type='file']"))).click().build().perform();

        fileUpload.UploadFileImage3MB();

        Thread.sleep(1000);
        driver.findElement(By.xpath(Utility.fetchLocator("UploadUpload_XPATH"))).click();
        test.log(Status.PASS, "File Download functional");

        Thread.sleep(2000);
        WebElement msg =(new WebDriverWait(driver, 15)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchLocator("assertFilupload_XPATH"))));
        String text = msg.getText();
        if (msg.isEnabled() && text.contains("Successful")) {
            test.log(Status.PASS, "FileUpload was successful");
        } else {
            test.log(Status.FAIL, "FileUpload Failed");
        }


        if (driver.findElements(By.xpath(Utility.fetchLocator("assertTrue_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Upload Validation was successful");
        } else {
            test.log(Status.FAIL, "Validation Failed");
        }

        Thread.sleep(3000);
        System.out.println("********************FILE UPLOAD********************");
        driver.quit();
    }
}
