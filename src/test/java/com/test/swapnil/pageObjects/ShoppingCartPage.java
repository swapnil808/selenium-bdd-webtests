package com.test.swapnil.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.swapnil.utils.BasePage;

public class ShoppingCartPage extends BasePage {
	

	public ShoppingCartPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "(//*[contains(text(),'Proceed to checkout')])[last()]")
	private WebElement btn_proceedToCheckout;
	
	@FindBy(xpath = "//input[@id='cgv']")
	private WebElement chkBox_AgreeTermsAndCondition;
	
	@FindBy(xpath = "//a[@title='Pay by check.']")
	private WebElement btn_PayByCheck;
	
	@FindBy(xpath = "//*[text()='I confirm my order']")
	private WebElement btn_ConfirmOrder;
	
	@FindBy(xpath = "//div[@class='box order-confirmation']")
	private WebElement msg_OrderConfirmation;
	
	@FindBy(xpath = "//a[@title='Back to orders']")
	private WebElement btn_BackToOrders;
	
	@FindBy(xpath = "//*[@class='color-myaccount']")
	private List<WebElement> list_orders;
	
	
	
	
	public void proceedToCheckout() {
		btn_proceedToCheckout.click();
	}

	public void agreeTermsAndConditions() {
		chkBox_AgreeTermsAndCondition.click();
	}

	public void payByCheck() {
		WaitUntilElementVisible(btn_PayByCheck);
		btn_PayByCheck.click();
	}

	public void confirmOrder() {
		WaitUntilElementVisible(btn_ConfirmOrder);
		btn_ConfirmOrder.click();
	}
	
	public String getOrderReference() {
		WaitUntilElementVisible(msg_OrderConfirmation);
		String orderConfirmMsg = msg_OrderConfirmation.getAttribute("innerText");
		String[] orderCnfMsg = orderConfirmMsg.split("reference");
		String orderRef = orderCnfMsg[1].substring(0, 10).trim();
		
		return orderRef;
	}

	public void navigateBackToOrders() {
		btn_BackToOrders.click();
	}
	
	
	public boolean verifyOrderOnOrderHistory(String orderReference) {
		boolean orderFound=false;
		for(int i=0;i<list_orders.size();i++) {
			if(list_orders.get(i).getText().trim().equalsIgnoreCase(orderReference)) {
				orderFound = true;
				break;
			}
		}
		return orderFound;
	}

}
