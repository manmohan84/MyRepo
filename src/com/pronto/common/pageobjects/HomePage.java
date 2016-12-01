package com.pronto.common.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {
	protected WebDriver driver;
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void gotoCareerPage(){
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 Actions actions = new Actions(driver);
			
		 	WebElement webelement = driver.findElement(By.cssSelector("div#navigation li:nth-child(6)"));
	       
	        //actions.moveToElement(webelement).moveToElement(driver.findElement(By.cssSelector("div#navigation li:nth-child(6) ul li:nth-child(1)"))).click().perform();
	        actions.moveToElement(webelement).build().perform();
	        try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        //driver.findElement(By.cssSelector("div#navigation li:nth-child(6) ul li:nth-child(1)")).click();
	        driver.findElement(By.xpath("//a[text()='Careers']")).click();
	}
	
	public void selectCityNames(WebElement ele) {
		ele.click();
	}
	
	public List<WebElement> getAllOpenPositions(String id){
		List<WebElement> eles = driver.findElements(By.cssSelector("div#" + id + " li.job-listing a"));
		return eles;
	}
		

}
