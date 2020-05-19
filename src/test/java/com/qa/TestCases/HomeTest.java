package com.qa.TestCases;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class HomeTest extends BaseTest{
	HomePage hp;
	LoginPage lp;
	
	@Test()
	public void verifyPageTitile(){
		setTestDesc("verifyPageTitile");
		Assert.assertTrue(hp.logoDisplyad());
	}
	
	@Test
	public void verifpageTitle(){
		HomePage hp = new HomePage();
		setTestDesc("verifpageTitle");
		Assert.assertEquals(hp.pageTitle(), "");
		}
	}
