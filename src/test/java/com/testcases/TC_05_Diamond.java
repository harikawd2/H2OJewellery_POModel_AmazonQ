package com.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.base.BaseTest;
import com.listeners.ExtentReportManager;
import com.pages.DiamondPage;
import com.pages.GoldPage;
import com.pages.LoginPage;

public class TC_05_Diamond extends BaseTest {

	LoginPage loginPage     = new LoginPage();
	GoldPage goldPage       = new GoldPage();
	DiamondPage diamondPage = new DiamondPage();

	@Test(priority = 1, description = "Verify Diamond sub-tab is accessible under H2O Jewellery tab")
	public void verifyDiamondSubTab() {
		driver.navigate().refresh();
		ExtentReportManager.getTest().log(Status.INFO, "Logging in and navigating to H2O Jewellery tab");
		loginPage.loginToApp(
				prop.getProperty("H2oJewellery_Valid_UserName"),
				prop.getProperty("H2oJewellery_Valid_Password"));

		goldPage.clickH2OJewelleryTab();

		ExtentReportManager.getTest().log(Status.INFO, "Clicking Diamond sub-tab");
		diamondPage.clickDiamondSubTab();

		Assert.assertTrue(diamondPage.isDiamondSectionDisplayed(), "Diamond section not displayed after clicking Diamond sub-tab");
		ExtentReportManager.getTest().log(Status.PASS, "Diamond section is displayed under H2O Jewellery tab");
	}

	@Test(priority = 2, description = "Verify Diamond Earrings category displays items")
	public void verifyDiamondEarringsCategory() {
		ExtentReportManager.getTest().log(Status.INFO, "Clicking Earrings from Diamond side menu");
		diamondPage.clickEarrings();

		int count = diamondPage.getDiamondItemsCount();
		Assert.assertTrue(count > 0, "No Diamond Earrings items displayed");
		ExtentReportManager.getTest().log(Status.PASS, "Diamond Earrings items displayed. Count: " + count);
	}

	@Test(priority = 3, description = "Verify Diamond Rings category displays items")
	public void verifyDiamondRingsCategory() {
		ExtentReportManager.getTest().log(Status.INFO, "Clicking Rings from Diamond side menu");
		diamondPage.clickRings();

		int count = diamondPage.getDiamondItemsCount();
		Assert.assertTrue(count > 0, "No Diamond Rings items displayed");
		ExtentReportManager.getTest().log(Status.PASS, "Diamond Rings items displayed. Count: " + count);
	}

	@Test(priority = 4, description = "Verify Diamond Bangles category displays items")
	public void verifyDiamondBanglesCategory() {
		ExtentReportManager.getTest().log(Status.INFO, "Clicking Bangles from Diamond side menu");
		diamondPage.clickBangles();

		int count = diamondPage.getDiamondItemsCount();
		Assert.assertTrue(count > 0, "No Diamond Bangles items displayed");
		ExtentReportManager.getTest().log(Status.PASS, "Diamond Bangles items displayed. Count: " + count);
	}

	@Test(priority = 5, description = "Verify Add to Cart works for a Diamond item")
	public void verifyAddDiamondItemToCart() {
		ExtentReportManager.getTest().log(Status.INFO, "Clicking Earrings and adding first Diamond item to cart");
		diamondPage.clickEarrings();
		diamondPage.addFirstDiamondItemToCart();

		ExtentReportManager.getTest().log(Status.PASS, "Diamond item added to cart successfully");
	}
}
