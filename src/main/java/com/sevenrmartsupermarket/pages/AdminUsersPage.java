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

public class AdminUsersPage {
	WebDriver driver;
	Properties properties = new Properties();
	GeneralUtility generalUtility = new GeneralUtility();

	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement creatnewbutton;
	@FindBy(xpath = "//input[@id='username']")
	WebElement adminusersusername;
	@FindBy(xpath = "//input[@id='password']")
	WebElement adminuserspassword;
	@FindBy(xpath = "//select[@id='user_type']")
	WebElement usertypedropdown;
	@FindBy(xpath = "//select[@id='user_type']//option[@value='staff']")
	WebElement usertypestaff;
	@FindBy(xpath = "//select[@id='user_type']//option[@value='admin']")
	WebElement usertypeadmin;
	@FindBy(xpath = "//select[@id='user_type']//option[@value='partner']")
	WebElement usertypepartner;
	@FindBy(xpath = "//select[@id='user_type']//option[@value='db']")
	WebElement usertypedeleveryboy;
	@FindBy(xpath = "//button[@name='Create']")
	WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertmsg;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement adminuserssearch;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']")
	WebElement adminusersreset;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement searchbuttonInAdminUser;
	@FindBy(xpath = "//input[@id='un']")
	WebElement userNameFieldInSearch;
	@FindBy(xpath = "//button[@value='sr']")
	WebElement searchButtonInsideSearch;
	@FindBy(xpath = "//a[@class='btn btn-sm btn btn-danger btncss']")
	WebElement deleteButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement deleteSuccessfullyText;
	@FindBy(xpath = "//center[text()='.........RESULT NOT FOUND.......']")
	WebElement resultNotFoundText;
	@FindBy(xpath = "//table//tbody/tr//td[1]")
	List<WebElement> names;

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
		return (alertmsg.getText());
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

	public void getUserDeleteSuccessfullyAlertText() {
		System.out.println(deleteSuccessfullyText.getText());
	}

	public void getSearchResultNotFoundText() {
		System.out.println(resultNotFoundText.getText());
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
}
