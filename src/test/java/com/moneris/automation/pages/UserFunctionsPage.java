package com.moneris.automation.pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserFunctionsPage extends BasePage {
	
	public UserFunctionsPage(WebDriver driver) {
		super(driver);
	}
	
	public UserFunctionsPage checkSignOutIsDisplayed() {
		WebElement userNameBanner = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sign Out")));
		
		assertEquals("Sign Out", userNameBanner.getText());
		
		return new UserFunctionsPage(driver);
	}
	
	public UserFunctionsPage checkIsOnManagerFunctionsPage() {
		assertEquals("Merchant Direct - Manager Functions", driver.getTitle());
		
		return new UserFunctionsPage(driver);
	}
	
	public void clickOnMessageCentreLink() {
		WebElement messageCentreLink = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Message Centre")));
		messageCentreLink.click();
	}
	
	public void clickOnViewCustomerReportsStatements() {
//		WebElement customerReports = driver.findElement(By.linkText("View Customer Reports/Statements"));
		
		WebElement customerReports = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("View Customer Reports/Statements")));
		customerReports.click();
	}
	
	public void clickOnCreateUserProfiles() {
//		WebElement customerReports = driver.findElement(By.linkText("View Customer Reports/Statements"));
		
		WebElement createUserProfiles = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Create User Profiles")));
		createUserProfiles.click();
	}
	
}
