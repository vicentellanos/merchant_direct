package com.moneris.automation.pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends BasePage {
	public ChangePasswordPage(WebDriver driver) {
		super(driver);
	}

	public ChangePasswordPage checkIsOnChangePasswordPage() {

		assertEquals("Merchant Direct - Change Password", driver.getTitle());

		return new ChangePasswordPage(driver);
	}

	public ChangePasswordPage enterOldPassword(String oldPassword) {
		if (oldPassword != null) {
			WebElement oldPasswordTF = driver.findElement(By.name("PASSWORD"));

			oldPasswordTF.sendKeys(oldPassword);
		}
		return new ChangePasswordPage(driver);
	}

	public ChangePasswordPage enterNewPassword(String newPassword) {
		if ( newPassword != null) {
			WebElement newPasswordTF = driver.findElement(By.name("NEWPASS1"));

			newPasswordTF.sendKeys(newPassword);
		}
		return new ChangePasswordPage(driver);
	}
	
	public ChangePasswordPage enterReEnterNewPassword(String reEnterNewPassword) {
		if ( reEnterNewPassword != null) {
			WebElement reEnterNewPasswordTF = driver.findElement(By.name("NEWPASS2"));

			reEnterNewPasswordTF.sendKeys(reEnterNewPassword);
		}
		return new ChangePasswordPage(driver);
	}
	
	public ChangePasswordPage clickOnSubmitButton() {
		WebElement submitBtn = driver.findElement(By.name("Ok"));
		submitBtn.click();
		return new ChangePasswordPage(driver);
	}
	
	public ChangePasswordPage clickOnCancelButton() {
		WebElement cancelBtn = driver.findElement(By.name("Cancel"));
		cancelBtn.click();
		return new ChangePasswordPage(driver);
	}
}
