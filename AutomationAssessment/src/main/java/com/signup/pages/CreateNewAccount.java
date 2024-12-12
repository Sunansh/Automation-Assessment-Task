package com.signup.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateNewAccount {
	//creating driver instance through constructor
	WebDriver driver;
	public CreateNewAccount(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//Locators
	By fn = By.id("firstname");
	By ln = By.id("lastname");
	By email = By.id("email_address");
	By pass = By.id("password");
	By cnfpass = By.id("password-confirmation");
	By createaccbtn = By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button");
	
	//Actions
	public void firstName(String fName)
	{
		driver.findElement(fn).sendKeys(fName);
	}
	
	public void lastName(String lName)
	{
		driver.findElement(ln).sendKeys(lName);
	}
	
	public void emailAdd(String mail)
	{
		driver.findElement(email).sendKeys(mail);
	}
	
	public void password(String pwd)
	{
		driver.findElement(pass).sendKeys(pwd);
	}
	
	public void confirmPass(String cnfPassword)
	{
		driver.findElement(cnfpass).sendKeys(cnfPassword);
	}
	
	public void createAccount()
	{
		driver.findElement(createaccbtn).click();
	}

}
