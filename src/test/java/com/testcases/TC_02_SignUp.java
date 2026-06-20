package com.testcases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.base.BaseTest;
import com.listeners.ExtentReportManager;
import com.pages.LoginPage;
import com.pages.SignUpPage;

public class TC_02_SignUp extends BaseTest {

	LoginPage loginPage   = new LoginPage();
	SignUpPage signUpPage = new SignUpPage();

	@Test(priority = 1, description = "Verify new user registration with valid data")
	public void newUserRegistration() {
		driver.navigate().refresh();
		ExtentReportManager.getTest().log(Status.INFO, "Clicking Sign Up link from Login page");
		loginPage.clickSignUpLink();

		String uniqueName  = prop.getProperty("H2oJewellery_SignUp_Name") + System.currentTimeMillis();
		String uniqueEmail = System.currentTimeMillis() + prop.getProperty("H2oJewellery_SignUp_Email");

		ExtentReportManager.getTest().log(Status.INFO, "Registering user: " + uniqueName + " | Email: " + uniqueEmail);
		signUpPage.registerNewUser(
				uniqueName,
				uniqueEmail,
				prop.getProperty("H2oJewellery_SignUp_Password"),
				prop.getProperty("H2oJewellery_SignUp_UserType"));

		ExtentReportManager.getTest().log(Status.PASS, "User registration form submitted successfully");
	}
}
