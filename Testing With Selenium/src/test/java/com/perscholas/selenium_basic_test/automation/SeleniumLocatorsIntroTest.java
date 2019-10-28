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
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.hasItems;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class SeleniumLocatorsIntroTest {
	
	private static WebDriver driver;
	
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/ivell/Downloads/chromedriver_win32/chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/TestingWithSelenium/SeleniumLocatorsServlet");
	}
	
	@AfterClass
	public static void shutDown() {
		driver.close();
	}
	
	@Test
	public void findByCssSelector() {
		WebElement courseElement = driver.findElement(By.cssSelector("div > h1"));
		
		String actual = courseElement.getText();
		
		assertThat(actual, equalTo("Courses"));
	}
	
	@Test
	public void findByXPath() {
		String actual = driver.findElement(By.xpath("//*[@id=\"div2\"]/h1")).getText();
		
		assertThat(actual, equalTo("Courses"));
	}
	
	@Test
	public void findById() throws InterruptedException {
		long sescondsSinceMidnight = LocalTime.MIDNIGHT.until(LocalTime.now(), ChronoUnit.SECONDS);
		
		if (sescondsSinceMidnight > 86397) {
			Thread.sleep(3100);
		}
		
		String dateTimeText = driver.findElement(By.id("dateTime")).getText();
		String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MMM d, yyyy"));
		
		assertThat(dateTimeText, containsString("Today's date and time is " + currentDate));
	}
	
	@Test
	public void findByName() {
		driver.findElement(By.name("userName")).sendKeys("John");
		driver.findElement(By.name("submit")).click();
		
		String welcomeMessage = driver.findElement(By.id("welcomeMessage")).getText();
		
		assertThat(welcomeMessage, equalTo("Welcome John!"));
	}
	
	@Test
	public void findByClassName() {
		List<WebElement> elementList = driver.findElements(By.className("courseName"));
		List<String> courseNames = new ArrayList<>();
		
		for(WebElement webElement : elementList) {
			courseNames.add(webElement.getText());
		}
		
		String expected1 = "Application Support Management";
		String expected2 = "Data Engineering";
		String expected3 = "Quality Engineering & Assurance";
		
		assertThat(courseNames.size(), equalTo(3));
		assertThat(courseNames, hasItems(expected1, expected2, expected3));
	}
}
