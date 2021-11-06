package com.technocredits.orangehrm.pages;

import org.openqa.selenium.By;

import com.technocredits.orangehrm.base.PredefinedActions;

public class MenuPage extends PredefinedActions {
	
	public void navigateTo(String menu) {
		
		String arr[] = menu.split("->");
		for(String menuItem : arr)
			driver.findElement(By.xpath("//a/span[text()='"+menuItem+"']")).click();
	}

}
