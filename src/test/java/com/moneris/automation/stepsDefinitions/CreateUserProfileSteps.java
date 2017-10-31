package com.moneris.automation.stepsDefinitions;

import java.util.HashMap;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.moneris.automation.excel.ExcelUtility;
import com.moneris.automation.excel.UserInformation;
import com.moneris.automation.pages.ChangePasswordPage;
import com.moneris.automation.pages.CreateUserProfilePage;
import com.moneris.automation.pages.SignInPage;
import com.moneris.automation.pages.TermsOfUsePage;
import com.moneris.automation.pages.TopMenuPage;
import com.moneris.automation.pages.UpdateYourProfilePage;
import com.moneris.automation.pages.UserFunctionsPage;
import com.moneris.automation.pages.UserHomePage;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class CreateUserProfileSteps extends AbstractSteps {
	WebDriver driver;
	String username = null;
	SignInPage signInPage;
	UserFunctionsPage userFunctionsPage;
	CreateUserProfilePage createUserProfilePage;
	TermsOfUsePage termsOfUsePage;
	ChangePasswordPage changePasswordPage;
	UpdateYourProfilePage updateYourProfilePage;
	UserHomePage userHomePage;
	TopMenuPage topMenuPage;
	
	HashMap<Integer, UserInformation> userInfo;
	
	@Given("^user is on the Create User Profile page$")
	public void user_is_on_the_create_user_profile_page() throws Throwable {
		createUserProfilePage = new CreateUserProfilePage(driver);
		createUserProfilePage.checkIsOnCreateUserProfilePage();
	}
	
	@And("^user clicks on the Create User Profiles Link$")
	public void user_clicks_on_the_create_user_profiles_link() throws Throwable {
		userFunctionsPage = new UserFunctionsPage(driver);
		userFunctionsPage.clickOnCreateUserProfiles();
	}
	
	@And("^user enters the User ID \"([^\"]*)\"$")
	public void user_enters_the_user_ID(int excel_row) throws Throwable {
		createUserProfilePage = new CreateUserProfilePage(driver);
		
		System.out.println("The user ID:"+userInfo.get(excel_row).getUserID());
	
		createUserProfilePage.enterUserId(userInfo.get(excel_row).getUserID());
	}
	
	@And("^user enters the Password Email Address \"([^\"]*)\"$")
	public void user_enters_the_password_email_address(int excel_row) throws Throwable {
		createUserProfilePage = new CreateUserProfilePage(driver);
		createUserProfilePage.enterPasswordEmailAddress(userInfo.get(excel_row).getPasswordEmailAddress());
	}
	
	@And("^user enters the Notification Email Address \"([^\"]*)\"$")
	public void user_enters_the_notification_email_address(int excel_row) throws Throwable {
		createUserProfilePage = new CreateUserProfilePage(driver);
		createUserProfilePage.enterNotificationEmailAddress(userInfo.get(excel_row).getNotificationEmailAddress());
	}
	
	@And("^user enters the User Name \"([^\"]*)\"$")
	public void user_enters_the_user_name(int excel_row) throws Throwable {
		createUserProfilePage = new CreateUserProfilePage(driver);
		createUserProfilePage.enterUserName(userInfo.get(excel_row).getUserName());
	}
	
	@And("^user selects the User Type \"([^\"]*)\"$")
	public void user_enters_the_user_type(int excel_row) throws Throwable {
		createUserProfilePage = new CreateUserProfilePage(driver);
		createUserProfilePage.selectUserType(userInfo.get(excel_row).getUserType());
	}
	
	@And("^user enters the Customer ID \"([^\"]*)\"$")
	public void user_enters_the_customer_ID(int excel_row) throws Throwable {
		createUserProfilePage = new CreateUserProfilePage(driver);
		createUserProfilePage.enterCustomerId(userInfo.get(excel_row).getCustomerID());
	}
	
	@And("^user enters the Sales Rep Code \"([^\"]*)\"$")
	public void user_enters_the_sales_rep_code(int excel_row) throws Throwable {
		createUserProfilePage = new CreateUserProfilePage(driver);
		createUserProfilePage.enterSalesRepCode(userInfo.get(excel_row).getSalesRepCode());
	}
	
	@And("^user enters the Customer Type \"([^\"]*)\"$")
	public void user_enters_the_customer_type(int excel_row) throws Throwable {
		createUserProfilePage = new CreateUserProfilePage(driver);
		createUserProfilePage.enterCustomerType(userInfo.get(excel_row).getCustomerType());
	}
	
	@And("^user selects the Message Centre Access \"([^\"]*)\"$")
	public void user_selects_the_message_centre_access(int excel_row) throws Throwable {
		createUserProfilePage = new CreateUserProfilePage(driver);
		createUserProfilePage.selectMessageCentreAccess(userInfo.get(excel_row).getMessageCentreAccess());
	}
	
	@And("^user selects the Outgoing Messages Access \"([^\"]*)\"$")
	public void user_selects_the_outgoing_messages_access(int excel_row) throws Throwable {
		createUserProfilePage = new CreateUserProfilePage(driver);
		createUserProfilePage.selectOutgoingMessagesAccess(userInfo.get(excel_row).getOutgoingMessagesAccess());
	}
	
	@And("^user selects the Cardholder Data Access \"([^\"]*)\"$")
	public void user_selects_the_cardholder_data_acccess(int excel_row) throws Throwable {
		createUserProfilePage = new CreateUserProfilePage(driver);
		createUserProfilePage.selectCardholderDataAccess(userInfo.get(excel_row).getCardholderDataAccess());
	}
	
	@And("^user selects the Reports Access \"([^\"]*)\"$")
	public void user_selects_the_reports_access(int excel_row) throws Throwable {
		createUserProfilePage = new CreateUserProfilePage(driver);
		createUserProfilePage.selectReportsAccess(userInfo.get(excel_row).getReportsAccess());
	}
	
	@And("^user selects the Rewards Management \"([^\"]*)\"$")
	public void user_selects_the_rewards_management(int excel_row) throws Throwable {
		createUserProfilePage = new CreateUserProfilePage(driver);
		createUserProfilePage.selectRewardsManagement(userInfo.get(excel_row).getRewardsManagement());
	}
	
	@And("^user enters the Additional Customer Numbers \"([^\"]*)\"$")
	public void user_selects_the_additional_customer_numbers(int excel_row) throws Throwable {
		createUserProfilePage = new CreateUserProfilePage(driver);
		createUserProfilePage.enterAdditionalCustomerNumbers(userInfo.get(excel_row).getAdditionalCustomerNumbers());
	}
	
	@And("^user clicks on the Submit button of Create User Profile$")
	public void user_clicks_on_the_submit_button_of_create_user_profile() throws Throwable {
		createUserProfilePage = new CreateUserProfilePage(driver);
		createUserProfilePage.clickOnSubmitButton();
	}
	
//	@And("^user clicks on the Daily Transaction Report Menu$")
//	public void user_clicks_on_daily_transaction_report_menu() throws Throwable {
//		customerReportSelectionPage = new CustomerReportSelectionPage(driver);
//		customerReportSelectionPage.clickOnDailyTransactionReportMenu();
//	}

	@Then("^the temporary password is displayed$")
	public void user_is_on_daily_transaction_report_menu_page() throws Throwable {
		createUserProfilePage = new CreateUserProfilePage(driver);
		createUserProfilePage.checkTempPasswordIsDisplayed();
	}
	
	@And("^the temporary password is saved on the excel spreadsheet row \"([^\"]*)\"$")
	public void the_temporary_password_is_saved_on_the_excel_spreadsheet(int excel_row) throws Throwable {
		createUserProfilePage = new CreateUserProfilePage(driver);
		
		ExcelUtility.writeTempPasswordToExcel(createUserProfilePage.extractTempPassword(), excel_row);
	}
	
	/* Steps for the finalizing the create user profile  - finalizeCreateUserProfile.feature */	
	
	@Then("^user is on Terms of Use page$")
	public void user_is_on_terms_of_use_page() throws Throwable {
		termsOfUsePage = new TermsOfUsePage(driver);
		termsOfUsePage.checkIsTermOfUsePage();
	}
	
	@And("^user clicks on the I Agree button of the Terms of Use page$")
	public void user_clicks_on_the_i_agree_button_of_the_terms_of_use_page() throws Throwable {
		termsOfUsePage = new TermsOfUsePage(driver);
		termsOfUsePage.clickOnIAgreeButton();
	}
	
	@Then("^user is on Change Password Page$")
	public void user_is_on_change_password_page() throws Throwable {
		changePasswordPage = new ChangePasswordPage(driver);
		changePasswordPage.checkIsOnChangePasswordPage();
	}
	
	@And("^user enters the Old Password \"([^\"]*)\"$")
	public void user_enters_the_old_password(int excel_row) throws Throwable {
		changePasswordPage = new ChangePasswordPage(driver);
		changePasswordPage.enterOldPassword(userInfo.get(excel_row).getTemporaryPassword());
	}
	
	@And("^user enters the New Password \"([^\"]*)\"$")
	public void user_enters_the_new_password(int excel_row) throws Throwable {
		changePasswordPage = new ChangePasswordPage(driver);
		changePasswordPage.enterNewPassword(userInfo.get(excel_row).getNewPassword());
	}
	
	@And("^user re-enters the New Password \"([^\"]*)\"$")
	public void user_re_enters_the_new_password(int excel_row) throws Throwable {
		changePasswordPage = new ChangePasswordPage(driver);
		changePasswordPage.enterReEnterNewPassword(userInfo.get(excel_row).getNewPassword());
	}
	
	@And("^user clicks on the Submit button of the Change Pasword page$")
	public void user_clicks_on_the_submit_button_of_the_change_password_page() throws Throwable {
		changePasswordPage = new ChangePasswordPage(driver);
		changePasswordPage.clickOnSubmitButton();
	}
	
	@Then("^user is on Update Your Profile Page$")
	public void user_is_on_update_your_profile_page() throws Throwable {
		updateYourProfilePage = new UpdateYourProfilePage(driver);
		updateYourProfilePage.checkIsOnUpdateYourProfilePage();
	}
	
	@And("^user selects the Preferred Language \"([^\"]*)\"$")
	public void user_selects_the_preferred_language(String preferredLanguage) throws Throwable {
		updateYourProfilePage = new UpdateYourProfilePage(driver);
		updateYourProfilePage.selectPreferredLanguage(preferredLanguage);
	}
	
	@And("^user clicks on the Update Profile button$")
	public void user_clicks_on_the_update_profile_button() throws Throwable {
		updateYourProfilePage = new UpdateYourProfilePage(driver);
		updateYourProfilePage.clickOnUpdateProfileButton();
	}
	
	@And("^user is on the Home Page$")
	public void user_is_on_the_home_page() throws Throwable {
		userHomePage = new UserHomePage(driver);
		userHomePage.checkIsOnUserHomePage();
	}
	 
	@And("^user clicks on the \"([^\"]*)\" link$")
	public void user_clicks_on_the_sign_out_link(String linkOption) throws Throwable {
		topMenuPage = new TopMenuPage(driver);
		topMenuPage.clickOnLink(linkOption);
	}
	
	@Before
	public void startUp() {
		driver = getDriver();
		userInfo = ExcelUtility.convertExcelCreateUsersToHashMap();
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
