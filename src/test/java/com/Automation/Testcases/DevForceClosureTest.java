package com.Automation.Testcases;

import org.testng.annotations.Test;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;

public class DevForceClosureTest extends ActionEngine {
	public DevForceClosureTest() {

		super(ConfigsReader.getPropValue("applicationUrl"));
	}

	@Test(enabled = true)
	public void devLoginInitiate() {
		spLogin.loginToSPApplication(ConfigsReader.getPropValue("SPDevRevID"),
				ConfigsReader.getPropValue("SPDevRevPwd"));
		devForceclosure.devForceClosureAuditTrail();
		spLogout.logOut();

		
	}
}
