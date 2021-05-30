package com.qa.googlenews.pages;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qa.googlenews.baseclass.BaseClass;
import com.qa.googlenews.utilities.ConstantVariables;


public class GoogleNewsPage extends BaseClass {
	
	//WebDriver driver;
	//WebDriverWait wait;
	ConstantVariables constant = new ConstantVariables();
	
	
	//Create all the locators of the google page
	JavascriptExecutor js = (JavascriptExecutor) driver;
	By sportsTab = By.xpath("//span[text()='Sports']");
	By sportsText = By.xpath("//h2[text()='Sports'][1]");
	
	public void validate_Click_SportsTab() {
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, constant.PageTitle);		
		WebElement ElsportsTab = driver.findElement(sportsTab);					
		js.executeScript("arguments[0].scrollIntoView();", ElsportsTab);
		WebDriverWait wait = new WebDriverWait(driver,20);	
		wait.until(ExpectedConditions.presenceOfElementLocated(sportsTab));
		driver.findElement(sportsTab).click();
		WebElement sText = driver.findElement(sportsText);
		Assert.assertTrue(sText.isDisplayed());
		
	}
	
	
	public void getMidSportsTab_Click() {
		List<WebElement> totalChildTabs = driver.findElements(By.xpath("//div[contains(@class,'mrslJ ZjAUM  nkLxl U9r6ld')]//child::div[@role='tab']"));
		int totaltabs = totalChildTabs.size();
		int middleTab = Math.round(totaltabs/2);
		
		for(int i = 0; i< totalChildTabs.size() ;i++ ) {
			 if(i==middleTab) {
				 WebElement midTab = driver.findElement(By.xpath("//div[contains(@class,'mrslJ ZjAUM  nkLxl U9r6ld')]//child::div[@role='tab']["+middleTab+"]"));
				 midTab.click();
			 }
		}
		
	}
	
	public void clickOnLastButOneLink() {	
		List<WebElement> links = driver.findElements(By.xpath("//div[@class='NiLAwe y6IFtc R7GTQ keNKEd j7vNaf nID9nc']"));
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");			 
		int linkToClick = links.size()-2;
		WebElement clickLink = links.get(linkToClick);
		clickLink.click();
		
	}
	

}

