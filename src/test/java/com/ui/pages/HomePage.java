package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import com.constant.Browser;
import com.constant.Env;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;
import com.utility.LoggerUtility;

public class HomePage extends BrowserUtility {
	Logger logger =LoggerUtility.getLogger(this.getClass());
	
	private static final By SIGN_IN_LOCATOR = By.xpath("//button[contains(text(),'Sign In')]");
	
	
	 
		public HomePage(Browser browser,boolean isHeadless) {
			super(browser,isHeadless);//Call the parent class contructor from the child class constructor
			goToWebsite(JSONUtility.readJSON(Env.QA).getUrl());
	}
	
	public LoginPage goToLoginPage() {//Page Functions
		logger.info("Trying to perform login on sign in page");
		
     clickOn(SIGN_IN_LOCATOR);
     
     LoginPage loginPage=new LoginPage(getDriver());
     return loginPage;
     
	}
}
