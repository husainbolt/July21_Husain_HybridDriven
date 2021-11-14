package com.technocredits.orangehrm.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.technocredits.orangehrm.base.PredefinedActions;
import com.technocredits.orangehrm.pojo.Employee;

public class PIM_EmployeeListPage extends PredefinedActions {

	public PIM_EmployeeListPage setEmpNameinQuickSearch(String name) {
		
		//WebDriverWait wait = new WebDriverWait(driver, 20);
		//WebElement quickSearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("employee_name_quick_filter_employee_list_value")));
		WebElement quickSearch = getElement("ID", "employee_name_quick_filter_employee_list_value", true);
		quickSearch.sendKeys(name);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}

	public PIM_EmployeeListPage setIDinQuickSearch(String id) {
		
		System.out.println("Step - Searching using QuickSearch");

		return setEmpNameinQuickSearch(id);
	}
	
	public PIM_EmployeeListPage waitTillSuggestionBoxAppears() {
		
		//WebDriverWait wait = new WebDriverWait(driver, 20);
		//WebElement quickSearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("employee_name_quick_filter_employee_list_value")));
		WebElement quickSearch = getElement("ID", "employee_name_quick_filter_employee_list_value", true);
		return this;
	}

	public PIM_EmployeeListPage clickonQuickSearchIcon(boolean isWaitRequired) {
		
		//WebDriverWait wait = new WebDriverWait(driver, 30);
		if(isWaitRequired)
			waitTillSuggestionBoxAppears();
		//WebElement e = driver.findElement(By.xpath(
				//"//div[@id='employee_name_quick_filter_employee_list_dropdown']//div[contains(@class,'angucomplete-row')]"));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
			//	"//div[@id='employee_name_quick_filter_employee_list_dropdown']//div[contains(@class,'angucomplete-row')]")));
		getElement("XPATH", "//div[@id='employee_name_quick_filter_employee_list_dropdown']//div[contains(@class,'angucomplete-row')]", true);
		//driver.findElement(By.id("quick_search_icon")).click();
		getElement("ID", "quick_search_icon", false).click();
		return this;
	}

	public List<Employee> getListOfEmployee() {
		
		int totalRows = driver.findElements(By.xpath("//table[@id='employeeListTable']/tbody/tr")).size();
		System.out.println(totalRows);
		System.out.println("Step - Capturing rows from search results");
		List<Employee> empList = new ArrayList<Employee>();
		for (int index = 1; index <= totalRows; index++) {
			Employee employee = new Employee();
			employee.setEmpID(
					driver.findElement(By.xpath("//table[@id='employeeListTable']/tbody/tr['" + index + "']/td[2]"))
							.getText());
			employee.setName(
					driver.findElement(By.xpath("//table[@id='employeeListTable']/tbody/tr['" + index + "']/td[3]"))
							.getText());
			employee.setJobTitle(
					driver.findElement(By.xpath("//table[@id='employeeListTable']/tbody/tr['" + index + "']/td[4]"))
							.getText());
			employee.setEmpStatus(
					driver.findElement(By.xpath("//table[@id='employeeListTable']/tbody/tr['" + index + "']/td[5]"))
							.getText());
			employee.setSubUnit(
					driver.findElement(By.xpath("//table[@id='employeeListTable']/tbody/tr['" + index + "']/td[6]"))
							.getText());
			employee.setCostCenter(
					driver.findElement(By.xpath("//table[@id='employeeListTable']/tbody/tr['" + index + "']/td[7]"))
							.getText());
			employee.setLocation(
					driver.findElement(By.xpath("//table[@id='employeeListTable']/tbody/tr['" + index + "']/td[8]"))
							.getText());
			employee.setSupervisor(
					driver.findElement(By.xpath("//table[@id='employeeListTable']/tbody/tr['" + index + "']/td[9]"))
							.getText());
			empList.add(employee);
		}

		return empList;

	}

}
