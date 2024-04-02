package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageExpensePage;
import com.sevenrmartsupermarket.pages.PushNotificationPage;
import com.sevenrmartsupermarket.utilities.ExcelUtility;

public class PushNotificationTest extends Base {
	LoginPage loginPage;
	PushNotificationPage pushnotificationpage;
	ExcelUtility excel = new ExcelUtility();
	ManageExpensePage manageexpensepage;

	@Test
	public void verifyThatThePushNotificationMessageIsAbleToSend() {
		loginPage = new LoginPage(driver);
		pushnotificationpage = new PushNotificationPage(driver);
		manageexpensepage = new ManageExpensePage(driver);
		loginPage.login();
		pushnotificationpage.clickOnPushNotification();
		excel.setExcelFile("PushNotificationData", "Notification");
		String title = excel.getCellData(0, 0);
		System.out.println(title);
		String description = excel.getCellData(0, 1);
		System.out.println(description);
		pushnotificationpage.enterTitle(title);
		pushnotificationpage.enterDescription(description);
		pushnotificationpage.clickOnSendButton();
		manageexpensepage.newManageExpenseCreateSuccessfullyalert();
		String result = manageexpensepage.newManageExpenseCreateSuccessfullyalert();
		manageexpensepage.closeTheNewManageExpenseAlert();
		Assert.assertEquals(result, "Alert!");
	}
	@Test
	public void verifyThatTheResetButton()
	{
		loginPage = new LoginPage(driver);
		pushnotificationpage = new PushNotificationPage(driver);
		manageexpensepage = new ManageExpensePage(driver);
		loginPage.login();
		pushnotificationpage.clickOnPushNotification();
		excel.setExcelFile("PushNotificationData", "Notification");
		String title = excel.getCellData(0, 0);
		String description = excel.getCellData(0, 1);
		pushnotificationpage.enterTitle(title);
		pushnotificationpage.enterDescription(description);
		pushnotificationpage.clickOnSendButton();
		String result = manageexpensepage.newManageExpenseCreateSuccessfullyalert();
		manageexpensepage.closeTheNewManageExpenseAlert();
		pushnotificationpage.clickOnTheResetButton();
		Assert.assertEquals(result, "Alert!");
	}
	@Test
	public void verifyThatTheHomeLinkButton()
	{
		loginPage = new LoginPage(driver);
		pushnotificationpage = new PushNotificationPage(driver);
		manageexpensepage = new ManageExpensePage(driver);
		loginPage.login();
		pushnotificationpage.clickOnPushNotification();
		excel.setExcelFile("PushNotificationData", "Notification");
		String title = excel.getCellData(0, 0);
		String description = excel.getCellData(0, 1);
		pushnotificationpage.enterTitle(title);
		pushnotificationpage.enterDescription(description);
		pushnotificationpage.clickOnSendButton();
		String result = manageexpensepage.newManageExpenseCreateSuccessfullyalert();
		manageexpensepage.closeTheNewManageExpenseAlert();
		pushnotificationpage.clickOnTheHomeLinkButton();
		Assert.assertEquals(result, "Alert!");
	}
}
