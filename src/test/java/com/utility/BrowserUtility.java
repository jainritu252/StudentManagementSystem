package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import com.constant.Browser;

public class BrowserUtility {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	Logger logger = LoggerUtility.getLogger(this.getClass());

	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
	}

	public BrowserUtility(String browserName) {
		logger.info("Launching the browser for" + browserName);
		if (browserName.equalsIgnoreCase("chrome")) {

			driver.set(new ChromeDriver());
		}

		else if (browserName.equalsIgnoreCase("safari")) {
			driver.set(new SafariDriver());
		} else {
			logger.error("Invalid Browser Name ...Please select chrome and safari");
			System.err.println("Invalid Browser Name ...Please select chrome and safari");
		}

	}

	public BrowserUtility(Browser browserName) {
		logger.info("Launching the browser for" + browserName);
		if (browserName == Browser.CHROME) {
			driver.set(new ChromeDriver());
		} else if (browserName == Browser.FIREFOX) {
			driver.set(new FirefoxDriver());
		} else if (browserName == Browser.SAFARI) {
			driver.set(new SafariDriver());
		}
	}
	
	public BrowserUtility(Browser browserName,boolean isHeadless) {
		logger.info("Launching the browser for" + browserName);
		     
		if (browserName == Browser.CHROME) {
			if(isHeadless) {
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--headless=old");	
			options.addArguments("--window-size=1920,1080");
			driver.set(new ChromeDriver(options));
		} 
			else {
				driver.set(new ChromeDriver());
			}
		}
		else if (browserName == Browser.FIREFOX) {
				if(isHeadless) {
				FirefoxOptions options=new FirefoxOptions();
				options.addArguments("--headless=old");	
				options.addArguments("disable-gpu ");
			driver.set(new FirefoxDriver(options));
				}
				 else {
					driver.set(new FirefoxDriver());
				}
			
		} else if (browserName == Browser.SAFARI) {
		
				if(isHeadless) {
					SafariOptions options=new SafariOptions();
				driver.set(new SafariDriver(options));
					}
				}
				 else {
			driver.set(new SafariDriver());
		}
		}
	


	public void goToWebsite(String url) {
		logger.info("Visting the website " + url);
		driver.get().get(url);
	}

	public void maximizeWindow() {
		logger.info("Maximize the browser window");

		driver.get().manage().window().maximize();
	}

	public void clickOn(By locator) {
		logger.info("Finding element with the locator" + locator);

		WebElement element = driver.get().findElement(locator);
		logger.info("Element found now performing click" + locator);
		element.click();
	}

	public void enterText(By locator, String textToEnter) {
		logger.info("Finding element with the locator" + locator);
		WebElement element = driver.get().findElement(locator);
		logger.info("Element found and now enter text" + textToEnter);

		element.sendKeys(textToEnter);
	}

	public String getVisibleText(By locator) {
		logger.info("Finding element with the locator" + locator);

		WebElement element = driver.get().findElement(locator);
		logger.info("Element found and returning the visible" + element.getText());
		return element.getText();

	}

	public String takeScreenShot(String name) {

		TakesScreenshot screenshot = (TakesScreenshot) driver.get();

		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH-mm-ss");
		String timeStamp = simpleDateFormat.format(date);
		String path = System.getProperty("user.dir") + "/screeshots/" + name + " - " + timeStamp + ".png";
		File screenshotFile = new File(path);

		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {

			e.printStackTrace();
		}
		return path;
	}
}