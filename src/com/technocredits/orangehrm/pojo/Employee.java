package com.technocredits.orangehrm.pojo;

public class Employee {
	
	String empID, name, jobTitle, empStatus, subUnit, costCenter, location, supervisor;
	
	public void setEmpID(String empID) {
		this.empID = empID;
	}
	
	public String getEmpID() {
		return this.empID;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
	public void setEmpStatus(String empStatus) {
		this.empStatus = empStatus;
	}
	
	public void setSubUnit(String subUnit) {
		this.subUnit = subUnit;
	}
	
	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

}
