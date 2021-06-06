package com.test.swapnil.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.swapnil.utils.BasePage;

public class MyPersonalInfoPage extends BasePage {
	

	public MyPersonalInfoPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//*[@title='View my customer account']")
	private WebElement accountUserDashboard;
	
	@FindBy(xpath = "//input[@id='firstname']")
	private WebElement txtBox_firstName;
	
	@FindBy(xpath = "//input[@id='lastname']")
	private WebElement txtBox_lastName;
	
	@FindBy(xpath = "//input[@id='old_passwd']")
	private WebElement txtBox_currentPassword;
	
	@FindBy(xpath = "//input[@id='passwd']")
	private WebElement txtBox_newPassword;
	
	@FindBy(xpath = "//input[@id='confirmation']")
	private WebElement txtBox_confirmPassword;
	
	@FindBy(xpath = "//button[@name='submitIdentity']")
	private WebElement btn_save;
	
	@FindBy(xpath = "//p[contains(text(),'Your personal information has been successfully updated.')]")
	private WebElement msg_personalInfoUpdatedSuccessMsg;
	
	
	
	
	public void updateFirstName(String fName) {
		WaitUntilElementVisible(txtBox_firstName);
		txtBox_firstName.clear();
		txtBox_firstName.sendKeys(fName);
	}
	
	public void updateLastName(String lName) {
		txtBox_lastName.clear();
		txtBox_lastName.sendKeys(lName);
	}
	
	public void enterCurrentPassword(String currentPass) {
		txtBox_currentPassword.sendKeys(currentPass);
	}
	
	public void enterNewPassword(String newPass) {
		txtBox_newPassword.sendKeys(newPass);
	}
	
	public void confirmNewPassword(String newPass) {
		txtBox_confirmPassword.sendKeys(newPass);
	}
	
	public void saveDetails() {
		btn_save.click();
	}
	
	public boolean verifyPersonalInfoUpdatedSuccessMsg() {
		WaitUntilElementVisible(msg_personalInfoUpdatedSuccessMsg);
		boolean updateFlag = msg_personalInfoUpdatedSuccessMsg.isDisplayed();
		return updateFlag;
	}
	
	public boolean verifyUpdatedNameOnDashboardHeader(String expectedFirstName) {
		boolean updateFlag = false;
		WaitUntilElementVisible(accountUserDashboard);
		String actualAccountUserName = accountUserDashboard.getText();
		if(actualAccountUserName.contains(expectedFirstName)) {
			updateFlag = true;
		}
		return updateFlag;
	}

}
