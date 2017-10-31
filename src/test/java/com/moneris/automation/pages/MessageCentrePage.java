package com.moneris.automation.pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MessageCentrePage extends BasePage {
	public MessageCentrePage(WebDriver driver) {
		super(driver);
	}
	
	public void checkIsOnMessageCentrePage() {
		assertEquals("Merchant Direct - Message Centre", driver.getTitle());
	}
	
	public MessageCentrePage clickOnDisplayMessagesForUserIdRadioButton() {
		WebElement messageForUserIDRadio = driver.findElement(By.xpath("//*[@id=\"filter\"]/table/tbody/tr[3]/td/table/tbody/tr[3]/td[1]/input"));
		
		messageForUserIDRadio.click();

		return new MessageCentrePage(driver);
	}
	
	public MessageCentrePage enterDisplayMessagesForUserIdString(String userId) {
	
		WebElement messageForUserIDTextField = driver.findElement(By.name("forUser"));
		
		messageForUserIDTextField.sendKeys(userId);
	
		return new MessageCentrePage(driver);
	}
	
	public MessageCentrePage clicksOnSearchButton() {
		
		WebElement searchButton = driver.findElement(By.name("Search"));
		
		searchButton.click();
	
		return new MessageCentrePage(driver);
	}
}
