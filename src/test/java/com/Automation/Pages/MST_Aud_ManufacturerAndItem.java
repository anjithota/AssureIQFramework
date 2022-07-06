package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;
import com.Automation.Utils.TimeUtil;

public class MST_Aud_ManufacturerAndItem extends ActionEngine {

	@FindBy(xpath = "//div[@class='left-menupanel']/div[5]")
	WebElement AuditManagement;

	// Registaration

	@FindBy(id = "MID_01")
	WebElement ManufacturerAndItemRegistaration;

	@FindBy(id = "btnAdvSearch")
	WebElement AdvancedSearch;

	@FindBy(xpath = "//input[@class='date-range-control form-control date-range-control-from']")
	WebElement DateOfYear;

	@FindBy(id = "btnSubmitListFilter")
	WebElement ApplyButton;

	@FindBy(className = "text-ellipsis")
	WebElement UniqueCodeRecord;

	@FindBy(id = "btnSubmit_1")
	WebElement SubmitBtn;

	@FindBy(id = "MST_MID_CTR_003_error")
	WebElement ItemError;

	@FindBy(id = "MST_MID_CTR_003_button")
	WebElement AddItems;

	@FindBy(name = "MST_PRD_CTF_001")
	WebElement IssueCodeFilter;

	@FindBy(xpath = "//button[@class='btn notselected btn-sm btnAddRemoveBtn']")
	WebElement AddButton;

	@FindBy(id = "btnOk")
	WebElement Addbutton;

	@FindBy(xpath = "//span[@class='confirmation_text']")
	WebElement UniqueCode;

	@FindBy(id = "cfnMsg_Next")
	WebElement Done;

	// Modification

	@FindBy(id = "MID_02")
	WebElement ManufacturerAndItemModification;

	@FindBy(name = "MST_MID_CTR_002")
	WebElement IssuefilterCode;

	@FindBy(xpath = "//span[text()='Enter Value']")
	WebElement Remarks_Error;

	@FindBy(id = "txtRemarks")
	WebElement Remarks;

	// Status Change gv648LS

	@FindBy(id = "MID_03")
	WebElement ManufacturerAndItemStatusChange;

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

	// Audit Trails
	@FindBy(id = "MID_04")
	WebElement ManufacturerAndItemAuditTrails;

	@FindBy(xpath = "//span[@class='popup-close-button']")
	WebElement AuditTrailsclose;

	public void manufacturerAndItemRegistaration(String date, String itemListRecord) {

		click(AuditManagement, "Audit Management");
		TimeUtil.shortWait();
		scrollToViewElement(ManufacturerAndItemRegistaration);
		click(ManufacturerAndItemRegistaration, "Manufacturer And Item Registaration");
		switchToBodyFrame(driver);
		click(AdvancedSearch, "Advanced Search");
		click(DateOfYear, "Date of Year Change");
		clearField(DateOfYear, "Date of Year Change");
		sendText(DateOfYear, date, "21 May 2020");
		click(ApplyButton, "Apply Button");
		click(UniqueCodeRecord, "UniqueCode Record");
		click(SubmitBtn, "Submit Button");

		verifyCaptionContains(ItemError, "Select Value");
		click(AddItems, "Add Item");
		switchToPopupModelFrame(driver);
		click(AdvancedSearch, "Advanced Search");
		click(IssueCodeFilter, "IssueCode Filter");
		sendText(IssueCodeFilter, itemListRecord, "IssueCodeFilter");
		click(ApplyButton, "Apply Button");

		click(AddButton, "Add Button");

		click(Addbutton, "Add Button");
		switchToParentFrame(driver);
		click(SubmitBtn, "Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, UniqueCode);
		click(Done, "Done poup");
		switchToDefaultContent(driver);
	}

	public void manufacturerAndItemModification(String name, String remarksReason) {
		click(AuditManagement, "Audit Management");
		TimeUtil.shortWait();
		scrollToViewElement(ManufacturerAndItemModification);
		click(ManufacturerAndItemModification, "Manufacturer And Item Modification");
		switchToBodyFrame(driver);
		click(AdvancedSearch, "Advanced Search");
		click(IssuefilterCode, "IssuefilterCode");
		enterUniqueCode(driver, IssuefilterCode);
		click(UniqueCodeRecord, "UniqueCode Record");
		click(SubmitBtn, "Submit Button");
		click(AddItems, "Add Item");
		switchToPopupModelFrame(driver);
		click(AdvancedSearch, "Advanced Search");
		click(IssueCodeFilter, "IssueCode Filter");
		sendText(IssueCodeFilter, name, "IssueCodeFilter");
		click(ApplyButton, "Apply Button");

		click(AddButton, "Add Button");

		click(Addbutton, "Add Button");
		switchToParentFrame(driver);

		verifyCaptionContains(Remarks_Error, "Enter Value");
		sendText(Remarks, remarksReason, "Remarks Reason");
		click(SubmitBtn, "SubitBtn");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, UniqueCode);
		click(Done, "Done poup");
		switchToDefaultContent(driver);

	}

	public void manufacturerAndItemStatusChangeInActive(String remarksReason) {

		click(AuditManagement, "Audit Management");
		TimeUtil.shortWait();
		scrollToViewElement(ManufacturerAndItemStatusChange);
		click(ManufacturerAndItemStatusChange, "Manufacturer And Item StatusChange");
		switchToBodyFrame(driver);
		click(AdvancedSearch, "Advanced Search");
		click(IssuefilterCode, "IssuefilterCode");
		enterUniqueCode(driver, IssuefilterCode);
		click(UniqueCodeRecord, "UniqueCode Record");
		click(SubmitBtn, "Submit Button");

		verifyCaptionContains(ProposedStatusError, "Select Value");
		click(Inactive, "In Active");
		sendText(Remarks, remarksReason, "Remarks Reason");
		click(SubmitBtn, "SubitBtn");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, UniqueCode);
		click(Done, "Done poup");
		switchToDefaultContent(driver);
	}

	public void manufacturerAndItemStatusChangeActive(String remarksReason) {

		click(AuditManagement, "Audit Management");
		TimeUtil.shortWait();
		scrollToViewElement(ManufacturerAndItemStatusChange);
		click(ManufacturerAndItemStatusChange, "Manufacture And Item StatusChange");
		switchToBodyFrame(driver);
		click(AdvancedSearch, "Advanced Search");
		click(IssuefilterCode, "IssuefilterCode");
		enterUniqueCode(driver, IssuefilterCode);
		click(UniqueCodeRecord, "UniqueCode Record");
		click(SubmitBtn, "Submit Button");

		verifyCaptionContains(ProposedStatusError, "Select Value");
		click(Active, "Active");
		sendText(Remarks, remarksReason, "Remarks Reason");
		click(SubmitBtn, "SubitBtn");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, UniqueCode);
		click(Done, "Done poup");
		switchToDefaultContent(driver);
	}

	public void manufacturerAndItemStatusChangePermanetInActive(String remarksReason) {

		click(AuditManagement, "Audit Management");
		TimeUtil.shortWait();
		scrollToViewElement(ManufacturerAndItemStatusChange);
		click(ManufacturerAndItemStatusChange, "Manufacturer And Item StatusChange");
		switchToBodyFrame(driver);
		click(AdvancedSearch, "Advanced Search");
		click(IssuefilterCode, "Issue filterCode");
		enterUniqueCode(driver, IssuefilterCode);
		click(UniqueCodeRecord, "UniqueCode Record");
		click(SubmitBtn, "Submit Button");

		verifyCaptionContains(ProposedStatusError, "Select Value");
		click(PermanetInActive, "Permanet InActive");
		click(PermanetInActiveYes, "Permanet InActiveYes");
		sendText(Remarks, remarksReason, "Remarks Reason");
		click(SubmitBtn, "SubitBtn");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, UniqueCode);
		click(Done, "Done poup");
		switchToDefaultContent(driver);
	}

	public void manufacturerAndItemAuditTrails() {
		click(AuditManagement, "Audit Management");
		TimeUtil.shortWait();
		scrollToViewElement(ManufacturerAndItemAuditTrails);
		click(ManufacturerAndItemAuditTrails, "Manufacturer And Item AuditTrails");
		switchToBodyFrame(driver);
		click(AdvancedSearch, "Advanced Search");
		click(IssuefilterCode, "Issue filterCode");
		enterUniqueCode(driver, IssuefilterCode);
		click(UniqueCodeRecord, "UniqueCode Record");
		click(SubmitBtn, "Submit Button");
		switchToPopupModelFrame(driver);
		click(AuditTrailsclose, "close pop");
		switchToDefaultContent(driver);

	}

}
