package com.Module.EscalationConfiguration;

import com.aventstack.extentreports.Status;
import com.base.TestBase;
import com.mifmif.common.regex.Generex;
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
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

public class CreateNewRegionToEscalation extends TestBase {

    String regex = "\\w{10}\\@gmail\\.com";
    String regex1 = "2637(1|3|7|8)\\d{7}";

    @Test
    public void CREATE_NEW_ESCALATION_ROLE() throws IOException, InterruptedException {
        test = extent.createTest("CREATE NEW ESCALATION ROLE");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        Login login = new Login(driver);
        TabHandle tabHandle = new TabHandle(driver);
        SecureRandom rn = new SecureRandom();
        int resourceshedule = rn.nextInt(3) + 1;

        login.LoginPremium();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Wfm_XPATH"))).click();

        Thread.sleep(1500);
        driver.findElement(By.xpath(Utility.fetchLocator("EscalationMainMenue_XPATH"))).click();

        Thread.sleep(1500);
        driver.findElement(By.xpath(Utility.fetchLocator("RegionToRoleBTN_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("NewRegionToRoleBTN_XPATH"))).click();

        Thread.sleep(2000);
        WebElement ele111 = driver.findElement(By.xpath(Utility.fetchLocator("RegionsBTN_XPATH")));
        ele111.click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("IbejuRegion_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Clicker_XPATH"))).click();

        Thread.sleep(2000);
        WebElement ele1111 = driver.findElement(By.xpath(Utility.fetchLocator("Role_XPATH")));
        Select sel111 = new Select(ele1111);
        sel111.selectByIndex(resourceshedule);

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("RegionEmail_XPATH"))).sendKeys(new Generex(regex).random());

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("CreateRegionToRole_XPATH"))).click();

        Thread.sleep(2000);
        WebElement msg =(new WebDriverWait(driver, 15)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchLocator("AssrtNewRegion_XPATH"))));
        String text = msg.getText();
        if (msg.isEnabled() && text.contains("Successful")) {
            test.log(Status.PASS, "New Region to Role was Created");
        } else {
            test.log(Status.FAIL, "Failed to create new region to Role");
        }

        driver.findElement(By.xpath(Utility.fetchLocator("OKBTN5_XPATH"))).click();

        driver.quit();
        System.out.println("********************CREATE NEW ROLE ESCALATION ROLE********************");
    }
}
