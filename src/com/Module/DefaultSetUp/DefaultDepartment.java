package com.Module.DefaultSetUp;

import com.aventstack.extentreports.Status;
import com.base.TestBase;
import com.utility.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import java.io.IOException;

public class DefaultDepartment extends TestBase {
    @Test
    public void DEFAULT_TEAMS() throws IOException, InterruptedException {
        test = extent.createTest("DEFAULT TEAMS");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        ScreenShot screenShot = new ScreenShot(driver);
        Login login = new Login(driver);
        TabHandle tabHandle = new TabHandle(driver);

        login.LoginDef1();

        Thread.sleep(200000000);
        driver.findElement(By.xpath(Utility.fetchLocator("Wfm_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("UserManagement_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Departmnet_XPATH"))).click();

        Thread.sleep(1500);
        if (driver.findElements(By.xpath(Utility.fetchLocator("Logistic_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Logistic is present as Default");
        } else {
            test.log(Status.FAIL, "Logistic is not present as Default");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("CustomerService_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Customer Service is present as Default");
        } else {
            test.log(Status.FAIL, "Customer Service is not present as Default");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("Sale_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Sales is present as Default");
        } else {
            test.log(Status.FAIL, "Sales is not present as Default");
        }

        driver.quit();
        System.out.println("********************DEFAULT TEAMS********************");
    }
}
