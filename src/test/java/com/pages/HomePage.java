package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.base.BaseTest;

public class HomePage extends BaseTest {

	// Locators
	private By logout_Button     = By.xpath("//button[text()='Logout']");
	private By addDevice_Button  = By.xpath("//button[contains(text(),'Add Device')]");
	private By pageTitle_Text    = By.xpath("//h1[contains(text(),'Devices')]");
	private By deviceTable       = By.xpath("//table");

	// Actions
	public boolean isHomePageDisplayed() {
		return driver.findElements(pageTitle_Text).size() > 0;
	}

	public boolean isLogoutButtonDisplayed() {
		return driver.findElements(logout_Button).size() > 0;
	}

	public void clickAddDevice() {
		WebElement el = driver.findElement(addDevice_Button);
		highlightElement(el);
		el.click();
	}

	public LoginPage clickLogout() {
		WebElement el = driver.findElement(logout_Button);
		highlightElement(el);
		el.click();
		return new LoginPage();
	}

	public boolean isDeviceTableDisplayed() {
		return driver.findElements(deviceTable).size() > 0;
	}

	public String getPageTitle() {
		return driver.getTitle();
	}
}
