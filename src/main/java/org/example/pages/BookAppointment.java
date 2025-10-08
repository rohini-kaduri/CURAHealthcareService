package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class BookAppointment {

    private WebDriver driver;
    private static final Logger logger = LoggerFactory.getLogger(BookAppointment.class);
    private WebDriverWait wait;

    // Test data
    private String defaultFacility = "Hongkong CURA Healthcare Center";
    private String defaultDate = "31/12/1998";

    // Locators
    private By dropdown = By.id("combo_facility");
    private By checkbox = By.name("hospital_readmission");
    private By radiobutton = By.id("radio_program_medicaid");
    private By day = By.xpath("//input[@placeholder='dd/mm/yyyy']");
    private By commentbox = By.id("txt_comment");
    private By submitbutton = By.id("btn-book-appointment");

    public BookAppointment(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void selectFacility(String facility) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(dropdown));
        driver.findElement(dropdown).sendKeys(facility);
    }

    public void clickCheckbox() {
        if (driver.findElement(checkbox).isSelected()) {
            logger.info("Checkbox is already selected");
        } else {
            driver.findElement(checkbox).click();
            logger.info("Checkbox was not selected and now clicked");
        }
    }

    public void selectMedicaid() {
        driver.findElement(radiobutton).click();
    }

    public void setDate(String date) {
        driver.findElement(day).sendKeys(date);
    }

    public void setComment(String comment) {
        driver.findElement(commentbox).sendKeys(comment);
    }

    public void clickSubmitButton() {
        driver.findElement(submitbutton).click();
    }

    public void waitForPageLoad() {
        wait.until(ExpectedConditions.urlContains("summary"));
    }

    // Fill appointment using default data
    public void fillAppointmentPage() {
        selectFacility(defaultFacility);
        clickCheckbox();
        selectMedicaid();
        setDate(defaultDate);
        setComment("Filled successfully");
        clickSubmitButton();
        waitForPageLoad();
    }
}
