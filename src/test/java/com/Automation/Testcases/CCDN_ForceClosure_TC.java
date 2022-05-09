 package com.Automation.Testcases;

import java.awt.AWTException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;
import com.Automation.Utils.Excelutil;

public class CCDN_ForceClosure_TC extends ActionEngine{
	String Epath = "./TestData/ChangeControlSR.xlsx";

	public CCDN_ForceClosure_TC() {

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
	
	// 4 CCOTD App
		@DataProvider(name = "CCOtd")
		public Object[][] getCCOTD() {

			Object getCCOTD[][] = Excelutil.getTestData(Epath, "CCOTD");
			return getCCOTD;
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

	@Test(priority = 3, dataProvider = "CCLgnQA", enabled = true)
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
	public void ccQAD(String reviewComments, String Category) throws Exception, AWTException {
		this.test = extent.createTest("Change Control QA Decision");
		epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("EPIQCCID"),
				ConfigsReader.getPropValue("EPIQCCPWD"));
		ccQAD.ccQAD(reviewComments, Category);
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
	
	@Test(priority=8, enabled = true)
	public void docForceClosureInitiate() {
		this.test = extent.createTest("Documentatoin Action Plan Force Closure Initiation");
		epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("CCLgnQAID"),
				ConfigsReader.getPropValue("EPIQCCPWD"));
		ccdnForceClosureInitiation.forceClosureInitiation();
		ccdnForceClosureInitiation.forceClosureAuditTrailDN();
		logout.logOut();

		
	}
	
	@Test(priority=9, enabled = true)
	public void docForceClosureApprove() {
		this.test = extent.createTest("Documentatoin Action Plan Force Closure Approval");
		epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("CCLgnIHODID"),
				ConfigsReader.getPropValue("CCLgnIHODPwd"));
		ccdnForceClosureApproval.ccForceClosureApprove();
		ccdnForceClosureInitiation.forceClosureAuditTrailDN();
		logout.logOut();

		
	}

}
