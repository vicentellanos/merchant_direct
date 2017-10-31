package com.moneris.automation.pages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TermsOfUsePage extends BasePage {
	public TermsOfUsePage(WebDriver driver) {
		super(driver);
	}

	public TermsOfUsePage checkIsTermOfUsePage() {

		assertEquals("Merchant Direct", driver.getTitle());
		assertTrue(driver.getPageSource().contains("TERMS OF USE"));	
		assertTrue(driver.getPageSource().contains("Please read and click 'I Agree' at the bottom."));
		
		return new TermsOfUsePage(driver);
	}
	
	public TermsOfUsePage clickOnIAgreeButton() {
		WebElement iAgreeBtn = driver.findElement(By.name("Submit"));
		iAgreeBtn.click();
		return new TermsOfUsePage(driver);
	}
	
	public TermsOfUsePage clickOnIDoNotAgreeButton() {
		WebElement iDoNotAgreeBtn = driver.findElement(By.name("Cancel"));
		iDoNotAgreeBtn.click();
		return new TermsOfUsePage(driver);
	}
	
	public TermsOfUsePage clickOnPrintButton() {
		WebElement printBtn = driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[14]/td[3]/form/input"));
		printBtn.click();
		return new TermsOfUsePage(driver);
	}
}
