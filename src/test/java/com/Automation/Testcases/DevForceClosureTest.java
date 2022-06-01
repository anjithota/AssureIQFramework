package com.Automation.Testcases;

import org.testng.annotations.Test;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;

public class DevForceClosureTest extends ActionEngine {
	
	
	public DevForceClosureTest() {

		super(ConfigsReader.getPropValue("applicationUrl"));
	}

	
	
	
	
	@Test(priority = 1, dataProvider = "DevLgnInit", enabled = true)
	public void devLoginInitiate(String block, String dateOfOccure, String dateOfIdentify, 
			String otherText, String  EventDesc, String initialInvestigation, String consequence, String assuemedCategory, String immediateAction) {
		test.createNode("Deviation Login Initiation Test").pass("Deviation Login Initiation").createNode("Deviation login Initiation")
		.pass("Deviation login");
		this.test = extent.createTest("Deviation Login Initiation");
		
		spLogin.loginToSPApplication(ConfigsReader.getPropValue("SPDevLgnID"),
				ConfigsReader.getPropValue("SPDevLgnPwd"));
		devLoginInitiation.devLoginInitiation(block, dateOfOccure, dateOfIdentify, otherText, EventDesc, 
				initialInvestigation, consequence, assuemedCategory, immediateAction);
		spLogout.logOut();

	}
	
	@Test(priority = 2, dataProvider = "DevLgnRev", enabled = true)
	public void devLgnReview(String hodComments, String planDesc, String reasonForPA) {
		test.createNode("Deviation Login Review Test").pass("Deviation Login Review").createNode("Deviation login Review")
		.pass("Deviation login");
		this.test = extent.createTest("Deviation Login Review");
		spLogin.loginToSPApplication(ConfigsReader.getPropValue("SPDevRevID"),
				ConfigsReader.getPropValue("SPDevRevPwd"));
		devLoginReview.devIhodApproval(hodComments, planDesc, reasonForPA);
		spLogout.logOut();
		
		
	}
	
	@Test(priority = 3, dataProvider = "DevLgnAppr", enabled = true)
	public void devLgnAprArrove(String QAComments) {
		test.createNode("Deviation Login Approve Test").pass("Deviation Login Approve").createNode("Deviation login Approve")
		.pass("Deviation login");
		this.test = extent.createTest("Deviation Login Approve");
			spLogin.loginToSPApplication(ConfigsReader.getPropValue("SPDevApprID"),
					ConfigsReader.getPropValue("SPDevApprPwd"));
			devLoginApprove.devLgnApprove(QAComments);
			spLogout.logOut();
			
		
	}
	
	@Test(priority = 4,enabled = true)
	public void devForceClosureInitiation() {
		test.createNode("Deviation Force Closure Initiation").pass("Deviation Force Closure Initiation").createNode("Deviation Force Closure Initiation")
		.pass("Deviation Force Closure Initiation Test");
		this.test = extent.createTest("Deviation Force Closure Initiation");
		spLogin.loginToSPApplication(ConfigsReader.getPropValue("SPDevLgnID"),
				ConfigsReader.getPropValue("SPDevLgnPwd"));
		devForceclosure.devForceClosureInitiation();
		devForceclosure.devForceClosureAuditTrail();
		spLogout.logOut();

		
	}
	
	@Test(priority = 5,enabled = true)
	public void devForceClosureApprove() {
		test.createNode("Deviation Force Closure Approve").pass("Deviation Force Closure Approve").createNode("Deviation Force Closure Approve")
		.pass("Deviation Force Closure Approve Test");
		this.test = extent.createTest("Deviation Force Closure Approve");
		spLogin.loginToSPApplication(ConfigsReader.getPropValue("SPDevRevID"),
				ConfigsReader.getPropValue("SPDevRevPwd"));
		
		devForceclosure.devForceClosureAuditTrail();
		spLogout.logOut();

		
	}
	
	
	

	
	
}
