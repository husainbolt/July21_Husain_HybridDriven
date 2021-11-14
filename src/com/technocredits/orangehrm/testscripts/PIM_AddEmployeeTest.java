package com.technocredits.orangehrm.testscripts;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.technocredits.orangehrm.pages.MenuPage;
import com.technocredits.orangehrm.pages.PIM_AddEmployeePage;
import com.technocredits.orangehrm.pages.PIM_EmployeeListPage;
import com.technocredits.orangehrm.pojo.Employee;
import com.technocredits.orangehrm.util.ExcelOperations;

public class PIM_AddEmployeeTest extends TestBase {

	MenuPage menuPage;

	@BeforeMethod
	public void setUp() {
		menuPage = super.setup();
	}

	public void verifyAddEmployee() throws InterruptedException {
		menuPage.navigateTo("PIM->Add Employee");
		PIM_AddEmployeePage pim_AddEmployeePage = new PIM_AddEmployeePage();
		pim_AddEmployeePage.setFirstName("Techno").setMiddleName("M").setLastName("Credits")
				.setLocation("Australian Regional HQ").clickOnNext().setHobbies("Swimming").clickOnNext()
				.setWorkShiftSection("Twilight").setEffectiveDate("3").setRegion("Region-1").setFTE("0.75")
				.setTempDept("Sub unit-2").clickOnSave();

		softAssert.assertTrue(pim_AddEmployeePage.isSuccessfullySaved());

		String actualName = pim_AddEmployeePage.getNameOnBar();
		String expectedName = "Techno Credits";
		String empID = pim_AddEmployeePage.getEmpID();

		System.out.println("Validate client is saved successfully by comparing name fetched from bar");
		softAssert.assertEquals(actualName, expectedName);
		softAssert.assertAll();

		menuPage.navigateTo("Employee List");
		System.out.println("Step - Navigate to Employee List screen");
		PIM_EmployeeListPage pim_EmployeeListPage = new PIM_EmployeeListPage();

		/*
		 * List<Employee> empList = pim_EmployeeListPage.getListOfEmployee();
		 * .setEmpNameinQuickSearch("Alice") .clickonQuickSearchIcon()
		 * .getListOfEmployee();
		 * 
		 * boolean isEmployeeDisplayed = false;
		 * 
		 * for(Employee list : empList) { if(list.getEmpID().equals(empID)) {
		 * isEmployeeDisplayed = true; break; } }
		 * 
		 * Assert.assertTrue(isEmployeeDisplayed);
		 */

		List<Employee> empList = pim_EmployeeListPage.setEmpNameinQuickSearch(empID).waitTillSuggestionBoxAppears()
				.getListOfEmployee();

		System.out.println("Verify correct empID is populated in the search results");
		Assert.assertEquals(empList.get(0).getEmpID(), empID, "Employee ID does not match");
	}

	@Test(dataProvider = "EmployeeData")
	public void verifyAddDataProviderTestEmployee(String firstName, String middleName, String lastName, String location,
			String hobbies, String workShift, String effectiveFrom, String region, String fte, String dept)
			throws InterruptedException {
		menuPage.navigateTo("PIM->Add Employee");
		PIM_AddEmployeePage pim_AddEmployeePage = new PIM_AddEmployeePage();
		pim_AddEmployeePage.setFirstName(firstName).setMiddleName(middleName).setLastName(lastName)
				.setLocation(location).clickOnNext().setHobbies(hobbies).clickOnNext().setWorkShiftSection(workShift)
				.setEffectiveDate(effectiveFrom).setRegion(region).setFTE(fte).setTempDept(dept).clickOnSave();

		softAssert.assertTrue(pim_AddEmployeePage.isSuccessfullySaved());

		String actualName = pim_AddEmployeePage.getNameOnBar();
		String expectedName = firstName + " " + lastName;
		String empID = pim_AddEmployeePage.getEmpID();

		System.out.println("Validate client is saved successfully by comparing name fetched from bar");
		softAssert.assertEquals(actualName, expectedName);
		softAssert.assertAll();

		menuPage.navigateTo("Employee List");
		System.out.println("Step - Navigate to Employee List screen");
		PIM_EmployeeListPage pim_EmployeeListPage = new PIM_EmployeeListPage();

		/*
		 * List<Employee> empList = pim_EmployeeListPage.getListOfEmployee();
		 * .setEmpNameinQuickSearch("Alice") .clickonQuickSearchIcon()
		 * .getListOfEmployee();
		 * 
		 * boolean isEmployeeDisplayed = false;
		 * 
		 * for(Employee list : empList) { if(list.getEmpID().equals(empID)) {
		 * isEmployeeDisplayed = true; break; } }
		 * 
		 * Assert.assertTrue(isEmployeeDisplayed);
		 */

		List<Employee> empList = pim_EmployeeListPage.setEmpNameinQuickSearch(empID).waitTillSuggestionBoxAppears()
				.getListOfEmployee();

		System.out.println("Verify correct empID is populated in the search results");
		Assert.assertEquals(empList.get(0).getEmpID(), empID, "Employee ID does not match");
	}

	@DataProvider(name = "EmployeeData")
	public Object[][] getEmployeeData() throws IOException {
		return ExcelOperations.getData("./testdata/EmployeeList1.xlsx", "Data");
	}

	@AfterMethod
	public void teardown() {
		super.tearDown();
	}

}
