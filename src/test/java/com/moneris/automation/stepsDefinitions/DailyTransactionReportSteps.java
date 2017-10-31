package com.moneris.automation.stepsDefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.moneris.automation.pages.CustomerReportSelectionPage;
import com.moneris.automation.pages.CustomerSelectionPage;
import com.moneris.automation.pages.DailyTransactionReportMenuPage;
import com.moneris.automation.pages.MessageCentrePage;
import com.moneris.automation.pages.SignInPage;
import com.moneris.automation.pages.UserFunctionsPage;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class DailyTransactionReportSteps extends AbstractSteps {
//public final String driverPath = "C:\\Users\\vicente.llanos\\eclipse-workspace\\merchant_direct\\src\\test\\resources\\geckodriver-v0.19.0-win64\\";
	
	WebDriver driver;
	String username = null;
	SignInPage signInPage;
	UserFunctionsPage userFunctionsPage;
	MessageCentrePage messageCentrePage;
	CustomerSelectionPage customerSelectionPage;
	CustomerReportSelectionPage customerReportSelectionPage;
	DailyTransactionReportMenuPage dailyTransactionReportMenuPage;
	
//	@Given("^the Merchant Direct home page$")
//	public void the_Merchant_Direct_home_page() throws Throwable {
//		signInPage = new SignInPage(driver);
//		signInPage.navigateTo();
//	}
//
//	@When("^user signs in with credentials username:\"([^\"]*)\" password:\"([^\"]*)\"$")
//	public void user_signin_with_credentials_username_password(String userN, String passW) throws Throwable {
//		username = userN;
//		signInPage.signIn(userN, passW);
//	}
	
	@And("^user clicks on the View Customer Reports/Statements$")
	public void user_clicks_on_view_customer_reports_statements() throws Throwable {
		userFunctionsPage = new UserFunctionsPage(driver);
		userFunctionsPage.clickOnViewCustomerReportsStatements();

	}
	
//	@And("^user clicks on Display Messages For User ID radio button$")
//	public void user_clicks_on_display_message_for_userID_radio_button() throws Throwable {
//		messageCentrePage = new MessageCentrePage(driver);
//		messageCentrePage.clickOnDisplayMessagesForUserIdRadioButton();
//	}
	
	@And("^user enters the customer number:\"([^\"]*)\"$")
	public void user_enters_the_customer_number(String custNum) throws Throwable {
		customerSelectionPage = new CustomerSelectionPage(driver);
		customerSelectionPage.enterCustomerNumber(custNum);
	}
	
	@And("^user clicks on the submit button$")
	public void click_on_submit_button() throws Throwable {
		customerSelectionPage = new CustomerSelectionPage(driver);
		customerSelectionPage.clickOnSubmitButton();
	}
	
	@And("^user clicks on the Daily Transaction Report Menu$")
	public void user_clicks_on_daily_transaction_report_menu() throws Throwable {
		customerReportSelectionPage = new CustomerReportSelectionPage(driver);
		customerReportSelectionPage.clickOnDailyTransactionReportMenu();
	}
	
	
	@And("^user clicks on the Select Report button$")
	public void user_clicks_on_select_report_button() throws Throwable {
		customerReportSelectionPage = new CustomerReportSelectionPage(driver);
		customerReportSelectionPage.clickOnSelectReportButton();
	}

	@Then("^user is on Daily Transaction Report Menu page$")
	public void user_is_on_daily_transaction_report_menu_page() throws Throwable {
		dailyTransactionReportMenuPage = new DailyTransactionReportMenuPage(driver);
		dailyTransactionReportMenuPage.checkIsOnDailyTransactionReportMenuPage();
	}
	
	@Before
	public void startUp() {
//		System.setProperty("webdriver.gecko.driver", driverPath+"geckodriver.exe");
//		driver = new FirefoxDriver();
		driver = getDriver();
	}

	@After
	public void tearDown(Scenario scenario) {
		if (driver == null || driver.toString().contains("(null)"))
			return;
		if (scenario.isFailed()) {
		      // Take a screenshot...
		      final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		      scenario.embed(screenshot, "image/png"); // ... and embed it in the report.
		}
		driver.quit();
	}
}
