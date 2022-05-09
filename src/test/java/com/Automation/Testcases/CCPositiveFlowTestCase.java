package com.Automation.Testcases;

import java.awt.AWTException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Automation.Base.ActionEngine;
import com.Automation.Pages.CC_OTD;
import com.Automation.Pages.DocActionVerify;
import com.Automation.Utils.ConfigsReader;
import com.Automation.Utils.Excelutil;
import com.aventstack.extentreports.ExtentReports;

public class CCPositiveFlowTestCase extends ActionEngine {
	String ExcelPath = "./TestData/ChangeControlTC01.xlsx";
	String Epath = "./TestData/CCLogin.xlsx";

	ExtentReports extentReport;
	/*
	 * @DataProvider(name = "ChangeControl") public Object[][] getccData() { Object
	 * getccData[][] = Excelutil.getTestData(ExcelPath, "CC01"); return getccData; }
	 */

	public CCPositiveFlowTestCase() {

		super(ConfigsReader.getPropValue("applicationUrl"));

	}
	// Data Provider for Change Control Login Initiation

	@DataProvider(name = "CCLgnInit")
	public Object[][] getCCLgn() {

		Object getCCLgn[][] = Excelutil.getTestData(Epath, "ChangeControlLogin");
		return getCCLgn;
	}

	// Data Provider for Change Control IHOD Return

	@DataProvider(name = "CCLgnIHODRtn")
	public Object[][] getCCIHODReturn() {

		Object getCCIHODReturn[][] = Excelutil.getTestData(ExcelPath, "CCIHODReturn");
		return getCCIHODReturn;
	}

	// Data Provider for Change Control Login Re Initiation

	@DataProvider(name = "CCLgnReinit")
	public Object[][] getCCReInitiation() {

		Object getCCReInitiation[][] = Excelutil.getTestData(ExcelPath, "CCLoginReinit");
		return getCCReInitiation;
	}

	// Data Provider for Change Control IHOD Approval

	@DataProvider(name = "CCLgnIHODApp")
	public Object[][] getCCIHODApproval() {

		Object getCCIHODApproval[][] = Excelutil.getTestData(ExcelPath, "CCIHODApproval");
		return getCCIHODApproval;
	}

	// Data Provider for Change Control QA Return

	@DataProvider(name = "CCLgnQARtn")
	public Object[][] getCCQAReturn() {

		Object getCCQAReturn[][] = Excelutil.getTestData(ExcelPath, "CCQAReturn");
		return getCCQAReturn;
	}

	// Data Provider for Change Control Login Again Re initiation

	@DataProvider(name = "CCLgnAgnReinit")
	public Object[][] getCCAgnReInitiation() {

		Object getCCAgnReInitiation[][] = Excelutil.getTestData(ExcelPath, "CCLoginAgainReinit");
		return getCCAgnReInitiation;
	}

	// CCLgnIHODApp
	@DataProvider(name = "CCLgnAgnIHODApp")
	public Object[][] getCCAgnIHODApproval() {

		Object getCCAgnIHODApproval[][] = Excelutil.getTestData(ExcelPath, "CCAgainIHODApproval");
		return getCCAgnIHODApproval;
	}

	// CCQAReviewComments
	@DataProvider(name = "CCLgnQAApp")
	public Object[][] getCCAgnQAApproval() {

		Object getCCAgnQAApproval[][] = Excelutil.getTestData(ExcelPath, "CCQAReviewComments");
		return getCCAgnQAApproval;
	}

	// Data provider for CCOTD
	@DataProvider(name = "CCOtd")
	public Object[][] getCCOTD() {

		Object getCCOTD[][] = Excelutil.getTestData(ExcelPath, "CCOTD");
		return getCCOTD;
	}

	// Data provider for CCQAD
	@DataProvider(name = "CCQad")
	public Object[][] getCCQAD() {

		Object getCCQAD[][] = Excelutil.getTestData(ExcelPath, "CCQAD");
		return getCCQAD;
	}

	// 1 Data Provider For Return at 1st approval

	@DataProvider(name = "DLReviewReturn")
	public Object[][] getDLReviewReturn() {

		Object getDLReviewReturn[][] = Excelutil.getTestData(ExcelPath, "DL1RET");
		return getDLReviewReturn;
	}

	// 2 Data Provider For ReInitiate after return at 1st approval

	@DataProvider(name = "DLReinitiate")
	public Object[][] getDLReinitiate() {

		Object getDLReinitiate[][] = Excelutil.getTestData(ExcelPath, "DL0REI1");
		return getDLReinitiate;
	}

	// 3 Data Provider For Review after reinitiate

	@DataProvider(name = "DLReviewerApprove")
	public Object[][] getDLReviewerApprove() {

		Object getDLReviewerApprove[][] = Excelutil.getTestData(ExcelPath, "DL1REV1");
		return getDLReviewerApprove;
	}

	// 4 Data Provider For Return at 2nd approval

	@DataProvider(name = "DLApproverReturn")
	public Object[][] getDLApproverReturn() {

		Object getDLApproverReturn[][] = Excelutil.getTestData(ExcelPath, "DL2RET");
		return getDLApproverReturn;
	}

	// 5 Data Provider For reinitiate after return at 2nd approval

	@DataProvider(name = "DLAgainReinitiate")
	public Object[][] getDLAgainReinitiate() {

		Object getDLAgainReinitiate[][] = Excelutil.getTestData(ExcelPath, "DL0REI2");
		return getDLAgainReinitiate;
	}

	// 6 Data Provider For Review after 2nd reinitiate
	@DataProvider(name = "DLReviwerAgainReview")
	public Object[][] getDLReviwerAgainReview() {

		Object getDLReviwerAgainReview[][] = Excelutil.getTestData(ExcelPath, "DL1REV2");
		return getDLReviwerAgainReview;
	}

	// 7 Data Provider For 2nd approve
	@DataProvider(name = "DLApproverApprove")
	public Object[][] getDLApproverApprove() {

		Object getDLApproverApprove[][] = Excelutil.getTestData(ExcelPath, "DL2APP");
		return getDLApproverApprove;
	}

	// 8 Data Provider for Doc Task Allocation
	@DataProvider(name = "DocTaskAlc")
	public Object[][] getDocTskAlcn() {

		Object getDocTskAlcn[][] = Excelutil.getTestData(ExcelPath, "DOCTSK");
		return getDocTskAlcn;
	}

	// 9 Data Provider for Doc Execution
	@DataProvider(name = "DOcExe")
	public Object[][] getDOcExe() {

		Object getDocDOcExe[][] = Excelutil.getTestData(ExcelPath, "DOCEXE");
		return getDocDOcExe;
	}

	// 10 Data Provider for Doc closure
	@DataProvider(name = "DOcCls")
	public Object[][] getDOcCls() {

		Object getDocDOcCls[][] = Excelutil.getTestData(ExcelPath, "DOCCLS");
		return getDocDOcCls;
	}

	// Data Provider for cc closure initiation
	@DataProvider(name = "CCClsI")
	public Object[][] getCCClsI() {

		Object getCCClsI[][] = Excelutil.getTestData(ExcelPath, "CCCLSIn");
		return getCCClsI;
	}

	// Data Provider for cc closure Return
	@DataProvider(name = "CCClsRet")
	public Object[][] getCCClsRet() {

		Object getCCClsRet[][] = Excelutil.getTestData(ExcelPath, "CCCLSRET");
		return getCCClsRet;
	}

	// Data Provider for cc closure Reinitiateion
	@DataProvider(name = "CCClsRei")
	public Object[][] getCCClsRei() {

		Object getCCClsRei[][] = Excelutil.getTestData(ExcelPath, "CCCLSREI");
		return getCCClsRei;
	}

	// Data Provider for cc closure Approval
	@DataProvider(name = "CCClsApp")
	public Object[][] getCCClsApp() {

		Object getCCClsApp[][] = Excelutil.getTestData(ExcelPath, "CCCLSAPP");
		return getCCClsApp;
	}

	// Test Cases for Change Control Login Initiation

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

	@Test(priority = 2, dataProvider = "CCLgnIHODRtn", enabled = true)
	public void ccIHODLgn(String RemarkReason) {
		test.createNode("CC Login Return Test").pass("CC Login Return").createNode("CC login Return")
		.pass("CC login");
		this.test = extent.createTest("Change Control Login Review Return");
		epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("CCLgnIHODID"),
				ConfigsReader.getPropValue("CCLgnIHODPwd"));
		ccIHODReturn.returnTranAtIHOD(RemarkReason);
		ccIHODRtnAuditTrail.ccIHODRtnAT();
		logout.logOut();
	}

	@Test(priority = 3, dataProvider = "CCLgnReinit", enabled = true)
	public void ccReinit(String RemarkReason) {
		test.createNode("CC Login ReInitiation Test").pass("CC Login ReInitiation").createNode("CC login ReInitiation")
		.pass("CC login");
		this.test = extent.createTest("Change Control Login ReInitiation");
		epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("EPIQCCID"),
				ConfigsReader.getPropValue("EPIQCCPWD"));
		ccLoginReinit.ccLgnReinitiation(RemarkReason);
		ccLoginReinitAuditTrail.ccLgnReinitAT();
		logout.logOut();
	}

	// Test Cases for Change Control IHOD Approval

	@Test(priority = 4, dataProvider = "CCLgnIHODApp", enabled = true)
	public void ccIHODApprovalLgn(String IHODComments, String PlanDescription, String RemarkReason) {
		test.createNode("CC Login Review Test").pass("CC Login Review").createNode("CC login Review")
		.pass("CC Review");
		this.test = extent.createTest("Change Control Login Review");
		epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("CCLgnIHODID"),
				ConfigsReader.getPropValue("CCLgnIHODPwd"));
		ccIHODApproval.ccIHODApproval(IHODComments, PlanDescription, RemarkReason);
		ccIHODApprovalAuditTrail.ccIHODApprovalAT();
		logout.logOut();
	}

	// Test Cases for Change Control QA Review Return

	@Test(priority = 5, dataProvider = "CCLgnQARtn", enabled = true)
	public void ccQAReviewLgn(String RemarkReason) {
		test.createNode("CC Login Return Test").pass("CC Login Return").createNode("CC login Return")
		.pass("CC login Return");
		this.test = extent.createTest("Change Control Login Approver Return");
		epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("CCLgnQAID"),
				ConfigsReader.getPropValue("CCLgnQAPwd"));
		ccQAReturn.returnTranAtQAReview(RemarkReason);
		ccQARtnAuditTrail.ccQAReviewRtnAT();
		logout.logOut();
	}

	// Change Control Login Stage with 2 Approvals

	@Test(priority = 6, dataProvider = "CCLgnAgnReinit", enabled = true)
	public void ccAgainReinit(String RemarkReason) {
		test.createNode("CC Login ReInitiation Test").pass("CC Login ReInitiation").createNode("CC login ReInitiation")
		.pass("CC login Reinitition");
		this.test = extent.createTest("Change Control Login ReInitiation");
		epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("EPIQCCID"),
				ConfigsReader.getPropValue("EPIQCCPWD"));
		ccLoginAgainReinit.ccLgnAgnReinitiation(RemarkReason);
		ccLoginAgainAuditTrail.ccLgnAgnReinitAT();
		logout.logOut();
	}

	@Test(priority = 7, dataProvider = "CCLgnAgnIHODApp", enabled = true)
	public void ccAgainIHODApprovalLgn(String IHODComments, String RemarkReason) {
		test.createNode("CC Login Review Test").pass("CC Login Review").createNode("CC login Review")
		.pass("CC Review");
		this.test = extent.createTest("Change Control Login Review");
		epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("CCLgnIHODID"),
				ConfigsReader.getPropValue("CCLgnIHODPwd"));
		ccAgainIHODApproval.ccAgnIHODApproval(IHODComments, RemarkReason);
		ccIHODApprovalAuditTrail.ccIHODApprovalAT();
		logout.logOut();
	}

	@Test(priority = 8, dataProvider = "CCLgnQAApp", enabled = true)
	public void ccQAReviewApprovalLgn(String QAReviewComments, String RemarkReason) {
		test.createNode("CC Login Approve Test").pass("CC Login Approve").createNode("CC login Approve")
		.pass("CC Approve");
		this.test = extent.createTest("Change Control Login Approval");
		epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("CCLgnQAID"),
				ConfigsReader.getPropValue("CCLgnQAPwd"));
		ccQAApproval.ccQAApproval(QAReviewComments, RemarkReason);
		ccQAApprovalAuditTrail.ccQAApprovalAT();
		logout.logOut();
	}

	@Test(priority = 9, enabled = true)
	public void verifyDoc() {
		test.createNode("CC Documentation Verify Test").pass("CC Documentation Verify").createNode("CC Documentation Verify")
		.pass("CC Documentation Verify");
		this.test = extent.createTest("Documentation Action Plan Verification");
		epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("EPIQCCID"),
				ConfigsReader.getPropValue("EPIQCCPWD"));
		docActionVerify.DocLoginReviewTest();

		logout.logOut();

	}

	@Test(priority = 10, dataProvider = "CCOtd", enabled = true)
	public void ccOTD(String Comments) {
		test.createNode("CC OTD Test").pass("CC OTD").createNode("CC OTD")
		.pass("CC OTD");
		this.test = extent.createTest("Change Control Other Deparment Comments");
		epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("EPIQCCID"),
				ConfigsReader.getPropValue("EPIQCCPWD"));
		ccOTD.ccOTD(Comments);
		ccOTDAuditTrail.ccOTD_AuditTrail();
		logout.logOut();

	}

	@Test(priority = 11, dataProvider = "CCQad", enabled = true)
	public void ccQAD(String reviewComments, String Category) throws Exception, AWTException {
		test.createNode("CC QAD Test").pass("CC QAD").createNode("CC QAD")
		.pass("CC QAD");
		this.test = extent.createTest("Change Control QA Decision");
		epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("EPIQCCID"),
				ConfigsReader.getPropValue("EPIQCCPWD"));
		ccQAD.ccQAD(reviewComments, Category);
		ccQADAuditTrail.ccQAD_AuditTrail();
		logout.logOut();

	}

	@Test(priority = 12, enabled = true)
	public void VerificationClosure() {
		test.createNode("CC Closure Test").pass("CC Closure").createNode("CC Closure")
		.pass("CC Closure");
		this.test = extent.createTest("Change Control Closure Verifiation");
		epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("EPIQCCID"),
				ConfigsReader.getPropValue("EPIQCCPWD"));
		verifyCCClosure.ccClosure();
		logout.logOut();

	}

	@Test(priority = 13, dataProvider = "DLReviewReturn", enabled = true)
	public void docLgnReturnAtReviwer(String RemarkReason) {
		test.createNode("Documentatoin Action Plan Login Review Return").pass("Documentatoin Action Plan Login Review Return").createNode("Documentatoin Action Plan Login Review Return")
		.pass("Documentatoin Action Plan Login Review Return");
		this.test = extent.createTest("Documentatoin Action Plan Login Review Return");
		epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("EPIQCCID"),
				ConfigsReader.getPropValue("EPIQCCPWD"));
		docLgnReview.DnLgnReturn(RemarkReason);
		docLgnAudTrail.docLgnReturnAuditTrail();
		logout.logOut();

	}

	// this test case checks the reinitiate option after return at 1st approval
	// initiator

	@Test(priority = 14, dataProvider = "DLReinitiate", enabled = true)
	public void docLgnReinitiate(String PlanDesc, String RemarkReason) {
		test.createNode("Documentatoin Action Plan Login Reinitiation").pass("Documentatoin Action Plan Login Reinitiation").createNode("Documentatoin Action Plan Login Reinitiation")
		.pass("Documentatoin Action Plan Login Reinitiation");
		this.test = extent.createTest("Documentatoin Action Plan Login Reinitiation");
		epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("CCLgnIHODID"),
				ConfigsReader.getPropValue("EPIQCCPWD"));
		docLgnReinit.dnLoginReInitiationCC(PlanDesc, RemarkReason);
		docLgnAudTrail.docLgnReviewedAuditTrail();
		logout.logOut();

	}

	// this test case checks the review option after reinitiate 1st approve

	@Test(priority = 15, dataProvider = "DLReviewerApprove", enabled = true)
	public void docLgnReview(String Comments) {
		test.createNode("Documentatoin Action Plan Login Review").pass("Documentatoin Action Plan Login Review").createNode("Documentatoin Action Plan Login Review")
		.pass("Documentatoin Action Plan Login Review");
		this.test = extent.createTest("Documentatoin Action Plan Login Review");
		epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("EPIQCCID"),
				ConfigsReader.getPropValue("EPIQCCPWD"));
		docLgnReview.DnLgnReview(Comments);
		docLgnAudTrail.docLgnReviewedAuditTrail();
		logout.logOut();

	}

	// this test case checks the return option at 2nd approval

	@Test(priority = 16, dataProvider = "DLApproverReturn", enabled = true)
	public void docLgnApproveReturn(String RemarkReason) {
		test.createNode("Documentatoin Action Plan Login Approver Return").pass("Documentatoin Action Plan Approver Return").createNode("Documentatoin Action Plan Login Approver Return")
		.pass("Documentatoin Action Plan Login Approver Return");
		this.test = extent.createTest("Documentatoin Action Plan Login Approver Return");
		epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("CCLgnQAID"),
				ConfigsReader.getPropValue("EPIQCCPWD"));
		doclgnApprove.DnLgnReturn(RemarkReason);
		docLgnAudTrail.docLgnReturnAuditTrail();
		logout.logOut();

	}

	// this test case checks the reinitiate option after return at 2nd approval

	@Test(priority = 17, dataProvider = "DLAgainReinitiate", enabled = true)
	public void docLgnAgainReintiate(String PlanDesc, String RemarkReason) {
		test.createNode("Documentatoin Action Plan Login Reinitiation").pass("Documentatoin Action Plan Reinitiation").createNode("Documentatoin Action Plan Login Reinitiation")
		.pass("Documentatoin Action Plan Login Reinitiation");
		this.test = extent.createTest("Documentatoin Action Plan Login Reinitiation");
		epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("CCLgnIHODID"),
				ConfigsReader.getPropValue("EPIQCCPWD"));
		docLgnReinit.dnLoginReInitiationCC(PlanDesc, RemarkReason);
		docLgnAudTrail.docLgnReviewedAuditTrail();
		logout.logOut();

	}

	// this test case checks the Review option after Reinitiate

	@Test(priority = 18, dataProvider = "DLReviwerAgainReview", enabled = true)
	public void docLgnAgainReview(String Comments) {
		test.createNode("Documentatoin Action Plan Login Review").pass("Documentatoin Action Plan Review").createNode("Documentatoin Action Plan Login Review")
		.pass("Documentatoin Action Plan Login Review");
		this.test = extent.createTest("Documentatoin Action Plan Login Review");
		epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("EPIQCCID"),
				ConfigsReader.getPropValue("EPIQCCPWD"));
		docLgnReview.DnLgnAgainReview(Comments);
		docLgnAudTrail.docLgnReviewedAuditTrail();
		logout.logOut();

	}

	// this test case checks the 2nd approval option
	@Test(priority = 19, dataProvider = "DLReviwerAgainReview", enabled = true)
	public void docLgnApproval(String Comments) {
		test.createNode("Documentatoin Action Plan Login Approve").pass("Documentatoin Action Plan Approve").createNode("Documentatoin Action Plan Login Approve")
		.pass("Documentatoin Action Plan Login Approve");
		this.test = extent.createTest("Documentatoin Action Plan Login Approval");
		epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("CCLgnQAID"),
				ConfigsReader.getPropValue("EPIQCCPWD"));
		doclgnApprove.DnLgnApprove(Comments);
		docLgnAudTrail.docLgnReviewedAuditTrail();
		logout.logOut();

	}

	// this test case checks the Documentation Task Allocation
	@Test(priority = 20, dataProvider = "DocTaskAlc", enabled = true)
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
	@Test(priority = 21, dataProvider = "DOcExe", enabled = true)
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
	@Test(priority = 22, dataProvider = "DOcCls", enabled = true)
	public void docClousure(String Comments) {
		test.createNode("Documentatoin Action Plan Closure").pass("Documentatoin Action Closure").createNode("Documentatoin Action Plan Closure")
		.pass("Documentatoin Action Plan Closure");
		this.test = extent.createTest("Documentatoin Action Plan Closure");
		epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("CCLgnIHODID"),
				ConfigsReader.getPropValue("EPIQCCPWD"));
		docClosure.docClsInitiation(Comments);
		docClosure.donClsAuditTrail();
		logout.logOut();

	}

	// this test case checks the CC Closure Initiation
	@Test(priority = 23, dataProvider = "CCClsI", enabled = true)
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

	// this test case checks the CC Closure Return
	@Test(priority = 24, dataProvider = "CCClsRet", enabled = true)
	public void ccClousureReturn(String RemarkReason) {
		test.createNode("Change Control Closure Return").pass("Change Control Closure Return").createNode("Change Control Closure Return")
		.pass("Change Control Closure Return");
		this.test = extent.createTest("Change Control Closure Return");
		epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("CCLgnIHODID"),
				ConfigsReader.getPropValue("CCLgnIHODPwd"));
		ccClosureApproval.ccClosureReturn(RemarkReason);
		ccClosureAuditTrail.ccClsReturnAuditTrail();
		logout.logOut();

	}

	// this test case checks the CC Closure Re Initiation
	@Test(priority = 25, dataProvider = "CCClsRei", enabled = true)
	public void ccClousureReInitiate(String ImplemetationDetail, String RemarkReason) {
		test.createNode("Change Control Closure ReInitiation").pass("Change Control Closure ReInitiation").createNode("Change Control Closure ReInitiation")
		.pass("Change Control Closure ReInitiation");
		this.test = extent.createTest("Change Control Closure ReInitiation");
		epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("EPIQCCID"),
				ConfigsReader.getPropValue("EPIQCCPWD"));
		ccClosureInitiation.ccClosureReInitiation(ImplemetationDetail, RemarkReason);
		ccClosureAuditTrail.ccClsApproveAuditTrail();
		logout.logOut();

	}

	// this test case checks the CC Closure Approve
	@Test(priority = 26, dataProvider = "CCClsApp", enabled = true)
	public void ccClousureApprove(String QAComment) {
		test.createNode("Change Control Closure Approval").pass("Change Control Closure Approval").createNode("Change Control Closure Approval")
		.pass("Change Control Closure Approval");
		this.test = extent.createTest("Change Control Closure Approval");
		epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("CCLgnIHODID"),
				ConfigsReader.getPropValue("CCLgnIHODPwd"));
		ccClosureApproval.ccClosureApprove(QAComment);
		ccClosureAuditTrail.ccClsApproveAuditTrail();
		logout.logOut();
	}
	
}
