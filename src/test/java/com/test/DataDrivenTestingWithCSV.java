package com.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTestingWithCSV {

	@DataProvider(name = "testDataProvider")
	public Object[][] dataProviderMethod() {

		Object[][] testObjArray = null;

		try {
			
			String filePath = System.getProperty("user.dir") + "\\Test.csv";
			//"C:\\Users\\Viral Korat\\eclipse-workspace\\com.testingwithChrome\\Test.csv"
			
			testObjArray = CSVUtils.getTableArray(filePath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return testObjArray;
	}

	@Test(dataProvider = "testDataProvider")
	public void testReport(String username, String password) {
		System.out.println("Username :" + username + " Password :" + password);
	}
}
