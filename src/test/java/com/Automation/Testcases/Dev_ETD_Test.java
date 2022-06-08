package com.Automation.Testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;
import com.Automation.Utils.Excelutil;
import com.aventstack.extentreports.ExtentReports;

public class Dev_ETD_Test extends ActionEngine {
	String Epath = "./TestData/DevPos.xlsx";
	ExtentReports extentReport;

	public Dev_ETD_Test() {
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

	@DataProvider(name = "devETD")
	public Object[][] Devetd() {

		Object getDevetd[][] = Excelutil.getTestData(Epath, "DevETD");
		return getDevetd;
	}

	@Test(priority = 1, dataProvider = "DevLgnInit", enabled = true)
	public void devLoginInitiate(String block, String dateOfOccure, String dateOfIdentify, String otherText,
			String EventDesc, String initialInvestigation, String consequence, String assuemedCategory,
			String immediateAction) {
		test.createNode("Deviation Login Initiation Test").pass("Deviation Login Initiation")
				.createNode("Deviation login Initiation").pass("Deviation login");
		this.test = extent.createTest("Deviation Login Initiation");

		spLogin.loginToSPApplication(ConfigsReader.getPropValue("SPDevLgnID"),
				ConfigsReader.getPropValue("SPDevLgnPwd"));
		devLoginInitiation.devLoginInitiation(block, dateOfOccure, dateOfIdentify, otherText, EventDesc,
				initialInvestigation, consequence, assuemedCategory, immediateAction);
		spLogout.logOut();

	}

	

	@Test(priority = 2, dataProvider = "devETD", enabled = true)
	public void devETDInditiation(String Days) {
		test.createNode("Deviation ETD Initiation").pass("Deviation ETD Initiation")
				.createNode("Deviation ETD Initiation").pass("Deviation ETD Initiation");
		this.test = extent.createTest("Deviation ETD Initiation");
		spLogin.loginToSPApplication(ConfigsReader.getPropValue("SPDevLgnID"),
				ConfigsReader.getPropValue("SPDevLgnPwd"));
		//devETDsp.devEtdInitiation(Days);
		devETDsp.devEtdInitiation(Days);
		devETDsp.devEtdAuditTrail();
		spLogout.logOut();
	}
	
	@Test(priority = 3, enabled = true)
	public void devETDReview() {
		test.createNode("Deviation ETD Review").pass("Deviation ETD Review")
				.createNode("Deviation ETD Review").pass("Deviation ETD Review");
		this.test = extent.createTest("Deviation ETD Review");
		spLogin.loginToSPApplication(ConfigsReader.getPropValue("SPDevRevID"),
				ConfigsReader.getPropValue("SPDevRevPwd"));
		devETDsp.devEtdReview();
		devETDsp.devEtdAuditTrail();
		spLogout.logOut();
	}

	@Test(priority = 4, enabled = true)
	public void devETDApprove() {
		test.createNode("Deviation ETD Approve").pass("Deviation ETD Approve")
				.createNode("Deviation ETD Approve").pass("Deviation ETD Approve");
		this.test = extent.createTest("Deviation ETD Approve");
		spLogin.loginToSPApplication(ConfigsReader.getPropValue("SPDevApprID"),
				ConfigsReader.getPropValue("SPDevApprPwd"));
		devETDsp.devEtdApprove();
		devETDsp.devEtdAuditTrail();
		spLogout.logOut();
	}

}
