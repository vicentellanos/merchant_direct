package com.moneris.automation.pages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateUserProfilePage extends BasePage {
	public CreateUserProfilePage(WebDriver driver) {
		super(driver);
	}

	public CreateUserProfilePage checkIsOnCreateUserProfilePage() {

		assertEquals("Merchant Direct - Create User Profile", driver.getTitle());

		return new CreateUserProfilePage(driver);
	}

	public CreateUserProfilePage enterUserId(String userId) {
		if (userId != null) {
			WebElement userIdTF = driver.findElement(By.name("NUSERID"));

			userIdTF.sendKeys(userId);
		}
		return new CreateUserProfilePage(driver);
	}

	public CreateUserProfilePage enterPasswordEmailAddress(String passwordEmailAddress) {
		if ( passwordEmailAddress != null) {
			WebElement passwordEmailAddressTF = driver.findElement(By.name("EMAILPSW"));

			passwordEmailAddressTF.sendKeys(passwordEmailAddress);
		}
		return new CreateUserProfilePage(driver);
	}

	public CreateUserProfilePage enterNotificationEmailAddress(String notificationEmailAddress) {

		if (notificationEmailAddress != null) { 
			WebElement notificationEmailAddressTF = driver.findElement(By.name("EMAIL"));

			notificationEmailAddressTF.sendKeys(notificationEmailAddress);
		}
		return new CreateUserProfilePage(driver);
	}

	public CreateUserProfilePage enterUserName(String userName) {
		if (userName != null) {
			WebElement userNameTF = driver.findElement(By.name("NUSERNAME"));

			userNameTF.sendKeys(userName);
		}
		return new CreateUserProfilePage(driver);
	}

	public CreateUserProfilePage selectUserType(String userType) {
		if (userType != null) {
			Select userTypeDD = new Select(driver.findElement(By.name("NUSERTYPE")));
			userTypeDD.selectByVisibleText(userType);
		}
		return new CreateUserProfilePage(driver);
	}

	public CreateUserProfilePage enterCustomerId(String customerId) {
		if (customerId != null) { 
			WebElement customerIdTF = driver.findElement(By.name("NCUSTNO"));

			customerIdTF.sendKeys(customerId);
		}
		return new CreateUserProfilePage(driver);
	}

	public CreateUserProfilePage enterSalesRepCode(String salesRepCode) {
		if (salesRepCode != null) {
			WebElement salesRepCodeTF = driver.findElement(By.name("REPCODE"));

			salesRepCodeTF.sendKeys(salesRepCode);
		}
		return new CreateUserProfilePage(driver);
	}

	public CreateUserProfilePage enterCustomerType(String customerType) {
		
		WebElement customerTypeTF = driver.findElement(By.name("CUSTTYPE"));
		if (customerType != null && customerTypeTF.isEnabled()) {
			customerTypeTF.sendKeys(customerType);
		}
		return new CreateUserProfilePage(driver);
	}


	public CreateUserProfilePage selectMessageCentreAccess(String messageCentreAccess) {
		WebElement messageCentreAccessElement = driver.findElement(By.name("SMCIND"));
		
		if (messageCentreAccess != null && messageCentreAccessElement.isEnabled()) {
			Select messageCentreAccessDD = new Select(messageCentreAccessElement);
			messageCentreAccessDD.selectByVisibleText(messageCentreAccess);
		}
		return new CreateUserProfilePage(driver);
	}

	public CreateUserProfilePage selectOutgoingMessagesAccess(String outgoingMessagesAccess) {
		WebElement outgoingMessagesAccessElement = driver.findElement(By.name("OUTIND"));
		if (outgoingMessagesAccess != null && outgoingMessagesAccessElement.isEnabled()) {
			Select outgoingMessagesAccessDD = new Select(outgoingMessagesAccessElement);
			outgoingMessagesAccessDD.selectByVisibleText(outgoingMessagesAccess);
		}
		return new CreateUserProfilePage(driver);
	}

	public CreateUserProfilePage selectCardholderDataAccess(String cardholderDataAccess) {
		WebElement cardholderDataAccessElement = driver.findElement(By.name("CHLDRIND"));
		Select cardholderDataAccessDD = new Select(cardholderDataAccessElement);
		if (cardholderDataAccess != null && cardholderDataAccessElement.isEnabled()) {
			cardholderDataAccessDD.selectByVisibleText(cardholderDataAccess);
		}
		return new CreateUserProfilePage(driver);
	}

	public CreateUserProfilePage selectReportsAccess(String reportsAccess) {
		WebElement reportsAccessElement = driver.findElement(By.name("RPTACSIND"));
		Select reportsAccessDD = new Select(reportsAccessElement);
		if (reportsAccess != null && reportsAccessElement.isEnabled() ) {
			reportsAccessDD.selectByVisibleText(reportsAccess);
		}
		return new CreateUserProfilePage(driver);
	}

	public CreateUserProfilePage selectRewardsManagement(String rewardsManagement) {
		WebElement rewardsManagementElem = driver.findElement(By.name("REWMANIND"));
		Select rewardsManagementDD = new Select(rewardsManagementElem);
		if (rewardsManagement != null && rewardsManagementElem.isEnabled()) {
			rewardsManagementDD.selectByVisibleText(rewardsManagement);
		}
		return new CreateUserProfilePage(driver);
	}

	public CreateUserProfilePage enterAdditionalCustomerNumbers(String additionalInfo) {

		WebElement additionalInfoTA = driver.findElement(By.name("CustNums"));
		if (additionalInfo != null && additionalInfoTA.isEnabled())  {
			additionalInfoTA.sendKeys(additionalInfo);
		}

		return new CreateUserProfilePage(driver);
	}

	public CreateUserProfilePage clickOnSubmitButton() {
		WebElement submitBtn = driver.findElement(By.name("Submit"));
		submitBtn.click();
		return new CreateUserProfilePage(driver);
	}

	public String extractTempPassword() {
		WebElement errorMessageElement = driver.findElement(By.className("errormessage"));
		String errorMsgText = errorMessageElement.getText();
		String[] splitErrorMsgText = errorMsgText.split(":");
		String tempPassword = null;
		
		if (splitErrorMsgText[1] != null) {
			tempPassword = splitErrorMsgText[1].trim();
		}
		
		System.out.println("The temporary password is:"+ tempPassword);

		return tempPassword;
	}

	public CreateUserProfilePage checkTempPasswordIsDisplayed() {
		WebElement tempPasswordElement = driver.findElement(By.className("errormessage"));
		assertTrue(tempPasswordElement.getText().contains(extractTempPassword()));
		tempPasswordElement.getText();

		return new CreateUserProfilePage(driver);
	}
}
