package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;
import com.Automation.Utils.TimeUtil;

public class MST_Aud_AuditAreaChecklistMapping extends ActionEngine {

	@FindBy(xpath = "//div[@class='left-menupanel']/div[5]")
	WebElement AuditManagement;

	// Registration

	@FindBy(id = "CKTM_01")
	WebElement AuditAreaChecklistMappingRegistration;

	@FindBy(id = "btnSubmit_1")
	WebElement SubmitBtn;

	@FindBy(id = "CKT_MAP_CTR_002_error")
	WebElement TypeAditArea_Error;

	@FindBy(xpath = "//label[@for='CKT_MAP_CTR_002_1']")
	WebElement TypeAditArea;

	@FindBy(id = "CKT_MAP_CTR_003_error")
	WebElement AuditAreaAddItemsError;

	@FindBy(id = "CKT_MAP_CTR_003")
	WebElement AuditAreaAddItems;

	@FindBy(id = "btnAdvSearch")
	WebElement AdvancedSearch;

	@FindBy(name = "UniqueCode")
	WebElement AuditAreaUniqueCoddeIssueCodeFilter;

	@FindBy(xpath = "//span[@class='text-ellipsis'][1]")
	WebElement UniqueCodeRecord;

	@FindBy(xpath = "//button[text()='Apply']")
	WebElement ApplyButton;

	@FindBy(id = "btnOk")
	WebElement AuditAreaOkButton;

	@FindBy(id = "CKT_MAP_CTR_004_error")
	WebElement CheckListError;

	@FindBy(id = "CKT_MAP_CTR_004")
	WebElement CheckListAddItems;

//	@FindBy(xpath = "//button[text()='Add']")                                   
//	WebElement CheckListAddButton;
//	
	@FindBy(xpath = "//button[@class='btn notselected btn-sm btnAddRemoveBtn']")
	WebElement AddButton;

	@FindBy(xpath = "//span[@class='confirmation_text']")
	WebElement UniqueCode;

	@FindBy(id = "cfnMsg_Next")
	WebElement Done;

//	@FindBy(xpath = "//label[@for='CKT_MAP_CTR_002_2']")
//	WebElement CheckList;

	// Modification

	@FindBy(id = "CKTM_02")
	WebElement AuditAreaChecklistMappingModification;

	@FindBy(name = "CKT_MAP_CTR_001")
	WebElement AuditAreaIssueCodeFilter;

	@FindBy(xpath = "//span[text()='Enter Value']")
	WebElement Remarks_Error;

	@FindBy(id = "txtRemarks")
	WebElement Remarks;

	// StatusChange

	@FindBy(id = "CKTM_03")
	WebElement AuditAreaChecklistMappingStatusChange;

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

	// AuditTrails

	@FindBy(id = "CKTM_04")
	WebElement AuditAreaChecklistMappingStatusAuditTrails;

	@FindBy(xpath = "//span[@class='popup-close-button']")
	WebElement AuditTrailsclose;

	public void auditAreaChecklistMappingRegistration(String auditUniqueCode, String checklistUniqueCode) {
		TimeUtil.shortWait();
		click(AuditManagement, "Audit Management");
		scrollToViewElement(AuditAreaChecklistMappingRegistration);
		click(AuditAreaChecklistMappingRegistration, "AuditArea Checklist Mapping Registration");
		switchToBodyFrame(driver);

		click(SubmitBtn, "Submit Button");
		verifyCaptionContains(TypeAditArea_Error, "Select Value");
		click(TypeAditArea, "Type Adit Area");
		click(SubmitBtn, "Submit Button");

		verifyCaptionContains(AuditAreaAddItemsError, "Select Value");
		click(AuditAreaAddItems, "Audit Area AddItems");
		switchToPopupModelFrame(driver);
		click(AdvancedSearch, "Advanced Search");
		click(AuditAreaUniqueCoddeIssueCodeFilter, "Audit Area Issue Code Filter");
		// sendText(AuditAreaUniqueCoddeIssueCodeFilter, auditUniqueCode,
		// "AuditAreaIssueCodeFilter");
		enterUniqueCode(driver, AuditAreaUniqueCoddeIssueCodeFilter);
		click(ApplyButton, "Apply Button");
		click(UniqueCodeRecord, "UniqueCodeRecord");
		click(AuditAreaOkButton, "Audit Area Ok Button");
		switchToParentFrame(driver);

		verifyCaptionContains(CheckListError, "Select Value");
		click(CheckListAddItems, "Check List AddItems");
		switchToPopupModelFrame(driver);
		click(AdvancedSearch, "Advanced Search");
		click(AuditAreaUniqueCoddeIssueCodeFilter, "Audit Area Issue Code Filter");
		// sendText(AuditAreaUniqueCoddeIssueCodeFilter, checklistUniqueCode,
		// "AuditAreaIssueCodeFilter");
		enterUniqueCode(driver, AuditAreaUniqueCoddeIssueCodeFilter);
		click(ApplyButton, "Apply Button");

		click(AddButton, "CheckList Add Button");

		click(AuditAreaOkButton, "Audit Area Ok Button");
		switchToParentFrame(driver);

		click(SubmitBtn, "Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, UniqueCode);
		click(Done, "Done poup");
		switchToDefaultContent(driver);
	}

	public void auditAreaChecklistMappingModification(String name, String remarksReason) {
		TimeUtil.shortWait();
		click(AuditManagement, "Audit Management");
		scrollToViewElement(AuditAreaChecklistMappingModification);
		click(AuditAreaChecklistMappingModification, "AuditArea Checklist Mapping Modification");
		switchToBodyFrame(driver);

		// click(SubmitBtn, "SubmitBtn");
		click(AdvancedSearch, "Advanced Search");
		click(AuditAreaIssueCodeFilter, "Audit Area Issue Code Filter");
		enterUniqueCode(driver, AuditAreaIssueCodeFilter);
		click(UniqueCodeRecord, "UniqueCode Record");

		click(SubmitBtn, "Submit Button");
		click(CheckListAddItems, "Check List AddItems");
		switchToPopupModelFrame(driver);
		click(AdvancedSearch, "Advanced Search");
		click(AuditAreaUniqueCoddeIssueCodeFilter, "Audit Area Issue Code Filter");

		sendText(AuditAreaUniqueCoddeIssueCodeFilter, name, "AuditAreaIssueCodeFilter");
		click(ApplyButton, "Apply Button");
		click(AddButton, "CheckList Add Button");

		click(AuditAreaOkButton, "Audit Area Ok Button");
		switchToParentFrame(driver);

		verifyCaptionContains(Remarks_Error, "Enter Value");
		sendText(Remarks, remarksReason, "Remarks Reason");
		click(SubmitBtn, "SubitBtn");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, UniqueCode);
		click(Done, "Done poup");
		switchToDefaultContent(driver);
	}

	public void auditAreaChecklistMappingStatusChangeInActive(String remarksReason) {
		TimeUtil.shortWait();
		click(AuditManagement, "Audit Management");
		scrollToViewElement(AuditAreaChecklistMappingStatusChange);
		click(AuditAreaChecklistMappingStatusChange, "AuditArea Checklist Mapping StatusChange");
		switchToBodyFrame(driver);

		// click(SubmitBtn, "SubmitBtn");
		click(AdvancedSearch, "Advanced Search");
		// click(AuditAreaIssueCodeFilter, "Audit Area Issue Code Filter");
		enterUniqueCode(driver, AuditAreaIssueCodeFilter);
		click(UniqueCodeRecord, "UniqueCodeRecord");
		// click(ApplyButton, "Apply Button");
		click(SubmitBtn, "Submit Button");
		verifyCaptionContains(ProposedStatusError, "Select Value");
		click(Inactive, "In Active");

		// verifyCaptionContains(Remarks_Error, "Enter Value");
		sendText(Remarks, remarksReason, "Remarks Reason");
		click(SubmitBtn, "Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, UniqueCode);
		click(Done, "Done poup");
		switchToDefaultContent(driver);
	}

	public void auditAreaChecklistMappingStatusChangeActive(String remarksReason) {
		TimeUtil.shortWait();
		click(AuditManagement, "Audit Management");
		scrollToViewElement(AuditAreaChecklistMappingStatusChange);
		click(AuditAreaChecklistMappingStatusChange, "AuditArea Checklist Mapping StatusChange");
		switchToBodyFrame(driver);

		// click(SubmitBtn, "SubmitBtn");
		click(AdvancedSearch, "Advanced Search");
		// click(AuditAreaIssueCodeFilter, "Audit Area Issue Code Filter");
		enterUniqueCode(driver, AuditAreaIssueCodeFilter);
		click(UniqueCodeRecord, "UniqueCode Record");

		click(SubmitBtn, "Submit Button");
		verifyCaptionContains(ProposedStatusError, "Select Value");
		click(Active, "Active");
		// verifyCaptionContains(Remarks_Error, "Enter Value");
		sendText(Remarks, remarksReason, "Remarks Reason");
		click(SubmitBtn, "Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, UniqueCode);
		click(Done, "Done poup");
		switchToDefaultContent(driver);
	}

	public void auditAreaChecklistMappingStatusChangePermanetInActive(String remarksReason) {
		TimeUtil.shortWait();
		click(AuditManagement, "Audit Management");
		scrollToViewElement(AuditAreaChecklistMappingStatusChange);
		click(AuditAreaChecklistMappingStatusChange, "AuditArea Checklist Mapping StatusChange");
		switchToBodyFrame(driver);

		// click(SubmitBtn, "SubmitBtn");
		click(AdvancedSearch, "Advanced Search");
		click(AuditAreaIssueCodeFilter, "Audit Area Issue Code Filter");
		enterUniqueCode(driver, AuditAreaIssueCodeFilter);
		click(UniqueCodeRecord, "UniqueCode Record");

		click(SubmitBtn, "Submit Button");
		verifyCaptionContains(ProposedStatusError, "Select Value");
		click(PermanetInActive, "Permanet In Active");
		click(PermanetInActiveYes, "Permanet In Active Yes");
		// verifyCaptionContains(Remarks_Error, "Enter Value");
		sendText(Remarks, remarksReason, "Remarks Reason");
		click(SubmitBtn, "Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, UniqueCode);
		click(Done, "Done poup");
		switchToDefaultContent(driver);
	}

	public void auditAreaChecklistMappingStatusAuditTrails() {
		TimeUtil.shortWait();
		click(AuditManagement, "Audit Management");
		scrollToViewElement(AuditAreaChecklistMappingStatusAuditTrails);
		click(AuditAreaChecklistMappingStatusAuditTrails, "AuditArea Checklist Mapping AuditTrails");
		switchToBodyFrame(driver);

		// click(SubmitBtn, "SubmitBtn");
		click(AdvancedSearch, "Advanced Search");
		click(AuditAreaIssueCodeFilter, "Audit Area Issue Code Filter");
		enterUniqueCode(driver, AuditAreaIssueCodeFilter);
		click(UniqueCodeRecord, "UniqueCode Record");
		switchToPopupModelFrame(driver);

		click(AuditTrailsclose, "close pop");
		switchToDefaultContent(driver);
	}

}
