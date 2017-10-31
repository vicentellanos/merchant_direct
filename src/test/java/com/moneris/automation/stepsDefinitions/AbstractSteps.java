package com.moneris.automation.stepsDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class AbstractSteps {
	public static final String FIREFOX_DRIVER_PATH = System.getProperty("user.dir")+"\\src\\test\\resources\\geckodriver-v0.19.0-win64\\";
	public static final String CHROME_DRIVER_PATH = System.getProperty("user.dir")+"\\src\\test\\resources\\chromedriver_win32\\";
	public static final String INTERNET_EXPLORER_64_BIT_DRIVER_PATH = System.getProperty("user.dir")+"\\src\\test\\resources\\IEDriverServer_x64_3.6.0\\";
	public static final String INTERNET_EXPLORER_32_BIT_DRIVER_PATH = System.getProperty("user.dir")+"\\src\\test\\resources\\IEDriverServer_Win32_3.6.0\\";

	public static final String browser = System.getProperty("browser");
	protected static WebDriver driver;

	protected WebDriver getDriver() {
		if (driver == null || driver.toString().contains("(null)")) {
			if ( browser != null) {
				if (browser.equals("firefox")) {
					System.setProperty("webdriver.gecko.driver", FIREFOX_DRIVER_PATH+"geckodriver.exe");
					driver = new FirefoxDriver();
				}
				else if (browser.equals("chrome")) {
					System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH+"chromedriver.exe");
					driver = new ChromeDriver();
				}
				else if (browser.equals("iexplorer")) {
					System.setProperty("webdriver.ie.driver", INTERNET_EXPLORER_32_BIT_DRIVER_PATH+"IEDriverServer.exe");
					driver = new InternetExplorerDriver();
				}
			}
			else {
				System.setProperty("webdriver.gecko.driver", FIREFOX_DRIVER_PATH+"geckodriver.exe");
				driver = new FirefoxDriver();
			}
		}
		return driver;
	}
}
