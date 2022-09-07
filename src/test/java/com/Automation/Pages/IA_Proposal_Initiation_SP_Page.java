package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;
import com.Automation.Utils.TimeUtil;

public class IA_Proposal_Initiation_SP_Page extends ActionEngine {
	@FindBy(id = "btnCreate")
	WebElement initiate;

	@FindBy(id = "btnProcessLogin")
	WebElement processLogin;

	@FindBy(id = "btnSubmit")
	WebElement proceedButton;

	@FindBy(xpath = "//label[@for='item_IA']")
	WebElement InternalAuditIcon;

	@FindBy(id = "btnSubmit_1")
	WebElement SubmitButton;

	@FindBy(id = "AUD_LGN_CTF_006")
	WebElement DepartmentAddButton;

	@FindBy(id = "AUD_LGN_CTF_006_error")
	WebElement DepartmentFieldError;

	@FindBy(id = "btnAdvSearch")
	WebElement PopupSearchButton;

	@FindBy(id = "btnOk")
	WebElement popupOkButton;

	@FindBy(className = "toast-message")
	WebElement AlertMessage;

	@FindBy(className = "toast-close-button")
	WebElement AlertCloseButton;

	@FindBy(name = "MST_DEP_CTF_002")
	WebElement DepartmentCodeFilter;

	@FindBy(id = "btnSubmitListFilter")
	WebElement PopupApplyButton;

	@FindBy(className = "caliber-labeled-option")
	WebElement DepartmentRadioButton;

	@FindBy(id = "AUD_LGN_CTF_001_error")
	WebElement AuditPlanError;

	@FindBy(xpath = "//label[@for='AUD_LGN_CTF_001_1']")
	WebElement AuditPlanScheduled;

	@FindBy(id = "AUD_LGN_CTF_002_error")
	WebElement ScheduleReferenceError;

	@FindBy(id = "AUD_LGN_CTF_002")
	WebElement ScheduleReferenceButton;

	@FindBy(xpath = "//input[@name='UniqueCode']")
	WebElement AuditCodesearchfilterText;

	@FindBy(className = "caliber-labeled-option")
	WebElement AuditCodeRadioButton;

	@FindBy(id = "AUD_LGN_CTF_004_error")
	WebElement DescriptionError;

	@FindBy(id = "AUD_LGN_CTF_004")
	WebElement Description;

	@FindBy(id = "AUD_LGN_CTF_021_error")
	WebElement StartDateError;

	@FindBy(id = "AUD_LGN_CTF_021")
	WebElement StartDate;

	@FindBy(id = "AUD_LGN_CTF_022_error")
	WebElement EndDateError;

	@FindBy(id = "AUD_LGN_CTF_022")
	WebElement EndDate;

	@FindBy(id = "AUD_LGN_CTF_023_error")
	WebElement LeadAuditorError;

	@FindBy(id = "AUD_LGN_CTF_023")
	WebElement LeadAuditorButton;

	@FindBy(name = "UniqueCode")
	WebElement LoginIDFilter;
	
	@FindBy(className = "caliber-labeled-option")
	WebElement UserRadioButton;
	
	@FindBy(id = "AUD_LGN_CTF_024_error")
	WebElement AuditorError;
	
	@FindBy(id = "AUD_LGN_CTF_024")
	WebElement AuditorButton;
	
	@FindBy(xpath = "//button[@class='btn notselected btn-sm btnAddRemoveBtn']")
	WebElement USerAddbutton;
	
	@FindBy(xpath = "//small[text()='IA']")
	WebElement InternalAuditMYTaskMenu;
	
	@FindBy(id = "MyTaskPrc_IA_AUD_IA_LGN_FRM_ID_01")
	WebElement IAProposalMyTakMenu;
	

	@FindBy(xpath = "//span[@class='confirmation_text']")
	WebElement UniqeCode;
	
	@FindBy(id = "btnAdvSearch")
	WebElement AdvancedSearch;

	@FindBy(name = "AUD_LGN_CTF_003")
	WebElement IssueCodeFilter;

	@FindBy(id = "btnSubmitListFilter")
	WebElement ApplyButton;

	@FindBy(className = "text-ellipsis")
	WebElement Record;
	
	@FindBy(id = "txtRemarks")
	WebElement Remarks;

	@FindBy(xpath = "(//div[@id='StdRemarks_container']//following::span[@class='error'])[1]")
	WebElement RemarkError;
	
	@FindBy(xpath = "//div[@class='left-menupanel']/div[5]")
	WebElement AuditManagement;
	
	@FindBy(id = "IALN_04")
	WebElement AuditProposalAuditTrailMenu;
	
	@FindBy(className = "event-div")
	WebElement Events;
	
	@FindBy(className = "popup-close-button")
	WebElement Close;


	
	public void ia_Proposal_Initiation_SP(String department, String description, String startDate, String endDate,
			String leadAuditor, String auditorName, String coAuditorName) {

		switchToDefaultContent(driver);
		
		click(initiate, "InitiateButtton");

		click(processLogin, "ProcessLogin");

		// Switch to Frame
		switchToPopupModelFrame(driver);

		click(InternalAuditIcon, "Internal Audit Icon");

		click(proceedButton, "Proceed button");

		switchToDefaultContent(driver);

		switchToBodyFrame(driver);

		click(SubmitButton, "submit Button");

		verifyCaptionContains(DepartmentFieldError, "Select Value");

		click(DepartmentAddButton, "Department Add button");

		switchToPopupModelFrame(driver);

		click(popupOkButton, "Ok button");

		verifyCaptionContains(AlertMessage, "Select Value");

		click(AlertCloseButton, "Alert close button");

		click(PopupSearchButton, "Department Advanced search button");

		sendText(DepartmentCodeFilter, department, "Department Code");

		click(PopupApplyButton, "Apply button");

		click(DepartmentRadioButton, "Department Radio button");

		click(popupOkButton, "Ok button");

		switchToParentFrame(driver);

		click(SubmitButton, "Submit button");

		verifyCaptionContains(AuditPlanError, "Select Value");

		click(AuditPlanScheduled, "Scheduled Plan");

		click(SubmitButton, "Submit button");

		verifyCaptionContains(ScheduleReferenceError, "Select Value");

		click(ScheduleReferenceButton, "Schedule reference button");

		switchToPopupModelFrame(driver);

		click(popupOkButton, "Ok button");

		verifyCaptionContains(AlertMessage, "Select Value");

		click(AlertCloseButton, "Alert close button");

		click(PopupSearchButton, "Department Advanced search button");

		// sendText(AuditCodesearchfilterText, auditCode, "Audit Code");

		enterUniqueCode(driver, AuditCodesearchfilterText);

		click(PopupApplyButton, "Apply button");

		click(AuditCodeRadioButton, "Audit Code");

		click(popupOkButton, "Ok button");

		switchToParentFrame(driver);

		click(SubmitButton, "Submit button");

		verifyCaptionContains(DescriptionError, "Enter Value");

		sendText(Description, description, "Description Text box");

		click(SubmitButton, "Submit button");

		verifyCaptionContains(StartDateError, "Select Value");

		sendText(StartDate, startDate, "Proposed Strart date");

		click(SubmitButton, "Submit button");

		/*
		 * verifyCaptionContains(EndDateError, "Select Value");
		 * 
		 * sendText(EndDate, endDate, "Proposed End date");
		 * 
		 * click(SubmitButton, "Submit button");
		 */

		verifyCaptionContains(LeadAuditorError, "Select Value");

		click(LeadAuditorButton, "Lead Auditor Add Button");

		switchToPopupModelFrame(driver);

		click(popupOkButton, "Ok button");

		verifyCaptionContains(AlertMessage, "Select Value");

		click(AlertCloseButton, "Alert close button");

		click(PopupSearchButton, "Department Advanced search button");

		sendText(LoginIDFilter, leadAuditor, "Lead Audtor");
		
		click(PopupApplyButton, "Apply button");
		
		click(UserRadioButton, "Lead Auditor name");
		
		click(popupOkButton, "Ok button");
		
		switchToParentFrame(driver);
		
		//Auditor selection

		
		click(SubmitButton, "Submit button");
		
		verifyCaptionContains(AuditorError, "Select Value");

		click(AuditorButton, "Auditor Add Button");

		switchToPopupModelFrame(driver);

		click(popupOkButton, "Ok button");

		verifyCaptionContains(AlertMessage, "Select Value");

		click(AlertCloseButton, "Alert close button");

		click(PopupSearchButton, "Advanced search button");

		sendText(LoginIDFilter, auditorName, "Auditor Name");
		
		click(PopupApplyButton, "Apply button");
		
		click(USerAddbutton, "Auditor name");
		
		click(PopupSearchButton, "Advanced search button");

		sendText(LoginIDFilter, coAuditorName, "Co Auditor Name");
		
		click(PopupApplyButton, "Apply button");
		
		click(USerAddbutton, "Co Auditor name");
		
		click(popupOkButton, "Ok button");
		
		switchToParentFrame(driver);
		
		click(SubmitButton, "Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, UniqeCode);
		switchToDefaultContent(driver);

	}
	
	public void auditProposalReinitiation(String description, String remarks) {
		TimeUtil.shortWait();
		switchToBodyFrame(driver);
		scrollToViewElement(InternalAuditMYTaskMenu);
		click(InternalAuditMYTaskMenu, "Internal Audit My task menu");
		click(IAProposalMyTakMenu, "Audit Proposal my task menu");
		switchToTaskListFrame(driver);
		click(AdvancedSearch, "Advanced Search");
		enterUniqueCodeConcat(driver, IssueCodeFilter);
		click(ApplyButton, "Apply Button");
		click(Record, "Record");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		clearField(Description, "Description");
		sendText(Description, description, "Description Text box");

		click(SubmitButton, "Submit button");
		
		verifyCaptionContains(RemarkError, "Enter Value");
		sendText(Remarks, remarks, "Remarks");
		click(SubmitButton, "Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnID"));
		switchToDefaultContent(driver);
		
	}
	
	public void auditTrailNavigation() {
		switchToDefaultContent(driver);
		click(AuditManagement, "Audit Management menu");
		scrollToViewElement(AuditProposalAuditTrailMenu);
		click(AuditProposalAuditTrailMenu, "Audit Proposal AuditTrail Menu");
		switchToBodyFrame(driver);
		click(AdvancedSearch, "Advanced Search button");
		enterUniqueCode(driver, IssueCodeFilter);
		click(ApplyButton, "Apply button");
		click(Record, "Record");
		
	}
	

	public void auditPropsalAuditTrailInitiation() {
		auditTrailNavigation();
		switchToPopupModelFrame(driver);
		scrollToViewElement(Events);
		click(Close, "Close button");
		switchToDefaultContent(driver);
	}
	
	public void auditPropsalAuditTrailReInitiation() {
		auditTrailNavigation();
		switchToPopupModelFrame(driver);
		
		
		//click(element, elementName);
		scrollToViewElement(Events);
		click(Close, "Close button");
		switchToDefaultContent(driver);
	}
	
}
