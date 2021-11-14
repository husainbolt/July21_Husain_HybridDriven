package com.technocredits.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.technocredits.orangehrm.base.PredefinedActions;

public class MenuPage extends PredefinedActions {
	
	public void navigateTo(String menu) {
		
		String arr[] = menu.split("->");
		for(String menuItem : arr) {
			//WebDriverWait wait = new WebDriverWait(driver, 20);
			//WebElement e = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a/span[text()='"+menuItem+"']")));
			WebElement e = getElement("XPATH", "//a/span[text()='"+menuItem+"']", true);
			e.click();
		}
	}

}
