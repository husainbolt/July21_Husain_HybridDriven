package com.technocredits.orangehrm.testscripts;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.technocredits.orangehrm.base.PredefinedActions;
import com.technocredits.orangehrm.pages.DashboardPage;
import com.technocredits.orangehrm.pages.LoginPage;

public class DashboardTest {

	SoftAssert softAssert = new SoftAssert();

	@BeforeMethod
	public void setup() {
		System.out.println("Step - Launch HRM app");
		PredefinedActions.start();
		LoginPage loginPage = new LoginPage();
		System.out.println("Step - Enter login creds");
		loginPage.enterLoginDetails("Admin", "Pass=1234");

		System.out.println("Step - Click on Login button");
		loginPage.clickOnLoginButton();

	}

	@Test
	public void verifyWidgetsTest() {
		System.out.println("STep - Verify Dashboard Title");
		DashboardPage dashboardPage = new DashboardPage();
		String expectedTitle = "Dashboard";
		String actualTitle = dashboardPage.verifyDashboardTitle();
		softAssert.assertEquals(expectedTitle, actualTitle);

		System.out.println("Verify Dashboard Page header");
		String expectedDashboardHeader = "Dashboard";
		String actualDashboardHeader = dashboardPage.verifyDashboardPageTitle();
		softAssert.assertEquals(expectedDashboardHeader, actualDashboardHeader);

		System.out.println("Verify11 widgets are present on the dashboard");
		int expecedWidgetCount = 12;
		int actualWidgetCount = dashboardPage.getTotalWidgets();
		softAssert.assertEquals(expecedWidgetCount, actualWidgetCount);
		softAssert.assertAll();

		List<String> expectedElementsList = new ArrayList<String>();
		expectedElementsList.add("Quick Access");
		expectedElementsList.add("Buzz Latest Posts");
		expectedElementsList.add("Employee Job Details");
		expectedElementsList.add("My Actions");
		expectedElementsList.add("Headcount by Location");
		expectedElementsList.add("Employees on Leave Today");
		expectedElementsList.add("Time At Work");
		expectedElementsList.add("Performance Quick Feedback");
		expectedElementsList.add("Annual basic payment by Location");
		expectedElementsList.add("Latest Documents");
		expectedElementsList.add("Latest News");
		expectedElementsList.add("Yearly New Hires");
		List<String> actualElementList = dashboardPage.getAllWidgetsText();
		System.out.println("Verify widget count");
		Assert.assertEquals(expectedElementsList, actualElementList);

	}
	
	@AfterMethod
	public void tearDown() {
		PredefinedActions.closeBrowser();
	}

}
