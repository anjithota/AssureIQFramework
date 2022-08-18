package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;

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

	public void ia_Proposal_Initiation_SP(String department, String description, String startDate, String endDate,
			String leadAuditor) {

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
		

	}

}
