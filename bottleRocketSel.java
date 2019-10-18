WebDriver driver;
String baseURl;

@BeforeClass(alwaysRun = true)
public void setUp() throws Exception{
  WebDriverManager.firefoxdriver().setup();
  driver = new FirefoxDriver();
  baseUrl = "http://www.google.com";
  dirver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  driver.get(baseUrl);
}

@BeforeMethod
public void myBeforeMethod(){
  driver.login();
}

@Test
public void myFirstTest(){
  WebElement myWebElement = driver.findElement(By.name("q"));
  myWebElement.sendKeys("This is an amazing class!");
  Assert.assertTrue(myWebElelement.isDisplayed());
  System.out.println("Assertion is true");
}


@afterMethod
public void theEnd(){
  driver.quit();
}

@Test
public void mySecondTest(){
  
}
