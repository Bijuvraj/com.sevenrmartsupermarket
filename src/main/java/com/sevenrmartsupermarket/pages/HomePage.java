package com.sevenrmartsupermarket.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class HomePage {
	GeneralUtility generalUtility;
	PageUtility pageUtility;
	public WebDriver driver;

	@FindBy(xpath = "//div[@class='info']//a[@href='https://groceryapp.uniqassosiates.com/admin/home']")
	private WebElement profileName;
	@FindBy(xpath = "(//p[text()='Admin Users'])[1]")
	private WebElement adminusers;
	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy'])[1]")
	private WebElement managedeleveryboy;
	@FindBy(xpath = "(//li//a[@class='nav-link'])[3]")
	private WebElement manageExpense;
	@FindBy(xpath = "//section//div/p")
	private List<WebElement> iconslist;
	@FindBy(xpath = "//nav[@class='mt-2']//ul//li//a")
	private List<WebElement> allOptionlist;
	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	private WebElement adminlogo;
	@FindBy(xpath = "(//a[@class='dropdown-item'])[2]")
	private WebElement logoutOption;
	@FindBy(xpath = "//span[text()='7rmart supermarket']")
	private WebElement appLogoText;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getProfileName() {
		return (profileName.getText());
	}

	public List<String> printAllIconsNames() {
		GeneralUtility generalutility = new GeneralUtility();
		List<String> iconsName = new ArrayList<String>();
		iconsName = generalutility.getTextOfElements(iconslist);
		return iconsName;
	}

	public List<String> printAllOptionsName() {
		GeneralUtility generalutility = new GeneralUtility();
		List<String> optionsName = new ArrayList<String>();
		optionsName = generalutility.getTextOfElements(allOptionlist);
		return optionsName;
	}

	public void clickOnTheAdminLogoInRightCorner() {
		adminlogo.click();
	}

	public void clickOnTheLogOutOptionInAdmin() {
		logoutOption.click();
	}

	public String verifyTheAppLogoText() {
		return appLogoText.getText();
	}

	public void clickOnAdminUsers() {
		adminusers.click();
	}

	public void clickOnTheManageDeliveryBoyOption() {
		managedeleveryboy.click();
	}

	public void clickOnTheManageExpense() {
		manageExpense.click();
	}
}
