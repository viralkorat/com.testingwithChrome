package com.test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	
	public static WebDriver driver;
	
	public static void initial() {
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		login("Admin", "admin123");
	}

	public void failed(String testMEthodName) {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(
					"C:\\Users\\Viral Korat\\eclipse-workspace\\com.testingwithChrome\\Screenshot\\"+testMEthodName+"_"+".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void login(String username, String password) {
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//*[@type='submit']")).click();
	}
}
