package com.sevenrmartsupermarket.tests;

import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.Excel;

public class HomeTest extends Base {
	Excel excel = new Excel();
	LoginPage loginPage;
	HomePage homePage;

	@Test
	public void verifyAlliconsName() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		loginPage.login();
		List<String> actualIconsList = homePage.printAllIconsNames();
		List<String> expextedIconsList = new ArrayList<String>();
		expextedIconsList.add("Manage Pages");
		expextedIconsList.add("Admin Users");
		expextedIconsList.add("Dashboard");
		expextedIconsList.add("Category");
		expextedIconsList.add("Manage Product");
		expextedIconsList.add("Manage Offer Code");
		expextedIconsList.add("Manage Slider");
		expextedIconsList.add("Manage Delivery Boy");
		expextedIconsList.add("Manage Users");
		expextedIconsList.add("Manage Orders");
		expextedIconsList.add("Manage Location");
		expextedIconsList.add("Mobile Slider");
		expextedIconsList.add("Manage News");
		expextedIconsList.add("Manage Expense");
		expextedIconsList.add("Manage Gift cards &vouchers");
		expextedIconsList.add("Manage Gift cards &vouchers");
		System.out.println(actualIconsList);
		Assert.assertEquals(actualIconsList, expextedIconsList);
	}

	@Test
	public void verifyThatAllOptionNames() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		loginPage.login();
		List<String> expextedOptionsList = new ArrayList<String>();
		expextedOptionsList.add("Dashboard");
		expextedOptionsList.add("Manage Orders");
		expextedOptionsList.add("Manage Product");
		expextedOptionsList.add("Manage Expense");
		expextedOptionsList.add("");
		expextedOptionsList.add("");
		expextedOptionsList.add("Manage Users");
		expextedOptionsList.add("Push Notifications");
		expextedOptionsList.add("Manage Content");
		expextedOptionsList.add("");
		expextedOptionsList.add("");
		expextedOptionsList.add("");
		expextedOptionsList.add("");
		expextedOptionsList.add("Manage Location");
		expextedOptionsList.add("Manage Slider");
		expextedOptionsList.add("Mobile Slider");
		expextedOptionsList.add("Manage Category");
		expextedOptionsList.add("");
		expextedOptionsList.add("");
		expextedOptionsList.add("Manage Offer Code");
		expextedOptionsList.add("");
		expextedOptionsList.add("");
		expextedOptionsList.add("Manage Delivery Boy");
		expextedOptionsList.add("Manage Payment Methods");
		expextedOptionsList.add("Admin Users");
		expextedOptionsList.add("Settings");
		expextedOptionsList.add("");
		expextedOptionsList.add("");
		expextedOptionsList.add("");
		List<String> actualOptionsList = homePage.printAllOptionsName();
		System.out.println(actualOptionsList);
		Assert.assertEquals(actualOptionsList, expextedOptionsList);
	}

}
