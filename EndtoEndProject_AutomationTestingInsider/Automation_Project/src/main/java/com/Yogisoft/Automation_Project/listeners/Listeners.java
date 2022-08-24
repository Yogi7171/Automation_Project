package com.Yogisoft.Automation_Project.listeners;

import org.testng.ITestListener;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext ;
import org.testng.ITestResult ;
import org.testng.Reporter;

import com.Yogisoft.Automation_Project.basepage.BasePage;	

public class Listeners extends BasePage implements ITestListener  {
	public class ListenerTest implements ITestListener						
	{		

	    	
	    public void onFinish(ITestContext arg0) {					
	        // TODO Auto-generated method stub				
	        		
	    }		

	    		
	    public void onStart(ITestContext arg0) {					
	        // TODO Auto-generated method stub				
	        		
	    }		

	   	
	    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {					
	        // TODO Auto-generated method stub				
	        		
	    }		

	    
	    public void onTestFailure(ITestResult arg0) 
	    {		
	    	Reporter.log("Test is Failed"+arg0.getMethod().getMethodName());	
	    	Calendar cal=Calendar.getInstance();
	    	SimpleDateFormat simpleDate=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
	    	String methodnName = arg0.getName();
	        if (!arg0.isSuccess())
	        {
	        	File sourcepath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        	String reportDirectory = (new File(System.getProperty("user.dir")).getAbsolutePath()+"/src/main/java/com/Yogisoft/Automation_Project");
	        	File targetPath=new File((String)reportDirectory+"/failedscreens/"+methodnName+simpleDate.format(cal.getTime())+".jpg");
	        	
	        	try {
					FileUtils.copyFile(sourcepath, targetPath);
				} catch (Exception e) {
					e.printStackTrace();
				}
	        }
	        			
	        		
	    }		

	    		
	    public void onTestSkipped(ITestResult arg0) {					
	    	Reporter.log("Test is skipped"+arg0.getMethod().getMethodName());			
	        		
	    }		

	    		
	    public void onTestStart(ITestResult arg0) {					
	        Reporter.log("Test Start running"+arg0.getMethod().getMethodName());			
	        		
	    }		

	    
	    public void onTestSuccess(ITestResult arg0) {					
	    	Reporter.log("Test is success"+arg0.getMethod().getMethodName());	
	    	Calendar cal=Calendar.getInstance();
	    	SimpleDateFormat simpleDate=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
	    	String methodnName = arg0.getName();
	        if (arg0.isSuccess())
	        {
	        	File sourcepath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        	String reportDirectory = (new File(System.getProperty("user.dir")).getAbsolutePath()+"/src/main/java/com/Yogisoft/Automation_Project");
	        	File targetPath=new File((String)reportDirectory+"/passedscreens/"+methodnName+simpleDate.format(cal.getTime())+".jpg");
	        	
	        	try {
					FileUtils.copyFile(sourcepath, targetPath);
				} catch (IOException e) {
					e.printStackTrace();
				}
	        }
	    }		
	}		
}
