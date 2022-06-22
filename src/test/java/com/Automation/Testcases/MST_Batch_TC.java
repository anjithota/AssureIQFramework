package com.Automation.Testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;
import com.Automation.Utils.Excelutil;

public class MST_Batch_TC extends ActionEngine{
	public MST_Batch_TC() {

		super(ConfigsReader.getPropValue("applicationUrl"));
	}
	String Epath = "./TestData/Master_Batch.xlsx";
	
	@DataProvider(name = "bat_Reg")
	public Object[][] getbat_Reg() {
		Object getbat_Reg[][] = Excelutil.getTestData(Epath, "Bat_Reg");
		return getbat_Reg;
	}
	
	@DataProvider(name = "bat_Mod")
	public Object[][] getbat_Mod() {
		Object getbat_Mod[][] = Excelutil.getTestData(Epath, "Bat_Mod");
		return getbat_Mod;
	}
	
	@DataProvider(name = "bat_Stc")
	public Object[][] getbat_Stc() {
		Object getbat_Stc[][] = Excelutil.getTestData(Epath, "Bat_Stc");
		return getbat_Stc;
	}
	
	@Test(priority = 1, dataProvider = "bat_Reg", enabled = true)
	public void loginToEPIQ(String batchlotId, String productUcode, String batchlotSize, String qualityInspection) {
		this.test = extent.createTest("Change Control Login Initiation");
		spLogin.loginToSPApplication(ConfigsReader.getPropValue("SPDevLgnID"),
				ConfigsReader.getPropValue("SPDevLgnPwd"));
		
		mst_Batch.batchRegistrationInitiation(batchlotId, productUcode, batchlotSize, qualityInspection);
		spLogout.logOut();
	}
	
	@Test(priority = 2, dataProvider = "bat_Mod", enabled = true)
	public void loginToEPIQ(String qualityInspection, String remarks) {
		this.test = extent.createTest("Change Control Login Initiation");
		spLogin.loginToSPApplication(ConfigsReader.getPropValue("SPDevLgnID"),
				ConfigsReader.getPropValue("SPDevLgnPwd"));
		
		mst_Batch.batchModificationInitiation(qualityInspection, remarks);
		spLogout.logOut();
	}
	
	@Test(priority = 3, dataProvider = "bat_Stc", enabled = true)
	public void batchStatusChangeInActive(String remarks) {
		this.test = extent.createTest("Change Control Login Initiation");
		spLogin.loginToSPApplication(ConfigsReader.getPropValue("SPDevLgnID"),
				ConfigsReader.getPropValue("SPDevLgnPwd"));
		
		mst_Batch.batchStatusChangeInactive(remarks);
	//	mst_Batch.batchStatusChangeAuditTrail();
	spLogout.logOut();
	}
	
	
	@Test(priority = 4, dataProvider = "bat_Stc", enabled = true)
	public void batchStatusChangeActive(String remarks) {
		this.test = extent.createTest("Change Control Login Initiation");
		spLogin.loginToSPApplication(ConfigsReader.getPropValue("SPDevLgnID"),
				ConfigsReader.getPropValue("SPDevLgnPwd"));
		
		mst_Batch.batchStatusChangeActive(remarks);
		//mst_Batch.batchStatusChangeAuditTrail();
	spLogout.logOut();
	}
	
	@Test(priority = 5, dataProvider = "bat_Stc", enabled = true)
	public void batchStatusChangePermanentActive(String remarks) {
		this.test = extent.createTest("Change Control Login Initiation");
		spLogin.loginToSPApplication(ConfigsReader.getPropValue("SPDevLgnID"),
				ConfigsReader.getPropValue("SPDevLgnPwd"));
		
		mst_Batch.batchStatusChangePermanentInactive(remarks);
		//mst_Batch.batchStatusChangeAuditTrail();
	spLogout.logOut();
	}
	
	
	

}
