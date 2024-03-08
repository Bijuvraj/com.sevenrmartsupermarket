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
WebElement pushnotification;
@FindBy(xpath = "//input[@placeholder='Enter Title']")
WebElement titlefield;
@FindBy(xpath = "//input[@placeholder='Enter Description']")
WebElement descriptionfield;
@FindBy(xpath = "//button[@type='submit']")
WebElement sendButton;

public PushNotificationPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}
public void clickOnPushNotification()
{
	pushnotification.click();
}
public void enterTitle(String title)
{
	titlefield.sendKeys(title);
}
public void enterDescription(String description)
{
	descriptionfield.sendKeys(description);
}
public void clickOnSendButton()
{
	sendButton.click();
}

/**
public void pushNotification(String title, String description)
{
	enterTitle(title);
	enterDescription(description);
	clickOnSendButton();
}
public void pushNotification()
{
	String title = properties.getProperty("title");
	String description = properties.getProperty("description");
	//pushNotification(title,description);
	enterTitle(title);
	enterDescription(description);
	clickOnSendButton();
}**/

}
