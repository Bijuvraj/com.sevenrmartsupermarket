package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageExpensePage {
	public WebDriver driver;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/expense-category']")
	WebElement expenseCategory;
	@FindBy(xpath ="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-expense']")
	WebElement manageExpense;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement createNewExpenseCategoryBtn;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement searchExpenseCategoryBtn;
	@FindBy(xpath = "//input[@id='name']")
	WebElement titleOfNewExpenseCategory;
	@FindBy(xpath = "//button[@name='Create']")
	WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement titleCreationSuccessAlertMsg;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement createNewExpenseCategory;
	
	public ManageExpensePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnTheExpenseCategory()
	{
		expenseCategory.click();
	}
	public void clickOnTheManageExpenseOption()
	{
		manageExpense.click();
	}
	public void cilckOnTheNewExpenseCategoryButton()
	{
		createNewExpenseCategory.click();
	}
	public void enterTheTitle(String title)
	{
		titleOfNewExpenseCategory.sendKeys(title);
	}
	public void ClickOnTheSaveButton()
	{
		saveButton.click();
	}
	public String getTitleCreateSuccessfullAlertMsg()
	{
		return (titleCreationSuccessAlertMsg.getText());
	}
	public void clickOnTheNewManageExpenseButton()
	{
		
	}
}
