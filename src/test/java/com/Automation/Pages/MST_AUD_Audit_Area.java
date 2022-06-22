package com.Automation.Pages;

import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;
import com.Automation.Utils.TextUtils;
import com.Automation.Utils.TimeUtil;

public class MST_AUD_Audit_Area extends ActionEngine{
	
	Properties prop;
	public static String Uniquecode = "";

	public static String getUniqueCode() {
		return Uniquecode;
	}

	public static void setUniquecode(String uniquecode) {
		Uniquecode = uniquecode;
	}
	
	@FindBy(xpath = "//div[@class='left-menupanel']/div[5]")
	WebElement AuditManagement;
	
	@FindBy(id="AARA_01")
	WebElement AuditAreaRegistration;
	
	@FindBy(id = "btnSubmit_1")
	WebElement SubmitBtn;
	
	@FindBy(id="AUD_ARA_CTF_001_error")
	WebElement UniqueCodeError;
	
	@FindBy(id="AUD_ARA_CTF_001")
	WebElement UniqueCode;
	
	@FindBy(id="AUD_ARA_CTF_002_error")
	WebElement NameError;
	
	@FindBy(id="AUD_ARA_CTF_002")
	WebElement Name;
	
	@FindBy(id="AUD_ARA_CTF_003_error")
	WebElement AuditTypeError;
	
	@FindBy(id="select2-AUD_ARA_CTF_003-container")
	WebElement AuditTypeSlect;
	
	@FindBy(xpath = "//option[@class='caliber-selectdropdown-option'][1]")
	WebElement AuditTypeInternalSelect;
	
	@FindBy(id="AUD_ARA_CTF_004_error")
	WebElement DepartmentError;
	
	@FindBy(id="AUD_ARA_CTF_004_button")
	WebElement DepartmentAddItems;
	
	@FindBy(id = "btnAdvSearch")
	WebElement AdvancedSearch;
	

	@FindBy(name="MST_DEP_CTF_002")
	WebElement AditAreaIssueCodeFilter;
	
	@FindBy(xpath = "//span[@class='text-ellipsis'][1]")
	WebElement DepartmentCode;
	
	@FindBy(xpath = "//button[text()='Add']")
	WebElement IformTechnology;
	
	
	@FindBy(id="btnSubmitListFilter")
	WebElement ApplyBtn;
	
	@FindBy(xpath = "//button[@class='btn notselected btn-sm btnAddRemoveBtn']")
	WebElement SqaAddButton;
	
	@FindBy(xpath = "//button[text()='Add']")
	WebElement AddButton;
	
	@FindBy(id="btnOk")
	WebElement okButton;
	
	@FindBy(id="AUD_ARA_CTF_006")
	WebElement OthersDetails;
	
	@FindBy(xpath = "//span[@class='confirmation_text']")
	WebElement unicCode;
	
	@FindBy(id="cfnMsg_Next")
	WebElement Done;
	
	//Modification
	
	@FindBy(id="AARA_02")
	WebElement auditAreaModification;
	
//	@FindBy(id="btnSubmitListFilter")
//	WebElement ApplyBtn;
		
	@FindBy(id = "AUD_ARA_CTF_003")
	WebElement AuditTypeDropDown;
	
	@FindBy(name="AUD_ARA_CTF_001")
	WebElement IssueFilterCode;
	
	@FindBy(xpath = "//span[@class='text-ellipsis'][1]")
	WebElement Record;
	
	@FindBy(xpath = "//span[text()='Enter Value']")
	WebElement Remarks_Error;
	
	@FindBy(id = "txtRemarks")
	WebElement Remarks;
	
	//Status Change
	
	@FindBy(id="AARA_03")
	WebElement AuditAreaStatusChange;
	
	@FindBy(xpath = "//span[text()='Select Value']")
	WebElement ProposedStatusError;
	
	@FindBy(xpath = "//label[@for='NewStatus_5']")
	WebElement Inactive;
	
	@FindBy(xpath = "//label[@for='NewStatus_1']")
	WebElement Active;
	
	@FindBy(xpath = "//label[@for='NewStatus_10']")
	WebElement PermanetInActive;
	
	@FindBy(id = "confirmationRevertYes")
	WebElement PermanetInActiveYes;
	
	//AuditTrails
	
	@FindBy(id="AARA_04")
	WebElement AuditAreaAuditTrails;
	
	@FindBy(xpath = "//span[@class='popup-close-button']")
	WebElement AuditTrailsclose;
	
	
	public void auditAreaRegistration(String unicCod,String name, String auditType, String DepartmentCode ,String Details)
	{
		String s = "";

		prop = ConfigsReader.readProperties("./configs/configuration.properties");
		if (prop.getProperty("EnableAppendRandomValue").equalsIgnoreCase("YES")) {
			s = TextUtils.randomvalue(3);
			System.out.println("Generated S Value is: " + s);
		}
		setUniquecode(Uniquecode = unicCod + s);
		TimeUtil.shortWait();
		click(AuditManagement, "Audit Management Menu");
		scrollToViewElement(AuditAreaRegistration);
		click(AuditAreaRegistration, "Audit Area Registration");
		switchToBodyFrame(driver);
		click(SubmitBtn, "SubmitBtn");
		
		verifyCaptionContains(UniqueCodeError, "Enter Value");
		sendText(UniqueCode, Uniquecode, "unicCode");
		click(SubmitBtn, "SubmitBtn");
		
		verifyCaptionContains(NameError, "Enter Value");
		sendText(Name, name, "Name");
		click(SubmitBtn, "SubmitBtn");
		
		verifyCaptionContains(AuditTypeError, "Select Value");
		/*
		 * click(AuditTypeSlect, "AuditTypeSlect"); //switchToPopupModelFrame(driver);
		 * click(AuditTypeInternalSelect, "Audit Type Internal Select");
		 */
		selectDropdownUsingVisisbleText(AuditTypeDropDown, auditType, "");
		
		verifyCaptionContains(DepartmentError, "Select Value");
		click(DepartmentAddItems, "DepartmentAddItems");
		switchToPopupModelFrame(driver);
		click(AdvancedSearch, "AdvancedSearch");
		sendText(AditAreaIssueCodeFilter, DepartmentCode, "DepartmentCode");
		//enterUniqueCode(driver, IssueCode);
		click(ApplyBtn, "Apply Button");
		click(SqaAddButton, "Sqa AddButton");
		
		click(AddButton, "Add Button");
		//click(okButton, "okButton");
		switchToParentFrame(driver);
		sendText(OthersDetails, Details, "OthersDetails");
		click(SubmitBtn, "SubmitBtn");
		
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, unicCode);
		click(Done, "Done poup");
		switchToDefaultContent(driver);	
		
	}	
		
		
		public void auditAreaModification(String name , String remarksReason)
		{
			click(AuditManagement, "Audit Management Menu");
			scrollToViewElement(auditAreaModification);
			click(auditAreaModification, "auditAreaModification");
			switchToBodyFrame(driver);
			click(AdvancedSearch, "AdvancedSearch");
			click(IssueFilterCode, "Issue FilterCode");
			enterUniqueCode(driver, IssueFilterCode);
			click(ApplyBtn, "ApplyBtn");
			click(Record, "Record");
			
			click(SubmitBtn, "SubmitBtn");
			clearField(Name, "Name");
			sendText(Name, name, "Name");
			click(SubmitBtn, "SubitBtn");
			
			verifyCaptionContains(Remarks_Error, "Enter Value");
			sendText(Remarks, remarksReason, "Remarks Reason");
			click(SubmitBtn, "SubitBtn");
			
			E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
			saveUniqueCode(driver, unicCode);
			click(Done, "Done poup");
			switchToDefaultContent(driver);	
			
			
		}
		
		public void auditAreaStatusChangeInactive(String remarksReason)
		{
			click(AuditManagement, "Audit Management Menu");
			scrollToViewElement(AuditAreaStatusChange);
			click(AuditAreaStatusChange, "AuditAreaStatusChange");
			switchToBodyFrame(driver);
			click(AdvancedSearch, "AdvancedSearch");
			enterUniqueCode(driver, IssueFilterCode);
			click(Record, "Record");
			
			click(SubmitBtn, "Submit Btn");
			
			verifyCaptionContains(ProposedStatusError, "Select Value");
			click(Inactive, "In Active");
			sendText(Remarks, remarksReason, "Remarks Reason");
			click(SubmitBtn, "Submit Button");
			E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
			saveUniqueCode(driver, unicCode);
			click(Done, "Done poup");
			switchToDefaultContent(driver);		
		}
		
		public void AuditAreaStatusChangeActive(String remarksReason)
		{
			click(AuditManagement, "Audit Management Menu");
			scrollToViewElement(AuditAreaStatusChange);
			click(AuditAreaStatusChange, "AuditAreaStatusChange");
			switchToBodyFrame(driver);
			click(AdvancedSearch, "AdvancedSearch");
			enterUniqueCode(driver, IssueFilterCode);
			click(Record, "Record");
			
			click(SubmitBtn, "Submit Btn");
			
			verifyCaptionContains(ProposedStatusError, "Select Value");
			click(Active, "Active");
			sendText(Remarks, remarksReason, "Remarks Reason");
			click(SubmitBtn, "Submit Button");
			E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
			saveUniqueCode(driver, unicCode);
			click(Done, "Done poup");
			switchToDefaultContent(driver);		
		}
		public void auditAreaStatusChangePermanetInActive(String remarksReason)
		{
			click(AuditManagement, "Audit Management Menu");
			scrollToViewElement(AuditAreaStatusChange);
			click(AuditAreaStatusChange, "AuditAreaStatusChange");
			switchToBodyFrame(driver);
			click(AdvancedSearch, "AdvancedSearch");
			enterUniqueCode(driver, IssueFilterCode);
			click(Record, "Record");
			
			click(SubmitBtn, "SubmitBtn");
			
			verifyCaptionContains(ProposedStatusError, "Select Value");
			click(PermanetInActive, "PermanetInActive");
			click(PermanetInActiveYes, "PermanetInActiveYes");
			sendText(Remarks, remarksReason, "Remarks Reason");
			click(SubmitBtn, "Submit Button");
			E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
			saveUniqueCode(driver, unicCode);
			click(Done, "Done poup");
			switchToDefaultContent(driver);		
		}
		
		
		public void auditAreaAuditTrails()
		{
			click(AuditManagement, "Audit Management Menu");
			scrollToViewElement(AuditAreaAuditTrails);
			click(AuditAreaAuditTrails, "AuditAreaAuditTrails");
			switchToBodyFrame(driver);
			click(AdvancedSearch, "AdvancedSearch");
			enterUniqueCode(driver, IssueFilterCode);
			click(Record, "Record");
			switchToPopupModelFrame(driver);
			
			click(AuditTrailsclose, "close pop");
			switchToDefaultContent(driver);
			
		}
		
		
	
}
