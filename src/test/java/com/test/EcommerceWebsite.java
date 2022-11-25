package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
public class EcommerceWebsite extends Base {

	WebDriver driver;

	@BeforeClass
	public void testLoading() {
		initial();
	}

	@Test(priority = 1)
	public void admin() {
		driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"))
				.click();
	}

	@Test(priority = 2)
	public void job() {
		driver.findElement(By.xpath("//header/div[2]/nav[1]/ul[1]/li[2]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Job Titles')]")).click();

	}

	@Test(priority = 3)
	public void addButton() {
		driver.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--secondaryx']")).click();
	}

}
