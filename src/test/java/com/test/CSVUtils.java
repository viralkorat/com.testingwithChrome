package com.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVUtils {

	public static Object[][] getTableArray(String filepath) throws IOException {

		File file = new File(filepath);

		System.out.println("Is Exists? " + file.exists());
		System.out.println("Directory : " + file.isDirectory());
		System.out.println("Can Readable? " + file.canRead());
		System.out.println("Absolute Path : " + new File(".").getAbsolutePath());
		System.out.println("Absolute File : " + new File(".").getAbsoluteFile());

		System.out.println("The path is '" + filepath + "'");

		Object[][] tabArray = null;

		List<List<Object>> list = new ArrayList<List<Object>>();
		BufferedReader br = new BufferedReader(new FileReader(filepath));
		String line = br.readLine();
		Object[] cell = line.split(",");
		for (Object header : cell) {
			List<Object> subList = new ArrayList<Object>();
			subList.add(header);
			list.add(subList);
		}
		while ((line = br.readLine()) != null) {
			Object[] elems = line.split(",");
			for (int i = 0; i < elems.length; i++) {
				list.get(i).add(elems[i]);
			}
		}
		br.close();

		int rows = list.get(0).size();
		int cols = list.size();

		tabArray = new Object[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				tabArray[i][j] = list.get(j).get(i);
			}
		}
		return tabArray;
	}
}