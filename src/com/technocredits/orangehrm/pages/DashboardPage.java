package com.technocredits.orangehrm.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.technocredits.orangehrm.base.PredefinedActions;

public class DashboardPage extends PredefinedActions {
	public String verifyDashboardTitle() {
		return driver.getTitle();
	}
	
	public String verifyDashboardPageTitle() {
		return driver.findElement(By.xpath("//li[@class='page-title']")).getText();
	}
	
	public int getTotalWidgets() {
		return driver.findElements(By.xpath("//div[@class='widget-header']")).size();
	}
	
	public List<String> getAllWidgetsText() {
		return PredefinedActions.getTextOfAllElements("//div[@class='widget-header']/span[2]");
	}
}
