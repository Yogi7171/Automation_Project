package com.Yogisoft.Automation_Project.basepage;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.Random;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BasePage {
	
	public WebDriver driver;
	//Config.properties file for 
	public static final String path="./config.properties";
	//Log4J code
	public String log4jpath="log4j.properties";
	
	
	//For Extent Reports
	public static ExtentReports extent;
	public ExtentTest test;
	public ITestResult result;
	
	static 
		{
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
			extent=new ExtentReports(System.getProperty("user.dir")+"/src/main/java/com/Yogisoft/Automation_Project/htmlreports/test/"+dateFormat.format(cal.getTime())+".html",false);
			
		}
	@BeforeMethod
	public void startReport(Method result) 
		{
			test=extent.startTest(result.getName());
			test.log(LogStatus.INFO,result.getName()+"is Started");
		}
	
	@AfterMethod
	public void endReport(ITestResult result)
	{
		getResult(result);
	}
	
	
	public void getResult(ITestResult result2) {
		if(result2.getStatus()==ITestResult.SUCCESS) 
			{
				test.log(LogStatus.PASS,result2.getName()+"test is passed");
			}
		else if
				(result2.getStatus()==ITestResult.SKIP) 
		  	{
				test.log(LogStatus.SKIP,result2.getName()+"test is skipped");
		  	}
		else if(result2.getStatus()==ITestResult.FAILURE) 
			{
			test.log(LogStatus.FAIL,result2.getName()+"test is failed");
			}
		
	}


	//select method used for dropdown day,month and year so I dont have to write select every time
	public void selectOption(WebElement element,int Option)
	{
		Select s = new Select(element);
		s.selectByIndex(Option);
		
	}
	
	//Random number Generation method
	public int randomNumber() 
	{
		Random r = new Random();
		int random = r.nextInt(9999);
		return random;
	}
	
	public String getData(String key)throws Exception 
	{
		File f = new File(path);
		FileInputStream fi = new FileInputStream(f);
		Properties p = new Properties();
		p.load(fi);
		return p.getProperty(key);
	}
		
		
	// BrowserLaunch Method
	public void browserLaunch(String browser, String url) 
	{
		if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver","D:\\Library\\All Browser Drivers\\geckodriver-v0.31.0-win64 (1)\\geckodriver.exe");
			driver=new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver","D:\\Library\\All Browser Drivers\\chromedriver_win32 (2)\\chromedriver.exe" );	
		driver=new ChromeDriver();
		}else if(browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.","D:\\Library\\All Browser Drivers\\edgedriver_win64 (1)\\msedgedriver.exe" );	
			driver=new InternetExplorerDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		PropertyConfigurator.configure(log4jpath);
	}
		
}