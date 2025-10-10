package org.example.stepdefinitions;

import io.cucumber.java.en.*;

public class LoginSteps {

    @Given("User is on login page")
    public void user_is_on_login_page() {
        System.out.println("Navigated to login page");
    }

    @When("User enters valid username and password")
    public void user_enters_valid_username_and_password() {
        System.out.println("Entered credentials");
    }

    @Then("User should be redirected to the dashboard")
    public void user_should_be_redirected_to_dashboard() {
        System.out.println("Login successful");
    }
}
