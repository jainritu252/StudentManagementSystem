package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class LoginPage extends BrowserUtility {
	

	private static final By EMAIL_TEXT_BOX_LOCATOR=By.id("email");
	private static final By PASSWORD_TEXT_BOX_LOCATOR=By.id("pass");
	private static final By SIGNIN_BUTTON_LOCATOR=By.xpath("//*[@class='button-1 login-button']");

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
   public MyAccountPage doLoginWith(String emailAddress,String password) {
	   enterText(EMAIL_TEXT_BOX_LOCATOR,emailAddress);
	   enterText(PASSWORD_TEXT_BOX_LOCATOR,password);
	   clickOn(SIGNIN_BUTTON_LOCATOR);
	   
	   MyAccountPage myAccountPage=new MyAccountPage(getDriver());
         return myAccountPage;
}
}