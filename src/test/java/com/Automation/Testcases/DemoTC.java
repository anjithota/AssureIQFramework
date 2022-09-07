package com.Automation.Testcases;

import org.testng.annotations.Test;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;

public class DemoTC extends ActionEngine {
	public DemoTC() {
		super(ConfigsReader.getPropValue("applicationUrl"));

	}

	//String Epath = "./TestData/ClosureAuthorities.xlsx";

	/*@DataProvider(name = "CCLgnInit")
	public Object[][] getPrc() {

		Object getPrc[][] = Excelutil.getTestData(Epath, "PRC_CC");
		return getPrc;
	}*/
 
	@Test
	public void devLoginInitiate() {

		test.createNode("Deviation Login Initiation Test").pass("Deviation Login Initiation")
				.createNode("Deviation login Initiation").pass("Deviation login");
		this.test = extent.createTest("Deviation Login Initiation");

		spLogin.loginToSPApplication(ConfigsReader.getPropValue("SPUser1"),
				ConfigsReader.getPropValue("SPuser1p"));
		auditFindingInitiator.auditFindingRegistarationWith100Findings("title", "Major", "title", "Internal_Audit", "user2");

		
	}

}
