package com.Automation.Testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;
import com.Automation.Utils.Excelutil;
import com.Automation.Utils.MyScreenRecorder;

public class CC_ForceClosure_Drop_TC extends ActionEngine{
	public CC_ForceClosure_Drop_TC() {

		super(ConfigsReader.getPropValue("applicationUrl"));
	}
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
		
		//4 Dataprovider for force closure approval
		
		@DataProvider(name = "CCLgnQAR")
		public Object[][] getCCFCAppr() {

			Object getCCFCAppr[][] = Excelutil.getTestData(Epath, "CCLgnQA");
			return getCCFCAppr;
		}
		
		@DataProvider(name = "FCDrop")
		public Object[][] getFroceClosureDrop() {

			Object getFroceClosureDrop[][] = Excelutil.getTestData(Epath, "Drop");
			return getFroceClosureDrop;
		}
	
	
		@Test(priority = 1, dataProvider = "CCLgnInit", enabled = true)
		public void loginToEPIQ(String Document, String Facility, String Others, String CurrentPractice,
				String ProposedChange, String JustForProposedChange, String SupportingData, String RemarkReasons) {
			test.createNode("CC Login Test").pass("CC Login").createNode("CC login")
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

		@Test(priority = 2, dataProvider = "CCLgnHod", enabled = false)
		public void CCHodRev(String IHODComments, String PlanDescription, String RemarkReason) {
			this.test = extent.createTest("Change Control Login Review");
			epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("CCLgnIHODID"),
					ConfigsReader.getPropValue("CCLgnIHODPwd"));
			ccIHODApproval.ccIHODApproval(IHODComments, PlanDescription, RemarkReason);
			ccLoginInitAuditTrail.ChangeControlLoginAT();
			logout.logOut();

		}

		@Test(priority = 3, dataProvider = "CCLgnQAR", enabled = false)
		public void ccQAReviewApprovalLgn(String QAReviewComments, String RemarkReason) {
			this.test = extent.createTest("Change Control Login Approval");
			epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("CCLgnQAID"),
					ConfigsReader.getPropValue("CCLgnQAPwd"));
			ccQAApproval.ccQAApproval(QAReviewComments, RemarkReason);
			ccLoginInitAuditTrail.ChangeControlLoginAT();
			logout.logOut();

		}
		
		@Test(priority = 4, enabled= false)
		public void forceClosureInitiate() {
			this.test = extent.createTest("Change Control force closure Initiation");
			epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("EPIQCCID"),
					ConfigsReader.getPropValue("EPIQCCPWD"));
			ccForceClosure.forceClosureInitiation();
			ccForceClosure.forceClosureAuditTrail();
			logout.logOut();
		}
		
		@Test(priority = 5,dataProvider = "FCDrop", enabled= false)
		public void forceClosureApprove(String RemarkReason) {
			this.test = extent.createTest("Change Control force closure Drop");
			epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("CCLgnIHODID"),
					ConfigsReader.getPropValue("CCLgnIHODPwd"));
			ccForceClosureApproval.ccForceClosureDrop(RemarkReason);
			
			
			ccForceClosureApproval.forceClosureDroppedAuditTrail();
			logout.logOut();
			
		}  
	
		@AfterTest
		public void afterTest() {
		extent.flush();
		MyScreenRecorder.stopRecording();



		}
}
