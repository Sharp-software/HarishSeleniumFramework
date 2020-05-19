package com.qa.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.browser.DriverFactory;

public class BasePge extends DriverFactory{
	Logger log = Logger.getLogger(this.getClass());
	
	public BasePge(){
		PageFactory.initElements(driver, this);
	}
	
	public static  void explicitlyWait(WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,com.qa.utils.Constants.EXPLICIT_WAIT);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void click(WebElement element) throws Exception{
		int attempts = 0;
		while (attempts < 3) {
			try {
				element.clear();
				break;
			} catch (StaleElementReferenceException e) {
				attempts++;
			} catch (WebDriverException e) {
				attempts++;
			}
		}
		if (attempts == 3) {
			throw new Exception("Failed to retrieve attibute post stale element exception and 2 retries.");
		}
	}
	
	
	public void sendKeys(WebElement element, String value) throws Exception {
		int attempts = 0;
		while (attempts < 3) {
			try {
				element.sendKeys(value);
				Thread.sleep(2000);
				break;
			} catch (StaleElementReferenceException e) {
				attempts++;
			}
		}
		if (attempts == 3) {
			throw new Exception("Failed to retrieve attibute post stale element exception and 2 retries.");
		}
	}
	
	public void sendKeys(WebElement element, Keys key){
		Actions actn = new Actions(driver);
		actn.sendKeys(key).build().perform();
	}
	
	public  String getText(WebElement element) throws Exception {
		int attempts = 0;
		while (attempts < 3) {
			try {
				return element.getText();
			} catch (StaleElementReferenceException e) {
				attempts++;
			}
		}
		throw new Exception("Failed to retrieve attibute post stale element exception and 2 retries.");
	}
	
	public boolean isSelected(WebElement element) throws Exception{
		boolean flag = true;
		explicitlyWait(element);
		try {
			element.isSelected();
			flag= true;
		} catch (Exception e) {
			throw new Exception("Please specify the currect element locator");
		}
		return flag;
	}
	
	public boolean isDisplayed(WebElement element) throws Exception{
		boolean flag = true;
		explicitlyWait(element);
		try {
			element.isDisplayed();
			flag= true;
		} catch (Exception e) {
			throw new Exception("Please specify the currect element locator");
		}
		return flag;
	}
	
	public static boolean isEnabled(WebElement element) throws Exception{
		boolean flag = true;
		explicitlyWait(element);
		try {
			element.isEnabled();
			flag= true;
		} catch (Exception e) {
			throw new Exception("Please specify the currect element locator");
		}
		return flag;
	}
	
	public String getAttribute(WebElement element, String AttributeName) throws Exception{
		int attempts = 0;
		while (attempts < 2) {
			try {
				return element.getAttribute(AttributeName);
			} catch (StaleElementReferenceException e) {
				attempts++;
			}
		}
		throw new Exception("Failed to retrieve attibute post stale element exception and 2 retries.");
	}
	
	public void clear(WebElement element) throws Exception{
		int attempts = 0;
		while (attempts < 2) {
			try {
				element.clear();
				break;
			} catch (StaleElementReferenceException e) {
				attempts++;
			}
		}
		if (attempts == 3) {
			throw new Exception("Failed to retrieve attibute post stale element exception and 2 retries.");
		}
	}
	
	public void doubleClick(WebElement element) throws Exception{
		try{
			Actions ac = new Actions(driver);
			ac.doubleClick(element).build().perform();
		}catch(Exception e){
			throw new Exception("Please specify the currect locator");
		}
	}
	

}
