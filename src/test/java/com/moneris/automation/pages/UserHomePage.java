package com.moneris.automation.pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserHomePage extends BasePage {
	public UserHomePage(WebDriver driver) {
		super(driver);
	}

	public UserHomePage verifyUpdatedProfileMessage() {
		
		WebElement updatedProfileMsg = driver.findElement(By.id("errormessage"));

		assertEquals("Your profile was updated", updatedProfileMsg.getText());

		return new UserHomePage(driver);
	}
	
	public UserHomePage checkIsOnUserHomePage() {

		assertEquals("Merchant Direct", driver.getTitle());

		return new UserHomePage(driver);
	}
	
	
}
