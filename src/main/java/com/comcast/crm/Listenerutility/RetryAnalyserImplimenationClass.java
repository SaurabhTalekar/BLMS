package com.comcast.crm.Listenerutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyserImplimenationClass implements IRetryAnalyzer{

	
	int count = 0;
	int limit = 5;
	@Override
	public boolean retry(ITestResult result) {
		
		if(count<limit) {
			count++;
			return true;
		}
		return false;
	}
	
	

}
