package com.sevenrmartsupermarket.pages;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class ManageExpensePage {
	PageUtility pageUtility;
	HomePage homePage;
	GeneralUtility generalUtility;
	public WebDriver driver;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/expense-category']")
	WebElement expenseCategory;
	@FindBy(xpath = "//table//tbody//tr//td")
	List<WebElement> allCategoryTitle;
	@FindBy(xpath = "//input[@name='name']")
	WebElement enterTitleNameInEdit;
	@FindBy(xpath = "//button[@name='Update']")
	WebElement updateBtnInEdit;
	@FindBy(xpath ="//a[@onclick='click_button(2)']")
	WebElement searchBtnInCategory;
	@FindBy(xpath = "//p[text()='Manage Expense']")////a[@href='https://groceryapp.uniqassosiates.com/admin/list-expense']
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
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newManageExpenseBtn;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement searchManageExpenseBtn;
	@FindBy(xpath = "//select[@id='user_id']")
	WebElement selectUser;
	@FindBy(xpath = "//input[@class='form-control date']")
	WebElement selectDate;
	@FindBy(xpath = "//select[@id='ex_cat']")
	WebElement selectCatagory;
	@FindBy(xpath = "//select[@id='order_id']")
	WebElement selectOrderid;
	@FindBy(xpath = "//select[@id='purchase_id']")
	WebElement purchaseId;
	@FindBy(xpath = "//select[@id='ex_type']")
	WebElement expenseType;
	@FindBy(xpath = "//input[@id='amount']")
	WebElement amount1;
	@FindBy(xpath = "//textarea[@placeholder='Enter the Content']")
	WebElement remarksField;
	@FindBy(xpath = "//input[@type='file']")
	WebElement chooseFileBtn;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement save;
	@FindBy(xpath = "//h5[text()=' Alert!']")
	WebElement alert;
	@FindBy(xpath = "//button[@class='close']")
	WebElement alertCloseBtn;
	@FindBy(xpath ="//a[text()='Cancel']")
	WebElement cancelButton;
	@FindBy(xpath = "//select[@id='um']")
	WebElement selectUserInSearch;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchBtnInSearch;
	@FindBy(xpath ="//table//tbody//tr[1]/td")
	WebElement getSearchDetails;
	@FindBy(xpath = "//a[text()='Reset']")
	WebElement resetBtnInSearch;
	

	public ManageExpensePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnTheExpenseCategory() {
		expenseCategory.click();
	}
	public void clickOnTheSeachButtonInCategoryExpense()
	{
		searchBtnInCategory.click();
	}
	public void clickOnTheEditCategoryButton(String titleName)
	{
		GeneralUtility generalUtility= new GeneralUtility();
		List<String> allName = new ArrayList<String>();
		allName = generalUtility.getTextOfElements(allCategoryTitle);
		int index = 0;
		for (index = 0; index < allName.size(); index++) {
			if (titleName.equals(allName.get(index))) {
				index++;
				break;
			}
		}
		System.out.println(allName);
		WebElement nameElement = driver.findElement(By.xpath("//div//table//tbody//tr["+index+"]//td[2]//a[1]"));
		nameElement.click();
	}
	public void clickOnBack_Space()
	{
		enterTitleNameInEdit.click();
		pageUtility = new PageUtility(driver);
		pageUtility.clickBack_Space(enterTitleNameInEdit);
	}
	public void clickOnTheUpdateButtonInEdit()
	{
		updateBtnInEdit.click();
	}

	public void clickOnTheManageExpenseOption() {
		manageExpense.click();
	}

	public void cilckOnTheNewExpenseCategoryButton() {
		createNewExpenseCategory.click();
	}

	public void enterTheTitle(String title) {
		titleOfNewExpenseCategory.sendKeys(title);
	}

	public void ClickOnTheSaveButton() {
		saveButton.click();
	}

	public String getTitleCreateSuccessfullAlertMsg() {
		return (titleCreationSuccessAlertMsg.getText());
	}

	public void clickOnTheNewManageExpenseButton() {
		newManageExpenseBtn.click();
	}

	public void selectUserId() {
		Select select1 = new Select(selectUser);
		select1.selectByIndex(4);
	}
	public void selectCategoryInManageExpense()	{
		Select select2 = new Select(selectCatagory);
		select2.selectByIndex(6);
	}
	public void selecTheOrderId()
	{
		Select select3 = new Select(selectOrderid);
		select3.selectByIndex(3);
	}
	public void selectThePurchaseId()	
	{
		Select select4 = new Select(purchaseId);
		select4.selectByIndex(6);
	}
	public void selectTheExpenseType()
	{
		Select select5 = new Select(expenseType);
		select5.selectByIndex(2);
	}
	public void enterTheAmount(String amount)	
	{
		amount1.sendKeys(amount);
	}
	public void enterTheRemarks(String remarks)
	{
		remarksField.sendKeys(remarks);
	}
	public void clickOnTheChooseFileButton()
	{
		String filepath = "C:\\Users\\bijuv\\Downloads\\PushNotification.xlsx";
		File file = new File(filepath);
		chooseFileBtn.sendKeys(file.getAbsolutePath());
	}
	public void clickOnTheSavaButtonInNewManageExpense()
	{
		PageUtility pageutility = new PageUtility(driver);
		pageutility.scrollAndClick(save);
	}
	public String newManageExpenseCreateSuccessfullyalert() {
		return alert.getText();
	}
	public void closeTheNewManageExpenseAlert()
	{
		alertCloseBtn.click();
	}
	public void clickOnTheCancelButton()
	{
		PageUtility pageutility = new PageUtility(driver);
		pageutility.scrollAndClick(cancelButton);
	}
	public void clickOnTheSearchButtonInManageExpense()
	{
		searchManageExpenseBtn.click();
		Select select1 = new Select(selectUserInSearch);
		select1.selectByIndex(4);
		searchBtnInSearch.click();
		System.out.println(getSearchDetails.getText());
		resetBtnInSearch.click();
	}
	
}
