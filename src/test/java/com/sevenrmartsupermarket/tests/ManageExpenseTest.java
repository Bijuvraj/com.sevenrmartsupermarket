package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageExpensePage;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class ManageExpenseTest extends Base{
	LoginPage loginPage;
	HomePage homePage;
	ManageExpensePage manageexpensepage;
	
	@Test
	public void verifyClickOnTheManageExpense()
	{
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		manageexpensepage = new ManageExpensePage(driver);
		loginPage.login();
		homePage.clickOnTheManageExpense();
	}
	@Test
	public void verifyThatCreateNewExpenseCategoryList()
	{
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		manageexpensepage = new ManageExpensePage(driver);
		loginPage.login();
		homePage.clickOnTheManageExpense();
		manageexpensepage.clickOnTheExpenseCategory();
		manageexpensepage.cilckOnTheNewExpenseCategoryButton();
		manageexpensepage.enterTheTitle("Expense "+GeneralUtility.getRandomFirstName());
		manageexpensepage.ClickOnTheSaveButton();
	}
	@Test
	public void verifyThatTheTitleCreationSuccessfullAlertMessage()
	{
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		manageexpensepage = new ManageExpensePage(driver);
		loginPage.login();
		homePage.clickOnTheManageExpense();
		manageexpensepage.clickOnTheExpenseCategory();
		manageexpensepage.cilckOnTheNewExpenseCategoryButton();
		manageexpensepage.enterTheTitle("Expense "+GeneralUtility.getRandomFirstName());
		manageexpensepage.ClickOnTheSaveButton();
		System.out.println(manageexpensepage.getTitleCreateSuccessfullAlertMsg());
		String expectedAlert = manageexpensepage.getTitleCreateSuccessfullAlertMsg();
		String actualAlert = manageexpensepage.getTitleCreateSuccessfullAlertMsg();
		Assert.assertEquals(actualAlert,expectedAlert);
		
	}
	@Test
	public void verifyToClickOnTheManageExpenseOption()
	{
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		manageexpensepage = new ManageExpensePage(driver);
		loginPage.login();
		homePage.clickOnTheManageExpense();
		manageexpensepage.clickOnTheManageExpenseOption();
	}
}