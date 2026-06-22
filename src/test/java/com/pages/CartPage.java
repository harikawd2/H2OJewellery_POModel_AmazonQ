package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.base.BaseTest;

public class CartPage extends BaseTest {

	// Cart sub-tab (labelled "Cart", maps to div id="branches")
	private By cart_SubTab           = By.xpath("(//button[@class='sub-tab-button' and text()='Cart'])[2]");
	private By cartSection           = By.id("branches");

	// Cart items & total
	private By cartItems_Container   = By.id("jewelleryCartItems");
	private By cartItems_List        = By.xpath("//div[@id='jewelleryCartItems']//div[contains(@class,'cart-item')]");
	private By cartTotal_Text        = By.id("jewelleryCartTotal");

	// Cart action buttons
	private By checkout_Button       = By.xpath("//div[@id='branches']//button[@class='checkout-btn']");
	private By clearCart_Button      = By.xpath("//div[@id='branches']//button[@class='clear-cart-btn']");
	private By remove_Buttons        = By.xpath("//div[@id='jewelleryCartItems']//button[contains(@class,'remove') or contains(text(),'Remove')]");

	// Checkout section (div id="jewelleryCheckout")
	private By address_TextArea      = By.id("jewelleryAddress");
	private By paymentType_Dropdown  = By.id("jewelleryPaymentType");
	private By placeOrder_Button     = By.id("jewelleryPlaceOrderBtn");
	private By backToCart_Button     = By.xpath("//button[@class='back-to-cart-btn']");

	// Order placed section
	private By orderPlaced_Header    = By.xpath("//div[@id='jewelleryOrderPlaced']//h2[text()='Order Placed!']");
	private By invoiceNumber_Text    = By.id("jewelleryInvoiceNumberDisplay");

	// Actions
	public void clickCartSubTab() {
		WebElement el = driver.findElement(cart_SubTab);
		highlightElement(el);
		el.click();
	}

	public boolean isCartSectionDisplayed() {
		return driver.findElement(cartSection).isDisplayed();
	}

	public int getCartItemsCount() {
		return driver.findElements(cartItems_List).size();
	}

	public String getCartTotal() {
		return driver.findElement(cartTotal_Text).getText();
	}

	public boolean isCheckoutButtonDisplayed() {
		return driver.findElements(checkout_Button).size() > 0;
	}

	public void clickCheckout() {
		WebElement el = driver.findElement(checkout_Button);
		highlightElement(el);
		el.click();
	}

	public void clickClearCart() {
		WebElement el = driver.findElement(clearCart_Button);
		highlightElement(el);
		el.click();
	}

	public void removeFirstCartItem() {
		WebElement el = driver.findElements(remove_Buttons).get(0);
		highlightElement(el);
		el.click();
	}

	public boolean isRemoveButtonDisplayed() {
		return driver.findElements(remove_Buttons).size() > 0;
	}

	public boolean isCartEmpty() {
		return driver.findElements(cartItems_List).isEmpty();
	}

	public void enterDeliveryAddress(String address) {
		WebElement el = driver.findElement(address_TextArea);
		highlightElement(el);
		el.clear();
		el.sendKeys(address);
	}

	public void selectPaymentType(String paymentType) {
		WebElement el = driver.findElement(paymentType_Dropdown);
		highlightElement(el);
		new org.openqa.selenium.support.ui.Select(el).selectByVisibleText(paymentType);
	}

	public void clickPlaceOrder() {
		WebElement el = driver.findElement(placeOrder_Button);
		highlightElement(el);
		el.click();
	}

	public boolean isOrderPlacedDisplayed() {
		return driver.findElements(orderPlaced_Header).size() > 0;
	}

	public String getInvoiceNumber() {
		return driver.findElement(invoiceNumber_Text).getText();
	}
}
