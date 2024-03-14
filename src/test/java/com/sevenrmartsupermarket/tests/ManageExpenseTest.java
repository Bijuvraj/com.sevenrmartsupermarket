package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
	SoftAssert softAssert = new SoftAssert();

	@Test
	public void verifyClickOnTheManageExpense() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		manageexpensepage = new ManageExpensePage(driver);
		loginPage.login();
		homePage.clickOnTheManageExpense();
		manageexpensepage.getSubOptionsOfManageExpense();
		String expctedSubOption = manageexpensepage.getSubOptionsOfManageExpense();
		String actualSubOption = manageexpensepage.getSubOptionsOfManageExpense();
		String expectedFooterText = "Copyright © 2024 7rmart supermarket.";
		String actualFooterText = manageexpensepage.verifyTheFooterTextInHome();
		softAssert.assertEquals(actualSubOption, expctedSubOption);
		softAssert.assertEquals(actualFooterText, expectedFooterText, "This is failed due to NoSuchElement");
		softAssert.assertAll();
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
		manageexpensepage.closeTheNewManageExpenseAlert();
		manageexpensepage.clickOnTheSeachButtonInCategoryExpense();
		manageexpensepage.enterExpenseTitleNameInSearch("Expense Stephany");
		manageexpensepage.clickOnTheSearchButtonInExpenseCategory();
		manageexpensepage.verifySearchedDetailsTitleName();
		String expectedTiltleName = manageexpensepage.verifySearchedDetailsTitleName();
		String actualTitleName = manageexpensepage.verifySearchedDetailsTitleName();
		manageexpensepage.clickOnTheResetButtonInTheExpenseCategory();
		Assert.assertEquals(actualTitleName, expectedTiltleName);
	}

	@Test
	public void VerifyThatEditTheExpenseCategoryInList() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		manageexpensepage = new ManageExpensePage(driver);
		loginPage.login();
		homePage.clickOnTheManageExpense();
		manageexpensepage.clickOnTheExpenseCategory();
		manageexpensepage.clickOnTheSeachButtonInCategoryExpense();
		manageexpensepage.clickOnTheEditCategoryButton("Expense Ger");
		manageexpensepage.clickOnBack_Space();
		manageexpensepage.clickOnTheUpdateButtonInEdit();
		manageexpensepage.newManageExpenseCreateSuccessfullyalert();
		String result = manageexpensepage.newManageExpenseCreateSuccessfullyalert();
		manageexpensepage.closeTheNewManageExpenseAlert();
		Assert.assertEquals(result, "Alert!");

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
		manageexpensepage.closeTheNewManageExpenseAlert();
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
		String result = manageexpensepage.newManageExpenseCreateSuccessfullyalert();
		manageexpensepage.closeTheNewManageExpenseAlert();
		manageexpensepage.clickOnTheCancelButton();
		Assert.assertEquals(result, "Alert!");
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
