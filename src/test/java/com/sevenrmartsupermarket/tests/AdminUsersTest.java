package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.AdminUsersPage;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class AdminUsersTest extends Base {
	LoginPage loginPage;
	HomePage homePage;
	AdminUsersPage adminuserspage;
	SoftAssert softAssert = new SoftAssert();

	@Test
	public void verifyTheUserClickOnTheAdminUsers() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		adminuserspage = new AdminUsersPage(driver);
		loginPage.login();
		homePage.clickOnAdminUsers();
		Assert.assertEquals(adminuserspage.getHeaderTextInAdminUsersPage(), "Admin Users");
	}

	@Test(groups = "smokeTest")
	public void verifyClickOnTheNewButton() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		adminuserspage = new AdminUsersPage(driver);
		loginPage.login();
		homePage.clickOnAdminUsers();
		adminuserspage.clickOnNewButton();
		adminuserspage.clickOnTheResetButton();
		adminuserspage.clickOnTheHome();
		String expectedFooterText = "Copyright © 2024 7rmart supermarket.";
		String actualFooterText = adminuserspage.verifyTheFooterTextInHome();
		Assert.assertEquals(actualFooterText, expectedFooterText, "This is failed due to NoSuchElement");
	}

	@Test
	public void verifyThatCreateNewAdminUser() {
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
		String expectedAlertText = "Alert!";
		String actualAlertText = adminuserspage.verifyTheAlertMessage();
		adminuserspage.alertClose();
		homePage.clickOnTheAdminLogoInRightCorner();
		homePage.clickOnTheLogOutOptionInAdmin();
		loginPage.login("Verlene", "Jijo");
		String result = homePage.getProfileName();
		softAssert.assertEquals(result, "Verlene");
		softAssert.assertEquals(actualAlertText, expectedAlertText);
		softAssert.assertAll();

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
		String expectedAlertText = "Alert!";
		String actualAlertText = adminuserspage.verifyTheAlertMessage();
		adminuserspage.alertClose();
		homePage.clickOnTheAdminLogoInRightCorner();
		homePage.clickOnTheLogOutOptionInAdmin();
		loginPage.login("Arlen", "Jijo");
		String result = homePage.getProfileName();
		softAssert.assertEquals(result, "Arlen");
		softAssert.assertEquals(actualAlertText, expectedAlertText);
		softAssert.assertAll();
	}

	@Test
	public void verifyCreateNew_Partner_inAdminUsers() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		adminuserspage = new AdminUsersPage(driver);
		loginPage.login();
		homePage.clickOnAdminUsers();
		adminuserspage.clickOnNewButton();
		adminuserspage.enterAdminUsersUserName("Jil " + GeneralUtility.getRandomFirstName());
		adminuserspage.enterAdminUsersPassword("Jijo");
		adminuserspage.selectAdminUsersOnUserTypeDropDown();
		adminuserspage.selectAdminUsersTypePartner();
		adminuserspage.clickOnTheSaveButton();
		String expectedAlertText = "Alert!";
		String actualAlertText = adminuserspage.verifyTheAlertMessage();
		adminuserspage.alertClose();
		homePage.clickOnTheAdminLogoInRightCorner();
		homePage.clickOnTheLogOutOptionInAdmin();
		loginPage.login("Jil Christiane", "Jijo");
		String result = homePage.getProfileName();
		softAssert.assertEquals(result, "Jil Christiane");
		softAssert.assertEquals(actualAlertText, expectedAlertText);
		softAssert.assertAll();
	}

	@Test
	public void verifyCreateNew_DeliveryBoy_InAdminUsers() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		adminuserspage = new AdminUsersPage(driver);
		loginPage.login();
		homePage.clickOnAdminUsers();
		adminuserspage.clickOnNewButton();
		adminuserspage.enterAdminUsersUserName("Jun " + GeneralUtility.getRandomFirstName());
		adminuserspage.enterAdminUsersPassword("Jijo");
		adminuserspage.selectAdminUsersOnUserTypeDropDown();
		adminuserspage.SelectAdminUsersTypeDeliveryBoy();
		adminuserspage.clickOnTheSaveButton();
		String expectedAlertText = "Alert!";
		String actualAlertText = adminuserspage.verifyTheAlertMessage();
		adminuserspage.alertClose();
		homePage.clickOnTheAdminLogoInRightCorner();
		homePage.clickOnTheLogOutOptionInAdmin();
		loginPage.login("Jun Shanda", "Jijo");
		String result = homePage.getProfileName();
		softAssert.assertEquals(result, "Jun Shanda");
		softAssert.assertEquals(actualAlertText, expectedAlertText);
		softAssert.assertAll();
	}

	@Test
	public void verifyThatCreateANewAdminUserAletrMsgText() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		adminuserspage = new AdminUsersPage(driver);
		loginPage.login();
		homePage.clickOnAdminUsers();
		adminuserspage.clickOnNewButton();
		adminuserspage.enterAdminUsersUserName("Jun " + GeneralUtility.getRandomFirstName());
		adminuserspage.enterAdminUsersPassword("Jijo");
		adminuserspage.selectAdminUsersOnUserTypeDropDown();
		adminuserspage.SelectAdminUsersTypeDeliveryBoy();
		adminuserspage.clickOnTheSaveButton();
		adminuserspage.verifyTheAlertMessage();
		String expectedAlertText = "Alert!";
		String actualAlertText = adminuserspage.verifyTheAlertMessage();
		adminuserspage.alertClose();
		Assert.assertEquals(actualAlertText, expectedAlertText);
	}

	@Test
	public void verifyThatClickOnTheSearchButtonAndSearchTheName() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		adminuserspage = new AdminUsersPage(driver);
		loginPage.login();
		homePage.clickOnAdminUsers();
		adminuserspage.clickOntheSearchButton();
		adminuserspage.enterUserNameInSearch("Jun Ashlea");
		adminuserspage.clickOnTheSearchButtonAfterEnterTheSearchDetails();
		String expectedDetails = adminuserspage.getSearchDetails();
		String actualDetails = adminuserspage.getSearchDetails();
		Assert.assertEquals(actualDetails, expectedDetails);
	}

	@Test
	public void verifyThatDeleteTheSearchedAdminUserDetails() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		adminuserspage = new AdminUsersPage(driver);
		loginPage.login();
		homePage.clickOnAdminUsers();
		adminuserspage.clickOntheSearchButton();
		adminuserspage.enterUserNameInSearch("Jeramy123");
		adminuserspage.clickOnTheSearchButtonAfterEnterTheSearchDetails();
		adminuserspage.clickOnTheDeleteButton();
		driver.switchTo().alert().accept();
		String expectedAlertText = "Alert!";
		String actualAlertText = adminuserspage.verifyTheAlertMessage();
		Assert.assertEquals(actualAlertText, expectedAlertText, ".........RESULT NOT FOUND.......");
	}

	@Test
	public void verifyThatTheAdminCanAbleToChangeThePassword() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		adminuserspage = new AdminUsersPage(driver);
		loginPage.login("Pearline", "Jijo");
		adminuserspage.clickOnTheSettingsOption();
		adminuserspage.clickOnTheChangePasswordInSettings();
		adminuserspage.changePassword("Jijo", "Jij", "Jij");
		adminuserspage.clickOnTheChangeButton();
		String result = adminuserspage.getUserDeleteSuccessfullyAlertText();
		adminuserspage.alertClose();
		adminuserspage.clickOnTheHome();
		Assert.assertEquals(result, "Alert!");
	}

	@Test
	public void verifyThatDeleteSuccessfullAlertText() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		adminuserspage = new AdminUsersPage(driver);
		loginPage.login();
		homePage.clickOnAdminUsers();
		adminuserspage.clickOntheSearchButton();
		adminuserspage.enterUserNameInSearch("Quincy");
		adminuserspage.clickOnTheSearchButtonAfterEnterTheSearchDetails();
		adminuserspage.clickOnTheDeleteButton();
		driver.switchTo().alert().accept();
		adminuserspage.getUserDeleteSuccessfullyAlertText();
		String result = adminuserspage.getUserDeleteSuccessfullyAlertText();
		Assert.assertEquals(result, "Alert!");
	}

	@Test
	public void verifyWetherSearchTheDeletedAdminUser() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		adminuserspage = new AdminUsersPage(driver);
		loginPage.login();
		homePage.clickOnAdminUsers();
		adminuserspage.clickOntheSearchButton();
		adminuserspage.enterUserNameInSearch("Ruthanne");
		adminuserspage.clickOnTheSearchButtonAfterEnterTheSearchDetails();
		System.out.println(adminuserspage.getSearchResultNotFoundText());
		String result = adminuserspage.getSearchResultNotFoundText();
		Assert.assertEquals(result, ".........RESULT NOT FOUND.......");
	}

	@Test
	public void verifyThatDeactivateTheUser() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		adminuserspage = new AdminUsersPage(driver);
		loginPage.login();
		homePage.clickOnAdminUsers();
		adminuserspage.deactivatingUser("Jil Williams");
		adminuserspage.verifyTheAlertMessage();
		String expectedAlertText = "Alert!";
		String actualAlertText = adminuserspage.verifyTheAlertMessage();
		adminuserspage.alertClose();
		Assert.assertEquals(actualAlertText, expectedAlertText);
	}

	@Test
	public void verifyThatDeleteTheUser() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		adminuserspage = new AdminUsersPage(driver);
		loginPage.login();
		homePage.clickOnAdminUsers();
		adminuserspage.deleteTheUser("Rufina");
		driver.switchTo().alert().accept();
		adminuserspage.verifyTheAlertMessage();
		String result = adminuserspage.getUserDeleteSuccessfullyAlertText();
		adminuserspage.alertClose();
		Assert.assertEquals(result, "Alert!");
	}

	@Test
	public void verifyThatEditTheUserDetails() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		adminuserspage = new AdminUsersPage(driver);
		loginPage.login();
		homePage.clickOnAdminUsers();
		adminuserspage.editTheUserDetails("Jil William");
		adminuserspage.clickBack_Space();
		adminuserspage.clickOnTheUpdateButton();
		adminuserspage.verifyTheAlertMessage();
		String result = adminuserspage.getUserDeleteSuccessfullyAlertText();
		adminuserspage.alertClose();
		Assert.assertEquals(result, "Alert!");
	}
}
