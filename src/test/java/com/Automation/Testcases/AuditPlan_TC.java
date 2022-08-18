package com.Automation.Testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;
import com.Automation.Utils.Excelutil;

public class AuditPlan_TC extends ActionEngine {
	String Epath = "./TestData/Masters.xlsx";

	public AuditPlan_TC() {
		super(ConfigsReader.getPropValue("applicationUrl"));

	}

	@DataProvider(name = "AuditPlanReg")
	public Object[][] getAuditPlanReg() {

		Object getAuditPlanReg[][] = Excelutil.getTestData(Epath, "AUT_pln_Reg");
		return getAuditPlanReg;
	}

	@DataProvider(name = "AuditPlanMod")
	public Object[][] getAuditPlanMod() {

		Object getAuditPlanMod[][] = Excelutil.getTestData(Epath, "AUT_pln_Mod");
		return getAuditPlanMod;
	}

	@DataProvider(name = "AuditPlanSt")
	public Object[][] getAuditPlanMSt() {

		Object getAuditPlanSt[][] = Excelutil.getTestData(Epath, "AUT_pln_St");
		return getAuditPlanSt;
	}

	@DataProvider(name = "AuditReturn")
	public Object[][] getAuditPlanReturn() {

		Object getAuditPlanReturn[][] = Excelutil.getTestData(Epath, "AUT_pln_St");
		return getAuditPlanReturn;
	}

	@DataProvider(name = "AuditReinit")
	public Object[][] getAuditPlanReInit() {

		Object getAuditPlanReInit[][] = Excelutil.getTestData(Epath, "AUT_Pln_ReInit");
		return getAuditPlanReInit;
	}

	@Test(priority = 1, dataProvider = "AuditPlanReg", enabled = true)
	public void auditPlanRegistration(String AuditType, String desc, String departmentCode, String unique, String days,
			String Durationdaye, String audit, String roleCode) {
		test.createNode("Audit Paln Registration Initiation Test").pass("Audit Paln Registration Initiation")
				.createNode("Audit Paln Registration Initiation").pass("Audit Paln Registration Initiation");
		this.test = extent.createTest("Audit Paln Registration Initiation");
		spLogin.loginToSPApplication(ConfigsReader.getPropValue("SPDevLgnID"),
				ConfigsReader.getPropValue("SPDevLgnPwd"));

		auditplan.auditPlanRegistration(AuditType, desc, departmentCode, unique, days, Durationdaye, audit, roleCode);
		auditplan.auditPlanAuditTrails();
		spLogout.logOut();
	}

	@Test(priority = 2, dataProvider = "AuditReturn", enabled = true)
	public void auditPlanRegistrationReturn(String remarks) {
		test.createNode("Audit Paln Registration Return Test").pass("Audit Paln Registration Return")
				.createNode("Audit Paln Registration Return").pass("Audit Paln Registration Return");
		this.test = extent.createTest("Audit Paln Registration Return");
		spLogin.loginToSPApplication(ConfigsReader.getPropValue("SPDevRevID"),
				ConfigsReader.getPropValue("SPDevRevPwd"));

		auditplan.auditPlanReturn(remarks);
		auditplan.auditPlanAuditTrailsRutrned();
		spLogout.logOut();
	}

	@Test(priority = 3, dataProvider = "AuditReinit", enabled = true)
	public void auditPlanRegistrationReinitiation(String scope, String remarks) {
		test.createNode("Audit Paln Registration Reinitiation Test").pass("Audit Paln Registration Reinitiation")
				.createNode("Audit Paln Registration Reinitiation").pass("Audit Paln Registration Reinitiation");
		this.test = extent.createTest("Audit Paln Registration Reinitiation");
		spLogin.loginToSPApplication(ConfigsReader.getPropValue("SPDevLgnID"),
				ConfigsReader.getPropValue("SPDevLgnPwd"));

		auditplan.auditPlanReinitiate(scope, remarks);
		auditplan.auditPlanAuditTrailsRutrned();
		spLogout.logOut();
	}

	@Test(priority = 4, enabled = true)
	public void auditPlanRegistrationApprove() {
		test.createNode("Audit Paln Registration Approval Test").pass("Audit Paln Registration Approval")
				.createNode("Audit Paln Registration Approval").pass("Audit Paln Registration Approval");
		this.test = extent.createTest("Audit Paln Registration Approval");
		spLogin.loginToSPApplication(ConfigsReader.getPropValue("SPDevRevID"),
				ConfigsReader.getPropValue("SPDevRevPwd"));
		auditplan.auditPlanApprove();
		auditplan.auditPlanAuditTrails();
		spLogout.logOut();
	}

	@Test(priority = 5, dataProvider = "AuditPlanMod", enabled = true)
	public void auditModifiaction(String days, String remarksReason) {
		test.createNode("Audit Paln Modification Initiation Test").pass("Audit Paln Modification Initiation")
				.createNode("Audit Paln Modification Initiation").pass("Audit Paln Modification Initiation");
		this.test = extent.createTest("Audit Paln Modification Initiation");
		spLogin.loginToSPApplication(ConfigsReader.getPropValue("SPDevLgnID"),
				ConfigsReader.getPropValue("SPDevLgnPwd"));

		auditplan.auditModifiaction(days, remarksReason);
		auditplan.auditPlanAuditTrailsModification();
		spLogout.logOut();
	}

	@Test(priority = 6, dataProvider = "AuditReturn", enabled = true)
	public void auditPlanModificationReturn(String remarks) {
		test.createNode("Audit Paln Modification Return Test").pass("Audit Paln Modification Return")
				.createNode("Audit Paln Modification Return").pass("Audit Paln Modification Return");
		this.test = extent.createTest("Audit Paln Modification Return");
		spLogin.loginToSPApplication(ConfigsReader.getPropValue("SPDevRevID"),
				ConfigsReader.getPropValue("SPDevRevPwd"));

		auditplan.auditPlanReturn(remarks);
		auditplan.auditPlanAuditTrailsModification();
		spLogout.logOut();
	}

	@Test(priority = 7, dataProvider = "AuditReinit", enabled = true)
	public void auditPlanModificationReinitiation(String scope, String remarks) {
		test.createNode("Audit Paln Modification Reinitiation Test").pass("Audit Paln Modification Reinitiation")
				.createNode("Audit Paln Modification Reinitiation").pass("Audit Paln Modification Reinitiation");
		this.test = extent.createTest("Audit Paln Modification Reinitiation");
		spLogin.loginToSPApplication(ConfigsReader.getPropValue("SPDevLgnID"),
				ConfigsReader.getPropValue("SPDevLgnPwd"));

		auditplan.auditPlanReinitiate(scope, remarks);
		auditplan.auditPlanAuditTrailsModification();
		spLogout.logOut();
	}

	@Test(priority = 8, enabled = true)
	public void auditPlanModificationApprove() {
		test.createNode("Audit Paln Modification Approval Test").pass("Audit Paln Modification Approval")
				.createNode("Audit Paln Modification Approval").pass("Audit Paln Modification Approval");
		this.test = extent.createTest("Audit Paln Modification Approval");
		spLogin.loginToSPApplication(ConfigsReader.getPropValue("SPDevRevID"),
				ConfigsReader.getPropValue("SPDevRevPwd"));

		auditplan.auditPlanApprove();
		auditplan.auditPlanAuditTrailsModification();
		spLogout.logOut();
	}

	@Test(priority = 9, dataProvider = "AuditPlanSt", enabled = true)
	public void statusChangeInActive(String Remarks) {
		spLogin.loginToSPApplication(ConfigsReader.getPropValue("SPDevLgnID"),
				ConfigsReader.getPropValue("SPDevLgnPwd"));

		auditplan.statusChangeInActive(Remarks);
		auditplan.auditPlanAuditTrailsStatusChange();
		spLogout.logOut();
	}

	@Test(priority = 10, enabled = true)
	public void auditPlanStatusChangeApprove() {
		spLogin.loginToSPApplication(ConfigsReader.getPropValue("SPDevRevID"),
				ConfigsReader.getPropValue("SPDevRevPwd"));

		auditplan.auditPlanApprove();
		auditplan.auditPlanAuditTrailsStatusChange();
		spLogout.logOut();
	}

	@Test(priority = 11, dataProvider = "AuditPlanSt", enabled = true)
	public void statusChangeActive(String Remarks) {
		spLogin.loginToSPApplication(ConfigsReader.getPropValue("SPDevLgnID"),
				ConfigsReader.getPropValue("SPDevLgnPwd"));

		auditplan.statusChangeActive(Remarks);
		auditplan.auditPlanAuditTrailsStatusChange();

		// auditplan.auditPlanAuditTrailsStatusChange();
		spLogout.logOut();
	}

	@Test(priority = 12, enabled = true)
	public void auditPlanStatusChangeInApprove() {
		spLogin.loginToSPApplication(ConfigsReader.getPropValue("SPDevRevID"),
				ConfigsReader.getPropValue("SPDevRevPwd"));

		auditplan.auditPlanApprove();
		auditplan.auditPlanAuditTrailsStatusChange();
		spLogout.logOut();
	}

	@Test(priority = 13, dataProvider = "AuditPlanSt", enabled = true)
	public void statusChangePermentInActive(String Remarks) {
		spLogin.loginToSPApplication(ConfigsReader.getPropValue("SPDevLgnID"),
				ConfigsReader.getPropValue("SPDevLgnPwd"));

		auditplan.statusChangePermentInActive(Remarks);
		auditplan.auditPlanAuditTrailsStatusChange();
		// auditplan.auditPlanAuditTrailsStatusChange();
		spLogout.logOut();
	}

	@Test(priority = 14, enabled = true)
	public void auditPlanStatusChangePiApprove() {
		spLogin.loginToSPApplication(ConfigsReader.getPropValue("SPDevRevID"),
				ConfigsReader.getPropValue("SPDevRevPwd"));

		auditplan.auditPlanApprove();
		auditplan.auditPlanAuditTrailsStatusChange();
		spLogout.logOut();
	}

	@Test(priority = 15, dataProvider = "AuditPlanReg", enabled = true)
	public void auditPlanRegistrationForDrop(String AuditType, String desc, String departmentCode, String unique,
			String days, String Durationdaye, String audit, String roleCode) {
		test.createNode("Audit Paln Registration Initiation Test").pass("Audit Paln Registration Initiation")
				.createNode("Audit Paln Registration Initiation").pass("Audit Paln Registration Initiation");
		this.test = extent.createTest("Audit Paln Registration Initiation");
		spLogin.loginToSPApplication(ConfigsReader.getPropValue("SPDevLgnID"),
				ConfigsReader.getPropValue("SPDevLgnPwd"));

		auditplan.auditPlanRegistration(AuditType, desc, departmentCode, unique, days, Durationdaye, audit, roleCode);
		auditplan.auditPlanAuditTrails();
		spLogout.logOut();
	}

	@Test(priority = 16, dataProvider = "AuditReturn", enabled = true)
	public void auditPlanRegistrationdROP(String remarks) {
		test.createNode("Audit Paln Registration Drop Test").pass("Audit Paln Registration Drop")
				.createNode("Audit Paln Registration Drop").pass("Audit Paln Registration Drop");
		this.test = extent.createTest("Audit Paln Registration Drop");
		spLogin.loginToSPApplication(ConfigsReader.getPropValue("SPDevRevID"),
				ConfigsReader.getPropValue("SPDevRevPwd"));

		auditplan.auditPlanDrop(remarks);
		auditplan.auditPlanAuditTrailsRutrned();
		spLogout.logOut();
	}
	
	

}
