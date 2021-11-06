package com.technocredits.orangehrm.pages;

import org.openqa.selenium.By;

import com.technocredits.orangehrm.base.PredefinedActions;

public class LoginPage extends PredefinedActions {

	public boolean isLogoDisplayed() {
		boolean isLogoDisplayed = driver.findElement(By.tagName("img")).isDisplayed();
		return isLogoDisplayed;
	}

	public boolean isLoginDisplayed() {
		boolean isLoginDisplayed = driver.findElement(By.xpath("//div[@id='logInPanelHeading']")).isDisplayed();
		return isLoginDisplayed;
	}

	public void enterLoginDetails(String uName, String pwd) {
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(uName);
		driver.findElement(By.id("txtPassword")).sendKeys(pwd);
	}

	public MenuPage clickOnLoginButton() {
		driver.findElement(By.id("btnLogin")).click();
		return new MenuPage();
	}

	public String getPwdErrorMessage() {
		return driver.findElement(By.id("spanMessage")).getText();
	}
}
