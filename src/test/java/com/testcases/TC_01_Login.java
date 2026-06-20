package com.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.base.BaseTest;
import com.listeners.ExtentReportManager;
import com.pages.HomePage;
import com.pages.LoginPage;

public class TC_01_Login extends BaseTest {

	LoginPage loginPage = new LoginPage();

	@Test(priority = 1, description = "Verify valid login navigates to Home page")
	public void validLogin() {
		ExtentReportManager.getTest().log(Status.INFO, "Entering valid username and password");
		HomePage homePage = loginPage.loginToApp(
				prop.getProperty("H2oJewellery_Valid_UserName"),
				prop.getProperty("H2oJewellery_Valid_Password"));

		ExtentReportManager.getTest().log(Status.INFO, "Clicked Login button - verifying Home page loaded");
		Assert.assertTrue(homePage.isLogoutButtonDisplayed(), "Login failed - Logout button not visible");
		ExtentReportManager.getTest().log(Status.PASS, "Valid login successful - Home page displayed");
	}

	@Test(priority = 2, description = "Verify invalid login shows error message")
	public void invalidLogin() {
		driver.navigate().refresh();
		ExtentReportManager.getTest().log(Status.INFO, "Entering invalid username and password");
		loginPage.enterUserName(prop.getProperty("H2oJewellery_Invalid_UserName"));
		loginPage.enterPassword(prop.getProperty("H2oJewellery_Invalid_Password"));
		loginPage.clickLoginButton();

		ExtentReportManager.getTest().log(Status.INFO, "Verifying error message is displayed");
		Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message not displayed for invalid login");
		ExtentReportManager.getTest().log(Status.PASS, "Error message displayed for invalid credentials");
	}
}
