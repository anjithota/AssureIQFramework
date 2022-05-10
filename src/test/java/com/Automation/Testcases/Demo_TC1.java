package com.Automation.Testcases;

import org.testng.annotations.Test;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;

public class Demo_TC1 extends ActionEngine {
	public Demo_TC1() {

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
