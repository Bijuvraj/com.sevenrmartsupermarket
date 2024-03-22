package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.Data_Provider;
import com.sevenrmartsupermarket.utilities.ScreenShot;

public class LoginTest extends Base {
	LoginPage loginpage;
	HomePage homepage;

	@Test(retryAnalyzer = com.sevenrmartsupermarket.listeners.RetryAnalyzer.class)
	public void verifyUserLogin() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginpage.login("Amina", "B000A0GB7Q");
		String expectedProfileName = "Amina";
		String actualProfileName = homepage.getProfileName();
		Assert.assertEquals(actualProfileName, expectedProfileName);
	}

	@Test
	public void verifyThatTheAdminCanAbleToLoginAndLogout() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginpage.login();
		homepage.clickOnTheAdminLogoInRightCorner();
		homepage.clickOnTheLogOutOptionInAdmin();
		loginpage.login();
		String result = homepage.verifyTheAppLogoText();
		Assert.assertEquals(result, "7rmart supermarket");
	}

	@Test
	public void verifyTheCheckBoxIsDisplayed() {
		loginpage = new LoginPage(driver);
		loginpage.verifyCheckBoxisDisplayed();
		boolean result = loginpage.verifyCheckBoxisDisplayed();
		System.out.println(result);
		Assert.assertTrue(result);
	}

	@Test(dataProvider = "ExcelProvider", dataProviderClass = Data_Provider.class)
	public void verifyClickOnTheCheckBox(String userName, String password) {
		loginpage = new LoginPage(driver);
		loginpage.enterUserName(userName);
		loginpage.enterPassword(password);
		loginpage.clickOnCheckBox();
		boolean result = loginpage.verifyThecheckBox_isEnabled();
		loginpage.clickOnLoginButton();
		Assert.assertTrue(result);
	}

	@Test
	public void verifyCheckBoxiSEnabled() {
		loginpage = new LoginPage(driver);
		loginpage.clickOnCheckBox();
		boolean result = loginpage.verifyThecheckBox_isEnabled();
		Assert.assertTrue(result);
	}

	@Test
	public void verifyTheCkeckBoxisSelected() {
		loginpage = new LoginPage(driver);
		loginpage.clickOnCheckBox();
		boolean result = loginpage.verifyThe_CheckBoxisSelected();
		Assert.assertTrue(result);
	}

	@Test
	public void verifyTheRememberMeText() {
		loginpage = new LoginPage(driver);
		System.out.println(loginpage.verifyRememberMeButtonText());
		String expectedText = "Remember Me";
		String actualText = loginpage.verifyRememberMeButtonText();
		Assert.assertEquals(actualText, expectedText);
	}

	@Test
	public void verifyBackgrountColorOf_SignInButton() {
		loginpage = new LoginPage(driver);
		System.out.println(loginpage.verifyTheBackgrountColorFor_SigninButton());
		String expectedColor = "rgba(255, 255, 255, 1)";
		String actualColor = loginpage.verifyTheBackgrountColorFor_SigninButton();
		Assert.assertEquals(actualColor, expectedColor);
	}

	@Test
	public void verifyTheSingInButtonText() {
		loginpage = new LoginPage(driver);
		System.out.println(loginpage.verifySignInButtonText());
		String expectedButtonText = "Sign In";
		String actualButtonText = loginpage.verifySignInButtonText();
		Assert.assertEquals(actualButtonText, expectedButtonText);
	}
}
