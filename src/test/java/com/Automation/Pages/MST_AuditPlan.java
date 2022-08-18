package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;
import com.Automation.Utils.TimeUtil;

public class MST_AuditPlan extends ActionEngine {

	@FindBy(xpath = "//div[@class='left-menupanel']/div[5]")
	WebElement AuditManagement;

	@FindBy(id = "APLN_01")
	WebElement AuditPlanRegistaration;

	@FindBy(id = "btnSubmit_1")
	WebElement btnSubmit;

	@FindBy(id = "AUD_PLN_CTF_003_error")
	WebElement AuditTypeError;

	@FindBy(id = "AUD_PLN_CTF_003")
	WebElement AuditTypeDropDown;

	@FindBy(id = "AUD_PLN_CTF_002_error")
	WebElement DescriptionError;

	@FindBy(id = "AUD_PLN_CTF_002")
	WebElement Description;

	@FindBy(id = "AUD_PLN_CTF_004_error")
	WebElement DepartmentError;

	@FindBy(id = "AUD_PLN_CTF_004")
	WebElement DepartmentAddItems;

	@FindBy(id = "btnAdvSearch")
	WebElement AdvancedSearch;

	@FindBy(name = "MST_DEP_CTF_002")
	WebElement IssueCodeFilter;

	@FindBy(name = "MST_RUL_CTF_002")
	WebElement RolecodeIssue;

	@FindBy(id = "btnSubmitListFilter")
	WebElement ApplyButton;

	@FindBy(className = "text-ellipsis")
	WebElement DepartmentCode;

	@FindBy(id = "btnOk")
	WebElement OkButton;

	@FindBy(id = "AUD_PLN_CTF_008_error")
	WebElement AuditAreaError;

	@FindBy(id = "AUD_PLN_CTF_008")
	WebElement AuditAreaAddItems;

	@FindBy(name = "UniqueCode")
	WebElement AuditArea;

	@FindBy(xpath = "//*[@class='btn notselected btn-sm btnAddRemoveBtn']")
	WebElement AddButton;

	@FindBy(id = "AUD_PLN_CTF_009_error")
	WebElement PlanTypeError;

	@FindBy(xpath = "//label[@for='AUD_PLN_CTF_009_1']")
	WebElement PlanTypeOneTime;

	@FindBy(id = "AUD_PLN_CTF_011_error")
	WebElement ScheduleDateError;

	@FindBy(xpath = "//span[@class='font-white ft-calendar'][1]")
	WebElement Caliender;

	@FindBy(xpath = "//td[text()='15'][1]")
	WebElement Date;

	@FindBy(id = "AUD_PLN_CTF_010_error")
	WebElement ProposalValidityError;

	@FindBy(id = "AUD_PLN_CTF_010")
	WebElement ProposalValidity;

	@FindBy(id = "AUD_PLN_CTF_021_error")
	WebElement AuditDurationError;

	@FindBy(id = "AUD_PLN_CTF_021")
	WebElement AuditDuration;

	@FindBy(id = "AUD_PLN_CTF_014_error")
	WebElement AuditScopeError;

	@FindBy(id = "AUD_PLN_CTF_014")
	WebElement AuditScope;

	@FindBy(id = "AUD_PLN_CTF_015_error")
	WebElement RolesError;

	@FindBy(id = "AUD_PLN_CTF_015_button")
	WebElement RolesAddItems;

	// Modification

	@FindBy(id = "APLN_02")
	WebElement AuditModification;

	@FindBy(name = "AUD_PLN_CTF_001")
	WebElement AuditPlanIssueCode;

	@FindBy(className = "text-ellipsis")
	WebElement AuditCodeRecord;

	@FindBy(xpath = "//span[text()='Enter Value']")
	WebElement Remarks_Error;

	@FindBy(id = "txtRemarks")
	WebElement Remarks;

	// Status Change

	@FindBy(id = "APLN_03")
	WebElement AuditStatusChange;

	@FindBy(xpath = "//span[text()='Select Value']")
	WebElement ProposedStatus_Error;

	@FindBy(xpath = "//textarea[@id='txtRemarks']")
	WebElement RemarksReasons;

	@FindBy(xpath = "//label[@for='NewStatus_5']")
	WebElement Inactive;

	@FindBy(xpath = "//label[@for='NewStatus_1']")
	WebElement Active;

	@FindBy(xpath = "//label[@for='NewStatus_10']")
	WebElement StatusChangePermentInActive;

	@FindBy(id = "confirmationRevertYes")
	WebElement PermanetInActiveYes;

	// AuditTrails

	@FindBy(id = "APLN_04")
	WebElement AuditplanAuditTrails;

	@FindBy(xpath = "//span[@class='popup-close-button']")
	WebElement AuditTrailsclose;

	@FindBy(xpath = "//div[text()='Registration']")
	WebElement Revision0;

	@FindBy(xpath = "//div[text()='Modification']")
	WebElement Revision1;

	@FindBy(xpath = "//div[text()='Status Change']")
	WebElement StatusChangeAuditTrails;

	@FindBy(id = "AuditEventModal_View")
	WebElement proceed;
	
	@FindBy(xpath = "//span[contains(text(),'Draft')]")
	WebElement DraftIcon;

	// My task

	@FindBy(xpath = "//span[contains(text(),'Audit Managment')]")
	WebElement AuditManagementMyTaskMenu;

	@FindBy(id = "MyTaskMod_AUDITMGR_AUD_PLN_FRM_ID_01")
	WebElement AuidtPlanMytask;

	@FindBy(xpath = "//label[@for='EsignerDecision_3']")
	WebElement ReturnDecision;

	@FindBy(xpath = "//label[@for='EsignerDecision_2']")
	WebElement ApproveDecision;

	@FindBy(xpath = "//label[@for='EsignerDecision_4']")
	WebElement DropDecision;

	@FindBy(xpath = "//span[@class='confirmation_text']")
	WebElement UniqeCode;

	// demo
	@FindBy(xpath = "//span[contains(text(),'Initiated By')]")
	WebElement demoj;

	public void auditPlanRegistration(String AuditType, String desc, String departmentCode, String unique, String days,
			String Durationdaye, String audit, String roleCode) {
		TimeUtil.shortWait();
		click(AuditManagement, "Audit Management");
		scrollToViewElement(AuditPlanRegistaration);
		click(AuditPlanRegistaration, "AuditPlan Registaration");
		switchToBodyFrame(driver);
		click(btnSubmit, "Submit Button");

		verifyCaptionContains(AuditTypeError, "Select Value");
		selectDropdownUsingVisisbleText(AuditTypeDropDown, AuditType, "AuditType DropDown");
		click(btnSubmit, "Submit Button");

		verifyCaptionContains(DescriptionError, "Enter Value");
		sendText(Description, desc, "Description");
		click(btnSubmit, "Submit Button");

		verifyCaptionContains(DepartmentError, "Select Value");
		click(DepartmentAddItems, "Department AddItems");
		switchToPopupModelFrame(driver);
		click(AdvancedSearch, "Advanced Search");
		click(IssueCodeFilter, "IssueCodeFilter");
		sendText(IssueCodeFilter, departmentCode, "IssueCodeFilter");
		click(ApplyButton, "Apply Button");
		click(DepartmentCode, "DepartmentCode");
		click(OkButton, "Ok Button");
		switchToParentFrame(driver);
		click(btnSubmit, "Submit Button");

		verifyCaptionContains(AuditAreaError, "Select Value");
		click(AuditAreaAddItems, "AuditArea AddItems");
		switchToPopupModelFrame(driver);
		click(AdvancedSearch, "Advanced Search");
		click(AuditArea, "AuditArea");
		sendText(AuditArea, unique, "AuditArea");
		click(ApplyButton, "Apply Button");
		click(AddButton, "Add Button");
		click(OkButton, "OkButton");
		switchToParentFrame(driver);
		click(btnSubmit, "Submit Button");

		verifyCaptionContains(PlanTypeError, "Select Value");
		click(PlanTypeOneTime, "PlanType OneTime");
		click(btnSubmit, "Submit Button");

		verifyCaptionContains(ScheduleDateError, "Select Value");
		click(Caliender, "Caliender");
		click(Date, "date");
		click(btnSubmit, "Submit Button");

		verifyCaptionContains(ProposalValidityError, "Enter Value");
		sendText(ProposalValidity, days, "ProposalValidity");
		click(btnSubmit, "Submit Button");

		verifyCaptionContains(AuditDurationError, "Enter Value");
		sendText(AuditDuration, Durationdaye, "AuditDuration");
		click(btnSubmit, "Submit Button");

		verifyCaptionContains(AuditScopeError, "Enter Value");
		sendText(AuditScope, audit, "auditScope");
		click(btnSubmit, "Submit Button");

		verifyCaptionContains(RolesError, "Select Value");
		click(RolesAddItems, "Roles AddItems");
		switchToPopupModelFrame(driver);
		click(AdvancedSearch, "Advanced Search");
		click(RolecodeIssue, "RolecodeIssue");
		sendText(RolecodeIssue, roleCode, "Rolecode Issue");
		click(ApplyButton, "Apply Button");
		click(AddButton, "Add Button");
		click(OkButton, "OkButton");
		switchToParentFrame(driver);
		click(btnSubmit, "Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, UniqeCode);
		switchToDefaultContent(driver);

	}

	public void auditModifiaction(String days, String remarksReason) {

		TimeUtil.shortWait();
		click(AuditManagement, "Audit Management");
		scrollToViewElement(AuditModification);
		click(AuditModification, "AuditPlan Modification");
		switchToBodyFrame(driver);
		click(AdvancedSearch, "Advanced Search");
		enterUniqueCode(driver, AuditPlanIssueCode);
		click(ApplyButton, "Apply Button");
		click(AuditCodeRecord, "AuditCode Record");
		clearField(ProposalValidity, "ProposalValidity");
		sendText(ProposalValidity, days, "ProposalValidity");
		click(btnSubmit, "Submit Button");
		verifyCaptionContains(Remarks_Error, "Enter Value");
		sendText(Remarks, remarksReason, "enetr name");
		click(btnSubmit, "Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, UniqeCode);
		switchToDefaultContent(driver);

	}

	public void statusChangeInActive(String Remarks) {

		TimeUtil.shortWait();
		click(AuditManagement, "Audit Management");
		scrollToViewElement(AuditStatusChange);
		click(AuditStatusChange, "AuditPlan StatusChange");
		switchToBodyFrame(driver);
		click(AdvancedSearch, "Advanced Search");
		enterUniqueCode(driver, AuditPlanIssueCode);
		click(ApplyButton, "Apply Button");
		click(AuditCodeRecord, "AuditCode Record");
		click(btnSubmit, "Submit Button");

		verifyCaptionContains(ProposedStatus_Error, "Enter Value");
		click(Inactive, " InActive");
		sendText(RemarksReasons, Remarks, "Remarks Reasons");
		click(btnSubmit, "Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, UniqeCode);
		switchToDefaultContent(driver);

	}

	public void statusChangeActive(String Remarks) {

		TimeUtil.shortWait();
		click(AuditManagement, "Audit Management");
		scrollToViewElement(AuditStatusChange);
		click(AuditStatusChange, "AuditPlan StatusChange");
		switchToBodyFrame(driver);
		click(AdvancedSearch, "Advanced Search");
		enterUniqueCode(driver, AuditPlanIssueCode);
		click(ApplyButton, "Apply Button");
		click(AuditCodeRecord, "AuditCode Record");
		click(btnSubmit, "Submit Button");

		verifyCaptionContains(ProposedStatus_Error, "Enter Value");
		click(Active, " Active");
		sendText(RemarksReasons, Remarks, "Remarks Reasons");
		click(btnSubmit, "Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, UniqeCode);
		switchToDefaultContent(driver);

	}

	public void statusChangePermentInActive(String Remarks) {

		TimeUtil.shortWait();
		click(AuditManagement, "Audit Management");
		scrollToViewElement(AuditStatusChange);
		click(AuditStatusChange, "AuditPlan StatusChange");
		switchToBodyFrame(driver);
		click(AdvancedSearch, "Advanced Search");
		enterUniqueCode(driver, AuditPlanIssueCode);
		click(ApplyButton, "Apply Button");
		click(AuditCodeRecord, "AuditCode Record");
		click(btnSubmit, "Submit Button");
		verifyCaptionContains(ProposedStatus_Error, "Enter Value");
		click(StatusChangePermentInActive, "StatusChangePermentInActive");
		click(PermanetInActiveYes, "PermanetInActiveYes");
		sendText(RemarksReasons, Remarks, "Remarks Reasons");
		click(btnSubmit, "Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, UniqeCode);
		switchToDefaultContent(driver);

	}

	public void auditPlanReinitiate(String scope, String remarks) {
		auditPlanMyTaskNavigation();
		// click(btnSubmit, "Submit Button");
		clearField(AuditScope, "Audit Scope");
		sendText(AuditScope, scope, "Audit Scope");
		click(btnSubmit, "Submit Button");
		verifyCaptionContains(Remarks_Error, "Enter Value");
		sendText(Remarks, remarks, "Remarks Reasons");
		click(btnSubmit, "Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnPwd"));
		saveUniqueCode(driver, UniqeCode);
		switchToDefaultContent(driver);

	}

	public void auditPlanAuditTrailsModification() {
		auditPlanAuditTrailNavigation();
		click(Revision0, "Revision 0");
		click(Revision1, "Revision 1");
		click(proceed, "proceed");
		click(AuditTrailsclose, "close pop");
		switchToDefaultContent(driver);

	}

	public void auditPlanAuditTrails() {
		auditPlanAuditTrailNavigation();
		click(AuditTrailsclose, "close pop");

	}

	public void auditPlanAuditTrailsStatusChange() {
		auditPlanAuditTrailNavigation();
		click(StatusChangeAuditTrails, "StatusChange AuditTrails");
		click(proceed, "proceed");
		click(AuditTrailsclose, "close pop");

	}

	public void auditPlanAuditTrailsRutrned() {
		auditPlanAuditTrailNavigation();
		click(Revision0, "Revision 0");
		click(DraftIcon, "Draft icon");
		click(proceed, "proceed");
		click(AuditTrailsclose, "close pop");

	}

	public void auditPlanReturn(String remarks) {
		auditPlanMyTaskNavigation();
		// click(btnSubmit, "Submit Button");
		click(ReturnDecision, "Return button");
		click(btnSubmit, "Submit Button");
		verifyCaptionContains(Remarks_Error, "Enter Value");
		sendText(RemarksReasons, remarks, "Remarks Reaons");
		click(btnSubmit, "Submit button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevRevPwd"));
		saveUniqueCode(driver, UniqeCode);
		switchToDefaultContent(driver);

	}

	public void auditPlanDrop(String remarks) {
		auditPlanMyTaskNavigation();
		// click(btnSubmit, "Submit Button");
		click(DropDecision, "Drop button");
		click(btnSubmit, "Submit Button");
		verifyCaptionContains(Remarks_Error, "Enter Value");
		sendText(RemarksReasons, remarks, "Remarks Reaons");
		click(btnSubmit, "Submit button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevRevPwd"));
		saveUniqueCode(driver, UniqeCode);
		switchToDefaultContent(driver);

	}

	public void auditPlanApprove() {
		auditPlanMyTaskNavigation();
		// click(btnSubmit, "Submit Button");
		click(ApproveDecision, "Approve button");
		click(btnSubmit, "Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevRevPwd"));
		saveUniqueCode(driver, UniqeCode);
		switchToDefaultContent(driver);

	}

	public void auditPlanMyTaskNavigation() {
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);
		scrollToViewElement(AuditManagementMyTaskMenu);
		click(AuditManagementMyTaskMenu, "Audit Managment my task menu");
		click(AuidtPlanMytask, "Auidt Plan My task menu");
		switchToTaskListFrame(driver);
		click(AdvancedSearch, "Advanced Search");
		enterUniqueCode(driver, AuditPlanIssueCode);
		click(ApplyButton, "Apply Button");
		click(AuditCodeRecord, "AuditCode Record");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);

	}

	public void auditPlanAuditTrailNavigation() {
		TimeUtil.shortWait();
		click(AuditManagement, "Audit Management");
		scrollToViewElement(AuditplanAuditTrails);
		click(AuditplanAuditTrails, "AuditPlan AuditTrails");
		switchToBodyFrame(driver);
		click(AdvancedSearch, "Advanced Search");
		enterUniqueCode(driver, AuditPlanIssueCode);
		click(ApplyButton, "Apply Button");
		click(AuditCodeRecord, "AuditCode Record");
		switchToPopupModelFrame(driver);

	}

}
