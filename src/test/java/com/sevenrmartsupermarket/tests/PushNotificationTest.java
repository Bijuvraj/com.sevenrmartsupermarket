package com.sevenrmartsupermarket.tests;

import org.testng.annotations.Test;
import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.PushNotificationPage;
import com.sevenrmartsupermarket.utilities.Excel;

public class PushNotificationTest extends Base {
	LoginPage loginPage;
	PushNotificationPage pushnotificationpage;
	Excel excel = new Excel();

	@Test
	public void verifyThePushNotificationMessage() {
		loginPage = new LoginPage(driver);
		pushnotificationpage = new PushNotificationPage(driver);
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
	}
}
