package com.qa.TestCases;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Hashtable;

import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.ExcelManager.TestDataLoader;
import com.qa.browser.DriverFactory;
import com.qa.utils.Constants;
import com.qa.utils.ReadProperty;

public class BaseTest {
	ExtentTest test;
	ExtentReports extent;
	public String testDesc;
	Logger log = Logger.getLogger(this.getClass());
	
	@BeforeTest(alwaysRun=true)
	public void startExtendReport() throws IOException{
		ReadProperty.propertFileCreater();
		log.info("Extent report configurtion is completed");
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter
					(Constants.REPORTDIR+"\\TestReport_"+Constants.getDateTimeStringWithMiliSeconds()+".html");
			htmlReporter.config().setDocumentTitle("Automation Test Report");
		    htmlReporter.config().setReportName("ActiTime Application Automation Report");
		    htmlReporter.config().setTheme(Theme.DARK);
		    htmlReporter.config().enableTimeline(false);
		    extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
			extent.setSystemInfo("Environment", "Windows");
			extent.setSystemInfo("Execution Engineer", "Harish K R");
	}
	
	@BeforeMethod(alwaysRun=true)
	public void setup(Method m){
		test= extent.createTest(m.getName());
		try {
			DriverFactory.setupDriver();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@AfterMethod(alwaysRun=true)
	public void getResult(ITestResult result){
		if(result.getStatus() == ITestResult.FAILURE)
		{
			test.log(Status.FAIL, "Test Case Failed is "+result.getName());
			test.log(Status.FAIL, "TestCase Description : " + getTestDesc());
			test.log(Status.FAIL, "Test failed with Exception : " + result.getThrowable());
		}
		else if(result.getStatus() == ITestResult.SKIP){
			test.log(Status.SKIP, "Test Case Skipped is "+result.getName());
			test.log(Status.SKIP, "TestCase Description : " + getTestDesc());
		}
		else if(result.getStatus() == ITestResult.SUCCESS)
		{
			test.log(Status.PASS, "Test Case Passed is "+result.getName());
			test.log(Status.PASS, "TestCase Description : " + getTestDesc());
		}
		DriverFactory.quit();
	}
	
	@AfterTest(alwaysRun=true)
	public void flushReport(){
		extent.flush();
	}
	
	private String getTestDesc() {
		return this.testDesc;
	}
	
	protected void setTestDesc(String testDesc){
		this.testDesc = testDesc;
	}
	
	public static String getLocString(String Key){
		String excelFileName = Constants.TESTDATA_DIR;
		String sheetName = ReadProperty.getProperty("Sheetname");
		String language = ReadProperty.getProperty("Languagename");
		Hashtable<String, String> ht =TestDataLoader.getLocalizedData(excelFileName, sheetName, language);
		String retvalue = ht.get(Key);
		return retvalue;
	}
	
	

}
