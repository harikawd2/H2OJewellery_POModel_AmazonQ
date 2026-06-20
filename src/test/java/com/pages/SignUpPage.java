package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.base.BaseTest;

public class SignUpPage extends BaseTest {

	// Locators
	private By name_Editbox       = By.id("signUpName");
	private By email_Editbox      = By.id("signUpEmail");
	private By password_Editbox   = By.id("signUpPassword");
	private By userType_Dropdown  = By.id("signUpRole");
	private By signUp_Button      = By.xpath("//*[@id='signUpModal']/div/button[1]");
	private By successMsg_Text    = By.xpath("//*[contains(text(),'Registration successful')]");

	// Actions
	public void enterName(String name) {
		WebElement el = driver.findElement(name_Editbox);
		highlightElement(el);
		el.clear();
		el.sendKeys(name);
	}

	public void enterEmail(String email) {
		WebElement el = driver.findElement(email_Editbox);
		highlightElement(el);
		el.clear();
		el.sendKeys(email);
	}

	public void enterPassword(String password) {
		WebElement el = driver.findElement(password_Editbox);
		highlightElement(el);
		el.clear();
		el.sendKeys(password);
	}

	public void selectUserType(String userType) {
		WebElement el = driver.findElement(userType_Dropdown);
		highlightElement(el);
		new Select(el).selectByVisibleText(userType);
	}

	public void clickSignUpButton() {
		WebElement el = driver.findElement(signUp_Button);
		highlightElement(el);
		el.click();
	}

	public boolean isSuccessMessageDisplayed() {
		return driver.findElements(successMsg_Text).size() > 0;
	}

	public void registerNewUser(String name, String email, String password, String userType) {
		enterName(name);
		enterEmail(email);
		enterPassword(password);
		selectUserType(userType);
		clickSignUpButton();
	}
}
