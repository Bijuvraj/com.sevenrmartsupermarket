package com.sevenrmartsupermarket.tests;

import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageDeliveryBoyPage;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class ManageDeliveryBoyTest extends Base {
	LoginPage loginPage;
	HomePage homePage;
	ManageDeliveryBoyPage managedeliveryboypage;
	
	@Test
	public void clickOnTheManageDeliveryBoyOption() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		loginPage.login();
		homePage.clickOnTheManageDeliveryBoyOption();
	}

	@Test
	public void verifyTheNewButton() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		loginPage.login();
		homePage.clickOnTheManageDeliveryBoyOption();
		managedeliveryboypage.clickOnTheNewDeliveryBoyButton();
	}

	@Test
	public void verifyThatCreateNewDeliveryBoy() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		loginPage.login();
		homePage.clickOnTheManageDeliveryBoyOption();
		String firstName = "Nioo "+GeneralUtility.getRandomFirstName();
		managedeliveryboypage.createDeliveryBoy(firstName, "abdsssdffdsg@gmail.com", "8978787878",
				"jhdvhdsbvjhbsdkvhcbshdvb ksdhfviushdh jsdhgjh", GeneralUtility.getRandomFirstName(), "nio");
		System.out.println(GeneralUtility.getRandomFirstName());
	}
	
	@Test
	public void verifyClickingOnTheSearchButton()
	{
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		loginPage.login();
		homePage.clickOnTheManageDeliveryBoyOption();
		managedeliveryboypage.verifyClickOnSearchButton();
	}
	
	@Test(groups = "smokeTest")
	public void verifyTheDeliveryBoySearchByNaame()
	{
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		loginPage.login();
		homePage.clickOnTheManageDeliveryBoyOption();
		managedeliveryboypage.verifyClickOnSearchButton();
		managedeliveryboypage.verifySearchByDeleveryboyName("Nio");
		managedeliveryboypage.clickonTheSearchButtonInAfterEnterTheName();
	}
	@Test(groups = "sanityTest")
	public void verifyThatDeleteTheSearchedDeliveryBoyDetails()
	{
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		loginPage.login();
		homePage.clickOnTheManageDeliveryBoyOption();
		managedeliveryboypage.verifyClickOnSearchButton();
		managedeliveryboypage.verifySearchByDeleveryboyName("Nioo");
		managedeliveryboypage.clickonTheSearchButtonInAfterEnterTheName();
		managedeliveryboypage.deleteTheSearchedDeliveryBoyDetailsByClickOnTheDeleteButton();
		driver.switchTo().alert().accept();
	}
	
	@Test(groups={"grp1","grp2"})
	public void verifyTheDeleteDeliveryBoySuccessfullyAlertMsg()
	{
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		loginPage.login();
		homePage.clickOnTheManageDeliveryBoyOption();
		managedeliveryboypage.verifyClickOnSearchButton();
		managedeliveryboypage.verifySearchByDeleveryboyName("Nioo Kirby");
		managedeliveryboypage.clickonTheSearchButtonInAfterEnterTheName();
		managedeliveryboypage.deleteTheSearchedDeliveryBoyDetailsByClickOnTheDeleteButton();
		driver.switchTo().alert().accept();
		managedeliveryboypage.verifyTheDeleteSuccessfullAlertMessage();
	}
	
	@Test
	public void verifyThatTheDeletedDBDetailsSearch()
	{
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		loginPage.login();
		homePage.clickOnTheManageDeliveryBoyOption();
		managedeliveryboypage.verifyClickOnSearchButton();
		managedeliveryboypage.verifySearchByDeleveryboyName("Nioo Kirby");
		managedeliveryboypage.clickonTheSearchButtonInAfterEnterTheName();
		managedeliveryboypage.searchResultNotFoundText();
	}
}
