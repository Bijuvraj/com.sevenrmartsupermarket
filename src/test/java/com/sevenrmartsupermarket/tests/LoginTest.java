package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.ScreenShot;

public class LoginTest extends Base {
	LoginPage loginpage;
	HomePage homepage;
	

	@Test(retryAnalyzer = com.sevenrmartsupermarket.listeners.RetryAnalyzer.class)
	public void verifyUserLogin() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		// loginpage.login(); //default admin login from xlsx
		loginpage.login("Amina", "B000A0GB7Q");
		String expectedProfileName = "Amina";
		String actualProfileName = homepage.getProfileName();
		Assert.assertEquals(actualProfileName, expectedProfileName);
	}

	@Test
	public void verifyTheChrckBoxIsDisplayed() {
		loginpage = new LoginPage(driver);
		loginpage.verifyCheckBoxisDisplayed();
		ScreenShot.takeScreenShot(driver, "hi");
	}

	@Test
	public void verifyClickOnTheCheckBox() {
		loginpage = new LoginPage(driver);
		loginpage.enterUserName("Amina");
		loginpage.enterPassword("B000A0GB7Q");
		loginpage.clickOnCheckBox();
		loginpage.verifyThe_CheckBoxisSelected();
		loginpage.clickOnLoginButton();
		ScreenShot.takeScreenShot(driver, "hi");

	}

	@Test
	public void verifyCheckBoxiSEnabled() {
		loginpage = new LoginPage(driver);
		loginpage.clickOnCheckBox();
		loginpage.verifyThecheckBox_isEnabled();
	}

	@Test
	public void verifyTheCkeckBoxisSelected() {
		loginpage = new LoginPage(driver);
		loginpage.clickOnCheckBox();
		loginpage.verifyThe_CheckBoxisSelected();
	}
	@Test
	public void verifyTheRememberMeText()
	{
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
	public void verifyTheSingInButtonText()
	{
		loginpage = new LoginPage(driver);
		System.out.println(loginpage.verifySignInButtonText());
		String expectedButtonText = "Sign In";
		String actualButtonText = loginpage.verifySignInButtonText();
		Assert.assertEquals(actualButtonText, expectedButtonText);
		
	}
}
