package com.signup.step_definitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.signup.utils.ManageWebDriver;
import com.signup.pages.SignIn;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignInSteps {
	
	WebDriver driver = ManageWebDriver.getDriver();
	@Given("User is on the homepage")
    public void user_is_on_the_homepage() {
        driver.get("https://magento.softwaretestingboard.com/");
    }

    @When("User navigates to the sign in page")
    public void user_navigates_to_sign_in_page() {
        driver.findElement(By.cssSelector("body > div.page-wrapper > header > div.panel.wrapper > div > ul > li.authorization-link > a")).click();
    }

    @When("User signs in with valid credentials")
    public void User_signs_in_with_valid_credentials() {
    	SignIn signIn = new SignIn(driver);
    	signIn.emailAdd("harrynagar@gmail.com");
    	signIn.password("Harry@1721");
    	signIn.signInClick();
    }

    @Then("User should be redirected to the homepage after successful sign-in")
    public void User_should_be_redirected_to_homepage_after_successful_sign_in() {
        String successMessage = driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[1]/span")).getText();
        Assert.assertTrue(successMessage.contains("Welcome"));
    }

    @When("User signs in with invalid {string} and {string}")
    public void User_signs_in_with_invalid_username_and_password(String username, String password) {
        SignIn signIn = new SignIn(driver);
        signIn.emailAdd(username);
        signIn.password(password);
        signIn.signInClick();
    }

    @Then("User should see an error message indicating invalid sign-in")
    public void User_should_see_an_error_message_indicating_invalid_sign_in() {
        String errorMessage = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div")).getText();
        Assert.assertTrue(errorMessage.contains("The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later."));
    }


}
