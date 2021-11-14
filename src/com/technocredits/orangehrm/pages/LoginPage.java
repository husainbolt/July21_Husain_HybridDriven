package com.technocredits.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.technocredits.orangehrm.base.PredefinedActions;

public class LoginPage extends PredefinedActions {

	public boolean isLogoDisplayed() {
		WebElement e = getElement("TagName", "img", false);
		boolean isLogoDisplayed = e.isDisplayed();
		return isLogoDisplayed;
	}

	public boolean isLoginDisplayed() {
		WebElement e = getElement("XPATH", "//div[@id='logInPanelHeading']", false);
		boolean isLoginDisplayed = e.isDisplayed();
		return isLoginDisplayed;
	}

	public void enterLoginDetails(String uName, String pwd) {
		WebElement e = getElement("XPATH", "//input[@id='txtUsername']", false);
		e.sendKeys(uName);
		e = getElement("ID", "txtPassword", false);
		e.sendKeys(pwd);
	}

	public MenuPage clickOnLoginButton() {
		clickOnElement(getElement("ID", "btnLogin", false), false);
		return new MenuPage();
	}

	public String getPwdErrorMessage() {
		return getElement("ID", "spanMessage", false).getText();
	}
}
