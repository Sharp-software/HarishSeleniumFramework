package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.browser.DriverManager;

public class HomePage extends BasePge {
	
	@FindBy(xpath= "//*[@id='topnav']/tbody/tr[1]/td[1]/div/div[3]/img")
	WebElement logo;
	
	
	public String pageTitle(){
		return driver.getTitle();
	}
	
	public boolean logoDisplyad(){
		return logo.isDisplayed();
	}

}
