package com.mystore.base;

//package com.Yogisoft.Automation_Project.basepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {
	
	public WebDriver driver;
	
	// BrowserLaunch Method
	public void browserLaunch(String browser, String url) 
	{
		System.setProperty("webDriver.chrome.driver","D:\\Library\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
		
}