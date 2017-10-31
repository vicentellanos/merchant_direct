package com.moneris.automation.pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class UpdateYourProfilePage extends BasePage{
	public UpdateYourProfilePage(WebDriver driver) {
		super(driver);
	}

	public UpdateYourProfilePage checkIsOnUpdateYourProfilePage() {

		assertEquals("Merchant Direct - Update Your Profile", driver.getTitle());

		return new UpdateYourProfilePage(driver);
	}
	
	public UpdateYourProfilePage clickOnUpdateProfileButton() {
		WebElement updateYourProfileBtn = driver.findElement(By.name("Update"));
		updateYourProfileBtn.click();
		return new UpdateYourProfilePage(driver);
	}
	
	public UpdateYourProfilePage clickOnCancelButton() {
		WebElement cancelBtn = driver.findElement(By.name("Cancel"));
		cancelBtn.click();
		return new UpdateYourProfilePage(driver);
	}
	
	public UpdateYourProfilePage selectPreferredLanguage(String preferredLanguage) {
		WebElement preferredLanguageElem = driver.findElement(By.name("prefLang"));
		Select preferredLanguageElemDD = new Select(preferredLanguageElem);
		if (preferredLanguage != null && preferredLanguageElem.isEnabled()) {
			preferredLanguageElemDD.selectByVisibleText(preferredLanguage);
		}
		return new UpdateYourProfilePage(driver);
	}
}
