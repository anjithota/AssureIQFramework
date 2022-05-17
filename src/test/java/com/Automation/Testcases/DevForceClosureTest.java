package com.Automation.Testcases;

import org.testng.annotations.Test;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;

public class DevForceClosureTest extends ActionEngine {
	
	
	public DevForceClosureTest() {

		super(ConfigsReader.getPropValue("applicationUrl"));
	}

	@Test(priority = 1,enabled = true)
	public void devLoginInitiate() {
		test.createNode("Deviation Force Closure Initiation").pass("Deviation Force Closure Initiation").createNode("Deviation Force Closure Initiation")
		.pass("Deviation Force Closure Initiation Test");
		this.test = extent.createTest("Deviation Force Closure Initiation");
		spLogin.loginToSPApplication(ConfigsReader.getPropValue("SPDevLgnID"),
				ConfigsReader.getPropValue("SPDevLgnPwd"));
		devForceclosure.devForceClosureInitiation();
		devForceclosure.devForceClosureAuditTrail();
		spLogout.logOut();

		
	}
	
	
}
