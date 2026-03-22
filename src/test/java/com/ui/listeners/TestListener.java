package com.ui.listeners;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ui.tests.TestBase;
import com.utility.BrowserUtility;
import com.utility.ExtentReporterUtility;
import com.utility.LoggerUtility;

public class TestListener implements ITestListener {
	Logger logger = LoggerUtility.getLogger(this.getClass());
	ExtentSparkReporter extentSparkReporter;
	ExtentReports extentReports;
	ExtentTest extentTest;

	@Override
	public void onTestStart(ITestResult result) {
		logger.info(result.getMethod().getMethodName());
		logger.info(result.getMethod().getDescription());
		logger.info(Arrays.toString(result.getMethod().getGroups()));
		ExtentReporterUtility.createExtentTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info(result.getMethod().getMethodName() + " " + "PASSED");
		ExtentReporterUtility.getTest().log(Status.PASS, result.getMethod().getMethodName() + " " + "PASSED");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		logger.error(result.getMethod().getMethodName() + " " + "FAILED");
		logger.error(result.getThrowable().getMessage());
		ExtentReporterUtility.getTest().log(Status.FAIL, result.getMethod().getMethodName() + " " + "FAILED");
		ExtentReporterUtility.getTest().log(Status.FAIL,result.getThrowable().getMessage());
		
		Object testclass=result.getInstance();
		BrowserUtility browserutility=((TestBase)testclass).getInstance();
		logger.info("Capturing the screenshot for the failed tests");
		 String screenshotPath=browserutility.takeScreenShot(result.getMethod().getMethodName());
		 logger.info("Attaching the screenshot to the HTML File");
		 ExtentReporterUtility.getTest().addScreenCaptureFromPath(screenshotPath);

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logger.error(result.getMethod().getMethodName() + " " + "SKIPPED");
		ExtentReporterUtility.getTest().log(Status.SKIP, result.getMethod().getMethodName() + " " + "SKIPPED");
	}

	@Override
	public void onStart(ITestContext context) {
		logger.info("Test Suite started");
		ExtentReporterUtility.setupSparkReporter("report.html");
	}
	@Override
	public void onFinish(ITestContext context) {
		logger.info("Test Suite completed");
		ExtentReporterUtility.flushReports();
	}
}
