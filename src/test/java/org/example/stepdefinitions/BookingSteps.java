package org.example.stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BookingSteps {

    WebDriver driver;
    By cnf = By.xpath("//p[@class='lead']");
    @Given("user launches the Cura Healthcare website")
    public void user_launches_the_website() {
        driver = new ChromeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();
    }

    @When("user logs in with valid credentials")
    public void user_logs_in() {
        driver.findElement(By.id("btn-make-appointment")).click();
        driver.findElement(By.id("txt-username")).sendKeys("John Doe");
        driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");
        driver.findElement(By.id("btn-login")).click();
    }

    @And("user selects the facility and date")
    public void select_facility_date() {
        driver.findElement(By.id("combo_facility")).sendKeys("Seoul CURA Healthcare Center");
        driver.findElement(By.id("txt_visit_date")).sendKeys("10/10/2025");
    }

    @And("user books the appointment")
    public void book_appointment() {
        driver.findElement(By.id("btn-book-appointment")).click();
    }

    @Then("appointment should be confirmed")
    public void verify_confirmation() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(cnf));
        String msg = driver.findElement(By.tagName("h2")).getText();
        System.out.println("Confirmation: " + msg);
        driver.quit();
    }
}
