package com.Automation.Testcases;

import org.testng.annotations.Test;

import com.Automation.Base.ActionEngine;
import com.Automation.Pages.LoginPage;
import com.Automation.Utils.ConfigsReader;


public class LoginTest extends ActionEngine {
	
	
	
	public LoginTest() {

		super(ConfigsReader.getPropValue("applicationUrl"));
	}

	@Test(priority = 1)
	public void loginPage() {
		
		/*login.loginToApplication(ConfigsReader.getPropValue("EPICID"), ConfigsReader.getPropValue("EPICPWD"));
		//login.logoutbutton();
		InitiateFacility.facilityRegistration(ConfigsReader.getPropValue("FCTUCODE"), ConfigsReader.getPropValue("FCTDESC"));
		login.logoutbutton();*/
	}

/*	@Test(priority = 2)
	public void facilityPage()
	{
		InitiateFacility.facilityRegistration("Sandeep", "Sandeep");
	}
	@Test(priority = 3)
	public void logout() {
		login.logoutbutton();
	}*/
}
