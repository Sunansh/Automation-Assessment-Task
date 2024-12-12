package com.signup.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ManageWebDriver {
	
	static WebDriver driver;
	
	public static WebDriver getDriver()
	{
		if(driver == null)
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		return driver;
	}
	
	public static void quitDriver()
	{
		if(driver != null)
		{
			driver.quit();
			driver = null;
		}
	}

}
