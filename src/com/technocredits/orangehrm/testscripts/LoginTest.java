package com.technocredits.orangehrm.testscripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import com.technocredits.orangehrm.base.PredefinedActions;
import com.technocredits.orangehrm.pages.LoginPage;

public class LoginTest {

	SoftAssert softAssert = new SoftAssert();

	@BeforeMethod
	public void setup() {

		System.out.println("Step - Launch HRM app");
		PredefinedActions.start();

	}

	public void validateLoginWithoutPwd() {
		
		LoginPage loginPage = new LoginPage();
		System.out.println("Verify Logo is displayed on Login page");
		boolean isLogoDisplayed = loginPage.isLogoDisplayed();
		softAssert.assertTrue(isLogoDisplayed, "Logo was not displayed");
		
		System.out.println("Step - Verify login panel");
		boolean isLoginDisplayed = loginPage.isLoginDisplayed();
		softAssert.assertTrue(isLoginDisplayed, "Login Panel was not displayed");

		System.out.println("Step - Enter login creds");
		loginPage.enterLoginDetails("Admin", "");
		softAssert.assertAll();

		System.out.println("Step - Click on Login button");
		loginPage.clickOnLoginButton();
		
		String expectedErrorMessage = "Password cannot be empty";
		String actualErrorMessage = loginPage.getPwdErrorMessage();
		softAssert.assertEquals(expectedErrorMessage, actualErrorMessage);

	}

	@AfterMethod
	public void tearDown() {

		PredefinedActions.closeBrowser();

	}

}
