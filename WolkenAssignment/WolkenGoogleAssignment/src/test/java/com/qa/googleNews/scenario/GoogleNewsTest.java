package com.qa.googleNews.scenario;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.googlenews.baseclass.BaseClass;
import com.qa.googlenews.pages.GoogleNewsPage;
import com.qa.googlenews.utilities.ConstantVariables;

public class GoogleNewsTest extends BaseClass {
	WebDriver driver;
	GoogleNewsPage googlePage = new GoogleNewsPage();
	BaseClass bc = new BaseClass();

	
	@BeforeMethod
	public void setUp() {		
		bc.initialize_driver("Chrome");
	}
	
	@Test
	public void validateGoogleNewsPage() {
		GoogleNewsPage googlePage = new GoogleNewsPage();
		googlePage.validate_Click_SportsTab();
		googlePage.getMidSportsTab_Click();
		googlePage.clickOnLastButOneLink();
		
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.manage().deleteAllCookies();
		driver.quit();
	}
	

}
