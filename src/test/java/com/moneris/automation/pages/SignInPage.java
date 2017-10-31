package com.moneris.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage extends BasePage{
	public SignInPage(WebDriver driver) {
		super(driver);
	}
	
	public SignInPage signIn(String userN, String passW) {
		WebElement usernameTextField = driver.findElement(By.name("USERID"));
		WebElement passwordTextField = driver.findElement(By.name("PASSWORD"));
		WebElement signInButton = driver.findElement(By.name("SignIn"));
		
		usernameTextField.sendKeys(userN);
		passwordTextField.sendKeys(passW);
	
		signInButton.click();
		
		return new SignInPage(driver);
	}
}
