package com.sevenrmartsupermarket.tests;

import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.AdminUsersPage;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageExpensePage;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class AdminUsersTest extends Base {
	LoginPage loginPage;
	HomePage homePage;
	AdminUsersPage adminuserspage;

	@Test
	public void clickOnTheAdminUsers() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		loginPage.login();
		homePage.clickOnAdminUsers();
		System.out.println();
	}

	@Test(groups = "smokeTest")
	public void verifyClickOnTheNewButton() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		adminuserspage = new AdminUsersPage(driver);
		loginPage.login();
		homePage.clickOnAdminUsers();
		adminuserspage.clickOnNewButton();
		System.out.println();
	}

	@Test
	public void verifyCreatNewAdminUser() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		adminuserspage = new AdminUsersPage(driver);
		loginPage.login();
		homePage.clickOnAdminUsers();
		adminuserspage.clickOnNewButton();
		adminuserspage.enterAdminUsersUserName(GeneralUtility.getRandomFirstName());
		adminuserspage.enterAdminUsersPassword("Jijo");
		adminuserspage.selectAdminUsersOnUserTypeDropDown();
		adminuserspage.selectAdminUsersTypeAdmin();
		adminuserspage.clickOnTheSaveButton();
	}

	@Test
	public void verifyCreateNew_Staff_InAdminUsers() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		adminuserspage = new AdminUsersPage(driver);
		loginPage.login();
		homePage.clickOnAdminUsers();
		adminuserspage.clickOnNewButton();
		adminuserspage.enterAdminUsersUserName(GeneralUtility.getRandomFirstName());
		adminuserspage.enterAdminUsersPassword("Jijo");
		adminuserspage.selectAdminUsersOnUserTypeDropDown();
		adminuserspage.selectAdminUsersTypeStaff();
		adminuserspage.clickOnTheSaveButton();
	}

	@Test
	public void verifyCreateNew_Partner_inAdminUsers() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		adminuserspage = new AdminUsersPage(driver);
		loginPage.login();
		homePage.clickOnAdminUsers();
		adminuserspage.clickOnNewButton();
		adminuserspage.enterAdminUsersUserName("Jil "+GeneralUtility.getRandomFirstName());
		adminuserspage.enterAdminUsersPassword("Jijo");
		adminuserspage.selectAdminUsersOnUserTypeDropDown();
		adminuserspage.selectAdminUsersTypePartner();
		adminuserspage.clickOnTheSaveButton();
	}

	@Test
	public void verifyCreateNew_DeliveryBoy_InAdminUsers() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		adminuserspage = new AdminUsersPage(driver);
		loginPage.login();
		homePage.clickOnAdminUsers();
		adminuserspage.clickOnNewButton();
		adminuserspage.enterAdminUsersUserName("Jun "+GeneralUtility.getRandomFirstName());
		adminuserspage.enterAdminUsersPassword("Jijo");
		adminuserspage.selectAdminUsersOnUserTypeDropDown();
		adminuserspage.SelectAdminUsersTypeDeliveryBoy();
		adminuserspage.clickOnTheSaveButton();
	}
	
	@Test
	public void verifyThatCreateANewAdminUserAletrMsgText()
	{
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		adminuserspage = new AdminUsersPage(driver);
		loginPage.login();
		homePage.clickOnAdminUsers();
		adminuserspage.clickOnNewButton();
		adminuserspage.enterAdminUsersUserName("Jun "+GeneralUtility.getRandomFirstName());
		adminuserspage.enterAdminUsersPassword("Jijo");
		adminuserspage.selectAdminUsersOnUserTypeDropDown();
		adminuserspage.SelectAdminUsersTypeDeliveryBoy();
		adminuserspage.clickOnTheSaveButton();
		System.out.println(adminuserspage.verifyTheAlertMessage());
	}
	@Test
	public void verifyThatClickOnTheSearchButtonAndSearchTheName()
	{
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		adminuserspage = new AdminUsersPage(driver);
		loginPage.login();
		homePage.clickOnAdminUsers();
		adminuserspage.clickOntheSearchButton();
		adminuserspage.enterUserNameInSearch("Ruthanne");
		adminuserspage.clickOnTheSearchButtonAfterEnterTheSearchDetails();
	}
	@Test
	public void verifyThatDeleteTheSearchedAdminUserDetails()
	{
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		adminuserspage = new AdminUsersPage(driver);
		loginPage.login();
		homePage.clickOnAdminUsers();
		adminuserspage.clickOntheSearchButton();
		adminuserspage.enterUserNameInSearch("Ruthanne");
		adminuserspage.clickOnTheSearchButtonAfterEnterTheSearchDetails();
		adminuserspage.clickOnTheDeleteButton();
		driver.switchTo().alert().accept();
	}
	@Test
	public void verifyThatDeleteSuccessfullAlertText()
	{
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		adminuserspage = new AdminUsersPage(driver);
		loginPage.login();
		homePage.clickOnAdminUsers();
		adminuserspage.clickOntheSearchButton();
		adminuserspage.enterUserNameInSearch("Jun Wenona");
		adminuserspage.clickOnTheSearchButtonAfterEnterTheSearchDetails();
		adminuserspage.clickOnTheDeleteButton();
		driver.switchTo().alert().accept();
		adminuserspage.getUserDeleteSuccessfullyAlertText();
	}
	@Test
	public void verifyWetherSearchTheDeletedAdminUser()
	{
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		adminuserspage = new AdminUsersPage(driver);
		loginPage.login();
		homePage.clickOnAdminUsers();
		adminuserspage.clickOntheSearchButton();
		adminuserspage.enterUserNameInSearch("Ruthanne");
		adminuserspage.clickOnTheSearchButtonAfterEnterTheSearchDetails();
		adminuserspage.getSearchResultNotFoundText();
	}
	@Test
	public void verifyThatDeactivateTheUser()
	{
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		adminuserspage = new AdminUsersPage(driver);
		loginPage.login();
		homePage.clickOnAdminUsers();
		adminuserspage.deactivatingUser("abcd56356397587");
		adminuserspage.verifyTheAlertMessage();
		adminuserspage.alertClose();
	}
	@Test
	public void verifyThatDeleteTheUser()
	{
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		adminuserspage = new AdminUsersPage(driver);
		loginPage.login();
		homePage.clickOnAdminUsers();
		adminuserspage.deleteTheUser("user437995067");
		driver.switchTo().alert().accept();
		adminuserspage.verifyTheAlertMessage();
		adminuserspage.alertClose();
	}
	@Test
	public void verifyThatEditTheUserDetails()
	{
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		adminuserspage = new AdminUsersPage(driver);
		loginPage.login();
		homePage.clickOnAdminUsers();
		adminuserspage.editTheUserDetails("user43799506");
		adminuserspage.clickBack_Space();
		adminuserspage.clickOnTheUpdateButton();
		adminuserspage.verifyTheAlertMessage();
		adminuserspage.alertClose();
	}
}
