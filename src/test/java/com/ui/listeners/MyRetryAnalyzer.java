package com.ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.constant.Env;
import com.utility.JSONUtility;

public class MyRetryAnalyzer implements IRetryAnalyzer {
	//private static final int MAX_NUMBERS_OF_ATTEMPTS=Integer.parseInt(PropertiesUtil.readProperty(Env.DEV,"MAX_NUMBERS_OF_ATTEMPTS"));
	      private static final int MAX_NUMBERS_OF_ATTEMPTS=JSONUtility.readJSON(Env.QA).getMAX_NUMBERS_OF_ATTEMPTS();
	
	private static int currentAttempt=1;
	

	@Override
	public boolean retry(ITestResult result) {
		if (currentAttempt<=MAX_NUMBERS_OF_ATTEMPTS) {
			currentAttempt++;
		   return true;
	}
	
		return false;
	}	

}
