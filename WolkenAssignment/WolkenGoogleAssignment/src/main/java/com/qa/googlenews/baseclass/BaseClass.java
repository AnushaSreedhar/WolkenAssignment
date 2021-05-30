/* BaseClass.java is mainly used to initialize the WebDrivers, initialize the configuration values like URL, username, password
 * browser etc which has been specified in the config.properties file. The code which fetches all the values from the config.properties
 * file will be written here in a generic way.
 * 
 * Java provides us a class called "Properties" using which we can fetch all the values from the config.properties file.
 * Then we need to make a connection with the properties file by using a FileInputStream class
 */


package com.qa.googlenews.baseclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;	
	public void initialize_driver(String browserName) {
		if(browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://news.google.com");
			driver.manage().window().maximize();	
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		else if(browserName.equalsIgnoreCase("InternetExplorer")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		else {
			System.out.println("The browser specified is not correct... please check");
		}
		
		driver.manage().window().maximize();
		

		
	}
	
	
	
	
}
