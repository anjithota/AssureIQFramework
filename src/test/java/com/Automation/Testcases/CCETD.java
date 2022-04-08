package com.Automation.Testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;
import com.Automation.Utils.Excelutil;

public class CCETD extends ActionEngine{
	String Epath = "./TestData/ChangeControlETD.xlsx";	
	public CCETD() {

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
	/*@DataProvider(name = "CCLgnQA")
	public Object[][] getCCQAAppr() {

		Object getCCQAAppr[][] = Excelutil.getTestData(Epath, "CCLgnQAr");
		return getCCQAAppr;
	}*/
	
	
	@DataProvider(name = "ETD")
	public Object[][] getETD() {

		Object getETD[][] = Excelutil.getTestData(Epath, "CCetd");
		return getETD;
	}
	
	@Test(priority = 1, dataProvider = "CCLgnInit", enabled = false)
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

	@Test(priority = 2, dataProvider = "CCLgnHod", enabled = false)
	public void CCHodRev(String IHODComments, String PlanDescription, String RemarkReason) {
		this.test = extent.createTest("Change Control Login Review");
		epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("CCLgnIHODID"),
				ConfigsReader.getPropValue("CCLgnIHODPwd"));
		ccIHODApproval.ccIHODApproval(IHODComments, PlanDescription, RemarkReason);
		ccLoginInitAuditTrail.ChangeControlLoginAT();
		logout.logOut();

	}

	
	
	@Test(priority = 3, dataProvider = "ETD", enabled = true)
	public void ccETDInitiation(String Days) {
		this.test = extent.createTest("Change Control ETD Initiation");
		epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("EPIQCCID"),
				ConfigsReader.getPropValue("EPIQCCPWD"));
		ccEtdInitiate.ccEtdInitiation(Days);
		ccEtdInitiate.ccEtdAuditTrail();
		logout.logOut();

	}
	
	@Test(priority = 4, enabled = true)
	public void ccETDRev( ) {
		this.test = extent.createTest("Change Control ETD Review");
		epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("CCLgnIHODID"),
				ConfigsReader.getPropValue("CCLgnIHODPwd"));
		ccEtdInitiate.ccEtdReview();
		ccEtdInitiate.ccEtdAuditTrail();
		logout.logOut();

	}
	
	@Test(priority = 5, enabled = true)
	public void ccETDAppr( ) {
		this.test = extent.createTest("Change Control ETD Approval");
		epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("CCLgnQAID"),
				ConfigsReader.getPropValue("CCLgnQAPwd"));
		ccEtdInitiate.ccEtdApprove();
		ccEtdInitiate.ccEtdAuditTrail();
		logout.logOut();

	}
	
	

}
