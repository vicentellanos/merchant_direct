package com.moneris.automation.stepsDefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.moneris.automation.excel.ExcelUtility;
import com.moneris.automation.excel.UserCredentials;
import com.moneris.automation.pages.SignInPage;
import com.moneris.automation.pages.UserFunctionsPage;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SingleSignInSteps extends AbstractSteps {
	
	WebDriver driver;
	UserCredentials userCredentials = null;
	SignInPage signInPage;
	UserFunctionsPage userFunctionsPage;
	
	@When("^user signs in with credentials username:\"([^\"]*)\" password:\"([^\"]*)\"$")
	public void user_signin_with_credentials_username_password(String userN, String passW) throws Throwable {
		signInPage = new SignInPage(driver);
		signInPage.signIn(userN, passW);
	}
	
	@When("^user signs in with credentials from excel file:\"([^\"]*)\" on row:\"([^\"]*)\" with username in column:\"([^\"]*)\" and password in column:\"([^\"]*)\"$")
	public void user_signin_with_credentials_from_excel_file(String excelFileName, int excel_row, int userNameCol, int passwordCol) throws Throwable {
		signInPage = new SignInPage(driver);
		userCredentials = ExcelUtility.excel_getCredentials(excelFileName, excel_row, userNameCol, passwordCol );
		signInPage.signIn(userCredentials.getUsername(), userCredentials.getPassword());
	}
	
	@Then("^user is on Manager Functions page$")
	public void user_is_on_manager_functions_page() throws Throwable {
		userFunctionsPage = new UserFunctionsPage(driver);
		userFunctionsPage.checkIsOnManagerFunctionsPage();
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
