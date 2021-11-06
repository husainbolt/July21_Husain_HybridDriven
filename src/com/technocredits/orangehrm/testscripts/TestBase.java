package com.technocredits.orangehrm.testscripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import com.technocredits.orangehrm.base.PredefinedActions;
import com.technocredits.orangehrm.pages.LoginPage;
import com.technocredits.orangehrm.pages.MenuPage;

public class TestBase {
	
	SoftAssert softAssert = new SoftAssert();

	public MenuPage setup() {
		System.out.println("Step - Launch HRM app");
		PredefinedActions.start();
		LoginPage loginPage = new LoginPage();
		System.out.println("Step - Enter login creds");
		loginPage.enterLoginDetails("Admin", "Pass=1234");

		System.out.println("Step - Click on Login button");
		return loginPage.clickOnLoginButton();

	}

	public void tearDown() {
		PredefinedActions.closeBrowser();
	}

}
