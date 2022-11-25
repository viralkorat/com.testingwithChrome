package com.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTestingWithExcel {

	@DataProvider(name = "excelDataProvider")
	public Object[][] dataProviderMethod() {
		Object[][] testObjArray = null;
		try {
			testObjArray = ExcelUtils.getTableArray("‪D:\\Test.xlsx","Sheet1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return testObjArray;
	}
	
	
	@Test(dataProvider="excelDataProvider")
	public void test_post_1(String username, String password) {
		System.out.println("UseName: " + username + ", Password: " + password);
	}

}
