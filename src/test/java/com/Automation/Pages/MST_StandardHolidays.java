package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;
import com.Automation.Utils.TimeUtil;

public class MST_StandardHolidays extends ActionEngine {

	@FindBy(xpath = "//div[@class='left-menupanel']/div[2]")
	WebElement MasterMenu;

	@FindBy(id = "CAL2_02")
	WebElement StandardHolidaysModification;

	@FindBy(id = "btnAdvSearch")
	WebElement AdvancedSearch;

	@FindBy(name = "MST_CAL_CTF_001")
	WebElement IssueCodeFilter;

	@FindBy(xpath = "//button[text()='Apply']")
	WebElement ApplyButton;
  
	@FindBy(className = "text-ellipsis")
	WebElement Record;

	@FindBy(id = "btnSubmit_1")
	WebElement SubmitBtn;

	@FindBy(xpath = "//i[@class='dynamic-vc-remove dynamic-vc-remove-icon']")
	WebElement RemoveButton;

	@FindBy(xpath = "//i[@class='dynamic-vc-add dynamic-vc-add-icon']")
	WebElement AddButton;

	@FindBy(xpath = "//select[@class='caliber-selectdropdown form-control reoccuring-date select2-hidden-accessible']")
	WebElement DateDropdown;

	@FindBy(xpath = "//select[@class='caliber-selectdropdown form-control reoccuring-month select2-hidden-accessible']")
	WebElement MonthDropDown;

	@FindBy(xpath = "//input[@class='caliber-textbox form-control reoccuring-desc']")
	WebElement Description;

	@FindBy(xpath = "//span[text()='Enter Value']")
	WebElement Remarks_Error;

	@FindBy(id = "txtRemarks")
	WebElement Remarks;

	@FindBy(xpath = "//span[@class='confirmation_text']")
	WebElement UniqueCodePopUp;

	@FindBy(id = "cfnMsg_Next")
	WebElement Done;
	
	//@FindBy(xpath)

	// Audit Trails

	@FindBy(id = "CAL2_04")
	WebElement StandardHolidaysAuditTrails;

	@FindBy(xpath = "//span[@class='popup-close-button']")
	WebElement AuditTrailsclose;


	

	public void standardHolidaysModification(String UniqueCode, String Date, String month, String desc,
			String remarksReason) {
		click(MasterMenu, "Master Menu");
		TimeUtil.shortWait();
		scrollToViewElement(StandardHolidaysModification);
		click(StandardHolidaysModification, "StandardHolidaysModification");
		switchToBodyFrame(driver);
		click(AdvancedSearch, "AdvancedSearch");
		click(IssueCodeFilter, "IssueCodeFilter");
		sendText(IssueCodeFilter, UniqueCode, "IssueCodeFilter");
		click(ApplyButton, "Apply Button");
		click(Record, "Record");
		click(SubmitBtn, "Submit Button");
		click(RemoveButton, "Remove Button");
		click(AddButton, "Add Button");
		selectDropdownUsingVisisbleText(DateDropdown, Date, "DateDropdown");
		click(SubmitBtn, "Submit Button");
		selectDropdownUsingVisisbleText(MonthDropDown, month, "MonthDropDown");
		click(SubmitBtn, "Submit Button");
		sendText(Description, desc, "Description");
		click(SubmitBtn, "Submit Button");
		verifyCaptionContains(Remarks_Error, "Enter Value");
		sendText(Remarks, remarksReason, "Remarks Reason");
		click(SubmitBtn, "Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, UniqueCodePopUp);
		click(Done, "Done poup");
		switchToDefaultContent(driver);

	}

	public void standardHolidaysAuditTrails() {
		click(MasterMenu, "Master Menu");
		TimeUtil.shortWait();
		scrollToViewElement(StandardHolidaysAuditTrails);
		click(StandardHolidaysAuditTrails, "StandardHolidaysAuditTrails");
		switchToBodyFrame(driver);
		click(AdvancedSearch, "AdvancedSearch");
		click(IssueCodeFilter, "IssueCodeFilter");
		enterUniqueCode(driver, IssueCodeFilter);
		click(Record, "Record");
		switchToPopupModelFrame(driver);
		click(AuditTrailsclose, "close pop");
		switchToDefaultContent(driver);

	}

	public void standardHolidaysAuditTrailsModifiction() {
		click(MasterMenu, "Master Menu");
		TimeUtil.shortWait();
		scrollToViewElement(StandardHolidaysAuditTrails);
		click(StandardHolidaysAuditTrails, "StandardHolidaysAuditTrails");
		switchToBodyFrame(driver);
		click(AdvancedSearch, "AdvancedSearch");
		click(IssueCodeFilter, "IssueCodeFilter");
		enterUniqueCode(driver, IssueCodeFilter);
		click(Record, "Record");
		switchToPopupModelFrame(driver);
		click(AuditTrailsclose, "close pop");
		switchToDefaultContent(driver);

	}
}
