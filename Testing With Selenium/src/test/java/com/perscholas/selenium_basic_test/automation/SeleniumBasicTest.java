package com.perscholas.selenium_basic_test.automation;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class SeleniumBasicTest {
	
	private static WebDriver driver;
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/ivell/Downloads/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/TestingWithSelenium/HomeServlet");
		
	}
	
	@AfterClass
	public static void shutDown() {
		driver.close();
	}
	
	@Test
	public void testTitle() {
		String actual = driver.getTitle();
		String expected = "Hello Selenium";
		assertThat(actual, equalTo(expected));
	}
	
	@Test
	public void testMessage() {
		WebElement message = driver.findElement(By.cssSelector("h1"));
		
		String actual = message.getText();
		String expected = "Hello Selenium!";
		assertThat(actual, equalTo(expected));
	}
}
