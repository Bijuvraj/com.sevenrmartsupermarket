package com.sevenrmartsupermarket.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class AdminUsersPage {
	WebDriver driver;
	Properties properties = new Properties();
	GeneralUtility generalUtility = new GeneralUtility();
	PageUtility pageUtility;

	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	private WebElement creatnewbutton;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement adminusersusername;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement adminuserspassword;
	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement usertypedropdown;
	@FindBy(xpath = "//select[@id='user_type']//option[@value='staff']")
	private WebElement usertypestaff;
	@FindBy(xpath = "//select[@id='user_type']//option[@value='admin']")
	private WebElement usertypeadmin;
	@FindBy(xpath = "//select[@id='user_type']//option[@value='partner']")
	private WebElement usertypepartner;
	@FindBy(xpath = "//select[@id='user_type']//option[@value='db']")
	private WebElement usertypedeleveryboy;
	@FindBy(xpath = "//button[@name='Create']")
	private WebElement saveButton;
	@FindBy(xpath = "//h5[text()=' Alert!']")
	private WebElement alertSuccessmsg;
	@FindBy(xpath = "//h5[text()=' Alert!']")
	private WebElement alertCloseBtn;
	@FindBy(xpath = "//button[@class='close']")
	private WebElement statusChangeAlertCloseBtn;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	private WebElement adminuserssearch;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']")
	private WebElement adminusersreset;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	private WebElement searchbuttonInAdminUser;
	@FindBy(xpath = "//input[@id='un']")
	private WebElement userNameFieldInSearch;
	@FindBy(xpath = "//button[@value='sr']")
	private WebElement searchButtonInsideSearch;
	@FindBy(xpath = "//a[@class='btn btn-sm btn btn-danger btncss']")
	private WebElement deleteButton;
	@FindBy(xpath = "//h5[text()=' Alert!']")
	private WebElement deleteSuccessfullyText;
	@FindBy(xpath = "//center[text()='.........RESULT NOT FOUND.......']")
	private WebElement resultNotFoundText;
	@FindBy(xpath = "//table//tbody/tr//td[1]")
	private List<WebElement> names;
	@FindBy(xpath ="//button[@name='Update']")
	private WebElement updateBtnInEdit;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement userNameFieldInUpdate;

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnNewButton() {
		creatnewbutton.click();
	}

	public void enterAdminUsersUserName(String userName) {
		adminusersusername.sendKeys(userName);
	}

	public void enterAdminUsersPassword(String password) {
		adminuserspassword.sendKeys(password);
	}

	public void selectAdminUsersOnUserTypeDropDown() {
		usertypedropdown.click();
	}

	public void selectAdminUsersTypeStaff() {
		usertypestaff.click();
	}

	public void selectAdminUsersTypeAdmin() {
		usertypeadmin.click();
	}

	public void selectAdminUsersTypePartner() {
		usertypepartner.click();
	}

	public void SelectAdminUsersTypeDeliveryBoy() {
		usertypedeleveryboy.click();
	}

	public void clickOnTheSaveButton() {
		saveButton.click();
	}

	public String verifyTheAlertMessage() {
		return (alertSuccessmsg.getText());
	}
	public void alertClose()
	{
		statusChangeAlertCloseBtn.click();
	}

	public void clickOntheSearchButton() {
		searchbuttonInAdminUser.click();
	}

	public void enterUserNameInSearch(String userName) {
		userNameFieldInSearch.sendKeys(userName);
	}

	public void clickOnTheSearchButtonAfterEnterTheSearchDetails() {
		searchButtonInsideSearch.click();
	}

	public void clickOnTheDeleteButton() {
		deleteButton.click();
	}

	public String getUserDeleteSuccessfullyAlertText() {
		return(deleteSuccessfullyText.getText());
	}

	public String getSearchResultNotFoundText() {
		return(resultNotFoundText.getText());
	}

	public void deactivatingUser(String person) {
		List<String> allName = new ArrayList<String>();
		allName = generalUtility.getTextOfElements(names);
		int index = 0;
		for (index = 0; index < allName.size(); index++) {
			if (person.equals(allName.get(index))) {
				index++;
				break;
			}
		}
		System.out.println(allName);
		WebElement nameElement = driver.findElement(By.xpath("//table//tbody/tr[" + index + "]//td[5]//a[1]"));
		nameElement.click();
	}
	public void deleteTheUser(String person)
	{
		List<String> allName = new ArrayList<String>();
		allName = generalUtility.getTextOfElements(names);
		int index = 0;
		for (index = 0; index < allName.size(); index++) {
			if (person.equals(allName.get(index))) {
				index++;
				break;
			}
		}
		System.out.println(allName);
		WebElement nameElement = driver.findElement(By.xpath("//table//tbody/tr[" + index + "]//td[5]//a[3]"));
		nameElement.click();
	}
	public void editTheUserDetails(String person)
	{
		List<String> allName = new ArrayList<String>();
		allName = generalUtility.getTextOfElements(names);
		int index = 0;
		for (index = 0; index < allName.size(); index++) {
			if (person.equals(allName.get(index))) {
				index++;
				break;
			}
		}
		System.out.println(allName);
		WebElement nameElement = driver.findElement(By.xpath("//table//tbody/tr[" + index + "]//td[5]//a[2]"));
		nameElement.click();
	}
	public void clickOnTheUpdateButton()
	{
		updateBtnInEdit.click();
	}
	public void clickBack_Space()
	{
		userNameFieldInUpdate.click();
		pageUtility = new PageUtility(driver);
		pageUtility.clickBack_Space(userNameFieldInUpdate);
	}
}
