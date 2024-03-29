package com.sevenrmartsupermarket.pages;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PushNotificationPage {
	WebDriver driver;
	Properties properties = new Properties();

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-notifications']")
	private WebElement pushnotification;
	@FindBy(xpath = "//input[@placeholder='Enter Title']")
	private WebElement titlefield;
	@FindBy(xpath = "//input[@placeholder='Enter Description']")
	private WebElement descriptionfield;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement sendButton;

	public PushNotificationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnPushNotification() {
		pushnotification.click();
	}

	public void enterTitle(String title) {
		titlefield.sendKeys(title);
	}

	public void enterDescription(String description) {
		descriptionfield.sendKeys(description);
	}

	public void clickOnSendButton() {
		sendButton.click();
	}

	public void pushNotification(String title, String description) {
		enterTitle(title);
		enterDescription(description);
		clickOnSendButton();
	}

	public void pushNotification() {
		String title = properties.getProperty("title");
		String description = properties.getProperty("description");
		enterTitle(title);
		enterDescription(description);
		clickOnSendButton();
	}
}
