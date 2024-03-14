package com.sevenrmartsupermarket.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.PageUtility;

public class ManageDeliveryBoyPage {

	WebDriver driver;
	PageUtility pageUtility;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Deliveryboy/add']")
	private WebElement newButton;
	@FindBy(xpath = "//input[@id='name']")
	private WebElement enterNamefield;
	@FindBy(xpath = "//input[@id='email']")
	private WebElement enterEmailField;
	@FindBy(xpath = "//input[@id='phone']")
	private WebElement enterPhoneNoField;
	@FindBy(xpath = "//textarea[@id='address']")
	private WebElement enterAddressField;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement enterUserNameField;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement enterPasswordField;
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveButton;
	@FindBy(xpath = "//a[@href='javascript:void(0)']")
	private WebElement searchButton;
	@FindBy(xpath = "//input [@id='un']")
	private WebElement searchByNamefield;
	@FindBy(xpath = "//button[@value='sr']")
	private WebElement searchButtonByAll;
	@FindBy(xpath = "(//a[@role='button'])[3]")
	private WebElement deleteButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement deleteSuccessAlert;
	@FindBy(xpath = "//center[text()='.........RESULT NOT FOUND.......']")
	private WebElement searchResultNotFound;
	@FindBy(xpath = "//table//tbody//tr//td[1]")
	private List<WebElement> getAllNames;
	@FindBy(xpath = "//h1[text()='Add-Delivery Boy']")
	private WebElement headerTextInManageDB;
	@FindBy(xpath = "//a[text()='Cancel']")
	private WebElement cancelBtnInManageDB;
	@FindBy(xpath = "//h5[text()=' Alert!']")
	private WebElement alertSuccessmsg;
	@FindBy(xpath = "//button[@class='close']")
	private WebElement alertCloseBtn;

	public ManageDeliveryBoyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getAllDeliveryBoysName() {
		List<WebElement> getAllDBName = driver.findElements(By.xpath("//table//tbody//tr//td[1]"));
		for (WebElement e : getAllDBName) {
			System.out.println(e.getText());
		}
		return "";
	}

	public void clickOnTheNewDeliveryBoyButton() {
		newButton.click();
	}

	public String getHeadeText() {
		return headerTextInManageDB.getText();
	}

	public void clickOnTheCancelButtonInManageDB() {
		cancelBtnInManageDB.click();
	}

	public String getSuccessfullyAlertText() {
		return alertSuccessmsg.getText();
	}

	public void clickOnTheAlertCloseButton() {
		alertCloseBtn.click();
	}

	public void enterName(String name) {
		enterNamefield.sendKeys(name);
	}

	public void enterEmail(String email) {
		enterEmailField.sendKeys(email);
	}

	public void enterPhoneNumber(String phno) {
		enterPhoneNoField.sendKeys(phno);
	}

	public void enterAddress(String address) {
		enterAddressField.sendKeys(address);
	}

	public void enterUserName(String username) {
		enterUserNameField.sendKeys(username);
	}

	public void enterPassword(String password) {
		enterPasswordField.sendKeys(password);
	}

	public void clickOnSaveButton() {
		pageUtility = new PageUtility(driver);
		pageUtility.scrollAndClick(saveButton);
		// saveButton.click();
	}

	public void createDeliveryBoy(String name, String email, String phno, String address, String userName,
			String password) {
		clickOnTheNewDeliveryBoyButton();
		enterName(name);
		enterEmail(email);
		enterPhoneNumber(phno);
		enterAddress(address);
		enterUserName(userName);
		enterPassword(password);
		clickOnSaveButton();
	}

	public void verifyClickOnSearchButton() {
		searchButton.click();
	}

	public void verifySearchByDeleveryboyName(String dbName) {
		searchByNamefield.sendKeys(dbName);
	}

	public void clickonTheSearchButtonInAfterEnterTheName() {
		searchButtonByAll.click();
	}

	public void deleteTheSearchedDeliveryBoyDetailsByClickOnTheDeleteButton() {
		deleteButton.click();
	}

	public String verifyTheDeleteSuccessfullAlertMessage() {
		return (deleteSuccessAlert.getText());
	}

	public String searchResultNotFoundText() {
		return (searchResultNotFound.getText());
	}
}
