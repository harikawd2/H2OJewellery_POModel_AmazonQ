package com.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

	public static WebDriver driver;
	public static Properties prop;

	@BeforeClass
	public void setUp() throws IOException {
		loadProperties();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("H2oJewellery_URL"));
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	private void loadProperties() throws IOException {
		prop = new Properties();
		String path = System.getProperty("user.dir") + "/src/test/resources/testdata/QA_TESTDATA.properties";
		FileInputStream fi = new FileInputStream(path);
		prop.load(fi);
		fi.close();
	}

	public void highlightElement(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].style.border='3px solid red'", element);
			Thread.sleep(300);
			js.executeScript("arguments[0].style.border='3px solid green'", element);
		} catch (Exception e) {
			System.out.println("Highlight exception: " + e.getMessage());
		}
	}
}
