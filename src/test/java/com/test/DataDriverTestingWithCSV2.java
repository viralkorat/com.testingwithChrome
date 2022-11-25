package com.test;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDriverTestingWithCSV2 {

	
    String CSV_Path = System.getProperty("user.dir")+ "‪\\AmazonTestData.csv";
    String[] csvCell;
    WebDriver driver;
    private CSVReader csvReader;

    @BeforeClass  //will be executing once before the class
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://amazon.com");
    }

    @Test
    public void dataRead_CSV() throws IOException, CsvValidationException {

        csvReader = new CSVReader(new FileReader(CSV_Path));   //object created of CSVReader
        driver.findElement(By.xpath("//a[@id='nav-link-accountList']")).click();
        driver.findElement(By.xpath("//a[@id='createAccountSubmit']")).click();

        while ((csvCell = csvReader.readNext()) != null) {
            String CustomerName = csvCell[0];
            String CustomerEmail = csvCell[1];
            String CustomerPassword = csvCell[2];
            String CustomerConfirmPassword = csvCell[3];

            WebElement customerName = driver.findElement(By.id("ap_customer_name"));
            customerName.clear();
            customerName.sendKeys(CustomerName);

            WebElement customerEmail = driver.findElement(By.id("ap_email"));
            customerEmail.clear();
            customerEmail.sendKeys(CustomerEmail);

            WebElement customerPassword = driver.findElement(By.id("ap_password"));
            customerPassword.clear();
            customerPassword.sendKeys(CustomerPassword);

            WebElement customerConfirmPassword = driver.findElement(By.id("ap_password_check"));
            customerConfirmPassword.clear();
            customerConfirmPassword.sendKeys(CustomerConfirmPassword);

            WebElement login = driver.findElement(By.id("continue"));
            login.click();

        }
    }
    
    @AfterClass
    public void close() {
    	driver.quit();
    }
   
}
