package com.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utility.BrowserUtility;

public class LoginTestOLD{

	public static void main(String[] args) {
		WebDriver driver =new ChromeDriver(); //Launch brower session;
    
	BrowserUtility browserUtility =new BrowserUtility(driver);
	browserUtility.goToWebsite("http://localhost:3000");
	
	browserUtility.maximizeWindow();
	
	By signInLinkLocator = By.xpath("//button[text()='Sign In']"); 
	browserUtility.clickOn(signInLinkLocator);
	
	
	By emailTextBoxLocator=By.id("email");
	browserUtility.enterText(emailTextBoxLocator,"rahulsharma@gmail.com");
	
	
	By passwordTextBoxLocator=By.id("pass");
	browserUtility.enterText(passwordTextBoxLocator,"Oracle@1999");
	
	
	By signInButtonLocator=By.xpath("//button[@type='submit' and contains(text(),'Sign In')]");
	browserUtility.clickOn(signInButtonLocator);
	
	
	

}}
