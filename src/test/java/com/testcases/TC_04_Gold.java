package com.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.base.BaseTest;
import com.listeners.ExtentReportManager;
import com.pages.GoldPage;
import com.pages.LoginPage;

public class TC_04_Gold extends BaseTest {

	LoginPage loginPage = new LoginPage();
	GoldPage goldPage   = new GoldPage();

	@Test(priority = 1, description = "Verify H2O Jewellery tab navigates to Gold section by default")
	public void verifyH2OJewelleryTabAndGoldSection() {
		driver.navigate().refresh();
		ExtentReportManager.getTest().log(Status.INFO, "Logging in with valid credentials");
		loginPage.loginToApp(
				prop.getProperty("H2oJewellery_Valid_UserName"),
				prop.getProperty("H2oJewellery_Valid_Password"));

		ExtentReportManager.getTest().log(Status.INFO, "Clicking H2O Jewellery tab");
		goldPage.clickH2OJewelleryTab();

		ExtentReportManager.getTest().log(Status.INFO, "Clicking Gold sub-tab");
		goldPage.clickGoldSubTab();

		Assert.assertTrue(goldPage.isGoldSectionDisplayed(), "Gold section not displayed after clicking Gold sub-tab");
		ExtentReportManager.getTest().log(Status.PASS, "Gold section is displayed under H2O Jewellery tab");
	}

	@Test(priority = 2, description = "Verify Gold Earrings category displays items")
	public void verifyGoldEarringsCategory() {
		ExtentReportManager.getTest().log(Status.INFO, "Clicking Earrings from Gold side menu");
		goldPage.clickEarrings();

		int count = goldPage.getGoldItemsCount();
		Assert.assertTrue(count > 0, "No Gold Earrings items displayed");
		ExtentReportManager.getTest().log(Status.PASS, "Gold Earrings items displayed. Count: " + count);
	}

	@Test(priority = 3, description = "Verify Gold Rings category displays items")
	public void verifyGoldRingsCategory() {
		ExtentReportManager.getTest().log(Status.INFO, "Clicking Rings from Gold side menu");
		goldPage.clickRings();

		int count = goldPage.getGoldItemsCount();
		Assert.assertTrue(count > 0, "No Gold Rings items displayed");
		ExtentReportManager.getTest().log(Status.PASS, "Gold Rings items displayed. Count: " + count);
	}

	@Test(priority = 4, description = "Verify Gold Bangles category displays items")
	public void verifyGoldBanglesCategory() {
		ExtentReportManager.getTest().log(Status.INFO, "Clicking Bangles from Gold side menu");
		goldPage.clickBangles();

		int count = goldPage.getGoldItemsCount();
		Assert.assertTrue(count > 0, "No Gold Bangles items displayed");
		ExtentReportManager.getTest().log(Status.PASS, "Gold Bangles items displayed. Count: " + count);
	}

	@Test(priority = 5, description = "Verify Add to Cart works for a Gold item")
	public void verifyAddGoldItemToCart() {
		ExtentReportManager.getTest().log(Status.INFO, "Clicking Earrings and adding first item to cart");
		goldPage.clickEarrings();
		goldPage.addFirstGoldItemToCart();

		ExtentReportManager.getTest().log(Status.PASS, "Gold item added to cart successfully");
	}
}
