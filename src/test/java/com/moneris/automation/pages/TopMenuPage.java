package com.moneris.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TopMenuPage extends BasePage{
	public TopMenuPage(WebDriver driver) {
		super(driver);
	}
	
	public void clickOnLink(String linkOption) {
		WebElement signOutLink = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(linkOption)));
		signOutLink.click();
	}
}
