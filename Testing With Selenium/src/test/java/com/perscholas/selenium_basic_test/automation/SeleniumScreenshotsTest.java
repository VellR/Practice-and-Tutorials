package com.perscholas.selenium_basic_test.automation;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumScreenshotsTest {
	private static WebDriver driver;
	
	@BeforeClass
	public static void setup() {
		System.setProperty("webdriver.chrome.driver", "/Users/ivell/Downloads/chromedriver_win32/chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/TestingWithSelenium/SeleniumScreenshotServlet");
	}
	
	@AfterClass
	public static void teardown() {
		driver.close();
	}
	
	@Test
	public void screenshotsTest() throws IOException {
		Dimension dimension = new Dimension(800, 600);
		driver.manage().window().setSize(dimension);
		
		screenshot(driver);
		dimension = new Dimension(450, 600);
		driver.manage().window().setSize(dimension);
		
		screenshot(driver);
		dimension = new Dimension(800, 600);
		driver.manage().window().setSize(dimension);
		
		screenshot(driver);
	}
	
	private void screenshot(WebDriver driver) throws IOException {
		TakesScreenshot scrShot = ((TakesScreenshot)driver);
		
		File scrFile = scrShot.getScreenshotAs(OutputType.FILE);
		
		File destination = new File("./ScreenShots/" + 
				LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd_HH.mm.ss.SSS")) +
				".png");
		
		FileUtils.copyFile(scrFile, destination);
	}
}
