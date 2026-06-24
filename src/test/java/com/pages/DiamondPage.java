package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.base.BaseTest;

public class DiamondPage extends BaseTest {

	// Diamond sub-tab & section
	private By diamond_SubTab        = By.xpath("//button[@class='sub-tab-button' and text()='Diamond']");
	private By diamondSection        = By.id("diamond");

	// Diamond side-menu category buttons
	private By earrings_SideBtn      = By.xpath("//div[@id='diamond']//button[text()='Earrings']");
	private By rings_SideBtn         = By.xpath("//div[@id='diamond']//button[text()='Rings']");
	private By bangles_SideBtn       = By.xpath("//div[@id='diamond']//button[text()='Bangles']");
	private By necklaces_SideBtn     = By.xpath("//div[@id='diamond']//button[text()='Necklaces']");

	// Diamond items and Add to Cart
	private By diamondItems_List     = By.xpath("//div[@id='diamond']//div[@class='jewellery-item']");
	private By addToCart_Buttons     = By.xpath("//div[@id='diamond']//button[@class='add-to-cart-btn']");

	// Actions
	public void clickDiamondSubTab() {
		WebElement el = driver.findElement(diamond_SubTab);
		highlightElement(el);
		el.click();
	}

	public boolean isDiamondSectionDisplayed() {
		return driver.findElement(diamondSection).isDisplayed();
	}

	public void clickEarrings() {
		WebElement el = driver.findElement(earrings_SideBtn);
		highlightElement(el);
		el.click();
	}

	public void clickRings() {
		WebElement el = driver.findElement(rings_SideBtn);
		highlightElement(el);
		el.click();
	}

	public void clickBangles() {
		WebElement el = driver.findElement(bangles_SideBtn);
		highlightElement(el);
		el.click();
	}

	public void clickNecklaces() {
		WebElement el = driver.findElement(necklaces_SideBtn);
		highlightElement(el);
		el.click();
	}

	public int getDiamondItemsCount() {
		return driver.findElements(diamondItems_List).size();
	}

	public void addFirstDiamondItemToCart() {
		WebElement el = driver.findElements(addToCart_Buttons).get(0);
		highlightElement(el);
		el.click();
		acceptAlert();
	}
}
