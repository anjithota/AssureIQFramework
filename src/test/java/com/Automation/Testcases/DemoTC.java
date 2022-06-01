package com.Automation.Testcases;

import org.testng.annotations.Test;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;

public class DemoTC extends ActionEngine {
	public DemoTC() {
		super(ConfigsReader.getPropValue("applicationUrl"));

	}
	
	@Test
	public void devLoginInitiate() {
		
		
		spLogin.loginToSPApplication(ConfigsReader.getPropValue("SPDevLgnID"),
				ConfigsReader.getPropValue("SPDevLgnPwd"));
		spLogout.logOut();
	}

}
