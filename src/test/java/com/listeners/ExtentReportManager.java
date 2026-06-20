package com.listeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.base.BaseTest;

public class ExtentReportManager implements ITestListener {

	private static ExtentReports extent;
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	@Override
	public void onStart(ITestContext context) {
		String timestamp = new SimpleDateFormat("ddMMMyyyy_HHmmss").format(new Date());
		String reportPath = System.getProperty("user.dir") + "/reports/H2OJewellery_Report_" + timestamp + ".html";

		ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setDocumentTitle("H2O Jewellery Test Report");
		spark.config().setReportName("H2O Jewellery - POM Framework Execution Report");

		extent = new ExtentReports();
		extent.attachReporter(spark);
		extent.setSystemInfo("Application", "H2O Jewellery");
		extent.setSystemInfo("URL", "https://seenu4selenium.github.io/devices-management-Webpage/");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("Tester", System.getProperty("user.name"));
	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest extentTest = extent.createTest(
				result.getTestClass().getName() + " - " + result.getMethod().getMethodName(),
				result.getMethod().getDescription());
		test.set(extentTest);
		test.get().log(Status.INFO, "Test Started: " + result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.get().log(Status.PASS, "Test PASSED: " + result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.get().log(Status.FAIL, "Test FAILED: " + result.getThrowable());
		try {
			String screenshotPath = captureScreenshot(result.getMethod().getMethodName());
			test.get().addScreenCaptureFromPath(screenshotPath, "Failure Screenshot");
		} catch (IOException e) {
			test.get().log(Status.WARNING, "Screenshot capture failed: " + e.getMessage());
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.get().log(Status.SKIP, "Test SKIPPED: " + result.getMethod().getMethodName());
	}

	@Override
	public void onFinish(ITestContext context) {
		if (extent != null) {
			extent.flush();
		}
	}

	public static ExtentTest getTest() {
		return test.get();
	}

	private String captureScreenshot(String testName) throws IOException {
		String timestamp = new SimpleDateFormat("ddMMMyyyy_HHmmss").format(new Date());
		String fileName = testName + "_" + timestamp + ".png";
		String screenshotDir = System.getProperty("user.dir") + "/reports/screenshots/";
		new File(screenshotDir).mkdirs();
		String fullPath = screenshotDir + fileName;

		File src = ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File(fullPath));
		return fullPath;
	}
}
