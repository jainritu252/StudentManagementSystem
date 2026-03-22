package com.ui.tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.constant.Browser;
import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;


public class LoginTest2{

	public static void main(String[] args) {
		WebDriver driver =new ChromeDriver(); //Launch browser session;
    
	HomePage homePage=new HomePage(Browser.CHROME,true);
    LoginPage loginPage=homePage.goToLoginPage();
    loginPage.doLoginWith("rahulsharma@gmail.com","Oracle@1999");
	
	

}}
