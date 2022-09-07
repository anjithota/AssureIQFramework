package com.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.ActionEngine;
import com.Automation.Utils.ConfigsReader;
import com.Automation.Utils.TimeUtil;

public class IA_AuditClosureAprroval extends ActionEngine {
	@FindBy(xpath = "//small[text()='IA']")
	WebElement InternalAuditMYTaskMenu;

	@FindBy(id = "MyTaskPrc_IA_IA_AUD_CLS_FRM_ID_01")
	WebElement AuditClosurerMyTaskMenu;

	@FindBy(id = "btnAdvSearch")
	WebElement AdvancedSearch;

	@FindBy(name = "AUD_LGN_CTF_003")
	WebElement IssueCodeFilter;

	@FindBy(id = "btnSubmitListFilter")
	WebElement ApplyButton;

	@FindBy(className = "text-ellipsis")
	WebElement Record;

	@FindBy(xpath = "//label[@for='EsignerDecision_2']")
	WebElement Approve;

	@FindBy(xpath = "//label[@for='EsignerDecision_3']")
	WebElement Return;

	@FindBy(id = "btnSubmit_1")
	WebElement SubmitButton;

	@FindBy(id = "AUD_CLS_CTR_004_error")
	WebElement QAcloserError;

	@FindBy(id = "AUD_CLS_CTR_004")
	WebElement QAcloser;

	@FindBy(id = "txtRemarks")
	WebElement Remarks;

	@FindBy(xpath = "(//div[@id='StdRemarks_container']//following::span[@class='error'])[1]")
	WebElement RemarkError;

	@FindBy(xpath = "//div[@class='left-menupanel']/div[5]")
	WebElement AuditManagement;

	@FindBy(id = "IACL_04")
	WebElement AuditClosureAuditTrailMenu;
	
	@FindBy(className = "event-div")
	WebElement Events;
	
	@FindBy(className = "popup-close-button")
	WebElement Close;

	public void auditCloserApprove(String comments) {
		auditClosureMyTaskNavigation();
		click(Approve, "Approve");
		verifyCaptionContains(QAcloserError, "Enter Value");
		sendText(QAcloser, comments, "Closer Comments");
		click(Approve, "Approve");
		click(SubmitButton, "Submit Button");
	}

	public void auditClosureMyTaskNavigation() {
		TimeUtil.shortWait();
		switchToBodyFrame(driver);
		scrollToViewElement(InternalAuditMYTaskMenu);
		click(InternalAuditMYTaskMenu, "Internal Audit");
		click(AuditClosurerMyTaskMenu, "AuditCloser MyTask");
		switchToTaskListFrame(driver);
		click(AdvancedSearch, "Advanced Search");
		enterUniqueCodeConcat(driver, IssueCodeFilter);
		click(ApplyButton, "Apply Button");
		click(Record, "Record");
		switchToDefaultContent(driver);
		switchToBodyFrame(driver);

	}

	public void auditCloserReturn(String remarks) {
		auditClosureMyTaskNavigation();
		click(Return, "Return");
		click(SubmitButton, "Submit Button");
		verifyCaptionContains(RemarkError, "Enter Value");
		sendText(Remarks, remarks, "Remarks");
		click(SubmitButton, "Submit Button");
		E_sign.e_Sign(ConfigsReader.getPropValue("SPDevLgnID"));
		switchToDefaultContent(driver);
	}

	public void auditClosureAuditTrailNavigation() {
		switchToDefaultContent(driver);
		click(AuditManagement, "Audit Management menu");
		scrollToViewElement(AuditClosureAuditTrailMenu);
		click(AuditClosureAuditTrailMenu, "Audit Closure AuditTrail Menu");
		switchToBodyFrame(driver);
	}

	public void auditClosureSearchFilter() {
		click(AdvancedSearch, "Advanced Search button");
		enterUniqueCode(driver, IssueCodeFilter);
		click(ApplyButton, "Apply button");
		click(Record, "Record");
	}
	
	public void auditClosureAUditTrailInitiation() {
		auditClosureAuditTrailNavigation();
		auditClosureSearchFilter();
		switchToPopupModelFrame(driver);
		scrollToViewElement(Events);
		click(Close, "Close button");
		switchToDefaultContent(driver);
		
		
	}
	
	public void auditClosureAUditTrailReturn() {
		auditClosureAuditTrailNavigation();
		auditClosureSearchFilter();
		switchToPopupModelFrame(driver);
		
		scrollToViewElement(Events);
		click(Close, "Close button");
		switchToDefaultContent(driver);
		
		
	}

}
