package com.signup.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignIn {
	
	//creating driver instance through constructor
		WebDriver driver;
		public SignIn(WebDriver driver)
		{
			this.driver = driver;
		}
		
		//Locators
		By email = By.id("email");
		By pass = By.id("pass");
		By sginbtn = By.xpath("//*[@id=\"send2\"]");
		
		//Actions		
		public void emailAdd(String mail)
		{
			driver.findElement(email).sendKeys(mail);
		}
		
		public void password(String pwd)
		{
			driver.findElement(pass).sendKeys(pwd);
		}
		
		public void signInClick()
		{
			driver.findElement(sginbtn).click();
		}

}
