package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;
import com.Automation.Utils.TimeUtil;

public class Audit_Finding_Initiator extends ActionEngine {

	@FindBy(xpath = "//small[text()='IA']")
	WebElement InternalAudit;

	@FindBy(id = "MyTaskPrc_IA_IA_AUD_FND_FRM_ID_01")
	WebElement AuditFindingMyTask;

	@FindBy(id = "btnAdvSearch")
	WebElement AdvancedSearch;

	@FindBy(name = "AUD_LGN_CTF_003")
	WebElement IssueCodeFilter;

	@FindBy(id = "btnSubmitListFilter")
	WebElement ApplyButton;

	@FindBy(className = "text-ellipsis")
	WebElement Record;

	@FindBy(id = "btnSubmit_1")
	WebElement SubmitButton;

	@FindBy(id = "AUD_FND_CTF_08_error")
	WebElement AuditFinding_Error;

	@FindBy(id = "AUD_FND_CTF_08")
	WebElement AuditFinding;

	@FindBy(xpath = "//button[contains(text(),'Ok')]")
	WebElement OkButton;

	@FindBy(xpath = "//span[text()='Enter Value'][1]")
	WebElement TitleError;

	@FindBy(xpath = "//input[@class='caliber-textbox form-control aud-find-desc']")
	WebElement TitleBox;

	@FindBy(xpath = "//div[contains(@class, 'caliber-control-group')]/child::span[text()='Select Value'][1]")
	WebElement CategoryError;

	@FindBy(xpath = "//select[@class='aud-find-category caliber-selectdropdown select2-hidden-accessible']")
	WebElement CategorySelect;

	@FindBy(xpath = "//span[text()='Enter Value']")
	WebElement DescriptionError;

	@FindBy(xpath = "//div[@class='note-editable card-block']")
	WebElement DescriptionTextBox;

	@FindBy(xpath = "//div[@class='col-12 col-sm-3'][2]//button/following-sibling::span")
	WebElement AuditAreaError;

	@FindBy(xpath = "//div[@class='col-12 col-sm-3'][2]//button") // btn btn-popup
	WebElement AuditAreaAddItems;

	@FindBy(name = "UniqueCode")
	WebElement AuditAreaUniqueCode;

	@FindBy(xpath = "//button[contains(text(),'Add')][1]")
	WebElement AddButton;

	@FindBy(id = "btnOk")
	WebElement Add;

	@FindBy(xpath = "//input[@class='audit-trainee-required caliber-labeled-option']/following-sibling::label")
	WebElement CheckBox;

	@FindBy(xpath = "//span[text()='Select Value']")
	WebElement AllocatedError;

	@FindBy(xpath = "//input[@class='audit-trainee-required caliber-labeled-option']/following-sibling::button")
	WebElement AllocatedTo;

	@FindBy(xpath = "//button[text()='Ok']")
	WebElement OkBtn;

	@FindBy(xpath = "//input[@name='radiobtn']/following-sibling::label")
	WebElement RadioBtn;

	@FindBy(xpath = "//span[@class='confirmation_text']")
	WebElement UniqueCode;

	@FindBy(id = "cfnMsg_Next")
	WebElement Done;

	@FindBy(xpath = "//button[@class='caliber-button-secondary float-right margin-right-30']")
	WebElement CancelButton;
	// Audit Trails

	@FindBy(xpath = "//div[@class='event-div']")
	WebElement AuditFindingEvent;

	@FindBy(xpath = "//div[@class='left-menupanel']/div[5]")
	WebElement AuditManagement;

	@FindBy(id = "IAFN_04")
	WebElement AuditTrails;

	@FindBy(xpath = "//div[text()='Registration']")
	WebElement Revision0;

	@FindBy(xpath = "//span[text()='Revision No. 0 - Draft']")
	WebElement Revision1;

	@FindBy(id = "AuditEventModal_View")
	WebElement proceed;

	@FindBy(name = "AUD_LGN_CTF_003")
	WebElement issueCodeFilter;

	@FindBy(name = "AUD_FND_CTF_07")
	WebElement WorkItemIdFilter;

	@FindBy(xpath = "//span[@class='popup-close-button']")
	WebElement ClosePopUp;

	// Re-Initoation Audit Finding

	@FindBy(xpath = "//span[text()='Enter Value']")
	WebElement RemarksError;

	@FindBy(id = "txtRemarks")
	WebElement RemarksReason;

	// Again Re-instation

	@FindBy(xpath = "//i[@class='bs-icon-pencil-square list-filter-icons']")
	WebElement modification;

	@FindBy(xpath = "//i[@class='bs-icon-file-earmark list-filter-icons']")
	WebElement FindingSaveButton;

	@FindBy(xpath = "//span[@class='caliber-dropdown-caret']")
	WebElement FindingToggleButton;

	@FindBy(xpath = "//*[@class='bs-icon-plus-square-fill major-add dynamic-vc-add list-filter-icons']")
	WebElement FindingAddButton;

	public void auditFindingRegistaration(String title, String category, String desc, String auditareaUniquecode,
			String loginid, String coAuditor) {
		TimeUtil.shortWait();
		switchToBodyFrame(driver);
		scrollToViewElement(InternalAudit);
		click(InternalAudit, "InternalAudit");
		click(AuditFindingMyTask, "AuditFinding MyTask");
		switchToTaskListFrame(driver);
		click(AdvancedSearch, "Advanced Search");
		// click(IssueCodeFilter, "IssueCode Filter");

		enterUniqueCodeConcat(driver, issueCodeFilter);
		// sendText(issueCodeFilter, "IA-CTPL-IT-22-0035", "");
		click(ApplyButton, "Apply Button");
		click(Record, "Record");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(SubmitButton, "Submit Button");

		verifyCaptionContains(AuditFinding_Error, "Select Value");
		click(AuditFinding, "Audit Finding");
		switchToPopupModelFrame(driver);// PopupModalFrame
		click(OkButton, "Ok Button");

		verifyCaptionContains(TitleError, "Enter Value");
		sendText(TitleBox, title, "TitleBox");
		click(OkButton, "Ok Button");

		verifyCaptionContains(CategoryError, "Select Value");
		// sendText(CategorySelect, category, "Category");
		selectDropdownUsingVisisbleText(CategorySelect, category, "category");
		click(OkButton, "Ok Button");

		verifyCaptionContains(DescriptionError, "Enter Value");
		sendText(DescriptionTextBox, desc, "Description TextBox");
		click(OkButton, "Ok Button");
		scrollToViewElement(AuditAreaAddItems);
		verifyCaptionContains(AuditAreaError, "Select Value");
		// TimeUtil.shortWait();
		click(AuditAreaAddItems, "AuditArea AddItems");
		switchToPopupModelFrame(driver);
		click(AdvancedSearch, "Advanced Search");
		// click(AuditAreaUniqueCode, "AuditArea UniqueCode");
		sendText(AuditAreaUniqueCode, auditareaUniquecode, "AuditArea UniqueCode");
		click(ApplyButton, "Apply Button");
		click(AddButton, "Add Button");
		click(Add, "Ok Button");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		switchToPopupModelFrame(driver);
		click(CheckBox, "CheckBox");
		click(OkButton, "Ok Button");
		verifyCaptionContains(AllocatedError, "Select Value");
		click(AllocatedTo, "Allocatedto AddItems");
		switchToPopupModelFrame(driver);
		click(AdvancedSearch, "Advanced Search");
		sendText(AuditAreaUniqueCode, loginid, "AuditArea UniqueCode");
		click(ApplyButton, "Apply Button");
		click(RadioBtn, "Auditee Record");
		click(Add, "Ok Button");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		switchToPopupModelFrame(driver);
		// click(CancelButton, "Cancel button");
		click(OkButton, "Ok Button");
		switchToParentFrame(driver);
		// auditFindingCoAuditorSelection.auditFindingCoAuditor(coAuditor);
		click(SubmitButton, "Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPUserPwd"));
		// saveUniqueCode(driver, UniqueCode);
		click(Done, "Done");
		switchToDefaultContent(driver);
	}

	public void auditFindindAuditTrails() {

		TimeUtil.shortWait();
		click(AuditManagement, "Audit Management");
		scrollToViewElement(AuditTrails);
		click(AuditTrails, "Audit Trails");
		switchToBodyFrame(driver);
		click(AdvancedSearch, "Advanced Search");
		enterUniqueCodeConcat(driver, issueCodeFilter);
		click(ApplyButton, "Apply Button");
		click(Record, "Record");
		switchToPopupModelFrame(driver);
//		click(Revision0, "Revision 0");
//		click(Revision1, "Revision 1");
//		click(proceed, "proceed");
		click(ClosePopUp, "Close PopUp");
		switchToDefaultContent(driver);
	}

	public void AuditFindingReInitiate(String desc, String Remarks) {

		TimeUtil.shortWait();
		switchToBodyFrame(driver);
		scrollToViewElement(InternalAudit);
		click(InternalAudit, "InternalAudit");
		click(AuditFindingMyTask, "Internal Audit MyTask");
		switchToTaskListFrame(driver);
		click(AdvancedSearch, "Advanced Search");
		// click(IssueCodeFilter, "IssueCode Filter");
		enterUniqueCodeConcat(driver, issueCodeFilter);
		click(ApplyButton, "Apply Button");
		click(Record, "Record");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		// click(SubmitButton, "Submit Button");
		click(AuditFinding, "Audit Finding");
		switchToPopupModelFrame(driver);
		click(modification, "modification");
		clearField(DescriptionTextBox, "modification");
		sendText(DescriptionTextBox, desc, "modification");
		click(OkButton, "Ok Button");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(SubmitButton, "Submit Button");
		verifyCaptionContains(RemarksError, "Remarks Error");
		sendText(RemarksReason, Remarks, "Remarks Error");
		click(SubmitButton, "Submit Button");

		E_sign.e_Sign(ConfigsReader.getPropValue("SPUserPwd"));
		// saveUniqueCode(driver, UniqueCode);
		click(Done, "Done");
		switchToDefaultContent(driver);
	}

	public void auditFindindReAuditTrails() {

		TimeUtil.shortWait();
		click(AuditManagement, "Audit Management");
		scrollToViewElement(AuditTrails);
		click(AuditTrails, "Audit Trails");
		switchToBodyFrame(driver);
		click(AdvancedSearch, "Advanced Search");
		enterUniqueCodeConcat(driver, issueCodeFilter);
		click(ApplyButton, "Apply Button");
		click(Record, "Record");
		switchToPopupModelFrame(driver);
		click(Revision0, "Revision 0");
		click(Revision1, "Revision 1");
		click(proceed, "proceed");
		scrollToViewElement(AuditFindingEvent);
		click(ClosePopUp, "Close PopUp");
		switchToDefaultContent(driver);
	}

	public void AuditFindingAgainReInitiate(String description, String Remarks) {

		TimeUtil.shortWait();
		switchToBodyFrame(driver);
		scrollToViewElement(InternalAudit);
		click(InternalAudit, "InternalAudit");
		click(AuditFindingMyTask, "Internal Audit MyTask");
		switchToTaskListFrame(driver);
		click(AdvancedSearch, "Advanced Search");
		// click(IssueCodeFilter, "IssueCode Filter");
		enterUniqueCode(driver, issueCodeFilter);
		click(ApplyButton, "Apply Button");
		click(Record, "Record");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		// click(SubmitButton, "Submit Button");
		click(AuditFinding, "Audit Finding");
		switchToPopupModelFrame(driver);
		click(modification, "modification");
		clearField(DescriptionTextBox, "modification");
		sendText(DescriptionTextBox, description, "modification");
		click(OkButton, "Ok Button");

		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(SubmitButton, "Submit Button");
		verifyCaptionContains(RemarksError, "Remarks Error");
		sendText(RemarksReason, Remarks, "Remarks Error");
		click(SubmitButton, "Submit Button");

		E_sign.e_Sign(ConfigsReader.getPropValue("SPUserPwd"));
		// saveUniqueCode(driver, UniqueCode);
		click(Done, "Done");
		switchToDefaultContent(driver);
	}

	public void AuditFinding2AgainReInitiate(String description, String Remarks) {

		TimeUtil.shortWait();
		switchToBodyFrame(driver);
		scrollToViewElement(InternalAudit);
		click(InternalAudit, "InternalAudit");
		click(AuditFindingMyTask, "Internal Audit MyTask");
		switchToTaskListFrame(driver);
		click(AdvancedSearch, "Advanced Search");
		// click(IssueCodeFilter, "IssueCode Filter");
		enterUniqueCodeConcat(driver, issueCodeFilter);
		click(ApplyButton, "Apply Button");
		click(Record, "Record");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		// click(SubmitButton, "Submit Button");
		click(AuditFinding, "Audit Finding");
		switchToPopupModelFrame(driver);
		click(modification, "modification");
		clearField(DescriptionTextBox, "modification");
		sendText(DescriptionTextBox, description, "modification");
		click(OkButton, "Ok Button");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(SubmitButton, "Submit Button");
		verifyCaptionContains(RemarksError, "Remarks Error");
		sendText(RemarksReason, Remarks, "Remarks Error");
		click(SubmitButton, "Submit Button");

		E_sign.e_Sign(ConfigsReader.getPropValue("SPUserPwd"));
		// saveUniqueCode(driver, UniqueCode);
		click(Done, "Done");
		switchToDefaultContent(driver);
	}

	public void auditFindingRegistarationWith100Findings(String title, String category, String desc,
			String auditareaUniquecode, String loginid) {
		TimeUtil.shortWait();
		switchToBodyFrame(driver);
		scrollToViewElement(InternalAudit);
		click(InternalAudit, "InternalAudit");
		click(AuditFindingMyTask, "AuditFinding MyTask");
		switchToTaskListFrame(driver);
		click(AdvancedSearch, "Advanced Search");
		// click(IssueCodeFilter, "IssueCode Filter");
		enterUniqueCodeConcat(driver, issueCodeFilter);
		sendText(issueCodeFilter, "IA-CTPL-IT-22-0046", "");
		click(ApplyButton, "Apply Button");
		click(Record, "Record");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(SubmitButton, "Submit Button");

		verifyCaptionContains(AuditFinding_Error, "Select Value");
		click(AuditFinding, "Audit Finding");

		switchToPopupModelFrame(driver);

		// Audit finding popup
		for (int i = 1; i <= 100; i++) {

			// PopupModalFrame

			sendText(TitleBox, title + i, "TitleBox");

			selectDropdownUsingVisisbleText(CategorySelect, category, "category");

			sendText(DescriptionTextBox, desc + i, "Description TextBox");
			scrollToViewElement(AuditAreaAddItems);
			// TimeUtil.shortWait();
			click(AuditAreaAddItems, "AuditArea AddItems");
			switchToPopupModelFrame(driver);
			click(AdvancedSearch, "Advanced Search");
			// click(AuditAreaUniqueCode, "AuditArea UniqueCode");
			sendText(AuditAreaUniqueCode, auditareaUniquecode, "AuditArea UniqueCode");
			click(ApplyButton, "Apply Button");
			click(AddButton, "Add Button");
			click(Add, "Ok Button");
			switchToDefaultContent(driver);
			switchToBodyFrame(driver);
			switchToPopupModelFrame(driver);
			click(CheckBox, "CheckBox");
			click(AllocatedTo, "Allocatedto AddItems");
			switchToPopupModelFrame(driver);
			click(AdvancedSearch, "Advanced Search");
			sendText(AuditAreaUniqueCode, loginid, "AuditArea UniqueCode");
			click(ApplyButton, "Apply Button");
			click(RadioBtn, "Auditee Record");
			click(Add, "Ok Button");

			switchToDefaultContent(driver);
			switchToBodyFrame(driver);
			switchToPopupModelFrame(driver);
			click(FindingSaveButton, "Finding SaveButton");
			click(FindingToggleButton, "Finding toggle button");
			click(FindingAddButton, "Finding Add Button");
			TimeUtil.shortWait();

		}
		// click(CancelButton, "Cancel button");
		click(OkButton, "Ok Button");

		// switch to body frame
		switchToParentFrame(driver);
		// auditFindingCoAuditorSelection.auditFindingCoAuditor(coAuditor);
		click(SubmitButton, "Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPUserPwd"));
		// saveUniqueCode(driver, UniqueCode);
		click(Done, "Done");
		switchToDefaultContent(driver);
	}

}
