package com.moneris.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomerSelectionPage extends BasePage {
	public CustomerSelectionPage(WebDriver driver) {
		super(driver);
	}
	
	public CustomerSelectionPage enterCustomerNumber(String custNum) {
		WebElement customerNumberTxtF = driver.findElement(By.name("CUSTBOX"));

		customerNumberTxtF.sendKeys(custNum);
		
		return new CustomerSelectionPage(driver);
	}
	
	public CustomerSelectionPage clickOnSubmitButton() {
		WebElement submitBtn = driver.findElement(By.xpath("/html/body/center/div[2]/table/tbody/tr[6]/td/input[1]"));

		submitBtn.click();
		
		return new CustomerSelectionPage(driver);
	}
}
