package com.qa.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Constants {
	public static final String CHROMEDRIVERPATH = System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
	public static final String GECKODRIVERPATH = System.getProperty("user.dir")+"\\resources\\geckodriver.exe";
	public static final String REPORTCONFIG = System.getProperty("user.dir")+"\\resources\\ReportsConfig.xml";
	public static final String REPORTDIR = System.getProperty("user.dir")+"\\target\\Reports\\ActitimeApplication\\"+getDateTimeString()+"";
	public static final String TESTDATA_DIR = System.getProperty("user.dir")+"\\resources\\TestData.xlsx";
	public static final int EXPLICIT_WAIT = 10;


	public static String getDateTimeString(){
	DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
	Date d = new Date();
	return dateFormat.format(d);	
	}

	public static String getDateTimeStringWithMiliSeconds(){
	DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss_sss");
	Date d = new Date();
	return dateFormat.format(d);	
	}
}