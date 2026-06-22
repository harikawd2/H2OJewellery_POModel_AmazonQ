package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.base.BaseTest;

public class GoldPage extends BaseTest {

	// H2O Jewellery tab
	private By h2oJewellery_Tab      = By.xpath("//button[@class='tab-button' and contains(text(),'H2O Jewellery')]");

	// Gold sub-tab & section
	private By gold_SubTab           = By.xpath("//button[@class='sub-tab-button active' and text()='Gold']");
	private By goldSection           = By.id("gold");

	// Gold side-menu category buttons
	private By earrings_SideBtn      = By.xpath("//div[@id='gold']//button[text()='Earrings']");
	private By rings_SideBtn         = By.xpath("//div[@id='gold']//button[text()='Rings']");
	private By bangles_SideBtn       = By.xpath("//div[@id='gold']//button[text()='Bangles']");
	private By necklaces_SideBtn     = By.xpath("//div[@id='gold']//button[text()='Necklaces']");
	private By chains_SideBtn        = By.xpath("//div[@id='gold']//button[text()='Chains']");
	private By oddiyaanams_SideBtn   = By.xpath("//div[@id='gold']//button[text()='Oddiyaanams']");
	private By bracelets_SideBtn     = By.xpath("//div[@id='gold']//button[text()='Bracelets']");
	private By haarams_SideBtn       = By.xpath("//div[@id='gold']//button[text()='Haarams']");

	// Gold items and Add to Cart
	private By goldItems_List        = By.xpath("//div[@id='gold']//div[@class='jewellery-item']");
	private By addToCart_Buttons     = By.xpath("//div[@id='gold']//button[@class='add-to-cart-btn']");

	// Actions
	public void clickH2OJewelleryTab() {
		WebElement el = driver.findElement(h2oJewellery_Tab);
		highlightElement(el);
		el.click();
	}

	public void clickGoldSubTab() {
		WebElement el = driver.findElement(gold_SubTab);
		highlightElement(el);
		el.click();
	}

	public boolean isGoldSectionDisplayed() {
		return driver.findElement(goldSection).isDisplayed();
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

	public void clickChains() {
		WebElement el = driver.findElement(chains_SideBtn);
		highlightElement(el);
		el.click();
	}

	public void clickOddiyaanams() {
		WebElement el = driver.findElement(oddiyaanams_SideBtn);
		highlightElement(el);
		el.click();
	}

	public void clickBracelets() {
		WebElement el = driver.findElement(bracelets_SideBtn);
		highlightElement(el);
		el.click();
	}

	public void clickHaarams() {
		WebElement el = driver.findElement(haarams_SideBtn);
		highlightElement(el);
		el.click();
	}

	public int getGoldItemsCount() {
		return driver.findElements(goldItems_List).size();
	}

	public void addFirstGoldItemToCart() {
		WebElement el = driver.findElements(addToCart_Buttons).get(0);
		highlightElement(el);
		el.click();
	}
}
