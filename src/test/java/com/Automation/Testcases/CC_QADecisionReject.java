package com.Automation.Testcases;

import java.awt.AWTException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;
import com.Automation.Utils.Excelutil;

public class CC_QADecisionReject extends ActionEngine {
	String Epath = "./TestData/ChangeControlSR.xlsx";

	public CC_QADecisionReject() {

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
	@DataProvider(name = "CCLgnQAR")
	public Object[][] getCCQAAppr() {

		Object getCCQAAppr[][] = Excelutil.getTestData(Epath, "CCLgnQA");
		return getCCQAAppr;
	}

	// 4 CCOTD App
	@DataProvider(name = "CCOtd")
	public Object[][] getCCOTD() {

		Object getCCOTD[][] = Excelutil.getTestData(Epath, "CCOTD");
		return getCCOTD;
	}

	// CCQAD Return App
	@DataProvider(name = "CCQad")
	public Object[][] getCCQAD() {

		Object getCCQAD[][] = Excelutil.getTestData(Epath, "QADR");
		return getCCQAD;
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

	@Test(priority = 1, dataProvider = "CCLgnInit", enabled = true)
	public void loginToEPIQ(String Document, String Facility, String Others, String CurrentPractice,
			String ProposedChange, String JustForProposedChange, String SupportingData, String RemarkReasons) {
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
		this.test = extent.createTest("Change Control Login Review");
		epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("CCLgnIHODID"),
				ConfigsReader.getPropValue("CCLgnIHODPwd"));
		ccIHODApproval.ccIHODApproval(IHODComments, PlanDescription, RemarkReason);
		ccLoginInitAuditTrail.ChangeControlLoginAT();
		logout.logOut();

	}

	@Test(priority = 3, dataProvider = "CCLgnQAR", enabled = true)
	public void ccQAReviewApprovalLgn(String QAReviewComments, String RemarkReason) {
		this.test = extent.createTest("Change Control Login Approval");
		epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("CCLgnQAID"),
				ConfigsReader.getPropValue("CCLgnQAPwd"));
		ccQAApproval.ccQAApproval(QAReviewComments, RemarkReason);
		ccLoginInitAuditTrail.ChangeControlLoginAT();
		logout.logOut();

	}

	@Test(priority = 4, dataProvider = "CCOtd", enabled = true)
	public void ccOTD(String Comments) {
		this.test = extent.createTest("Change Control Other Department Comments");
		epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("EPIQCCID"),
				ConfigsReader.getPropValue("EPIQCCPWD"));
		ccOTD.ccOTD(Comments);
		ccOTDAuditTrail.ccOTD_AuditTrail();
		logout.logOut();

	}

	@Test(priority = 5, dataProvider = "CCQad", enabled = true)
	public void ccQAD(String reviewComments, String Category, String Remarks) throws Exception, AWTException {
		this.test = extent.createTest("Change Control QA Decision");
		epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("EPIQCCID"),
				ConfigsReader.getPropValue("EPIQCCPWD"));
		ccQAD.ccQADReject(reviewComments, Category, Remarks);
		ccQADAuditTrail.ccQAD_AuditTrail();
		logout.logOut();

	}

	@Test(priority = 6, dataProvider = "DLReviewerApprove", enabled = true)
	public void docLgnReview(String Comments) {
		this.test = extent.createTest("Documentatoin Action Plan Login Review");
		epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("EPIQCCID"),
				ConfigsReader.getPropValue("EPIQCCPWD"));
		docLgnReview.DnLgnReview(Comments);
		docLgnAudTrail.docLgnInitAuditTrail();
		logout.logOut();

	}

	@Test(priority = 7, dataProvider = "DLApproverApprove", enabled = true)
	public void docLgnApproval(String Comments) {
		this.test = extent.createTest("Documentatoin Action Plan Login Approval");
		epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("CCLgnQAID"),
				ConfigsReader.getPropValue("EPIQCCPWD"));
		doclgnApprove.DnLgnApprove(Comments);
		docLgnAudTrail.docLgnInitAuditTrail();
		logout.logOut();

	}

	// this test case checks the Documentation Task Allocation
	@Test(priority = 8, dataProvider = "DocTaskAlc", enabled = true)
	public void docTaskAllocation(String Comments, String Department) {
		this.test = extent.createTest("Documentatoin Action Plan Task Allocation");
		epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("CCLgnIHODID"),
				ConfigsReader.getPropValue("EPIQCCPWD"));
		docTaskAllocation.DnTskAllocation(Comments, Department);
		docTaskAuditTrail.docTaskAlcnAuditTrail();
		logout.logOut();

	}

	// this test case checks the Documentation Execution
	@Test(priority = 9, dataProvider = "DOcExe", enabled = true)
	public void docExecution(String ActionsTaken) {
		this.test = extent.createTest("Documentatoin Action Plan Task Execution");
		epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("CCLgnIHODID"),
				ConfigsReader.getPropValue("EPIQCCPWD"));
		docExeInitiation.docExeInitiationDetails(ActionsTaken);
		docExeInitiation.donExeAuditTrail();
		logout.logOut();

	}

	// this test case checks the Documentation Closure
	@Test(priority = 10, dataProvider = "DOcCls", enabled = true)
	public void docClousure(String Comments) {
		this.test = extent.createTest("Documentatoin Action Plan Closure");
		epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("CCLgnIHODID"),
				ConfigsReader.getPropValue("EPIQCCPWD"));
		docClosure.docClsInitiation(Comments);
		// docClosure.donClsAuditTrail();
		logout.logOut();

	}

	// this test case checks the CC Closure Initiation
	@Test(priority = 11, dataProvider = "CCClsI", enabled = true)
	public void ccClousureInitiate(String ImplemetationDetail) {
		this.test = extent.createTest("Change Control Closure Initiation");
		epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("EPIQCCID"),
				ConfigsReader.getPropValue("EPIQCCPWD"));
		ccClosureInitiation.ccClosureInitiation(ImplemetationDetail);
		ccClosureAuditTrail.ccClsInitiateAuditTrail();
		logout.logOut();

	}

	// this test case checks the CC Closure Approve
	@Test(priority = 12, dataProvider = "CCClsApp", enabled = true)
	public void ccClousureApprove(String QAComment) {
		this.test = extent.createTest("Change Control Closure Approval");
		epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("CCLgnIHODID"),
				ConfigsReader.getPropValue("CCLgnIHODPwd"));
		ccClosureApproval.ccClosureApprove(QAComment);
		ccClosureAuditTrail.ccClsInitiateAuditTrail();
		logout.logOut();
	}

}
