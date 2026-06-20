package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.base.BaseTest;

public class LoginPage extends BaseTest {

	// Locators
	private By userName_Editbox   = By.id("username");
	private By password_Editbox   = By.id("password");
	private By login_Button       = By.xpath("//*[@id='loginModal']/div/div/button");
	private By signUp_Link        = By.linkText("Sign Up");
	private By errorMsg_Text      = By.xpath("//*[text()='Invalid username or password. Please try again.']");

	// Actions
	public void enterUserName(String userName) {
		WebElement el = driver.findElement(userName_Editbox);
		highlightElement(el);
		el.clear();
		el.sendKeys(userName);
	}

	public void enterPassword(String password) {
		WebElement el = driver.findElement(password_Editbox);
		highlightElement(el);
		el.clear();
		el.sendKeys(password);
	}

	public void clickLoginButton() {
		WebElement el = driver.findElement(login_Button);
		highlightElement(el);
		el.click();
	}

	public void clickSignUpLink() {
		WebElement el = driver.findElement(signUp_Link);
		highlightElement(el);
		el.click();
	}

	public boolean isErrorMessageDisplayed() {
		return driver.findElements(errorMsg_Text).size() > 0;
	}

	public HomePage loginToApp(String userName, String password) {
		enterUserName(userName);
		enterPassword(password);
		clickLoginButton();
		return new HomePage();
	}
}
