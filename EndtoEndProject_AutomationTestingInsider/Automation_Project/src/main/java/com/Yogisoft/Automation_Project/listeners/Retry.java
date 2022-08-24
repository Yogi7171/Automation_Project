package com.Yogisoft.Automation_Project.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Retry implements IRetryAnalyzer {

	private int retryCount = 0;
	private int maxRetryCount = 3;

	public boolean retry(ITestResult arg0) {
		if (retryCount < maxRetryCount) {
			log("Retrying Test " + arg0.getName() + " with the status " + getResultStatusName(arg0.getStatus())
					+ "for the " + (retryCount + 1) + " times");
			retryCount++;
			return true;
		}
		return false;
	}

	private void log(String string) {
		Reporter.log(string);

	}

	private String getResultStatusName(int status) {
		String resultName = null;
		if (status == 1)
			resultName = "PASS";
		if (status == 2)
			resultName = "FAIL";
		if (status == 3)
			resultName = "SKIP";
		return resultName;

	}
}