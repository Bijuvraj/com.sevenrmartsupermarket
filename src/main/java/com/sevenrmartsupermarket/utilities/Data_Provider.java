package com.sevenrmartsupermarket.utilities;

import org.testng.annotations.DataProvider;

public class Data_Provider {
	Excel excel = new Excel();

	@DataProvider(name = "ExcelProvider")
	public Object[][] exceldata() {
		excel.setExcelFile("LoginData", "Login");
		Object data[][] = excel.getMultidimentionalData(2, 2);
		return data;
	}
	@DataProvider (name = "loginDB")
	public Object[][] DBlogins() {
		excel.setExcelFile("DBData", "DB");
		Object data[][] = excel.getMultidimentionalData(2, 6);
		return data;
	}
}
