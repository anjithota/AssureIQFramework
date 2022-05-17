package com.Automation.Testcases;

import java.awt.AWTException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Automation.Base.ActionEngine;
import com.Automation.Pages.LogOut;
import com.Automation.Utils.ConfigsReader;
import com.Automation.Utils.Excelutil;
import com.Automation.Utils.MyScreenRecorder;

public class CC_ForceClosure_TC extends ActionEngine {
	
	
	String Epath = "./TestData/ChangeControlSR.xlsx";
	
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
		public CC_ForceClosure_TC() {

			super(ConfigsReader.getPropValue("applicationUrl"));
		}
		@Test(priority = 1, dataProvider = "CCLgnInit", enabled = true)
		public void loginToEPIQ(String Document, String Facility, String Others, String CurrentPractice,
				String ProposedChange, String JustForProposedChange, String SupportingData, String RemarkReasons) {
			this.test = extent.createTest("Change Control Login Initiation");
			epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("Initiator"),
					ConfigsReader.getPropValue("Initiatorpwd"));
			/*ccLogin.changeControlLoginPage();
			ccLoginInitiation.changeControlRegistrationDetails(Document, Facility, Others, CurrentPractice, ProposedChange,
					JustForProposedChange, SupportingData, RemarkReasons);*/
		ccLoginInitAuditTrail.ChangeControlLoginAT();
			logout.logOut();

		}
		
		@Test(priority = 1, dataProvider = "CCLgnInit", enabled = true)
		public void loginToEPIQl(String Document, String Facility, String Others, String CurrentPractice,
				String ProposedChange, String JustForProposedChange, String SupportingData, String RemarkReasons) {
			this.test = extent.createTest("Change Control Login Initiation");
			epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("Approvar"),
					ConfigsReader.getPropValue("Approvarpwd"));
			/*ccLogin.changeControlLoginPage();
			ccLoginInitiation.changeControlRegistrationDetails(Document, Facility, Others, CurrentPractice, ProposedChange,
					JustForProposedChange, SupportingData, RemarkReasons);*/
		ccLoginInitAuditTrail.ChangeControlLoginAT();
			logout.logOut();

		}
		
		

	/*	@Test(priority = 2, dataProvider = "CCLgnHod", enabled = true)
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
		
		@Test(priority = 4, enabled= true)
		public void forceClosureInitiate() {
			this.test = extent.createTest("Change Control force closure Initiation");
			epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("EPIQCCID"),
					ConfigsReader.getPropValue("EPIQCCPWD"));
			ccForceClosure.forceClosureInitiation();
			ccForceClosure.forceClosureAuditTrail();
			logout.logOut();
		}
		
		@Test(priority = 5, enabled= true)
		public void forceClosureApprove() {
			this.test = extent.createTest("Change Control force closure Approval");
			epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("CCLgnIHODID"),
					ConfigsReader.getPropValue("CCLgnIHODPwd"));
			ccForceClosureApproval.ccForceClosureApprove();
			
			
			ccForceClosureApproval.forceClosureApproveAuditTrail();
			logout.logOut();
			epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("CCLgnIHODID"),
					ConfigsReader.getPropValue("CCLgnIHODPwd"));
			ccForceClosureImpacts.cc_OTD_Frc();
			logout.logOut();
		} */ 
	
		@AfterTest
		public void afterTest() {
			extent.flush();
			MyScreenRecorder.stopRecording();

		}
}		
		
		
