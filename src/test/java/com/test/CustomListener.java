package com.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListener extends Base implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart " + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess " + result.getName());
		
	}
	
	public void onTestFailure(ITestResult result) {
		failed(result.getMethod().getMethodName());
       
	}
	
	public void onTestSkipped(ITestResult arg0) {
		System.out.println("onTestSkipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage");
	}

	public void onStart(ITestContext arg0) {
		System.out.println("onStart");
	}

	public void onFinish(ITestContext context) {
		System.out.println("onFinish");
	}

	public void onStart(ISuite arg0) {
		System.out.println("onStart");
	}

	public void onFinish(ISuite context) {
		System.out.println("onFinish");
	}
}