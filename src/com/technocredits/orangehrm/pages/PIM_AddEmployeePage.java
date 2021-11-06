package com.technocredits.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.technocredits.orangehrm.base.PredefinedActions;

public class PIM_AddEmployeePage extends PredefinedActions {

	public PIM_AddEmployeePage setFirstName(String fName) {
		System.out.println("Step - Enter First Name");
		driver.findElement(By.id("first-name-box")).sendKeys(fName);
		;
		return this;
	}

	public PIM_AddEmployeePage setMiddleName(String mName) {
		System.out.println("Step - Enter Middle Name");
		driver.findElement(By.id("middle-name-box")).sendKeys(mName);
		;
		return this;
	}

	public PIM_AddEmployeePage setLastName(String lName) {
		System.out.println("Step - Enter Last Name");
		driver.findElement(By.id("last-name-box")).sendKeys(lName);
		return this;
	}

	public PIM_AddEmployeePage setLocation(String location) {
		System.out.println("Step - Enter Location");
		driver.findElement(By.xpath("//div[@class='filter-option-inner-inner']")).click();
		driver.findElement(By.xpath("//span[text()='" + location + "']/parent::a")).click();
		return this;
	}

	public PIM_AddEmployeePage clickOnNext() {
		
		System.out.println("Step - Click on Next");
		driver.findElement(By.xpath("//button[text()='Next']")).click();
		return this;

	}

	public void addEmployeeInfo(String fName, String mName, String lName, String location) {

		setFirstName(fName);
		setMiddleName(mName);
		setLastName(lName);
		setLocation(location);
	}

	public PIM_AddEmployeePage setHobbies() {
		
		System.out.println("Step - Enter Hobbies");
		driver.findElement(By.id("5")).sendKeys("Swimming");
		return this;
	}

	public PIM_AddEmployeePage setWorkShiftSection(String shiftValue) throws InterruptedException {
		Thread.sleep(10000L);
		System.out.println("Step - Select shift value");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@id='work_shift_id_inputfileddiv']//span[@class='caret']/following-sibling::input")));
		e.click();

		WebElement m = wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//input[@value='Default Shift']/following-sibling::ul//li/span[text()='" + shiftValue + "']")));
		m.click();
		return this;
	}

	public PIM_AddEmployeePage setEffectiveDate(String date) {
		
		System.out.println("Step - Select Effective From Date");
		driver.findElement(By.xpath("//label[text()='Effective From']/following-sibling::span/span/i")).click();
		driver.findElement(By.xpath("//input[@id='add_employee_effective_date']/following-sibling::span//div[text()='"
				+ date + "'][contains(@class,'--infocus')]")).click();
		return this;

	}

	public PIM_AddEmployeePage setRegion(String region) {
		
		System.out.println("Step - Select Region");
		driver.findElement(By.xpath("//div[@id='9_inputfileddiv']/div/input")).click();
		driver.findElement(By.xpath("//div[@id='9_inputfileddiv']/div/ul//li/span[text()='" + region + "']")).click();
		return this;
	}
	
	public PIM_AddEmployeePage setFTE(String fte) {
		
		System.out.println("Step - Select FTE");
		driver.findElement(By.xpath("//div[@id='10_inputfileddiv']/div/input")).click();
		driver.findElement(By.xpath("//div[@id='10_inputfileddiv']/div/ul//li/span[text()='" + fte + "']")).click();
		return this;
	}
	
	public PIM_AddEmployeePage setTempDept(String dept) {
		
		System.out.println("Step - Select Temporary Department");
		driver.findElement(By.xpath("//div[@id='11_inputfileddiv']/div/input")).click();
		driver.findElement(By.xpath("//div[@id='11_inputfileddiv']/div/ul//li/span[text()='" + dept + "']")).click();
		return this;
	}
	
	public PIM_AddEmployeePage clickOnSave() {
		
		System.out.println("Step - Click on Save");
		driver.findElement(By.xpath("//button[@translate='Save']")).click();
		return this;
	}
	
	public boolean isSuccessfullySaved() {
		return driver.findElement(By.xpath("//div[text()='Successfully Saved']")).isDisplayed();
	}

	
	public String getNameOnBar() {
		
		System.out.println("Step - Get name from Bar");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement e =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='pim.navbar.employeeName']")));
		return e.getText();
	}

	public void personalDetailsInfo() {

	}

	public void importantInfo() {

	}
}
