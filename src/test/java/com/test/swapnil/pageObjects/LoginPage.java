package com.test.swapnil.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.swapnil.utils.BasePage;

public class LoginPage extends BasePage {
	

	public LoginPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//a[@class='login']")
	private WebElement lnk_SignIn;
	
	@FindBy(xpath = "//input[@id='email']")
	private WebElement txtBox_EmailAdd;
	
	@FindBy(xpath = "//input[@id='passwd']")
	private WebElement txtBox_Password;
	
	@FindBy(xpath = "//button[@id='SubmitLogin']")
	private WebElement btn_SignIn;
	
	@FindBy(xpath = "//*[contains(text(),'Welcome to your account')]")
	private WebElement msg_WelcomeToAccount;
	
	@FindBy(xpath = "//*[text()='My personal information']")
	private WebElement tab_PersonalInformation;
	
	
	
	public void clickOnSignInLink() {
		WaitUntilElementVisible(lnk_SignIn);
		lnk_SignIn.click();
	}
	
	public void enterEmailAddress(String userName) {
		WaitUntilElementVisible(txtBox_EmailAdd);
		txtBox_EmailAdd.clear();
		txtBox_EmailAdd.sendKeys(userName);
	}
	
	public void enterPassword(String password) {
		txtBox_Password.clear();
		txtBox_Password.sendKeys(password);
	}
	
	public void clickOnSignInButton() {
		btn_SignIn.click();
	}
	
	public boolean verifyWelcomeToAccMsgDisplayed() {
		WaitUntilElementVisible(msg_WelcomeToAccount);
		return msg_WelcomeToAccount.isDisplayed();
	}
	
	public void navigateToPersonalInformation() {
		WaitUntilElementVisible(tab_PersonalInformation);
		tab_PersonalInformation.click();
	}

}
