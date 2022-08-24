package com.Yogisoft.Automation_Project.home;

import org.testng.annotations.Test;

import com.Yogisoft.Automation_Project.basepage.BasePage;
import com.Yogisoft.Automation_Project.pageUI.CreateLoginAccount;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class TC001_CR extends BasePage {

		public static final Logger log=Logger.getLogger(TC001_CR.class.getName());
	@Test
  public void custmoreRegistration()throws Exception {
	  //has a relation with createLoginAccount(we have to create object to our class)
		log.info("****StartingTC001_CR*****");
	  CreateLoginAccount login = new CreateLoginAccount(driver);
	  login.createAccount();
	  	log.info("***End of the TC001_CR****");
  }
	
  @Test
	public void verifyLogin() 
	{
		System.out.println("verifyLogin");
	}
	
  @BeforeClass
  public void beforeTest()throws Exception {
	
	  browserLaunch(getData("browser"),getData("url"));
	  
  

}
  @AfterClass
  public void endTest() 
  	{
	  closeBrowser();
  	}

private void closeBrowser()
	{
		driver.quit();
		extent.endTest(test);
		extent.flush();
	
	}

	
}


