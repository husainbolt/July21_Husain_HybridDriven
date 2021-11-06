package com.technocredits.orangehrm.base;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PredefinedActions {
	
	protected static WebDriver driver;
	public static void start(String url) {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	public static void start() {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3000L, TimeUnit.SECONDS);
		driver.get("https://oct21selenium-trials72.orangehrmlive.com/auth/login");
		driver.manage().window().maximize();
	}
	
	protected static List<String> getTextOfAllElements(String locator){
		
		List<WebElement> actualElements = driver.findElements(By.xpath(locator));
		List<String> actualElementList = new ArrayList<String>();
		for(WebElement element : actualElements) {
			actualElementList.add(element.getText());
		}
		
		return actualElementList;
	}
	
	public static void closeBrowser() {
		driver.close();
	}
	
	public static void quitBrowser() {
		driver.quit();
	}

}
