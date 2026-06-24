package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.base.BaseTest;

public class SilverPage extends BaseTest {

	// Silver sub-tab & section
	private By silver_SubTab         = By.xpath("//button[@class='sub-tab-button' and text()='Silver']");
	private By silverSection         = By.id("silver");

	// Silver items and Add to Cart (no side-menu; flat jewellery-grid)
	private By silverItems_List      = By.xpath("//div[@id='silver']//div[@class='jewellery-item']");
	private By addToCart_Buttons     = By.xpath("//div[@id='silver']//button[@class='add-to-cart-btn']");
	private By silverItemNames       = By.xpath("//div[@id='silver']//div[@class='jewellery-item']//h4");
	private By silverItemPrices      = By.xpath("//div[@id='silver']//div[@class='jewellery-item']//p");

	// Actions
	public void clickSilverSubTab() {
		WebElement el = driver.findElement(silver_SubTab);
		highlightElement(el);
		el.click();
	}

	public boolean isSilverSectionDisplayed() {
		return driver.findElement(silverSection).isDisplayed();
	}

	public int getSilverItemsCount() {
		return driver.findElements(silverItems_List).size();
	}

	public void addFirstSilverItemToCart() {
		WebElement el = driver.findElements(addToCart_Buttons).get(0);
		highlightElement(el);
		el.click();
		acceptAlert();
	}

	public String getFirstSilverItemName() {
		return driver.findElements(silverItemNames).get(0).getText();
	}

	public String getFirstSilverItemPrice() {
		return driver.findElements(silverItemPrices).get(0).getText();
	}
}
