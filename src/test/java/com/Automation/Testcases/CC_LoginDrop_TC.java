package com.Automation.Testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;
import com.Automation.Utils.Excelutil;

public class CC_LoginDrop_TC extends ActionEngine {
	String Epath = "./TestData/ChangeControlSR.xlsx";

	public CC_LoginDrop_TC() {

		super(ConfigsReader.getPropValue("applicationUrl"));
	}

	// 1 Data Provider for Change Control Login Initiation
	@DataProvider(name = "CCLgnInit")
	public Object[][] getCCLgn() {

		Object getCCLgn[][] = Excelutil.getTestData(Epath, "CCLgnIn");
		return getCCLgn;
	}
	
	@DataProvider(name = "CCDrop")
	public Object[][] getFroceClosureDrop() {

		Object getFroceClosureDrop[][] = Excelutil.getTestData(Epath, "Drop");
		return getFroceClosureDrop;
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
	
	@Test(priority = 2, dataProvider = "CCDrop", enabled = true)
	public void CCHodRev(String Remarks) {
		this.test = extent.createTest("Change Control Login Review Drop");
		epiqLogin.loginToEPICOQApplication(ConfigsReader.getPropValue("CCLgnIHODID"),
				ConfigsReader.getPropValue("CCLgnIHODPwd"));
		ccIHODReturn.ccIHODApprovalDrop(Remarks);

		ccLoginInitAuditTrail.ChangeControlLoginAT();
		logout.logOut();

	}
	
	


}
