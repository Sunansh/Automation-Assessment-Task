package com.signup.step_definitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.signup.pages.CreateNewAccount;
import com.signup.utils.ManageWebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class AccountCreationSteps {
	
	WebDriver driver = ManageWebDriver.getDriver();
	@Given("User on the homepage")
    public void user_on_the_homepage() {
        driver.get("https://magento.softwaretestingboard.com/");
    }

    @When("User navigates to the create account page")
    public void user_navigates_to_create_account_page() {
        driver.findElement(By.cssSelector("body > div.page-wrapper > header > div.panel.wrapper > div > ul > li:nth-child(3) > a")).click();
    }

    @When("User fills in the registration form with valid details")
    public void User_fills_registration_form_with_valid_details() {
	String randomMail = "user" + UUID.randomUUID().toString() + "@gmail.com";
        CreateNewAccount createNewAccount = new CreateNewAccount(driver);
        createNewAccount.firstName("Sunansh");
        createNewAccount.lastName("Nagar");
        createNewAccount.emailAdd(randomMail);
        createNewAccount.password("Password@123");
        createNewAccount.confirmPass("Password@123");
        createNewAccount.createAccount();
    }

    @Then("User should see a success message indicating account creation is successful")
    public void User_should_see_success_message_indicating_registration_is_successful() {
        String successMessage = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")).getText();
        Assert.assertTrue(successMessage.equals("Thank you for registering with Main Website Store."));
    }

    @When("User fills in the registration form with missing {string}")
    public void User_fill_registration_form_with_missing_field(String field) {
        CreateNewAccount createNewAccount = new CreateNewAccount(driver);

        // Fill in the form, leaving the specified field blank
        createNewAccount.firstName("Sunansh");
        createNewAccount.lastName("Nagar");
        createNewAccount.emailAdd("sn@gmail.com");
        createNewAccount.password("Password@123");
        createNewAccount.confirmPass("Password@123");

        switch (field) {
            case "firstname":
                createNewAccount.firstName(""); // Leave first name blank
                break;
            case "lastname":
                createNewAccount.lastName(""); // Leave last name blank
                break;
            case "email_address":
                createNewAccount.emailAdd(""); // Leave email blank
                break;
            case "password":
                createNewAccount.password(""); // Leave password blank
                break;
            case "password_confirmation":
                createNewAccount.confirmPass(""); // Leave confirm password blank
                break;
            default:
                throw new IllegalArgumentException("Unexpected value: " + field);
        }

        createNewAccount.createAccount();
    }

    @Then("User should see an error message indicating {string} is required")
    public void User_should_see_error_message_indicating_field_is_required(String field) {
        String errorMessage = "";

        // Different XPaths for different fields
        switch (field) {
            case "firstname":
                errorMessage = driver.findElement(By.xpath("//*[@id=\"firstname-error\"]")).getText();
                break;
            case "lastname":
                errorMessage = driver.findElement(By.xpath("//*[@id=\"lastname-error\"]")).getText();
                break;
            case "email_address":
                errorMessage = driver.findElement(By.xpath("//*[@id=\"email_address-error\"]")).getText();
                break;
            case "password":
                errorMessage = driver.findElement(By.xpath("//*[@id=\"password-error\"]")).getText();
                break;
            case "password_confirmation":
                errorMessage = driver.findElement(By.xpath("//*[@id=\"password-confirmation-error\"]")).getText();
                break;
            default:
                throw new IllegalArgumentException("Unexpected field: " + field);
        }

        // Assert that the error message contains the appropriate field name
        Assert.assertTrue(errorMessage.equals("This is a required field."));
    }

    @When("User fills in the registration form with an invalid email {string}")
    public void i_fill_in_the_registration_form_with_an_invalid_email(String email) {
        CreateNewAccount createNewAccount = new CreateNewAccount(driver);
        createNewAccount.firstName("Sunansh");
        createNewAccount.lastName("Nagar");
        createNewAccount.emailAdd(email);
        createNewAccount.password("Password@123");
        createNewAccount.confirmPass("Password@123");
        createNewAccount.createAccount();
    }

    @Then("User should see an error message indicating invalid email format")
    public void User_should_see_error_message_indicating_invalid_email_format() {
        String errorMessage = driver.findElement(By.id("email_address-error")).getText();
        Assert.assertTrue(errorMessage.contains("Please enter a valid email address"));
    }

    @When("User fills in the registration form with a weak password {string}")
    public void User_fill_registration_form_with_weak_password(String password) {
        CreateNewAccount createNewAccount = new CreateNewAccount(driver);
        createNewAccount.firstName("Sunansh");
        createNewAccount.lastName("Nagar");
        createNewAccount.emailAdd("sn@gmail.com");
        createNewAccount.password(password);
        createNewAccount.confirmPass(password);
        createNewAccount.createAccount();
    }

    @Then("User should see an error message indicating weak password")
    public void User_should_see_error_message_indicating_weak_password() {
        String errorMessage = driver.findElement(By.id("password-strength-meter")).getText();
        Assert.assertTrue(errorMessage.contains("Password Strength: Weak"));
    }

    @When("User fills in the registration form with an already registered email {string}")
    public void User_fills_registration_form_with_already_registered_email(String email) {
        CreateNewAccount createNewAccount = new CreateNewAccount(driver);
        createNewAccount.firstName("Sunansh");
        createNewAccount.lastName("Nagar");
        createNewAccount.emailAdd(email);
        createNewAccount.password("Password@123");
        createNewAccount.confirmPass("Password@123");
        createNewAccount.createAccount();
    }

    @Then("User should see an error message indicating that there is already an existing account with this email address")
    public void User_should_see_error_message_indicating_that_account_already_exists_with_this_email() {
        String errorMessage = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div")).getText();
        Assert.assertTrue(errorMessage.contains("There is already an account with this email address."));
    }
    
    @When("User fills in the registration form with mismatched passwords")
    public void User_fills_registration_form_with_mismatched_passwords() {
        CreateNewAccount createNewAccount = new CreateNewAccount(driver);
        createNewAccount.firstName("Sunansh");
        createNewAccount.lastName("Nagar");
        createNewAccount.emailAdd("sn@gmail.com");
        createNewAccount.password("Password@123");
        createNewAccount.confirmPass("Password@123456");
        createNewAccount.createAccount();
    }

    @Then("User should see an error message indicating mismatched passwords")
    public void User_should_see_error_message_indicating_mismatched_passwords() {
        String errorMessage = driver.findElement(By.xpath("//*[@id=\"password-confirmation-error\"]")).getText();
        Assert.assertTrue(errorMessage.contains("Please enter the same value again"));
    }
}
