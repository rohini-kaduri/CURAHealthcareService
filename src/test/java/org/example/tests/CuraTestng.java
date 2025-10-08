package org.example.tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pages.BookAppointment;
import org.example.pages.LoginFlow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class CuraTestng {
    WebDriver driver;

    @BeforeMethod
public void setDriver() {
    WebDriverManager.chromedriver().setup();
     driver = new ChromeDriver();
    //launch website
     driver.get("https://katalon-demo-cura.herokuapp.com");
    //maximize the page
    driver.manage().window().fullscreen();
}
    //webdriver object

    @Test
            public void BookAppointment() throws InterruptedException {
                driver.findElement(By.id("btn-make-appointment")).click();

                LoginFlow LoginFlowobj = new LoginFlow(driver);
                LoginFlowobj.Loginpage();

                BookAppointment bookAppointmentobj = new BookAppointment(driver);
                bookAppointmentobj.fillAppointmentPage();

                //assert login pageload
                String url = driver.getCurrentUrl();
                Assert.assertTrue(url.contains("appointment"), "Page not loaded");

        WebElement cnf = bookAppointmentobj.waitForPageLoad();
        Assert.assertTrue(cnf.isDisplayed(), "Summary page did not load!");


                  }
    @AfterMethod
    public void tearDown()
    {
        if(driver!=null)
        driver.quit();
    }





}

