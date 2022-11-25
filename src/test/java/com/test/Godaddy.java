package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Godaddy {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.godaddy.com/en-ca");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@id='id-fb016f7a-780c-492d-92dc-b1627d458523']")).click();

		String mainWindow = driver.getWindowHandle();

		driver.switchTo().window(mainWindow);
		driver.findElement(By.xpath("//a[@id='id-1601340d-b852-40f4-b456-8f8f2b11e6e8']")).click();
		driver.manage().timeouts().getImplicitWaitTimeout();
		driver.findElement(By.xpath("//body/div[@id='dc-messaging-bottom-right']/div[1]/button[1]/div[1]/div[1]")).click();

		String secondWindow = driver.getWindowHandle();

		driver.switchTo().window(secondWindow);

		driver.findElement(By.xpath("//*[@title='Type your message']")).sendKeys("Hello!");
		driver.findElement(By.xpath("//*[@data-lp-point='send_button']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@title='Minimize']/following-sibling::*[1]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();

	}

}
