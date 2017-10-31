package com.moneris.automation.stepsDefinitions;

import java.util.HashMap;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.moneris.automation.excel.ExcelUtility;
import com.moneris.automation.excel.UserCredentials;
import com.moneris.automation.excel.UserInformation;
import com.moneris.automation.pages.MessageCentrePage;
import com.moneris.automation.pages.SignInPage;
import com.moneris.automation.pages.UserFunctionsPage;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SigninSteps extends AbstractSteps{
	
	WebDriver driver;
	UserCredentials userCredentials = null;
	SignInPage signInPage;
	UserFunctionsPage userFunctionsPage;
	MessageCentrePage messageCentrePage;
	
	HashMap<Integer, UserInformation> userInfo;
	
	@Given("^the Merchant Direct home page$")
	public void the_Merchant_Direct_home_page() throws Throwable {
		signInPage = new SignInPage(driver);
		signInPage.navigateTo();
	}

	@When("^user signs in with credentials \"([^\"]*)\"$")
	public void user_signs_in_with_credentials_username_password(int row) throws Throwable {
		signInPage = new SignInPage(driver);
		userCredentials = ExcelUtility.excel_getCredentials(row);
		signInPage.signIn(userCredentials.getUsername(), userCredentials.getPassword());
	}
	
	@And("^user clicks on the Message Centre Link$")
	public void user_clicks_on_message_centre() throws Throwable {
		userFunctionsPage = new UserFunctionsPage(driver);
		userFunctionsPage.clickOnMessageCentreLink();

	}
	
	@And("^user clicks on Display Messages For User ID radio button$")
	public void user_clicks_on_display_message_for_userID_radio_button() throws Throwable {
		messageCentrePage = new MessageCentrePage(driver);
		messageCentrePage.clickOnDisplayMessagesForUserIdRadioButton();
	}
	
	@And("^user enters the User ID:\"([^\"]*)\"$")
	public void user_enters_the_userID(String userId) throws Throwable {
		messageCentrePage = new MessageCentrePage(driver);
		messageCentrePage.enterDisplayMessagesForUserIdString(userId);
	}
	
	@And("^user clicks on the search button$")
	public void click_on_search_button() throws Throwable {
		messageCentrePage = new MessageCentrePage(driver);
		messageCentrePage.clicksOnSearchButton();
	}

	@Then("^signout is available$")
	public void signout_is_available() throws Throwable {
		userFunctionsPage = new UserFunctionsPage(driver);
		userFunctionsPage.checkSignOutIsDisplayed();
	}
	
	@Before
	public void startUp() {
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
