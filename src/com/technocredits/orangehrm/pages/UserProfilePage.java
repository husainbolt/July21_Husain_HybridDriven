package com.technocredits.orangehrm.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.technocredits.orangehrm.base.PredefinedActions;

public class UserProfilePage extends PredefinedActions {

	public void clickOnUserDropdown() {
		driver.findElement(By.id("user-dropdown")).click();
	}

	public List<String> getUserDropdownOptions() {

		return PredefinedActions.getTextOfAllElements("//ul[@id='user_menu']/li");
	}

	public int getTotalNumberofOptions() {
		return driver.findElements(By.xpath("//ul[@id='user_menu']/li")).size();
	}

	public void clickOnSubmen(String menuItem) {
		driver.findElement(By.xpath("//ul[@id='user_menu']/li[text()='" + menuItem + "']")).click();
	}

	public void clickOnAbout() {
		driver.findElement(By.xpath("//ul[@id='user_menu']/li[text()='About']")).click();
	}

	public String getCompNameFromABoutPopup() {

		return driver.findElement(By.xpath("//form[@id='frmSelectEmployees']/div/div/div/div[1]/p")).getText();

	}

	public List<String> getAboutPopupText() {

		return PredefinedActions.getTextOfAllElements("//form[@id='frmSelectEmployees']/div/div/div/div//p");

	}
}
