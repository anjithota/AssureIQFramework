package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;
import com.Automation.Utils.TimeUtil;

public class Audit_Finding_Responce_Initiator extends ActionEngine {

	@FindBy(xpath = "//small[text()='IA']")
	WebElement InternalAudit;

	@FindBy(id = "MyTaskPrc_IA_IA_AUD_AR_FRM_ID_01")
	WebElement AuditResponceMyTask;

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

	@FindBy(id = "AUD_AR_CTF_032_error")
	WebElement AuditResponceError;

	@FindBy(xpath = "//div[@class='note-editable card-block']")
	WebElement AuditResponce;

	@FindBy(id = "AUD_AR_CTF_004_error")
	WebElement CorrectiveActionPlanError;

	@FindBy(xpath = "//label[@for='AUD_AR_CTF_004_1']")
	WebElement CorrectiveActionYes;
	
	@FindBy(xpath = "//label[@for='AUD_AR_CTF_004_2']")
	WebElement CorrectiveActionNO;

	@FindBy(id = "AUD_AR_CTF_005_error")
	WebElement ProposedCorrectiveError;

	// No Action Plan In Audit Finding

	@FindBy(id = "AUD_AR_CTF_006_error")
	WebElement PreventiveActionPlanError;

	@FindBy(xpath = "//label[@for='AUD_AR_CTF_006_2']")
	WebElement PreventiveActionPlanNo;

	@FindBy(id = "AUD_AR_CTF_008_error")
	WebElement OtherActionPlanError;

	@FindBy(xpath = "//label[@for='AUD_AR_CTF_008_2']")
	WebElement OtherActionPlanNo;
	
	@FindBy(id="AUD_AR_CTF_005_error")
	WebElement ProposedCorrectiveActionPlanError;
	///-----real above--------------///
	
	
	@FindBy(id="AUD_AR_CTF_005")
	WebElement ProposedCorrectiveActionPlan;
	

	// ---------- Re-Initiator------------//

	@FindBy(xpath = "//span[text()='Enter Value']")
	WebElement RemarksReasonError;

	@FindBy(id = "txtRemarks")
	WebElement RemarksReason;

	// Audit Finding AuditTrails

	@FindBy(xpath = "//div[@class='left-menupanel']/div[5]")
	WebElement AuditManagementMenu;

	@FindBy(id = "IAAR_04")
	WebElement AuditResponceAuditTrails;

	@FindBy(xpath = "//span[@class='popup-close-button']")
	WebElement ClosePopUp;
	
	@FindBy(xpath = "//div[@class='event-div']")
	WebElement EventScroll;

	@FindBy(xpath = "//div[text()='Registration']")
	WebElement Revision0;

	@FindBy(xpath = "//span[text()='Revision No. 0 - Draft']")
	WebElement Revision1;

	@FindBy(id = "AuditEventModal_View")
	WebElement proceed;
	
	@FindBy(xpath = "//div[@class='event-div']")
	WebElement AuditResponceEvent;
	
	@FindBy(id="AUD_AR_CTF_004_error")
	WebElement CorrectiveActionError;
	
	@FindBy(xpath = "//a[@class='caliber-button-secondary d-inline-block']")
	WebElement DoneButton;
	
	

	public void auditFindingResponceInitiatior(String responce, String description, String departmentCode,
			String department) {

		TimeUtil.shortWait();
		switchToBodyFrame(driver);
		scrollToViewElement(InternalAudit);
		click(InternalAudit, "Internal Audit");
		click(AuditResponceMyTask, "AuditResponce MyTask");
		switchToTaskListFrame(driver);
		click(AdvancedSearch, "Advanced Search");
		enterUniqueCodeConcat(driver, IssueCodeFilter);
		click(ApplyButton, "Apply Button");
		click(Record, "Record");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(SubmitButton, "Submit Button");

		verifyCaptionContains(AuditResponceError, "Enter Value");
		sendText(AuditResponce, responce, "AuditResponce");
		click(SubmitButton, "Submit Button");
		verifyCaptionContains(CorrectiveActionError, "Select value");
		click(CorrectiveActionYes, "yes");
		click(SubmitButton, "submit");
		verifyCaptionContains(ProposedCorrectiveActionPlanError,"Select Value");
		click(ProposedCorrectiveActionPlan, "Proposed Corrective ActionPlan");
	//	auditFindingResponceActionPlan.audit_Finding_Responce_ActionPlan(description, departmentCode, department);

		verifyCaptionContains(PreventiveActionPlanError, "Select Value");
		click(PreventiveActionPlanNo, "Preventive ActionPlan No");
		click(SubmitButton, "Submit Button");

		verifyCaptionContains(OtherActionPlanError, "Select Value");
		click(OtherActionPlanNo, "Other Action No");
		click(SubmitButton, "Submit Button");

		E_sign.e_Sign(ConfigsReader.getPropValue("SPnewPWD"));
		// saveUniqueCode(driver, UniqueCode);
		// click(Done, "Done");
		switchToDefaultContent(driver);
	}

	

	public void auditFindingResponceInitiatiorWithOutActionPlan(String responce, String description, String departmentCode,
			String department) {

		TimeUtil.shortWait();
		switchToBodyFrame(driver);
		scrollToViewElement(InternalAudit);
		click(InternalAudit, "Internal Audit");
		click(AuditResponceMyTask, "AuditResponce MyTask");
		switchToTaskListFrame(driver);
		click(AdvancedSearch, "Advanced Search");
		enterUniqueCodeConcat(driver, IssueCodeFilter);
		click(ApplyButton, "Apply Button");
		click(Record, "Record");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(SubmitButton, "Submit Button");

		verifyCaptionContains(AuditResponceError, "Enter Value");
		sendText(AuditResponce, responce, "AuditResponce");
		click(SubmitButton, "Submit Button");
		verifyCaptionContains(CorrectiveActionError, "Select value");
		click(CorrectiveActionNO, "No");
		click(SubmitButton, "submit");

		verifyCaptionContains(PreventiveActionPlanError, "Select Value");
		click(PreventiveActionPlanNo, "Preventive ActionPlan No");
		click(SubmitButton, "Submit Button");

		verifyCaptionContains(OtherActionPlanError, "Select Value");
		click(OtherActionPlanNo, "Other Action No");
		click(SubmitButton, "Submit Button");

		E_sign.e_Sign(ConfigsReader.getPropValue("SPnewPWD"));
		// saveUniqueCode(driver, UniqueCode);
		// click(Done, "Done");
		switchToDefaultContent(driver);
	}

	public void auditResponceAuditTrails() {
		TimeUtil.shortWait();
		//switchToDefaultContent(driver);
		click(AuditManagementMenu, " Audit Management Menu");
		scrollToViewElement(AuditResponceAuditTrails);
		click(AuditResponceAuditTrails, "Audit Responce AuditTrails");
		switchToBodyFrame(driver);
		click(AdvancedSearch, "Advanced Search");
		
		enterUniqueCodeConcat(driver, IssueCodeFilter);
		click(ApplyButton, "Apply Button");
		click(Record, "Record");
		switchToPopupModelFrame(driver);
//		click(Revision0, "Revision 0");
//		click(Revision1, "Revision 1");
//		click(proceed, "proceed");
		click(ClosePopUp, "Close PopUp");
		switchToDefaultContent(driver);

	}

	public void auditFindingResponceReInitiatior(String responce, String remarks) {

		// TimeUtil.shortWait();
		// click(SubmitButton, "Submit Button");
		TimeUtil.shortWait();
		switchToBodyFrame(driver);
		scrollToViewElement(InternalAudit);
		click(InternalAudit, "Internal Audit");
		click(AuditResponceMyTask, "AuditResponce MyTask");
		switchToTaskListFrame(driver);
		click(AdvancedSearch, "Advanced Search");
		enterUniqueCodeConcat(driver, IssueCodeFilter);
		click(ApplyButton, "Apply Button");
		click(Record, "Record");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		//click(SubmitButton, "Submit Button");

		// verifyCaptionContains(AuditResponceError, "Enter Value");
		//clearField(AuditResponce, "Audit Responce");
		sendText(AuditResponce, responce, "AuditResponce");
		click(SubmitButton, "Submit Button");

		verifyCaptionContains(RemarksReasonError, "Enter Value");
		sendText(RemarksReason, remarks, "Remarks Reason");
		click(SubmitButton, "Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPnewPWD"));
		switchToDefaultContent(driver);
	}

	public void auditResponceReAuditTrails() {
		switchToDefaultContent(driver);
		TimeUtil.shortWait();
		click(AuditManagementMenu, " Audit Management Menu");
		scrollToViewElement(AuditResponceAuditTrails);
		click(AuditResponceAuditTrails, "Audit Responce AuditTrails");
		switchToBodyFrame(driver);
		click(AdvancedSearch, "Advanced Search");
		enterUniqueCodeConcat(driver, IssueCodeFilter);
		click(ApplyButton, "Apply Button");
		click(Record, "Record");
		switchToPopupModelFrame(driver);
		click(Revision0, "Revision 0");
		click(Revision1, "Revision 1");
		click(proceed, "proceed");
		//scrollToViewElement(AuditResponceEvent);
		scrollToViewElement(EventScroll);
		click(ClosePopUp, "Close PopUp");
		switchToDefaultContent(driver);

	}

	public void auditFindingResponceAgainReInitiatior(String responce, String remarks) {

		// TimeUtil.shortWait();
		// click(SubmitButton, "Submit Button");
		TimeUtil.shortWait();
		switchToBodyFrame(driver);
		scrollToViewElement(InternalAudit);
		click(InternalAudit, "Internal Audit");
		click(AuditResponceMyTask, "AuditResponce MyTask");
		switchToTaskListFrame(driver);
		click(AdvancedSearch, "Advanced Search");
		enterUniqueCodeConcat(driver, IssueCodeFilter);
		click(ApplyButton, "Apply Button");
		click(Record, "Record");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		///click(SubmitButton, "Submit Button");

		// verifyCaptionContains(AuditResponceError, "Enter Value");
		//clearField(AuditResponce, "Audit Responce");
		sendText(AuditResponce, responce, "AuditResponce");
		click(SubmitButton, "Submit Button");

		verifyCaptionContains(RemarksReasonError, "Enter Value");
		sendText(RemarksReason, remarks, "Remarks Reason");
		click(SubmitButton, "Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPnewPWD"));
		switchToDefaultContent(driver);
	}

	public void auditFindingResponceAgain2ReInitiatior(String responce, String remarks) {

		// TimeUtil.shortWait();
		// click(SubmitButton, "Submit Button");
		TimeUtil.shortWait();
		switchToBodyFrame(driver);
		scrollToViewElement(InternalAudit);
		click(InternalAudit, "Internal Audit");
		click(AuditResponceMyTask, "AuditResponce MyTask");
		switchToTaskListFrame(driver);
		click(AdvancedSearch, "Advanced Search");
		enterUniqueCodeConcat(driver, IssueCodeFilter);
		click(ApplyButton, "Apply Button");
		click(Record, "Record");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		//click(SubmitButton, "Submit Button");

		// verifyCaptionContains(AuditResponceError, "Enter Value");
		//clearField(AuditResponce, "Audit Responce");
		sendText(AuditResponce, responce, "AuditResponce");
		click(SubmitButton, "Submit Button");

		verifyCaptionContains(RemarksReasonError, "Enter Value");
		sendText(RemarksReason, remarks, "Remarks Reason");
		click(SubmitButton, "Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPnewPWD"));
		switchToDefaultContent(driver);
	}
	
	public void auditFindingResponceInitiatior100(String responce) {

		TimeUtil.shortWait();
		switchToBodyFrame(driver);
		scrollToViewElement(InternalAudit);
		click(InternalAudit, "Internal Audit");
		
		for (int i = 1; i < 100; i++) {
		
			scrollToViewElement(AuditResponceMyTask);
			click(AuditResponceMyTask, "AuditResponce MyTask");
		switchToTaskListFrame(driver);
		click(AdvancedSearch, "Advanced Search");
		enterUniqueCodeConcat(driver, IssueCodeFilter);
		click(ApplyButton, "Apply Button");
		click(Record, "Record");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		click(SubmitButton, "Submit Button");

		sendText(AuditResponce, responce+i, "AuditResponce");
		click(CorrectiveActionNO, "No");

		click(PreventiveActionPlanNo, "Preventive ActionPlan No");

		click(OtherActionPlanNo, "Other Action No");
		click(SubmitButton, "Submit Button");

		E_sign.e_Sign(ConfigsReader.getPropValue("SPuser2p"));
		// saveUniqueCode(driver, UniqueCode);
		click(DoneButton, "Done");
	//	switchToDefaultContent(driver);
		}
		switchToDefaultContent(driver);
	}

}
