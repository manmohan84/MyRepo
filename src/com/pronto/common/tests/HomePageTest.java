package com.pronto.common.tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.pronto.common.pageobjects.HomePage;

public class HomePageTest {
	
	private WebDriver driver;
	public static String MainBrowserWindow;
	//private SignInPage signInPage;
	private HomePage homePage;
	static String driverPath = "C:\\Users\\patraman\\workspace\\MyTestProject\\chromedriver\\";
	
	/*@BeforeClass
	public void setUp() {
		TestBaseSetup tbs = new TestBaseSetup();
		driver=tbs.getDriver();
	}*/
	
	 @BeforeTest

	    public void setup(){
		 System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver.exe");
		    driver = new ChromeDriver();
		    MainBrowserWindow = driver.getWindowHandle().toString();
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(60,TimeUnit.SECONDS);
            driver.manage().window().maximize();

	        driver.get("http://www.onetrust.com");
	        //driver.navigate().to("www.onetrust.com");
	        

	    }

		
	 @Test(priority=0)
	 public void myTest(){
		 /*try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 Actions actions = new Actions(driver);
			
		 	WebElement webelement = driver.findElement(By.cssSelector("div#navigation li:nth-child(6)"));
	       
	        actions.moveToElement(webelement).moveToElement(driver.findElement(By.cssSelector("div#navigation li:nth-child(6) ul li:nth-child(1)"))).click().perform();*/
		 homePage= new HomePage(driver);
		 homePage.gotoCareerPage();
		
		 //scrolling page to view the links
	        
	        JavascriptExecutor je = (JavascriptExecutor) driver;
        	WebElement element = driver.findElement(By.cssSelector("div.container"));
        	je.executeScript("arguments[0].scrollIntoView(true);",element);
        	try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
        	
        	List<WebElement> city = driver.findElements(By.cssSelector("ul.nav-tabs li"));
        	System.out.println("Number of cities: " + city.size());
        	
        	for( int i = 0; i < city.size(); i++){
        		String city_id = "";
        		System.out.println("City Name: " + city.get(i).getText());
        		if(city.get(i).getText().equals("SAN FRANCISCO")){
        			homePage.selectCityNames(city.get(i));
        			city_id = "san-francisco";
        		}else{
        			homePage.selectCityNames(city.get(i));
        			try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
        			city_id = city.get(i).getText().toLowerCase();
        		}
        		
        		List<WebElement> open_pos = homePage.getAllOpenPositions(city_id);
        		System.out.println("Open Positions: " + open_pos.size());
        		for(WebElement we1: open_pos){
        			try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
        			System.out.println("*** : " + we1.getText());
        		}
        	}
        	
        	
	}

}
