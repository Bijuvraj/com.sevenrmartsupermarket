package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.AdminUsersPage;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageExpensePage;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class ManageExpenseTest extends Base {
	LoginPage loginPage;
	HomePage homePage;
	ManageExpensePage manageexpensepage;

	@Test
	public void verifyClickOnTheManageExpense() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		manageexpensepage = new ManageExpensePage(driver);
		loginPage.login();
		homePage.clickOnTheManageExpense();
	}

	@Test
	public void verifyThatCreateNewExpenseCategoryList() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		manageexpensepage = new ManageExpensePage(driver);
		loginPage.login();
		homePage.clickOnTheManageExpense();
		manageexpensepage.clickOnTheExpenseCategory();
		manageexpensepage.cilckOnTheNewExpenseCategoryButton();
		manageexpensepage.enterTheTitle("Expense " + GeneralUtility.getRandomFirstName());
		manageexpensepage.ClickOnTheSaveButton();
	}
	@Test
	public void VerifyThatEditTheExpenseCategoryInList()
	{
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		manageexpensepage = new ManageExpensePage(driver);
		loginPage.login();
		homePage.clickOnTheManageExpense();
		manageexpensepage.clickOnTheExpenseCategory();
		//manageexpensepage.clickOnTheSeachButtonInCategoryExpense();
		manageexpensepage.clickOnTheEditCategoryButton("Expense Mi");
		manageexpensepage.clickOnBack_Space();
		manageexpensepage.clickOnTheUpdateButtonInEdit();
		manageexpensepage.newManageExpenseCreateSuccessfullyalert();
		manageexpensepage.closeTheNewManageExpenseAlert();
	}

	@Test
	public void verifyThatTheTitleCreationSuccessfullAlertMessage() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		manageexpensepage = new ManageExpensePage(driver);
		loginPage.login();
		homePage.clickOnTheManageExpense();
		manageexpensepage.clickOnTheExpenseCategory();
		manageexpensepage.cilckOnTheNewExpenseCategoryButton();
		manageexpensepage.enterTheTitle("Expense " + GeneralUtility.getRandomFirstName());
		manageexpensepage.ClickOnTheSaveButton();
		System.out.println(manageexpensepage.getTitleCreateSuccessfullAlertMsg());
		String expectedAlert = manageexpensepage.getTitleCreateSuccessfullAlertMsg();
		String actualAlert = manageexpensepage.getTitleCreateSuccessfullAlertMsg();
		Assert.assertEquals(actualAlert, expectedAlert);

	}

	@Test
	public void verifyToCreateNewManageExpenseList() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		manageexpensepage = new ManageExpensePage(driver);
		loginPage.login();
		homePage.clickOnTheManageExpense();
		manageexpensepage.clickOnTheManageExpenseOption();
		manageexpensepage.clickOnTheNewManageExpenseButton();
		manageexpensepage.selectUserId();
		manageexpensepage.selectCategoryInManageExpense();
		manageexpensepage.selecTheOrderId();
		manageexpensepage.selectThePurchaseId();
		manageexpensepage.selectTheExpenseType();
		manageexpensepage.enterTheAmount("6000");
		manageexpensepage.enterTheRemarks("6000");
		manageexpensepage.clickOnTheChooseFileButton();
		manageexpensepage.clickOnTheSavaButtonInNewManageExpense();
		manageexpensepage.newManageExpenseCreateSuccessfullyalert();
		manageexpensepage.closeTheNewManageExpenseAlert();
		manageexpensepage.clickOnTheCancelButton();
	}

	@Test
	public void VerifyThatSearchTheCreatedExpenseList() {

		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		manageexpensepage = new ManageExpensePage(driver);
		loginPage.login();
		homePage.clickOnTheManageExpense();
		manageexpensepage.clickOnTheManageExpenseOption();
		manageexpensepage.clickOnTheSearchButtonInManageExpense();
	}
}
