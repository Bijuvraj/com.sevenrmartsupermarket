package com.sevenrmartsupermarket.utilities;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	WebDriver driver;
	WebDriverWait wait;

	public WaitUtility(WebDriver driver) {
		this.driver = driver;
	}

	public void waitForClickable(WebElement element, long time) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitForInVisibility(WebElement element, long time) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	public void waitForSelected(WebElement element, long time) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}

	public void waitForVisibility(WebElement element, long time) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForLoadingWindow(WebElement element, long time) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
