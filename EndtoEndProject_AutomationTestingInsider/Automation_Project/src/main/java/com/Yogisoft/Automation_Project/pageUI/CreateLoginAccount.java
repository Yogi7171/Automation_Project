package com.Yogisoft.Automation_Project.pageUI;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
//import org.testng.Assert;(used for download testNG library because assertequal is not there)
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Yogisoft.Automation_Project.basepage.BasePage;

public class CreateLoginAccount extends BasePage 
	{
		//Log4J cocncept
		public static final Logger log=Logger.getLogger(CreateLoginAccount.class.getName());
	
		@FindBy(linkText = "Sign in")WebElement linkSignIN;
		@FindBy(id = "email_create")WebElement txtEmailID;
		@FindBy(id="SubmitCreate")WebElement btnCreateAnAccount;
		@FindBy(xpath = "//h1[text()='Create an account']")WebElement txtCreateAnAccount;
		@FindBy(id ="id_gender1")WebElement radioMr;
		@FindBy(id = "customer_firstname")WebElement txtFirstName;
		@FindBy(id = "customer_lastname")WebElement txtLastName;
		@FindBy(id = "passwd")WebElement txtpassword;
		@FindBy(id = "days")WebElement dropDownDays;
		@FindBy(id = "months")WebElement dropDownMonths;
		@FindBy(id = "years")WebElement dropDownYears;
		@FindBy(id = "address1")WebElement txtAddress1;
		@FindBy(id="address2")WebElement txtAddress2;
		@FindBy(id = "city")WebElement txtCity;
		@FindBy(id ="id_state")WebElement dropedownstate;
		@FindBy(id ="postcode")WebElement txtZipcode;
		@FindBy(id="id_country")WebElement dropdowncounrty;
		@FindBy(id="phone_mobile")WebElement txtMobile;
		@FindBy(id="alias")WebElement txtAliasAddress;
		@FindBy(id = "submitAccount")WebElement btnRegister;
		@FindBy(xpath = "//h1[text()='My account']")WebElement txtMyAccount;
		@FindBy(linkText = "Sign out")WebElement linkSignOut;
		
	//Constructor creation
		public CreateLoginAccount(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}


		public void createAccount ()throws Exception 
			{
				linkSignIN.click();
				log.info("Clicked on Sign IN button with object:"+linkSignIN.toString());
				txtEmailID.sendKeys(getData("firstname")+getData("lastname")+randomNumber()+getData("domainname"));
				log.info("Entering EmailID:"+txtEmailID.getAttribute("value")+"using object:"+txtEmailID.toString());
				btnCreateAnAccount.click();
				log.info("clicking on create an account:"+btnCreateAnAccount.toString());
				Thread.sleep(5000);
				//assertEquals(txtCreateAnAccount.getText(), "CREATE AN ACCOUNT");
				radioMr.click();
				log.info("clicking on Mr button:".toString());
				txtFirstName.sendKeys("Yogesh");
				log.info("Entering Firstname by using object:"+txtFirstName.toString());
				//log.info("Entering FirstName:"+txtFirstName.getAttribute("value")+"using object:"+txtFirstName.toString());
				txtLastName.sendKeys("chauhan");
				log.info("Entering Lastname by using object:"+txtLastName.toString());
				txtpassword.sendKeys("abc@123");
				log.info("Entering Password by using object:"+txtpassword.toString());
				selectOption(dropDownDays, 15);
				log.info("Selected a day by using object:"+dropDownDays.toString());
				selectOption(dropDownMonths, 10);
				log.info("selected a month by using object:"+dropDownMonths.toString());
				selectOption(dropDownYears, 10);
				log.info("selected a year by using object:"+dropDownYears.toString());
				txtAddress1.sendKeys(getData("address1"));
				log.info("Entering address1 by using object:"+txtAddress1.toString());
				txtAddress2.sendKeys(getData("address2"));
				log.info("Entering address2 by using object:"+txtAddress2.toString());
				txtCity.sendKeys("tarapur");
				log.info("Entering city by using object:"+txtCity.toString());
				selectOption(dropedownstate, 3);
				log.info("Selected a state by using object:"+dropedownstate);
				txtZipcode.sendKeys("12345");
				log.info("Entering zipcode by using object:"+txtZipcode.toString());
				selectOption(dropdowncounrty, 1);
				log.info("Selected a country by using object:"+dropdowncounrty.toString());
				txtMobile.sendKeys("4562531425");
				log.info("Entering Mobile number by using object:"+txtMobile.toString());
				txtAliasAddress.sendKeys(getData("aliasaddress"));
				log.info("Entering Alias Address by using object:"+txtAliasAddress.toString());
				btnRegister.click();
				log.info("Clicking on Registor by using object:"+btnRegister.toString());
				Thread.sleep(5000);
				assertEquals(txtMyAccount.getText(), "MY ACCOUNT");
				log.info("Verified My account page by using object:"+txtMyAccount.toString());
				linkSignOut.click();
				log.info("Clicking on signout by using object:"+linkSignOut.toString());
			}
		
		
	}
