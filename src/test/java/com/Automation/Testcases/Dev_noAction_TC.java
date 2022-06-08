package com.Automation.Testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;
import com.Automation.Utils.Excelutil;
import com.aventstack.extentreports.ExtentReports;

public class Dev_noAction_TC extends ActionEngine {
String Epath = "./TestData/DeviationPositive.xlsx";
String ELpath = "./TestData/DevPos.xlsx";	
	ExtentReports extentReport;
	
	public Dev_noAction_TC() {
		super(ConfigsReader.getPropValue("applicationUrl"));
		
	}
	@DataProvider(name = "DevLgnInit")
	public Object[][] getDevLgn() {

		Object getDevLgn[][] = Excelutil.getTestData(ELpath, "DlgnI");
		return getDevLgn;
	}
	@DataProvider(name = "DevLgnRev")
	public Object[][] DevLgnReiew() {

		Object getDevLgnReiew[][] = Excelutil.getTestData(Epath, "DevLgnNoAct");
		return getDevLgnReiew;
	}
	@DataProvider(name = "DevLgnAppr")
	public Object[][] DevLgnApprove() {

		Object getDevLgnAgnReiew[][] = Excelutil.getTestData(Epath, "DevLoginAppr");
		return getDevLgnAgnReiew;
	}
	
	@DataProvider(name = "devOTD")
	public Object[][] DevOtherDeprtComment() {

		Object getDevOtherDeprtComment[][] = Excelutil.getTestData(Epath, "DevOTD");
		return getDevOtherDeprtComment;
	}
	@DataProvider(name = "devQAD")
	public Object[][] DevQADecision() {

		Object getDevQADecision[][] = Excelutil.getTestData(Epath, "DevQAD");
		return getDevQADecision;
	}
	@DataProvider(name = "devClsIn")
	public Object[][] devClosure() {

		Object getdevClosure[][] = Excelutil.getTestData(Epath, "DevCls");
		return getdevClosure;
	}
	@DataProvider(name = "devClsAppr")
	public Object[][] devClosureApprove() {

		Object getdevClosureApprove[][] = Excelutil.getTestData(Epath, "DevClsAppr");
		return getdevClosureApprove;
	}
	@Test(priority = 1, dataProvider = "DevLgnInit", enabled = false)
	public void devLoginInitiate(String block, String dateOfOccure, String dateOfIdentify, 
			String otherText, String  EventDesc, String initialInvestigation, String consequence, String assuemedCategory, String immediateAction) {
		test.createNode("Deviation Login Initiation Test").pass("Deviation Login Initiation").createNode("Deviation login Initiation")
		.pass("Deviation login");
		this.test = extent.createTest("Deviation Login Initiation");
		
		spLogin.loginToSPApplication(ConfigsReader.getPropValue("SPDevLgnID"),
				ConfigsReader.getPropValue("SPDevLgnPwd"));
		devLoginInitiation.devLoginInitiation(block, dateOfOccure, dateOfIdentify, otherText, EventDesc, 
				initialInvestigation, consequence, assuemedCategory, immediateAction);
		devLoginInitiation.devLogininitiationAuditTrail();
		spLogout.logOut();

	}
	@Test(priority = 2, dataProvider = "DevLgnRev", enabled = false)
	public void devLgnReview(String hodComments, String reasonForCA, String reasonForPA) {
		test.createNode("Deviation Login Review Test").pass("Deviation Login Review").createNode("Deviation login Review")
		.pass("Deviation login");
		this.test = extent.createTest("Deviation Login Review");
		spLogin.loginToSPApplication(ConfigsReader.getPropValue("SPDevRevID"),
				ConfigsReader.getPropValue("SPDevRevPwd"));
		devLoginReview.devLgnreviewNoActionPlan(hodComments, reasonForCA, reasonForPA);
		devLoginInitiation.devLogininitiationAuditTrail();
		spLogout.logOut();
		
	}
	@Test(priority = 3, dataProvider = "DevLgnAppr", enabled = false)
	public void devLgnAprArrove(String QAComments) {
		test.createNode("Deviation Login Approve Test").pass("Deviation Login Approve").createNode("Deviation login Approve")
		.pass("Deviation login");
		this.test = extent.createTest("Deviation Login Approve");
			spLogin.loginToSPApplication(ConfigsReader.getPropValue("SPDevApprID"),
					ConfigsReader.getPropValue("SPDevApprPwd"));
			devLoginApprove.devLgnApprove(QAComments);
			devLoginInitiation.devLogininitiationAuditTrail();
			spLogout.logOut();
			
		
	}
	@Test(priority = 4, dataProvider = "devOTD", enabled = false)
	public void dev_Otd(String Comments) {
		test.createNode("Deviation OTD Test").pass("Deviation OTD").createNode("Deviation OTD")
		.pass("Deviation OTD");
		this.test = extent.createTest("Deviation Other Deparment Comments");
			spLogin.loginToSPApplication(ConfigsReader.getPropValue("SPDevApprID"),
					ConfigsReader.getPropValue("SPDevApprPwd"));
			devOTD.devOTD(Comments);
			devOTDAuditTrail.dev_Otd_auditTrail();
			spLogout.logOut();
			
		
	}
	
	@Test(priority = 5, dataProvider = "devQAD", enabled = false)
	public void dev_Qad(String rootCauseDropdown, String reviewComments, String rootCauseDetails) {
		test.createNode("Deviation QAD Test").pass("Deviation QAD").createNode("Deviation QAD")
		.pass("Deviation QAD");
		this.test = extent.createTest("Deviation QA Decision");
		
			spLogin.loginToSPApplication(ConfigsReader.getPropValue("SPDevApprID"),
					ConfigsReader.getPropValue("SPDevApprPwd"));
			devQAD.devQAD(rootCauseDropdown, reviewComments, rootCauseDetails);
			devQAD.devQADAuditTrail();
			spLogout.logOut();
			
		
	}
	@Test(priority = 6, dataProvider = "devClsIn", enabled = false)
	public void dev_Closure(String reviewComments) {
		test.createNode("Deviation Closure Initiation").pass("Deviation Closure Initiation").createNode("Deviation Closure Initiation")
		.pass("Deviation Initiation");
		this.test = extent.createTest("Deviation Closure Initiation");
			spLogin.loginToSPApplication(ConfigsReader.getPropValue("SPDevLgnID"),
					ConfigsReader.getPropValue("SPDevLgnPwd"));
			
			devClosureInitiation.devClosureInitiation(reviewComments);
			devClosureInitiation.devClosureInitiationAuditTrails();
			spLogout.logOut();
			
		
	}
	@Test(priority = 7, dataProvider = "devClsAppr", enabled = true)
	public void dev_ClosureApprove(String ReviewComments) {
		test.createNode("Deviation Closure Approve").pass("Deviation Closure Approve").createNode("Deviation Closure Approve")
		.pass("Deviation Approve");
		this.test = extent.createTest("Deviation Closure Approve");
			spLogin.loginToSPApplication(ConfigsReader.getPropValue("SPDevRevID"),
					ConfigsReader.getPropValue("SPDevRevPwd"));

			devClosureAppr.devClosureApprove(ReviewComments);
			devClosureInitiation.devClosureInitiationAuditTrails();
			spLogout.logOut();
	
	}
	

}
