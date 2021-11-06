package com.technocredits.orangehrm.testscripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import com.technocredits.orangehrm.base.PredefinedActions;
import com.technocredits.orangehrm.pages.LoginPage;
import com.technocredits.orangehrm.pages.UserProfilePage;

public class UserProfileTest {

	SoftAssert softAssert = new SoftAssert();

	public void verifyUserMenuOptions() {
		UserProfilePage userProfilePage = new UserProfilePage();
		userProfilePage.clickOnUserDropdown();
	}

}
