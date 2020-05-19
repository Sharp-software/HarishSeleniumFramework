package com.qa.browser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.qa.utils.Constants;
import com.qa.utils.ReadProperty;

public class DriverFactory {
	public static  WebDriver driver;
	public static FirefoxOptions foptions;
	public DesiredCapabilities capabalities;
	
	public static void  setupDriver(){
		if(ReadProperty.getProperty("Browser").equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVERPATH);
			ChromeProperties();
		}else if(ReadProperty.getProperty("Browser").equalsIgnoreCase("FireFox")){
			System.setProperty("webdriver.gecko.driver", Constants.GECKODRIVERPATH);
			FireFoxOptions();
			driver = new FirefoxDriver(foptions);
		}else{
			try {
				throw new Exception("Please set up the correct browser in Config.properties");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(ReadProperty.getProperty("WaitTime")), TimeUnit.SECONDS);
		driver.get(ReadProperty.getProperty("URL"));
		driver.manage().deleteAllCookies();
		
	}
	
	protected static void ChromeProperties(){
		ChromeOptions options = new ChromeOptions();
		DesiredCapabilities capabalities = new DesiredCapabilities();
		if(ReadProperty.getProperty("Headless").equalsIgnoreCase("yes")){
			options.addArguments("--headless");
		}else if(ReadProperty.getProperty("Incognito").equalsIgnoreCase("yes")){
			options.addArguments("--incognito");
		}else if(ReadProperty.getProperty("Notification").equalsIgnoreCase("yes")){
			options.addArguments("--disable-notifications");
		}else{
			options.addArguments("--disable-infobars");
			capabalities.setCapability(ChromeOptions.CAPABILITY, options);
			capabalities.merge(options);
			driver = new ChromeDriver(options);
			
		}
	}
	
	protected static void FireFoxOptions(){
		DesiredCapabilities capabalities = new DesiredCapabilities();
		if(ReadProperty.getProperty("Headless").equalsIgnoreCase("yes")){
			foptions.setHeadless(true);
		}else if(ReadProperty.getProperty("Incognito").equalsIgnoreCase("yes")){
			foptions.addArguments("-private");
		}else if(ReadProperty.getProperty("Notification").equalsIgnoreCase("yes")){
			foptions.addPreference("dom.webnotifications.enabled", false);
		}else{
			capabalities.setCapability("moz:firefoxOptions",foptions);
			foptions.merge(capabalities);
		}
		
	}
	

	public static void quit() {
		driver.quit();
	}
	

}
