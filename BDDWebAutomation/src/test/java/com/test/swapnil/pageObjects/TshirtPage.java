package com.test.swapnil.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.swapnil.utils.BasePage;

public class TshirtPage extends BasePage {
	

	public TshirtPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "(//a[@title='T-shirts'])[2]")
	private WebElement tab_TShirts;
	
	@FindBy(xpath = "(//a[@title='Faded Short Sleeve T-shirts'])[2]")
	private WebElement img_Product;
	
	@FindBy(xpath = "//select[@id='group_1']")
	private WebElement dropDown_Size;
	
	@FindBy(xpath = "//*[text()='Add to cart']")
	private WebElement btn_addToCart;
	
	@FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]")
	private WebElement btn_proceedToCheckout;
	
	
	
	public void clickOnTshirtsTab() {
		WaitUntilElementVisible(tab_TShirts);
		tab_TShirts.click();
	}
	
	public void selectProduct() {
		WaitUntilElementVisible(img_Product);
		img_Product.click();
	}
	
	public void selectProductSize(String size) {
		Select dropdownValue = new Select(dropDown_Size);
		dropdownValue.selectByVisibleText(size);
	}
	
	public void addProductToCart() {
		btn_addToCart.click();
	}

	
	public void proceedToCheckout() {
		WaitUntilElementVisible(btn_proceedToCheckout);
		btn_proceedToCheckout.click();
	}


}
