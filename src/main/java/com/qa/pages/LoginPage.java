package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.browser.DriverFactory;
import com.qa.browser.DriverManager;

public class LoginPage extends BasePge  {


	@FindBy(xpath="//input[@type='checkbox']")
	WebElement checkBox;
	
	@FindBy(name="username")
	WebElement usernameofActi;
	
	@FindBy(name="pwd")
	WebElement pwd;
	
	@FindBy(xpath="//*[@id='loginButton']/div")
	WebElement login;
	
	@FindBy(xpath="//label[@id='keepLoggedInLabel']")
	WebElement keepme;
	
	@FindBy(xpath="//span[@class='errormsg']")
	WebElement errormessage;
	
	public HomePage dologine(String username, String password) throws Exception{
		sendKeys(usernameofActi, username);
		sendKeys(pwd, password);
		click(login);
		return new HomePage();
	}
	
	
	public boolean keepmetest() throws Exception{
		return isDisplayed(keepme);
	}
	
	public String errormsg(String username, String password) throws Exception{
		sendKeys(usernameofActi, username);
		sendKeys(pwd, password);
		click(login);
		return getText(errormessage);
	}

}
