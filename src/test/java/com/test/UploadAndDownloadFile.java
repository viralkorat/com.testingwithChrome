package com.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadAndDownloadFile {

	public static void main(String[] args) throws InterruptedException, IOException, AWTException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.adobe.com/ca/acrobat/online/convert-pdf.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//button[@id='lifecycle-nativebutton']")).click();

		Robot rb = new Robot();
		rb.delay(2000);
		// Copy a path from PC and store in clipboard
		StringSelection ss = new StringSelection("C:\\Users\\Viral Korat\\Desktop\\Viral Resume\\SAA\\Viral_Korat_Resume.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		// ctrl+V for paste action
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);

		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);

		rb.keyPress(KeyEvent.VK_ENTER);
		
	}
}
