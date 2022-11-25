package com.test;

import java.io.File;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(CustomListener.class)
public class Screenshot extends Base {
	

	@BeforeMethod
	public void setup() {
		initial();
	}

	@Test
	public void method() {
		Assert.assertEquals(true, false);
	}
	
	@Test
	public void method2() {
		Assert.assertEquals(true, false);
	}
	@Test
	public void method3() {
		Assert.assertEquals(true, false);
	}
	@AfterMethod
	public void close() {
		driver.quit();
	}
	
	
	
}
