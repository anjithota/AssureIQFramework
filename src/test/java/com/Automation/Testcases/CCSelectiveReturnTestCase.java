package com.Automation.Testcases;

import java.awt.AWTException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;
import com.Automation.Utils.Excelutil;

public class CCSelectiveReturnTestCase extends ActionEngine {
	String Epath = "./TestData/ChangeControlSR.xlsx";

	public CCSelectiveReturnTestCase() {

		super(ConfigsReader.getPropValue("applicationUrl"));
	}

	// 1 Data Provider for Change Control Login Initiation
	@DataProvider(name = "CCLgnInit")
	public Object[][] getCCLgn() {

		Object getCCLgn[][] = Excelutil.getTestData(Epath, "CCLgnIn");
		return getCCLgn;
	}

	// 2 Data Provider for Change Control Login Initiation
	@DataProvider(name = "CCLgnHod")
	public Object[][] getCCHODRev() {

		Object getCCHODRev[][] = Excelutil.getTestData(Epath, "CCLgnHod");
		return getCCHODRev;
	}

	// 3 Data Provider for Change Control Login Initiation
	@DataProvider(name = "CCLgnQA")
	public Object[][] getCCQAAppr() {

		Object getCCQAAppr[][] = Excelutil.getTestData(Epath, "CCLgnQA");
		return getCCQAAppr;
	}

	// 5 CCLgnIHODApp
	@DataProvider(name = "CCLgnAgnIHODApp")
	public Object[][] getCCAgnIHODApproval() {

		Object getCCAgnIHODApproval[][] = Excelutil.getTestData(Epath, "CCAgainIHODApproval");
		return getCCAgnIHODApproval;
	}

	// 6 CCLgnSelective Return App
	@DataProvider(name = "CCLgnSrApp")
	public Object[][] getCCLgnSrApp() {

		Object getCCLgnSrApp[][] = Excelutil.getTestData(Epath, "CCSrQAApproval");
		return getCCLgnSrApp;
	}

	// 7 CCOTD App
	@DataProvider(name = "CCOtd")
	public Object[][] getCCOTD() {

		Object getCCOTD[][] = Excelutil.getTestData(Epath, "CCOTD");
		return getCCOTD;
	}
	
	// 11 CCOTD App
		@DataProvider(name = "CCOtdAgain")
		public Object[][] getCCOTDAgain() {

			Object getCCOTDAgain[][] = Excelutil.getTestData(Epath, "CCOTD2");
			return getCCOTDAgain;
		}

	// 12 CCQAD Return App
	@DataProvider(name = "CCQad")
	public Object[][] getCCQAD() {

		Object getCCQAD[][] = Excelutil.getTestData(Epath, "CCQAD");
		return getCCQAD;
	}

	// 13 Data Provider For Doc Review

	@DataProvider(name = "DLReviewerApprove")
	public Object[][] getDLReviewerApprove() {

		Object getDLReviewerApprove[][] = Excelutil.getTestData(Epath, "DL1REV1");
		return getDLReviewerApprove;
	}

	// 14 Data Provider For 2nd approve
	@DataProvider(name = "DLApproverApprove")
	public Object[][] getDLApproverApprove() {

		Object getDLApproverApprove[][] = Excelutil.getTestData(Epath, "DL2APP");
		return getDLApproverApprove;
	}

	// 15 Data Provider for Doc Task Allocation
	@DataProvider(name = "DocTaskAlc")
	public Object[][] getDocTskAlcn() {

		Object getDocTskAlcn[][] = Excelutil.getTestData(Epath, "DOCTSK");
		return getDocTskAlcn;
	}

	// 16 Data Provider for Doc Execution
	@DataProvider(name = "DOcExe")
	public Object[][] getDOcExe() {

		Object getDocDOcExe[][] = Excelutil.getTestData(Epath, "DOCEXE");
		return getDocDOcExe;
	}

	// 17 Data Provider for Doc closure
	@DataProvider(name = "DOcCls")
	public Object[][] getDOcCls() {

		Object getDocDOcCls[][] = Excelutil.getTestData(Epath, "DOCCLS");
		return getDocDOcCls;
	}

	// 18 Data Provider for cc closure initiation
	@DataProvider(name = "CCClsI")
	public Object[][] getCCClsI() {

		Object getCCClsI[][] = Excelutil.getTestData(Epath, "CCCLSIn");
		return getCCClsI;
	}

	// 19 Data Provider for cc closure Approval
	@DataProvider(name = "CCClsApp")
	public Object[][] getCCClsApp() {

		Object getCCClsApp[][] = Excelutil.getTestData(Epath, "CCCLSAPP");
		return getCCClsApp;
	}

	@Test(priority = 1, dataProvider = "CCLgnInit", enabled = true)
	public void loginToEPIQ(String Document, String Facility, String Others, String CurrentPractice,
			String ProposedChange, String JustForProposedChange, String SupportingData, String RemarkReasons) {
		test.createNode("CC Login Initiation Test").pass("CC Login Initiation").createNode("CC login Initiation")
		.pass("CC login");
		this.test = extent.createTest("Change Control Login Initiation");
		epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("EPIQCCID"),
				ConfigsReader.getPropValue("EPIQCCPWD"));
		ccLogin.changeControlLoginPage();
		ccLoginInitiation.changeControlRegistrationDetails(Document, Facility, Others, CurrentPractice, ProposedChange,
				JustForProposedChange, SupportingData, RemarkReasons);
		ccLoginInitAuditTrail.ChangeControlLoginAT();
		logout.logOut();

	}

	@Test(priority = 2, dataProvider = "CCLgnHod", enabled = true)
	public void CCHodRev(String IHODComments, String PlanDescription, String RemarkReason) {
		test.createNode("CC Login Review Test").pass("CC Login Review").createNode("CC login Review")
		.pass("CC login");
		this.test = extent.createTest("Change Control Login Review");
		epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("CCLgnIHODID"),
				ConfigsReader.getPropValue("CCLgnIHODPwd"));
		ccIHODApproval.ccIHODApproval(IHODComments, PlanDescription, RemarkReason);
		ccLoginInitAuditTrail.ChangeControlLoginAT();
		logout.logOut();

	}

	@Test(priority = 3, dataProvider = "CCLgnQA", enabled = true)
	public void ccQAReviewApprovalLgn(String QAReviewComments, String RemarkReason) {
		test.createNode("CC Login Approve Test").pass("CC Login Approve").createNode("CC login Approve")
		.pass("CC login");
		this.test = extent.createTest("Change Control Login Approval");
		epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("CCLgnQAID"),
				ConfigsReader.getPropValue("CCLgnQAPwd"));
		ccQAApproval.ccQAApproval(QAReviewComments, RemarkReason);
		ccLoginInitAuditTrail.ChangeControlLoginAT();
		logout.logOut();

	}

	@Test(priority = 4, enabled = true)
	public void ccOTDSelectiveReturn() {
		test.createNode("CC OTD Selective Return Test").pass("CC OTD Selective Return").createNode("CC OTD Selective Return")
		.pass("CC OTD Selective Return");
		this.test = extent.createTest("Change Control Other Department Comments Selective Return");
		epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("EPIQCCID"),
				ConfigsReader.getPropValue("EPIQCCPWD"));
		ccOTD.ccOTDSelectiveReturn();
		ccSelectiveReturnAudit.ccClsReturnAuditTrail();
		logout.logOut();

	}

	@Test(priority = 5, dataProvider = "CCLgnAgnIHODApp", enabled = true)
	public void CCLgnReReview(String IHODComments, String ReamarkReason) {
		test.createNode("CC Login Review Test").pass("CC Login Review").createNode("CC login Review")
		.pass("CC login");
		this.test = extent.createTest("Change Control Login Review");
		epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("CCLgnIHODID"),
				ConfigsReader.getPropValue("CCLgnIHODPwd"));
		ccAgainIHODApproval.ccAgnIHODApproval(IHODComments, ReamarkReason);
		ccIHODApprovalAuditTrail.ccIHODApprovalAT();
		logout.logOut();

	}

	@Test(priority = 6, dataProvider = "CCLgnSrApp", enabled = true)
	public void CCLgnReAprroval(String QAComments) {
		test.createNode("CC Login Approve Test").pass("CC Login Approve").createNode("CC login Approve")
		.pass("CC login");
		this.test = extent.createTest("Change Control Login Approval");
		epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("CCLgnQAID"),
				ConfigsReader.getPropValue("CCLgnQAPwd"));
		ccQAApproval.ccQASelectiveApproval(QAComments);
		ccIHODApprovalAuditTrail.ccIHODApprovalAT();
		logout.logOut();

	}

	@Test(priority = 7, dataProvider = "CCOtd", enabled = true)
	public void ccOTD(String Comments) {
		test.createNode("CC OTD Test").pass("CC OTD").createNode("CC OTD")
		.pass("CC OTD");
		this.test = extent.createTest("Change Control Other Department Comments");
		epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("EPIQCCID"),
				ConfigsReader.getPropValue("EPIQCCPWD"));
		ccOTD.ccOTD(Comments);
		ccOTDAuditTrail.ccOTD_AuditTrail();
		logout.logOut();

	}

	@Test(priority = 8, enabled = true)
	public void ccQADSelectiveReturn() {
		test.createNode("CC QA Decisoin Selective Return Test").pass("CC QA Decisoin Selective Return").createNode("CC QA Decisoin Selective Return")
		.pass("CC QA Decisoin Selective Return");
		this.test = extent.createTest("Change Control QA Decisoin Selective Return");
		epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("EPIQCCID"),
				ConfigsReader.getPropValue("EPIQCCPWD"));
		ccQAD.ccQADSelectiveReturn();
		ccSelectiveReturnAudit.ccClsReturnAuditTrail();
		logout.logOut();

	}

	@Test(priority = 9, dataProvider = "CCLgnAgnIHODApp", enabled = true)
	public void CCLgnAgnReview(String IHODComments, String ReamarkReason) {
		test.createNode("CC Login Review Test").pass("CC Login Review").createNode("CC login Review")
		.pass("CC login");
		this.test = extent.createTest("Change Control Login Review");
		epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("CCLgnIHODID"),
				ConfigsReader.getPropValue("CCLgnIHODPwd"));
		ccAgainIHODApproval.ccAgnIHODApproval(IHODComments, ReamarkReason);
		ccIHODApprovalAuditTrail.ccIHODApprovalAT();
		logout.logOut();

	}

	@Test(priority = 10, dataProvider = "CCLgnSrApp", enabled = true)
	public void CCLgnAgnAprroval(String QAComments) {
		test.createNode("CC Login Approve Test").pass("CC Login Approve").createNode("CC login Approve")
		.pass("CC login");
		this.test = extent.createTest("Change Control Login Approval");
		epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("CCLgnQAID"),
				ConfigsReader.getPropValue("CCLgnQAPwd"));
		ccQAApproval.ccQASelectiveApproval(QAComments);
		ccIHODApprovalAuditTrail.ccIHODApprovalAT();
		logout.logOut();

	}

	@Test(priority = 11, dataProvider = "CCOtdAgain", enabled = true)
	public void ccAgnOTD(String Comments, String RemarkReasons) {
		test.createNode("CC OTD Test").pass("CC OTD").createNode("CC OTD")
		.pass("CC OTD");
		this.test = extent.createTest("Change Control Other Department Comments");
		epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("EPIQCCID"),
				ConfigsReader.getPropValue("EPIQCCPWD"));
		ccOTD.ccOTDAgain(Comments, RemarkReasons);
		ccOTDAuditTrail.ccOTD_AuditTrailAgain();
		logout.logOut();

	}

	@Test(priority = 12, dataProvider = "CCQad", enabled = true)
	public void ccQAD(String reviewComments, String Category) throws Exception, AWTException {
		test.createNode("CC QA Decision Test").pass("CC QA Decision").createNode("CC QA Decision")
		.pass("CC QA Decision");
		this.test = extent.createTest("Change Control QA Decision");
		epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("EPIQCCID"),
				ConfigsReader.getPropValue("EPIQCCPWD"));
		ccQAD.ccQAD(reviewComments, Category);
		ccQADAuditTrail.ccQAD_AuditTrail();
		logout.logOut();

	}

	@Test(priority = 13, dataProvider = "DLReviewerApprove", enabled = true)
	public void docLgnReview(String Comments) {
		test.createNode("Documentatoin Action Plan Login Review").pass("Documentatoin Action Plan Login Review").createNode("Documentatoin Action Plan Login Review")
		.pass("Documentatoin Action Plan Login Review");
		this.test = extent.createTest("Documentatoin Action Plan Login Review");
		epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("EPIQCCID"),
				ConfigsReader.getPropValue("EPIQCCPWD"));
		docLgnReview.DnLgnReview(Comments);
		docLgnAudTrail.docLgnInitAuditTrail();
		logout.logOut();

	}

	@Test(priority = 14, dataProvider = "DLApproverApprove", enabled = true)
	public void docLgnApproval(String Comments) {
		test.createNode("Documentatoin Action Plan Login Approve").pass("Documentatoin Action Plan Login Approve").createNode("Documentatoin Action Plan Login Approve")
		.pass("Documentatoin Action Plan Login Approve");
		this.test = extent.createTest("Documentatoin Action Plan Login Approval");
		epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("CCLgnQAID"),
				ConfigsReader.getPropValue("EPIQCCPWD"));
		doclgnApprove.DnLgnApprove(Comments);
		docLgnAudTrail.docLgnInitAuditTrail();
		logout.logOut();

	}

	// this test case checks the Documentation Task Allocation
	@Test(priority = 15, dataProvider = "DocTaskAlc", enabled = true)
	public void docTaskAllocation(String Comments, String Department) {
		test.createNode("Documentatoin Action Plan Task Allocation").pass("Documentatoin Action Task Allocation").createNode("Documentatoin Action Plan Task Allocation")
		.pass("Documentatoin Action Plan Task Allocation");
		this.test = extent.createTest("Documentatoin Action Plan Task Allocation");
		epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("CCLgnIHODID"),
				ConfigsReader.getPropValue("EPIQCCPWD"));
		docTaskAllocation.DnTskAllocation(Comments, Department);
		docTaskAuditTrail.docTaskAlcnAuditTrail();
		logout.logOut();

	}

	// this test case checks the Documentation Execution
	@Test(priority = 16, dataProvider = "DOcExe", enabled = true)
	public void docExecution(String ActionsTaken) {
		test.createNode("Documentatoin Action Plan Task Execution").pass("Documentatoin Action Task Execution").createNode("Documentatoin Action Plan Task Execution")
		.pass("Documentatoin Action Plan Task Execution");
		this.test = extent.createTest("Documentatoin Action Plan Task Execution");
		epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("CCLgnIHODID"),
				ConfigsReader.getPropValue("EPIQCCPWD"));
		docExeInitiation.docExeInitiationDetails(ActionsTaken);
		docExeInitiation.donExeAuditTrail();
		logout.logOut();

	}

	// this test case checks the Documentation Closure
	@Test(priority = 17, dataProvider = "DOcCls", enabled = true)
	public void docClousure(String Comments) {
		test.createNode("Documentatoin Action Plan Closure").pass("Documentatoin Action Closure").createNode("Documentatoin Action Plan Closure")
		.pass("Documentatoin Action Plan Closure");
		this.test = extent.createTest("Documentatoin Action Plan Closure");
		epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("CCLgnIHODID"),
				ConfigsReader.getPropValue("EPIQCCPWD"));
		docClosure.docClsInitiation(Comments);
		//docClosure.donClsAuditTrail();
		logout.logOut();

	}

	// this test case checks the CC Closure Initiation
	@Test(priority = 18, dataProvider = "CCClsI", enabled = true)
	public void ccClousureInitiate(String ImplemetationDetail) {
		test.createNode("Change Control Closure Initiation").pass("Change Control Closure Initiation").createNode("Change Control Closure Initiation")
		.pass("Change Control Closure Initiation");
		this.test = extent.createTest("Change Control Closure Initiation");
		epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("EPIQCCID"),
				ConfigsReader.getPropValue("EPIQCCPWD"));
		ccClosureInitiation.ccClosureInitiation(ImplemetationDetail);
		ccClosureAuditTrail.ccClsInitiateAuditTrail();
		logout.logOut();

	}

	// this test case checks the CC Closure Approve
	@Test(priority = 19, dataProvider = "CCClsApp", enabled = true)
	public void ccClousureApprove(String QAComment) {
		test.createNode("Change Control Closure ReInitiation").pass("Change Control Closure ReInitiation").createNode("Change Control Closure ReInitiation")
		.pass("Change Control Closure ReInitiation");
		this.test = extent.createTest("Change Control Closure Approval");
		epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("CCLgnIHODID"),
				ConfigsReader.getPropValue("CCLgnIHODPwd"));
		ccClosureApproval.ccClosureApprove(QAComment);
		ccClosureAuditTrail.ccClsInitiateAuditTrail();
		logout.logOut();
	}

}
