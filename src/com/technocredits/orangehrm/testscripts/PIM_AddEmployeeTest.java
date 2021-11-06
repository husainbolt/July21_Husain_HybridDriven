package com.technocredits.orangehrm.testscripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.technocredits.orangehrm.pages.MenuPage;
import com.technocredits.orangehrm.pages.PIM_AddEmployeePage;

public class PIM_AddEmployeeTest extends TestBase {

	MenuPage menuPage;

	@BeforeMethod
	public void setUp() {
		menuPage = super.setup();
	}

	@Test
	public void verifyAddEmployee() throws InterruptedException {
		menuPage.navigateTo("PIM->Add Employee");
		PIM_AddEmployeePage pim_AddEmployeePage = new PIM_AddEmployeePage();
		pim_AddEmployeePage.setFirstName("Techno").setMiddleName("M").setLastName("Credits")
				.setLocation("Australian Regional HQ").clickOnNext().setHobbies().clickOnNext()
				.setWorkShiftSection("Twilight").setEffectiveDate("3").setRegion("Region-1").setFTE("0.75")
				.setTempDept("Sub unit-2").clickOnSave();

		softAssert.assertTrue(pim_AddEmployeePage.isSuccessfullySaved());

		String actualName = pim_AddEmployeePage.getNameOnBar();
		String expectedName = "Techno Credits";

		System.out.println("Validate client is saved successfully by comparing name fetched from bar");
		softAssert.assertEquals(actualName, expectedName);
		softAssert.assertAll();

	}

	@AfterMethod
	public void teardown() {
		super.tearDown();
	}

}
