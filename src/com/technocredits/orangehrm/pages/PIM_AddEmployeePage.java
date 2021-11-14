package com.technocredits.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.technocredits.orangehrm.base.PredefinedActions;

public class PIM_AddEmployeePage extends PredefinedActions {

	public String getEmpID() {
		// WebDriverWait wait = new WebDriverWait(driver, 20);
		// WebElement e =
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("employeeId")));
		WebElement e = getElement("ID", "employeeId", true);
		return e.getAttribute("value");
	}

	public PIM_AddEmployeePage setFirstName(String fName) {
		System.out.println("Step - Enter First Name");
		// WebDriverWait wait = new WebDriverWait(driver, 30);
		// WebElement e =
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first-name-box")));
		WebElement e = getElement("ID", "first-name-box", true);
		e.sendKeys(fName);
		return this;
	}

	public PIM_AddEmployeePage setMiddleName(String mName) {
		System.out.println("Step - Enter Middle Name");
		// driver.findElement(By.id("middle-name-box")).sendKeys(mName);
		WebElement e = getElement("ID", "middle-name-box", false);
		e.sendKeys(mName);
		return this;
	}

	public PIM_AddEmployeePage setLastName(String lName) {
		System.out.println("Step - Enter Last Name");
		// driver.findElement(By.id("last-name-box")).sendKeys(lName);
		WebElement e = getElement("ID", "last-name-box", false);
		e.sendKeys(lName);
		return this;
	}

	public PIM_AddEmployeePage setLocation(String location) {
		System.out.println("Step - Enter Location");
		// driver.findElement(By.xpath("//div[@class='filter-option-inner-inner']")).click();
		clickOnElement(getElement("XPATH", "//div[@class='filter-option-inner-inner']", false), false);
		// driver.findElement(By.xpath("//span[text()='" + location +
		// "']/parent::a")).click();
		clickOnElement(getElement("XPATH", "//span[text()='" + location + "']/parent::a", false), false);
		return this;
	}

	public PIM_AddEmployeePage clickOnNext() {

		System.out.println("Step - Click on Next");
		// driver.findElement(By.xpath("//button[text()='Next']")).click();
		clickOnElement(getElement("XPATH", "//button[text()='Next']", false), false);
		return this;

	}

	public void addEmployeeInfo(String fName, String mName, String lName, String location) {

		setFirstName(fName);
		setMiddleName(mName);
		setLastName(lName);
		setLocation(location);
	}

	public PIM_AddEmployeePage setHobbies(String hobbies) {

		System.out.println("Step - Enter Hobbies");
		// WebDriverWait wait = new WebDriverWait(driver, 20);
		// WebElement e =
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("5")));
		WebElement e = getElement("ID", "5", true);
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("arguments[0].scrollIntoView(true)", e);
		// js.executeScript("arguments[0].value='Swimming'", arg1);
		scrollToElement(e);
		e.sendKeys(hobbies);
		return this;
	}

	public PIM_AddEmployeePage setWorkShiftSection(String shiftValue) throws InterruptedException {
		Thread.sleep(10000L);
		System.out.println("Step - Select shift value");
		// WebDriverWait wait = new WebDriverWait(driver, 30);
		// WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(
		// By.xpath("//div[@id='work_shift_id_inputfileddiv']//span[@class='caret']/following-sibling::input")));
		// e.click();
		clickOnElement(getElement("XPATH",
				"//div[@id='work_shift_id_inputfileddiv']//span[@class='caret']/following-sibling::input", true),
				false);
		// WebElement m = wait.until(ExpectedConditions.visibilityOfElementLocated(By
		// .xpath("//input[@value='Default
		// Shift']/following-sibling::ul//li/span[text()='" + shiftValue + "']")));
		// m.click();
		clickOnElement(getElement("XPATH",
				"//input[@value='Default Shift']/following-sibling::ul//li/span[text()='" + shiftValue + "']", true),
				false);
		return this;
	}

	public PIM_AddEmployeePage setEffectiveDate(String date) {
		date = date.split("\\.")[0];
		System.out.println("Step - Select Effective From Date");
		driver.findElement(By.xpath("//label[text()='Effective From']/following-sibling::span/span/i")).click();
		driver.findElement(By.xpath("//input[@id='add_employee_effective_date']/following-sibling::span//div[text()='"
				+ date + "'][contains(@class,'--infocus')]")).click();
		return this;

	}

	public PIM_AddEmployeePage setRegion(String region) {

		System.out.println("Step - Select Region");
		// WebDriverWait wait = new WebDriverWait(driver, 10);
		// WebElement e = wait.until(
		// ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='9_inputfileddiv']/div/input")));
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("arguments[0].scrollIntoView(true)", e);
		// e.click();
		clickOnElement(getElement("XPATH", "//div[@id='9_inputfileddiv']/div/input", true), true);
		// e = wait.until(ExpectedConditions.elementToBeClickable(
		// By.xpath("//div[@id='9_inputfileddiv']/div/ul//li/span[text()='" + region +
		// "']")));
		// e.click();
		clickOnElement(
				getElement("XPATH", "//div[@id='9_inputfileddiv']/div/ul//li/span[text()='" + region + "']", false),
				false);
		return this;
	}

	public PIM_AddEmployeePage setFTE(String fte) {

		System.out.println("Step - Select FTE");
		if (fte.equals("1.0"))
			fte = "1";
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//WebElement e = wait.until(
			//	ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='10_inputfileddiv']/div/input")));
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].scrollIntoView(true)", e);
		//e.click();
		clickOnElement(getElement("XPATH", "//div[@id='10_inputfileddiv']/div/input", true), true);
		//e = wait.until(ExpectedConditions
		//		.elementToBeClickable(By.xpath("//div[@id='10_inputfileddiv']/div/ul//li/span[text()='" + fte + "']")));
		//e.click();
		clickOnElement(getElement("XPATH", "//div[@id='10_inputfileddiv']/div/ul//li/span[text()='" + fte + "']", false), false);
		return this;
	}

	public PIM_AddEmployeePage setTempDept(String dept) {

		System.out.println("Step - Select Temporary Department");
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//WebElement e = wait.until(
			//	ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='11_inputfileddiv']/div/input")));
		//e.click();
		clickOnElement(getElement("XPATH", "//div[@id='11_inputfileddiv']/div/input", true), false);
		//e = wait.until(ExpectedConditions.elementToBeClickable(
			//	By.xpath("//div[@id='11_inputfileddiv']/div/ul//li/span[text()='" + dept + "']")));
		//e.click();
		clickOnElement(getElement("XPATH", "//div[@id='11_inputfileddiv']/div/ul//li/span[text()='" + dept + "']", true), false);
		return this;
	}

	public PIM_AddEmployeePage clickOnSave() {

		System.out.println("Step - Click on Save");
		//driver.findElement(By.xpath("//button[@translate='Save']")).click();
		clickOnElement(getElement("XPATH", "//button[@translate='Save']", false), false);
		return this;
	}

	public boolean isSuccessfullySaved() {
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//WebElement e = wait
			//	.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Successfully Saved']")));
		WebElement e = getElement("XPATH", "//div[text()='Successfully Saved']", true);
		return e.isDisplayed();
	}

	public String getNameOnBar() {

		System.out.println("Step - Get name from Bar");
		//WebDriverWait wait = new WebDriverWait(driver, 30);
		//WebElement e = wait.until(
			//	ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='pim.navbar.employeeName']")));
		WebElement e = getElement("XPATH", "//span[@id='pim.navbar.employeeName']", true);
		return e.getText();
	}

	public void personalDetailsInfo() {

	}

	public void importantInfo() {

	}
}
