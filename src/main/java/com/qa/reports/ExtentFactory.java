package com.qa.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.utils.Constants;

public class ExtentFactory {
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	
	public static void createReporter() {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		
		htmlReporter = new ExtentHtmlReporter
				(Constants.REPORTDIR+"\\TestReport_"+Constants.getDateTimeStringWithMiliSeconds()+".html");
		htmlReporter.config().setDocumentTitle("Automation Test Report");
	    htmlReporter.config().setReportName("ActiTime Application Automation Report");
	    htmlReporter.config().setTheme(Theme.DARK);
	    htmlReporter.config().enableTimeline(false);
		//htmlReporter.loadXMLConfig(Constants.REPORTCONFIG);
		 extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Environment", "Windows");
		extent.setSystemInfo("Execution Engineer", "Harish K R");
		 
		    
	}
}
