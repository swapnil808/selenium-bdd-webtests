package com.test.swapnil.stepDefs;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.swapnil.pageObjects.LoginPage;
import com.test.swapnil.pageObjects.MyPersonalInfoPage;
import com.test.swapnil.pageObjects.ShoppingCartPage;
import com.test.swapnil.pageObjects.TshirtPage;
import com.test.swapnil.utils.PropertiesReader;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class OrderStepDefinitions {
	
    private WebDriver driver = Hooks.driver;
    private WebDriverWait wait;
	public String orderReference;
	public static Scenario message;
	LoginPage login;
	TshirtPage tshirt;
	ShoppingCartPage shoppingCart;
	MyPersonalInfoPage personalInfo;
	PropertiesReader propertiesReader;

    public OrderStepDefinitions() throws Exception {

        propertiesReader = new PropertiesReader();
        this.wait = new WebDriverWait(driver, propertiesReader.getTimeout());
    }
    
    
    @Given("I am on homepage")
	public void i_am_on_homepage() throws Exception {

		driver.get(propertiesReader.getValue("url"));
		
	}

	@Given("^I login with (.*) and (.*)$")
	public void i_login_with_username_and_password(String userName, String password) throws InterruptedException {

		login = new LoginPage(driver, wait);
		login.clickOnSignInLink();
		login.enterEmailAddress(userName);
		login.enterPassword(password);
		login.clickOnSignInButton();
		Assert.assertTrue(login.verifyWelcomeToAccMsgDisplayed());
	}

	
	@When("^I add tshirt to cart with (.*)$")
	public void i_add_tshirt_to_cart_with_size(String size) {
		tshirt = new TshirtPage(driver, wait);
		tshirt.clickOnTshirtsTab();
		tshirt.selectProduct();
		tshirt.selectProductSize(size);
		tshirt.addProductToCart();
		tshirt.proceedToCheckout();
	}

	@When("I confirm my order")
	public void i_confirm_my_order() {
		shoppingCart = new ShoppingCartPage(driver, wait);
		shoppingCart.proceedToCheckout();
		shoppingCart.proceedToCheckout();
		shoppingCart.agreeTermsAndConditions();
		shoppingCart.proceedToCheckout();
		shoppingCart.payByCheck();
		shoppingCart.confirmOrder();
		orderReference = shoppingCart.getOrderReference();
		shoppingCart.navigateBackToOrders();
	}

	@Then("I should see my order confirmation on order history")
	public void i_should_see_my_order_confirmation_on_order_history() {

		Assert.assertTrue("Order details not found", shoppingCart.verifyOrderOnOrderHistory(orderReference));
	}

	
	@When("^I update my (.*) and confirm (.*)$")
	public void i_update_my_test_new_f_name_and_confirm_qualitest(String firstName, String currentPass) {
		login.navigateToPersonalInformation();
		personalInfo = new MyPersonalInfoPage(driver, wait);
		personalInfo.updateFirstName(firstName);
		personalInfo.enterCurrentPassword(currentPass);
		personalInfo.saveDetails();
	}

	@Then("^I should see my personal information is updated with (.*) successfully$")
	public void i_should_see_my_personal_information_is_updated_with_test_new_f_name_successfully(String firstName) {
		
		Assert.assertTrue("Personal information updated success message not displayed", personalInfo.verifyPersonalInfoUpdatedSuccessMsg());
		Assert.assertTrue("First Name not updated successfully", personalInfo.verifyUpdatedNameOnDashboardHeader(firstName));
		
	}

}
