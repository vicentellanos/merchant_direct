package com.moneris.automation.pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DailyTransactionReportMenuPage extends BasePage {
	public DailyTransactionReportMenuPage(WebDriver driver) {
		super(driver);
	}
	
	public DailyTransactionReportMenuPage checkIsOnDailyTransactionReportMenuPage() {
	
		assertEquals("Daily Transaction Report Menu", driver.getTitle());
		
		return new DailyTransactionReportMenuPage(driver);
	}
	
//	public DailyTransactionReportMenuPage clickOnDailyTransactionReportMenu() {
//		WebElement submitBtn = driver.findElement(By.name("FOCEXEC_LIST"));
//
//		submitBtn.click();
//		
//		return new DailyTransactionReportMenuPage(driver);
//	}
	
//	public DailyTransactionReportMenuPage clickOnSelectReportButton() {
//		WebElement selectReportBtn = driver.findElement(By.xpath("//input[@name='Select Report']"));
//
//		selectReportBtn.click();
//		
//		return new DailyTransactionReportMenuPage(driver);
//	}
}
