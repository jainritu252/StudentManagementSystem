package com.ui.tests;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;

import com.constant.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LoggerUtility;

public class TestBase {
	protected HomePage homePage;
    Logger logger =LoggerUtility.getLogger(this.getClass());
	
    
    @BeforeMethod(description="load the homepage of website")
	public void setUp() {
		logger.info("Load the homepage of Website");
		homePage = new HomePage(Browser.CHROME,true);
		
	}
	public BrowserUtility getInstance() {
		return homePage;
	}
}