package com.sevenrmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.sevenrmartsupermarket.constants.Constants;

public class LoginPage {
	public WebDriver driver;
	Properties properties = new Properties();

	@FindBy(xpath = "//input[@placeholder='Username']")
	private WebElement userNameField;
	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement passwordField;
	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement loginButton;
	@FindBy(xpath = "//label[@for='remember']") 
	private WebElement checkBox;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

		try {
			FileInputStream fi = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(fi);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterUserName(String userName) {
		userNameField.sendKeys(userName);
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void clickOnLoginButton() {
		loginButton.click();
	}

	public String verifySignInButtonText() {
		return (loginButton.getText());
	}

	public void login(String userName, String password) {
		enterUserName(userName);
		enterPassword(password);
		clickOnLoginButton();
	}

	public void login() {
		String userName = properties.getProperty("userName");
		String password = properties.getProperty("password");
		enterUserName(userName);
		enterPassword(password);
		clickOnLoginButton();
	}

	public void clickOnCheckBox() {
		checkBox.click();
	}

	public boolean verifyThecheckBox_isEnabled() {
		return(checkBox.isEnabled());
	}

	public boolean verifyCheckBoxisDisplayed() {
		return(checkBox.isDisplayed());
	}

	public boolean verifyThe_CheckBoxisSelected() {
		return(checkBox.isSelected());
	}

	public String verifyTheBackgrountColorFor_SigninButton() {
		return (loginButton.getCssValue("color"));
	}

	public String verifyRememberMeButtonText() {
		return (checkBox.getText());
	}
}
