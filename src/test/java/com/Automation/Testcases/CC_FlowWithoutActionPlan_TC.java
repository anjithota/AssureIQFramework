package com.Automation.Testcases;

import java.awt.AWTException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;
import com.Automation.Utils.Excelutil;

public class CC_FlowWithoutActionPlan_TC extends ActionEngine{
	String Epath = "./TestData/CCNoActionPlan.xlsx";

	public CC_FlowWithoutActionPlan_TC() {

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
		
		// 7 CCOTD App
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
		public void CCHodRev(String IHODComments) {
			this.test = extent.createTest("Change Control Login Review");
			epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("CCLgnIHODID"),
					ConfigsReader.getPropValue("CCLgnIHODPwd"));
			ccIHODApproval.ccIHODApprovalNoActionPlan(IHODComments);
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
		
		// this test case checks the CC Closure Initiation
		@Test(priority = 6, dataProvider = "CCClsI", enabled = true)
		public void ccClousureInitiate(String ImplemetationDetail) {
			this.test = extent.createTest("Change Control Closure Initiation");
			epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("EPIQCCID"),
					ConfigsReader.getPropValue("EPIQCCPWD"));
			ccClosureInitiation.ccClosureInitiation(ImplemetationDetail);
			ccClosureAuditTrail.ccClsInitiateAuditTrail();
			logout.logOut();

		}

		// this test case checks the CC Closure Approve
		@Test(priority = 7, dataProvider = "CCClsApp", enabled = true)
		public void ccClousureApprove(String QAComment) {
			this.test = extent.createTest("Change Control Closure Approval");
			epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("CCLgnIHODID"),
					ConfigsReader.getPropValue("CCLgnIHODPwd"));
			ccClosureApproval.ccClosureApprove(QAComment);
			ccClosureAuditTrail.ccClsInitiateAuditTrail();
			logout.logOut();
		}

}
