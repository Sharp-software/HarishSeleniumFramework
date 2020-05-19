package com.qa.TestCases;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.ExcelManager.TestDataProvider;
import com.qa.pages.LoginPage;
import com.qa.utils.ReadProperty;

public class LoginTest extends BaseTest{
	Logger log = Logger.getLogger(this.getClass());
	
	@DataProvider
	public Object[][] getLogineCredensials() throws Exception{
		Object[][] data = TestDataProvider.getTestData(ReadProperty.getProperty("SheetNameforDP"));
		return data;
	}
	
	@Test(dataProvider="getLogineCredensials",priority=1)
	public void verifyLoginTest(String Username, String Password) throws Exception{
		setTestDesc("Verify that Home Page is diaplyed when loged in as Admin");
		LoginPage l= new LoginPage();
		l.dologine(Username, Password);
		System.out.println("1 test case");
	}
	
	@Test(priority=2)
	public void verifyCheckBox() throws Exception{
		setTestDesc("verifyCheckBoxn");
		LoginPage l= new LoginPage();
		Assert.assertTrue(l.keepmetest());
	}
	
	@Test(priority=3)
	public void verifyErrorMesg() throws Exception{
		setTestDesc("verify wheather error message is displayed when user enters invalid credencinals");
		LoginPage l= new LoginPage();
		String error = l.errormsg(getLocString("UserName"), "jhgas");
		Assert.assertEquals(error, getLocString("ErrMsg"));
	}
}
