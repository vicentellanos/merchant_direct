package com.moneris.automation.pages;

import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerReportSelectionPage extends BasePage{
	public CustomerReportSelectionPage(WebDriver driver) {
		super(driver);
	}
	
	public CustomerReportSelectionPage checkDailyAndDateRangeReportsIsDisplay() {
		
		WebElement dailyAndDateRangeReportsText = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("CUSTBOX/html/body/center/div[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[1]/td/table/tbody/tr/td")));
		
		assertEquals("Daily and Date Range Reports", dailyAndDateRangeReportsText.getText());
		
		return new CustomerReportSelectionPage(driver);
	}
	
	public CustomerReportSelectionPage clickOnDailyTransactionReportMenu() {
		
		WebElement dialyTransactionReportMenuRadio = driver.findElement(By.xpath("/html/body/center/div[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[12]/td/input"));
	
		dialyTransactionReportMenuRadio.click();
		
		return new CustomerReportSelectionPage(driver);
	}
	
	public CustomerReportSelectionPage clickOnSelectReportButton() {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		
		WebElement selectReportBtn = driver.findElement(By.xpath("/html/body/center/div[2]/table/tbody/tr[5]/td/input[1]"));

		selectReportBtn.click();
		
		return new CustomerReportSelectionPage(driver);
	}
}
