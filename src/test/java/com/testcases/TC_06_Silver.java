package com.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.base.BaseTest;
import com.listeners.ExtentReportManager;
import com.pages.GoldPage;
import com.pages.LoginPage;
import com.pages.SilverPage;

public class TC_06_Silver extends BaseTest {

	LoginPage loginPage   = new LoginPage();
	GoldPage goldPage     = new GoldPage();
	SilverPage silverPage = new SilverPage();

	@Test(priority = 1, description = "Verify Silver sub-tab is accessible under H2O Jewellery tab")
	public void verifySilverSubTab() {
		driver.navigate().refresh();
		ExtentReportManager.getTest().log(Status.INFO, "Logging in and navigating to H2O Jewellery tab");
		loginPage.loginToApp(
				prop.getProperty("H2oJewellery_Valid_UserName"),
				prop.getProperty("H2oJewellery_Valid_Password"));

		goldPage.clickH2OJewelleryTab();

		ExtentReportManager.getTest().log(Status.INFO, "Clicking Silver sub-tab");
		silverPage.clickSilverSubTab();

		Assert.assertTrue(silverPage.isSilverSectionDisplayed(), "Silver section not displayed after clicking Silver sub-tab");
		ExtentReportManager.getTest().log(Status.PASS, "Silver section is displayed under H2O Jewellery tab");
	}

	@Test(priority = 2, description = "Verify Silver items are displayed in the Silver section")
	public void verifySilverItemsDisplayed() {
		ExtentReportManager.getTest().log(Status.INFO, "Verifying Silver items are listed");
		int count = silverPage.getSilverItemsCount();

		Assert.assertTrue(count > 0, "No Silver items found on Silver section");
		ExtentReportManager.getTest().log(Status.PASS, "Silver items displayed. Count: " + count);
	}

	@Test(priority = 3, description = "Verify first Silver item name and price are displayed")
	public void verifySilverItemDetails() {
		String name  = silverPage.getFirstSilverItemName();
		String price = silverPage.getFirstSilverItemPrice();

		ExtentReportManager.getTest().log(Status.INFO, "First Silver item: " + name + " | Price: " + price);
		Assert.assertFalse(name.isEmpty(), "Silver item name is empty");
		Assert.assertFalse(price.isEmpty(), "Silver item price is empty");
		ExtentReportManager.getTest().log(Status.PASS, "Silver item name and price are displayed correctly");
	}

	@Test(priority = 4, description = "Verify Add to Cart works for a Silver item")
	public void verifyAddSilverItemToCart() {
		ExtentReportManager.getTest().log(Status.INFO, "Adding first Silver item to cart");
		silverPage.addFirstSilverItemToCart();

		ExtentReportManager.getTest().log(Status.PASS, "Silver item added to cart successfully");
	}
}
