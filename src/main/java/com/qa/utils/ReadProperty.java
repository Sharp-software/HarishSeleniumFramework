package com.qa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperty {
	
	public static String getProperty(String ConfignName) 
	{
		String retrunproperty=null;
		Properties prop =new Properties();
		try{
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\resources\\Config.properties");
		prop.load(file);
		retrunproperty= prop.getProperty(ConfignName);
		if(retrunproperty==null){
			throw new Exception("Property named "+ConfignName+ "not found");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return retrunproperty;
	}
	
	public static void propertFileCreater() throws IOException{
		Properties props = new Properties();
		FileOutputStream fis = new FileOutputStream("D://Automation//SeleniumTestNGFramework//src//main//resources//log4j.properties");
		props.setProperty("log4j.rootCategory", "debug, file");
		props.setProperty("log4j.appender.console", "org.apache.log4j.ConsoleAppender");
		props.setProperty("log4j.appender.console.layout", "org.apache.log4j.PatternLayout");
		props.setProperty("log4j.appender.console.layout.ConversionPattern", "%d{MM-dd-yyyy HH:mm:ss} %F %-5p [%t] %c{2} %L - %m%n");
		props.setProperty("log4j.appender.file", "org.apache.log4j.RollingFileAppender");
		props.setProperty("log4j.appender.file.File", "target/Logs/ActiTime_Logs$"+Constants.getDateTimeString()+".log");
		props.setProperty("log4j.appender.file.MaxFileSize", "10mb");
		props.setProperty("log4j.appender.file.MaxBackupIndex", "10");
		props.setProperty("log4j.appender.file.layout", "org.apache.log4j.PatternLayout");
		props.setProperty("log4j.appender.file.layout.ConversionPattern", "%d{ISO8601} %5p [%t] %c{1}:%L - %m%n");
		props.setProperty("log4j.appender.file.Append", "false");
		
        //writing properites into properties file from Java
        props.store(fis, "Properties file generated from Java program");
        fis.close();
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println("Hiiii");
		propertFileCreater();
	}
}
	
	

