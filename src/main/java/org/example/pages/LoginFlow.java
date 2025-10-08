package org.example.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginFlow {
    WebDriver driver;
    String name ="John Doe";
    String pwd ="ThisIsNotAPassword";
    WebDriverWait wait;

    public LoginFlow(WebDriver driver) {
        this.driver = driver;
    }
       //Locators
    By username = By.xpath("//input[@id='txt-username']");
    By password = By.xpath("//input[@id='txt-password']");
    By submit = By.xpath("//button[@id='btn-login']");


    //Send username
    public  void sendUsername(){

        driver.findElement(username).sendKeys(name);
    }
    //SendPassword
    public void sendPassword(){
        driver.findElement(password).sendKeys(pwd);
    }
//Login button
    public void clickSubmit(){
        driver.findElement(submit).click();
    }
    public void waitForPageLoad(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

public void Loginpage()  {
        sendUsername();
        sendPassword();
        clickSubmit();
    waitForPageLoad();


}


}

