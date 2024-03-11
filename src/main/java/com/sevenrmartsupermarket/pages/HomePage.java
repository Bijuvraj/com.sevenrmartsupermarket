package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;

	@FindBy(xpath = "//div[@class='info']//a[@href='https://groceryapp.uniqassosiates.com/admin/home']")
	WebElement profileName;
	@FindBy(xpath = "(//p[text()='Admin Users'])[1]")
	WebElement adminusers;
	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy'])[1]")
	WebElement managedeleveryboy;
	@FindBy(xpath = "(//li//a[@class='nav-link'])[3]")
	WebElement manageExpense;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getProfileName() {
		return (profileName.getText());
	}
	public void clickOnAdminUsers()
	{
		adminusers.click();
	}
	public void clickOnTheManageDeliveryBoyOption()
	{
		managedeleveryboy.click();
	}
	public void clickOnTheManageExpense()
	{
		manageExpense.click();
	}
}
