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
	GeneralUtility generalUtility = new GeneralUtility();
	public WebDriver driver;

	@FindBy(xpath = "//li[@class='nav-item has-treeview menu-open']//ul[@class='nav nav-treeview']//li[@class='nav-item']//a//p")
	private List<WebElement> subOptionsInManageExpense;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/expense-category']")
	private WebElement expenseCategory;
	@FindBy(xpath = "//table//tbody//tr")
	private List<WebElement> allCategoryTitle;
	@FindBy(xpath = "//input[@name='name']")
	private WebElement enterTitleNameInEdit;
	@FindBy(xpath = "//input[@name='name']")
	private WebElement SearchDetailsInExpenseCategory;
	@FindBy(xpath = "//button[@name='Update']")
	private WebElement updateBtnInEdit;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	private WebElement searchBtnInCategory;
	@FindBy(xpath = "//p[text()='Manage Expense']")
	private WebElement manageExpense;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	private WebElement createNewExpenseCategoryBtn;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	private WebElement searchExpenseCategoryBtn;
	@FindBy(xpath = "//input[@id='un']")
	private WebElement titleFieldInSearchExpenseCategory;
	@FindBy(xpath = "//button[@name='Search']")
	private WebElement searchBtnInSearchExpenseCategory;
	@FindBy(xpath = "//input[@id='name']")
	private WebElement titleOfNewExpenseCategory;
	@FindBy(xpath = "//button[@name='Create']")
	private WebElement saveButton;
	@FindBy(xpath = "(//a[text()='Reset'])[1]")
	private WebElement resetBtnInExpenseCategory;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement titleCreationSuccessAlertMsg;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	private WebElement createNewExpenseCategory;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	private WebElement newManageExpenseBtn;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	private WebElement searchManageExpenseBtn;
	@FindBy(xpath = "//select[@id='user_id']")
	private WebElement selectUser;
	@FindBy(xpath = "//input[@class='form-control date']")
	private WebElement selectDate;
	@FindBy(xpath = "//select[@id='ex_cat']")
	private WebElement selectCatagory;
	@FindBy(xpath = "//select[@id='order_id']")
	private WebElement selectOrderid;
	@FindBy(xpath = "//select[@id='purchase_id']")
	private WebElement purchaseId;
	@FindBy(xpath = "//select[@id='ex_type']")
	private WebElement expenseType;
	@FindBy(xpath = "//input[@id='amount']")
	private WebElement amount1;
	@FindBy(xpath = "//textarea[@placeholder='Enter the Content']")
	private WebElement remarksField;
	@FindBy(xpath = "//input[@type='file']")
	private WebElement chooseFileBtn;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement save;
	@FindBy(xpath = "//h5[text()=' Alert!']")
	private WebElement alert;
	@FindBy(xpath = "//button[@class='close']")
	private WebElement alertCloseBtn;
	@FindBy(xpath = "//a[text()='Cancel']")
	private WebElement cancelButton;
	@FindBy(xpath = "//select[@id='um']")
	private WebElement selectUserInSearch;
	@FindBy(xpath = "//button[@name='Search']")
	private WebElement searchBtnInSearch;
	@FindBy(xpath = "//table//tbody//tr[1]/td")
	private WebElement getSearchDetails;
	@FindBy(xpath = "//a[text()='Reset']")
	private WebElement resetBtnInSearch;
	@FindBy(xpath = "//strong[text()='Copyright © 2024 ']")
	private WebElement footerText;

	public ManageExpensePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnTheExpenseCategory() {
		expenseCategory.click();
	}

	public void clickOnTheSeachButtonInCategoryExpense() {
		searchBtnInCategory.click();
	}

	public void clickOnTheSearchButtonInExpenseCategory() {
		searchBtnInSearchExpenseCategory.click();
	}

	public void clickOnTheResetButtonInTheExpenseCategory() {
		resetBtnInExpenseCategory.click();
	}

	public void enterExpenseTitleNameInSearch(String title) {
		titleFieldInSearchExpenseCategory.sendKeys(title);
	}

	public String verifySearchedDetailsTitleName() {
		return SearchDetailsInExpenseCategory.getText();
	}

	public void clickOnTheEditCategoryButton(String titleName) {
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
		WebElement editElement = driver.findElement(By.xpath("//table//tbody//tr[" + index + "]//td[2]//a[1]"));
		editElement.click();
	}

	public void clickOnBack_Space() {
		enterTitleNameInEdit.click();
		pageUtility = new PageUtility(driver);
		pageUtility.clickBack_Space(enterTitleNameInEdit);
	}

	public void clickOnTheUpdateButtonInEdit() {
		updateBtnInEdit.click();
	}

	public void clickOnTheManageExpenseOption() {
		manageExpense.click();
	}

	public String getSubOptionsOfManageExpense() {
		List<WebElement> subOption = driver.findElements(By.xpath(
				"//li[@class='nav-item has-treeview menu-open']//ul[@class='nav nav-treeview']//li[@class='nav-item']//a//p"));
		for (WebElement e : subOption) {
			System.out.println(e.getText());
		}
		return "";
	}

	public String verifyTheFooterTextInHome() {
		return footerText.getText();
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

	public void selectCategoryInManageExpense() {
		Select select2 = new Select(selectCatagory);
		select2.selectByIndex(6);
	}

	public void selecTheOrderId() {
		Select select3 = new Select(selectOrderid);
		select3.selectByIndex(3);
	}

	public void selectThePurchaseId() {
		Select select4 = new Select(purchaseId);
		select4.selectByIndex(6);
	}

	public void selectTheExpenseType() {
		Select select5 = new Select(expenseType);
		select5.selectByIndex(2);
	}

	public void enterTheAmount(String amount) {
		amount1.sendKeys(amount);
	}

	public void enterTheRemarks(String remarks) {
		remarksField.sendKeys(remarks);
	}

	public void clickOnTheChooseFileButton() {
		String filepath = "C:\\Users\\bijuv\\Downloads\\PushNotification.xlsx";
		File file = new File(filepath);
		chooseFileBtn.sendKeys(file.getAbsolutePath());
	}

	public void clickOnTheSavaButtonInNewManageExpense() {
		PageUtility pageutility = new PageUtility(driver);
		pageutility.scrollAndClick(save);
	}

	public String newManageExpenseCreateSuccessfullyalert() {
		return alert.getText();
	}

	public void closeTheNewManageExpenseAlert() {
		alertCloseBtn.click();
	}

	public void clickOnTheCancelButton() {
		PageUtility pageutility = new PageUtility(driver);
		pageutility.scrollAndClick(cancelButton);
	}

	public void clickOnTheSearchButtonInManageExpense() {
		searchManageExpenseBtn.click();
		Select select1 = new Select(selectUserInSearch);
		select1.selectByIndex(4);
		searchBtnInSearch.click();
		System.out.println(getSearchDetails.getText());
		resetBtnInSearch.click();
	}
}
