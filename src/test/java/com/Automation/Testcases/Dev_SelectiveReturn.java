package com.Automation.Testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;
import com.Automation.Utils.Excelutil;
import com.aventstack.extentreports.ExtentReports;

public class Dev_SelectiveReturn extends ActionEngine{
	//String ExcelPath = "./TestData/ChangeControlTC01.xlsx";
	String Epath = "./TestData/DeviationPositive.xlsx";
	
ExtentReports extentReport;
	
	public Dev_SelectiveReturn() {
		super(ConfigsReader.getPropValue("applicationUrl"));
		
	}
	
	@DataProvider(name = "DevLgnInit")
	public Object[][] getDevLgn() {

		Object getDevLgn[][] = Excelutil.getTestData(Epath, "DlgnI");
		return getDevLgn;
	}
	
	@DataProvider(name = "DevLgnRev")
	public Object[][] DevLgnReiew() {

		Object getDevLgnReiew[][] = Excelutil.getTestData(Epath, "DevLoginRev");
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
	
	@DataProvider(name = "DevLgnAgnRev")
	public Object[][] DevLgnAgnReiew() {

		Object getDevLgnAgnReiew[][] = Excelutil.getTestData(Epath, "DevLoginAgnRevSR");
		return getDevLgnAgnReiew;
	}
	
	@DataProvider(name = "devQAD")
	public Object[][] DevQADecision() {

		Object getDevQADecision[][] = Excelutil.getTestData(Epath, "DevQAD");
		return getDevQADecision;
	}

	@DataProvider(name = "docRev")
	public Object[][] docLgnRev() {

		Object getdocLgnRev[][] = Excelutil.getTestData(Epath, "DocRev");
		return getdocLgnRev;
	}
	
	@DataProvider(name = "docAppr")
	public Object[][] docLgnAppr() {

		Object getdocLgnAppr[][] = Excelutil.getTestData(Epath, "DocAppr");
		return getdocLgnAppr;
	}
	
	@DataProvider(name = "docTsk")
	public Object[][] docTaskAllocation() {

		Object getdocTaskAllocation[][] = Excelutil.getTestData(Epath, "DocTask");
		return getdocTaskAllocation;
	}
	
	@DataProvider(name = "docExe")
	public Object[][] docTaskExecution() {

		Object getdocTaskExecution[][] = Excelutil.getTestData(Epath, "DocExe");
		return getdocTaskExecution;
	}
	
	@DataProvider(name = "docCls")
	public Object[][] docClosure() {

		Object getdocClosure[][] = Excelutil.getTestData(Epath, "DocCls");
		return getdocClosure;
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
	
	@Test(priority = 4, enabled = true)
	public void ccOTDSelectiveReturn() {
		
		test.createNode("CC OTD Selective Return Test").pass("CC OTD Selective Return").createNode("CC OTD Selective Return")
		.pass("CC OTD Selective Return");
		this.test = extent.createTest("Deviation Other Department Comments Selective Return");
		spLogin.loginToSPApplication(ConfigsReader.getPropValue("SPDevApprID"),
				ConfigsReader.getPropValue("SPDevApprPwd"));
		
		devOTD.devOTDSelectiveReturn();
	//	ccSelectiveReturnAudit.ccClsReturnAuditTrail();
		logout.logOut();

	}
	
	@Test(priority = 5, dataProvider = "DevLgnAgnRev", enabled = true)
	public void devLgnAgnReview(String hodComments, String reason) {
		test.createNode("Deviation Login Review Test").pass("Deviation Login Review").createNode("Deviation login Review")
		.pass("Deviation login");
		this.test = extent.createTest("Deviation Login Review");
		spLogin.loginToSPApplication(ConfigsReader.getPropValue("SPDevRevID"),
				ConfigsReader.getPropValue("SPDevRevPwd"));
		devLoginReview.ihodAgainReview(hodComments, reason);
		spLogout.logOut();
		
	}
	@Test(priority = 6, dataProvider = "DevLgnAppr", enabled = true)
	public void devLgnAgainArrove(String QAComments) {
		test.createNode("Deviation Login Approve Test").pass("Deviation Login Approve").createNode("Deviation login Approve")
		.pass("Deviation login");
		this.test = extent.createTest("Deviation Login Approve");
			spLogin.loginToSPApplication(ConfigsReader.getPropValue("SPDevApprID"),
					ConfigsReader.getPropValue("SPDevApprPwd"));
			devLoginApprove.devLgnApprove(QAComments);
			spLogout.logOut();
			
		
	}
	
	
	@Test(priority = 7, dataProvider = "devOTD", enabled = true)
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
	@Test(priority = 8, dataProvider = "devQAD", enabled = true)
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
	
	
	@Test(priority = 9, dataProvider = "docRev", enabled = true)
	public void doc_LgnReview(String Comments) {
		test.createNode("Documentatoin Action Plan Login Review").pass("Documentatoin Action Plan Login Review").createNode("Documentatoin Action Plan Login Review")
		.pass("Documentatoin Action Plan Login Review");
		this.test = extent.createTest("Documentatoin Action Plan Login Review");
			spLogin.loginToSPApplication(ConfigsReader.getPropValue("SPDevApprID"),
					ConfigsReader.getPropValue("SPDevApprPwd"));
			docLgnReview.DnLgnReview(Comments);
			
			doclgnAuditTrailsp.docLgnInitAuditTrail();
			spLogout.logOut();
			
		
	}
	
	@Test(priority = 10, dataProvider = "docAppr", enabled = true)
	public void doc_LgnApprove(String Comments) {
		test.createNode("Documentatoin Action Plan Login Approve").pass("Documentatoin Action Plan Approve").createNode("Documentatoin Action Plan Login Approve")
		.pass("Documentatoin Action Plan Login Approve");
		this.test = extent.createTest("Documentatoin Action Plan Login Approval");
			spLogin.loginToSPApplication(ConfigsReader.getPropValue("SPDevLgnID"),
					ConfigsReader.getPropValue("SPDevLgnPwd"));
			docLgnApprovesp.devLgnApprovalApprove(Comments);
			doclgnAuditTrailsp.docLgnInitAuditTrail();
			spLogout.logOut();
			
		
	}
	
	@Test(priority = 11, dataProvider = "docTsk", enabled = true)
	public void doc_TaskAllocation(String Comments, String Department) {
		test.createNode("Documentatoin Action Plan Task Allocation").pass("Documentatoin Action Task Allocation").createNode("Documentatoin Action Plan Task Allocation")
		.pass("Documentatoin Action Plan Task Allocation");
		this.test = extent.createTest("Documentatoin Action Plan Task Allocation");
			spLogin.loginToSPApplication(ConfigsReader.getPropValue("SPDevLgnID"),
					ConfigsReader.getPropValue("SPDevLgnPwd"));
			docTaskAllocation.DnTskAllocationsP(Comments, Department);
			docTaskAuditTrail.docTaskAuditTrailSP();
			spLogout.logOut();
			
		
	}
	
	@Test(priority = 12, dataProvider = "docExe", enabled = true)
	public void doc_TaskExecution(String ActionsTaken) {
		test.createNode("Documentatoin Action Plan Task Execution").pass("Documentatoin Action Task Execution").createNode("Documentatoin Action Plan Task Execution")
		.pass("Documentatoin Action Plan Task Execution");
		this.test = extent.createTest("Documentatoin Action Plan Task Execution");
			spLogin.loginToSPApplication(ConfigsReader.getPropValue("SPDevLgnID"),
					ConfigsReader.getPropValue("SPDevLgnPwd"));
			docExeInitiation.docExeInitiationDetailsSP(ActionsTaken);
			docExeInitiation.docTaskAuditTrailSP();
			spLogout.logOut();
			
		
	}
	
	@Test(priority = 13, dataProvider = "docCls", enabled = true)
	public void doc_Closure(String Comments) {
		test.createNode("Documentatoin Action Plan Closure").pass("Documentatoin Action Closure").createNode("Documentatoin Action Plan Closure")
		.pass("Documentatoin Action Plan Closure");
		this.test = extent.createTest("Documentatoin Action Plan Closure");
			spLogin.loginToSPApplication(ConfigsReader.getPropValue("SPDevLgnID"),
					ConfigsReader.getPropValue("SPDevLgnPwd"));

			docClosuresp.documentationClosure(Comments);
			docClosuresp.donClsAuditTrail();
			
			spLogout.logOut();
			
		
	}
	
	@Test(priority = 14, dataProvider = "devClsIn", enabled = true)
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

	
	@Test(priority = 15, dataProvider = "DevClsAppr", enabled = true)
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
