package com.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.base.BaseTest;
import com.listeners.ExtentReportManager;
import com.pages.CartPage;
import com.pages.GoldPage;
import com.pages.LoginPage;

public class TC_07_Cart extends BaseTest {

	LoginPage loginPage = new LoginPage();
	GoldPage goldPage   = new GoldPage();
	CartPage cartPage   = new CartPage();

	@Test(priority = 1, description = "Verify Cart sub-tab is accessible under H2O Jewellery tab")
	public void verifyCartSubTabIsAccessible() {
		driver.navigate().refresh();
		ExtentReportManager.getTest().log(Status.INFO, "Logging in and navigating to H2O Jewellery tab");
		loginPage.loginToApp(
				prop.getProperty("H2oJewellery_Valid_UserName"),
				prop.getProperty("H2oJewellery_Valid_Password"));

		goldPage.clickH2OJewelleryTab();

		ExtentReportManager.getTest().log(Status.INFO, "Clicking Cart sub-tab");
		cartPage.clickCartSubTab();

		Assert.assertTrue(cartPage.isCartSectionDisplayed(), "Cart section not displayed after clicking Cart sub-tab");
		ExtentReportManager.getTest().log(Status.PASS, "Cart section is displayed under H2O Jewellery tab");
	}

	@Test(priority = 2, description = "Verify Cart is empty before adding items")
	public void verifyCartIsEmptyInitially() {
		ExtentReportManager.getTest().log(Status.INFO, "Verifying Cart is empty initially");
		Assert.assertTrue(cartPage.isCartEmpty(), "Cart is not empty on first load");
		ExtentReportManager.getTest().log(Status.PASS, "Cart is empty as expected");
	}

	@Test(priority = 3, description = "Verify item added from Gold Earrings appears in Cart")
	public void verifyAddItemToCart() throws Exception {
		ExtentReportManager.getTest().log(Status.INFO, "Navigating to Gold sub-tab and adding an Earring to cart");
		Thread.sleep(5000);
		goldPage.clickGoldSubTab();
		goldPage.clickEarrings();
		goldPage.addFirstGoldItemToCart();

		ExtentReportManager.getTest().log(Status.INFO, "Navigating to Cart sub-tab to verify item");
		cartPage.clickCartSubTab();

		int count = cartPage.getCartItemsCount();
		Assert.assertTrue(count > 0, "Cart is empty after adding a Gold item");
		ExtentReportManager.getTest().log(Status.PASS, "Item is present in Cart. Cart item count: " + count);
	}

	@Test(priority = 4, description = "Verify Cart total is updated after adding an item")
	public void verifyCartTotalUpdated() {
		String total = cartPage.getCartTotal();
		ExtentReportManager.getTest().log(Status.INFO, "Cart total displayed: ₹" + total);
		Assert.assertFalse(total.equals("0"), "Cart total is still 0 after adding an item");
		ExtentReportManager.getTest().log(Status.PASS, "Cart total is updated correctly: ₹" + total);
	}

	@Test(priority = 5, description = "Verify Checkout button is displayed in Cart")
	public void verifyCheckoutButtonDisplayed() {
		ExtentReportManager.getTest().log(Status.INFO, "Verifying Checkout button is displayed in Cart");
		Assert.assertTrue(cartPage.isCheckoutButtonDisplayed(), "Checkout button not displayed in Cart");
		ExtentReportManager.getTest().log(Status.PASS, "Checkout button is displayed in Cart");
	}

	@Test(priority = 6, description = "Verify Clear Cart removes all items")
	public void verifyClearCart() {
		ExtentReportManager.getTest().log(Status.INFO, "Clicking Clear Cart button");
		cartPage.clickClearCart();

		Assert.assertTrue(cartPage.isCartEmpty(), "Cart is not empty after clicking Clear Cart");
		ExtentReportManager.getTest().log(Status.PASS, "Cart cleared successfully - Cart is now empty");
	}

	@Test(priority = 7, description = "Verify Checkout flow with Cash on Delivery places order successfully")
	public void verifyCheckoutWithCashOnDelivery() {
		ExtentReportManager.getTest().log(Status.INFO, "Adding a Gold Earring to cart for Checkout test");
		goldPage.clickGoldSubTab();
		goldPage.clickEarrings();
		goldPage.addFirstGoldItemToCart();

		cartPage.clickCartSubTab();
		ExtentReportManager.getTest().log(Status.INFO, "Proceeding to Checkout");
		cartPage.clickCheckout();

		ExtentReportManager.getTest().log(Status.INFO, "Entering delivery address and selecting Cash on Delivery");
		cartPage.enterDeliveryAddress(prop.getProperty("H2oJewellery_Delivery_Address"));
		cartPage.selectPaymentType("Cash on Delivery");
		cartPage.clickPlaceOrder();

		Assert.assertTrue(cartPage.isOrderPlacedDisplayed(), "Order Placed confirmation not displayed");
		ExtentReportManager.getTest().log(Status.PASS, "Order placed successfully. Invoice: " + cartPage.getInvoiceNumber());
	}
}
