package com.utility;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Login {
    WebDriver driver;

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void AcceptAlert() throws IOException, InterruptedException {
        if (driver.switchTo().alert() != null)//switches only if alert is displayed
        {
            Alert alert = driver.switchTo().alert();
            alert.accept(); // alert.accept();
        }
    }

    public void AlertDismis() throws IOException, InterruptedException {
        if (driver.switchTo().alert() != null) {
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
        }
    }

    public void LoginDef1()  throws IOException, InterruptedException  {
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Utility.fetchLocator("DomainName_XPATH"))).sendKeys(Utility.fetchLocator("DefaultShop_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Email_XPATH"))).sendKeys(Utility.fetchLocator("Defem_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Password_XPATH"))).sendKeys(Utility.fetchLocator("defpass_TEXT"));
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("LoginBTN_XPATH"))).click();
    }

    public void LoginNexus()  throws IOException, InterruptedException  {
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Utility.fetchLocator("DomainName_XPATH"))).sendKeys(Utility.fetchLocator("NexusDomainName1_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Email_XPATH"))).sendKeys(Utility.fetchLocator("NexusEmail1_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Password_XPATH"))).sendKeys(Utility.fetchLocator("NexusPassword1_TEXT"));
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("LoginBTN_XPATH"))).click();
    }

    public void LoginDefault()  throws IOException, InterruptedException  {
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Utility.fetchLocator("DomainName_XPATH"))).sendKeys(Utility.fetchLocator("DefaultShopName_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Email_XPATH"))).sendKeys(Utility.fetchLocator("DefaultEmail_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Password_XPATH"))).sendKeys(Utility.fetchLocator("DefaultPassWord_TEXT"));
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("LoginBTN_XPATH"))).click();
    }

    public void LoginPremium() throws IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Utility.fetchLocator("DomainName_XPATH"))).sendKeys(Utility.fetchLocator("PshopName_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Email_XPATH"))).sendKeys(Utility.fetchLocator("Pemail_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Password_XPATH"))).sendKeys(Utility.fetchLocator("Ppassword_TEXT"));
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("LoginBTN_XPATH"))).click();
    }

    public void LoginWFM() throws IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Utility.fetchLocator("interEmail_XPATH"))).sendKeys(Utility.fetchLocator("WfmEmail1_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("interPassword_XPATH"))).sendKeys(Utility.fetchLocator("WfmPassword1_TEXT"));
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("interLoginBTN_XPATH"))).click();
    }
}
