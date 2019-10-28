package com.perscholas.selenium_basic_test.automation;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

public class SeleniumCSSTest {
	private static WebDriver driver;
	
	@BeforeClass
	public static void setup() {
		
		System.setProperty("webdriver.chrome.driver", "/Users/ivell/Downloads/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/TestingWithSelenium/HomeServlet");	
	}
	
	@AfterClass
	public static void shutdown() {
		driver.close();
	}
	
	@Test
	public void findByCssBasic() {
		driver.get("");
		
		WebElement pLink = driver.findElement(By.cssSelector("html > body > div > p > a"));
		String actual = pLink.getText();
		assertThat(actual, equalTo("p link"));
		
		pLink = driver.findElement(By.cssSelector("div > p > a"));
		actual = pLink.getText();
		assertThat(actual, equalTo("p link"));
	}
	
	@Test
	public void findCssSiblings() {
		driver.get("");
		
		WebElement ul2 = driver.findElement(By.cssSelector(
				"html > body > div:nth-child(2) > ul:nth-child(2) > li:nth-child(2)"
				));
		
		String actual = ul2.getText();
		assertThat(actual, equalTo("div1 ul2 li2"));
		
		ul2 = driver.findElement(By.cssSelector("div > ul:nth-child(2) > li:nth-child(2)"));
		actual = ul2.getText();
		assertThat(actual, equalTo("div1 ul2 li2"));
	}
	
	@Test
	public void findCssSiblingsUsingId() {
		driver.get("");
		
		WebElement ul2 = driver.findElement(By.cssSelector("#div2 > div:nth-child(2) > p:nth-child(2)"));
		String actual = ul2.getText();
		assertThat(actual, equalTo("div2 div2 p2"));
	}
	
	@Test
	public void findCssUsingClassCombinations() {
		driver.get("");
		
		WebElement p1 = driver.findElement(By.cssSelector("p[class='pClass1 pClass3]"));
		String actual = p1.getText();
		assertThat(actual, equalTo("div2 div2 p1"));
	}
	
	@Test
	public void findCssListByClass() {
		driver.get("");
		
		List<WebElement> byClass = driver.findElements(By.className("pClass1"));
		List<String> elementText = new ArrayList<>();
		
		for(WebElement we : byClass) {
			elementText.add(we.getText());
		}
		
		assertThat(byClass.size(), equalTo(2));
		assertThat(elementText, hasItems("div2 div1 p1", "div2 div2 p1"));
	}
}
