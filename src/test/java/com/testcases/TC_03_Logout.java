package com.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.base.BaseTest;
import com.listeners.ExtentReportManager;
import com.pages.HomePage;
import com.pages.LoginPage;

public class TC_03_Logout extends BaseTest {

	LoginPage loginPage = new LoginPage();

	@Test(priority = 1, description = "Verify logout returns to Login page")
	public void logoutFromApp() {
		driver.navigate().refresh();
		ExtentReportManager.getTest().log(Status.INFO, "Logging in with valid credentials");
		HomePage homePage = loginPage.loginToApp(
				prop.getProperty("H2oJewellery_Valid_UserName"),
				prop.getProperty("H2oJewellery_Valid_Password"));

		Assert.assertTrue(homePage.isLogoutButtonDisplayed(), "Home page not loaded after login");
		ExtentReportManager.getTest().log(Status.INFO, "Login successful - clicking Logout button");

		homePage.clickLogout();

		Assert.assertFalse(homePage.isLogoutButtonDisplayed(), "Logout failed - still on Home page");
		ExtentReportManager.getTest().log(Status.PASS, "Logout successful - returned to Login page");
	}
}
