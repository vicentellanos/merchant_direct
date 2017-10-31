package com.moneris.automation.pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasePage {
	protected WebDriver driver;
	
	public final String BASE_URL = "https://www1.stemoneris.com/cgi-bin/rbaccess/rbunxcgi?F6=1&F7=L8&F21=PB&F22=L8&REQUEST=ClientSignin&LANGUAGE=ENGLISH";
//	public final String driverPath = "C:\\Users\\vicente.llanos\\eclipse-workspace\\merchant_direct\\src\\test\\resources\\geckodriver-v0.19.0-win64\\";
	
	public BasePage(WebDriver driver) {
//		if (driver.toString().contains("(null)")) {
//			System.setProperty("webdriver.gecko.driver", driverPath+"geckodriver.exe");
//			driver = new FirefoxDriver();
//		}
		this.driver = driver;
	}
	
	public SignInPage navigateTo() {
		driver.navigate().to(BASE_URL);
		assertEquals("Merchant Direct - Sign In", driver.getTitle());
		return new SignInPage(driver);
	}

}
