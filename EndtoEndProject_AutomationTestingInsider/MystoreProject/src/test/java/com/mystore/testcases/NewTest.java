package com.mystore.testcases;

import org.testng.annotations.Test;

import com.mystore.base.BasePage;

import org.testng.annotations.BeforeTest;

public class NewTest extends BasePage {
  @Test
  public void f() {
  }
  @BeforeTest
  public void beforeTest() {
  
  browserLaunch("chrome","http://automationpractice.com/index.php");
  }
}
